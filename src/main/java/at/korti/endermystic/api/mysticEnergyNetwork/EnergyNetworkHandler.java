package at.korti.endermystic.api.mysticEnergyNetwork;

import at.korti.endermystic.tileEntity.TileEntityEnergyCrystalStorage;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Korti on 03.04.2015.
 */
public class EnergyNetworkHandler {

    public static boolean AddCapacity(int capacity, String itemName){
        World world = GetWorld();
        EnergyNetwork network = GetNetwork(itemName);

        if(network == null){
            network = new EnergyNetwork("em_" + itemName);
            network.mysticEnergy = 0;
            network.mysticCapacity = capacity;
            network.markDirty();
            world.setItemData("em_" + itemName, network);
            return true;
        }
        else{
            if(network.mysticCapacity < capacity){
                network.mysticCapacity = capacity;
                network.markDirty();
                return true;
            }
        }

        return false;
    }

    public static boolean AddEnergy(int energy, String itemName){
        EnergyNetwork network = GetNetwork(itemName);
        if(network != null) {
            network.mysticEnergy = Math.min(network.mysticCapacity, network.mysticEnergy + energy);
            network.markDirty();
            return true;
        }
        return false;
    }

    public static boolean IsEnoughEnergy(int usage, String itemName){
        EnergyNetwork energyNetwork = GetNetwork(itemName);
        return energyNetwork != null ? usage <= energyNetwork.mysticCapacity : false;
    }

    private static boolean IsEnoughEnergy(int usage, int energy){
        return usage <= energy;
    }

    public static boolean DecEnergy(int usage, String itemName){
        EnergyNetwork energyNetwork = GetNetwork(itemName);
        if(energyNetwork != null){
            if(IsEnoughEnergy(usage, energyNetwork.mysticEnergy)){
                energyNetwork.mysticEnergy -= usage;
                energyNetwork.markDirty();
                return true;
            }
        }
        return false;
    }

    public static int GetEnergy(String itemName){
        return GetNetwork(itemName).mysticEnergy;
    }

    public static int GetCapacity(String itemName){
        return GetNetwork(itemName).mysticCapacity;
    }

    public static IEnergyProvider getProvider(World worldObj,int xCoord, int yCoord, int zCoord, int range){
        boolean isStorage = worldObj.getTileEntity(xCoord,yCoord,zCoord) instanceof TileEntityEnergyCrystalStorage;
        for (int x = xCoord - (range / 2); x < xCoord + (range / 2); x++) {
            for (int y = yCoord - (range / 2); y < yCoord + (range / 2); y++) {
                for (int z = zCoord - (range / 2); z < zCoord + (range / 2); z++) {
                    TileEntity tileEntity = worldObj.getTileEntity(x, y, z);
                    if(tileEntity instanceof IEnergyProvider){
                        if(isStorage && !(tileEntity instanceof TileEntityEnergyCrystalStorage)) {
                            IEnergyProvider provider = (IEnergyProvider) tileEntity;
                            if(provider != null && provider.hasEnoughEnergy(1)){
                                return provider;
                            }
                        }
                        else if(!isStorage) {
                            IEnergyProvider provider = (IEnergyProvider) tileEntity;
                            if(provider != null && provider.hasEnoughEnergy(1)) {
                                return provider;
                            }
                        }
                    }
                    else if(tileEntity instanceof IEnergyRelay){
                        IEnergyProvider provider = ((IEnergyRelay)tileEntity).getConnectionToProvider();
                        if(isStorage && !(provider instanceof TileEntityEnergyCrystalStorage)) {
                            if (provider != null && provider.hasEnoughEnergy(1)) {
                                return provider;
                            }
                        }
                        else if(!isStorage){
                            if (provider != null && provider.hasEnoughEnergy(1)) {
                                return provider;
                            }
                        }
                    }
                }
            }
        }

        return null;
    }

    private static World GetWorld(){
        return MinecraftServer.getServer().worldServers[0];
    }

    private static EnergyNetwork GetNetwork(String itemName){
        World world = GetWorld();
        return (EnergyNetwork)world.loadItemData(EnergyNetwork.class, "em_" + itemName);
    }
}
