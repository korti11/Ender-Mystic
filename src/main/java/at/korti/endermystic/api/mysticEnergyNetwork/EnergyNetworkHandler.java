package at.korti.endermystic.api.mysticEnergyNetwork;

import at.korti.endermystic.tileEntity.TileEntityEnergyCrystalStorage;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Korti on 03.04.2015.
 */
public class EnergyNetworkHandler {

    /**
     * Add capacity to player energy network. If the player has no energy network, a new EnergyNetwork would create.
     * @param capacity
     * @param playerName
     * @return If the capacity was added.
     */
    public static boolean addCapacity(int capacity, String playerName){
        World world = getWorld();
        EnergyNetwork network = getNetwork(playerName);

        if(network == null){
            network = new EnergyNetwork("em_" + playerName);
            network.mysticEnergy = 0;
            network.mysticCapacity = capacity;
            network.markDirty();
            world.setItemData("em_" + playerName, network);
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

    /**
     * Add energy to the player network.
     * @param energy
     * @param playerName
     * @return If the energy was added.
     */
    public static boolean addEnergy(int energy, String playerName){
        EnergyNetwork network = getNetwork(playerName);
        if(network != null) {
            network.mysticEnergy = Math.min(network.mysticCapacity, network.mysticEnergy + energy);
            network.markDirty();
            return true;
        }
        return false;
    }

    /**
     * Check if the player has enough energy.
     * @param usage
     * @param playerName
     * @return If there is enough energy.
     */
    public static boolean isEnoughEnergy(int usage, String playerName){
        EnergyNetwork energyNetwork = getNetwork(playerName);
        return energyNetwork != null ? usage <= energyNetwork.mysticCapacity : false;
    }

    private static boolean isEnoughEnergy(int usage, int energy){
        return usage <= energy;
    }

    /**
     * Decrease the energy of the energy network.
     * @param usage
     * @param playerName
     * @return If the energy has been decreased.
     */
    public static boolean decEnergy(int usage, String playerName){
        EnergyNetwork energyNetwork = getNetwork(playerName);
        if(energyNetwork != null){
            if(isEnoughEnergy(usage, energyNetwork.mysticEnergy)){
                energyNetwork.mysticEnergy -= usage;
                energyNetwork.markDirty();
                return true;
            }
        }
        return false;
    }

    /**
     * Get the current energy amount.
     * @param playerName
     * @return Energy amount.
     */
    public static int getEnergy(String playerName){
        return getNetwork(playerName).mysticEnergy;
    }

    /**
     * Get the current capacity amount.
     * @param itemName
     * @return Capacity amount.
     */
    public static int getCapacity(String itemName){
        return getNetwork(itemName).mysticCapacity;
    }

    /**
     * Get the connection to the nearest energy provider.
     * @param worldObj
     * @param xCoord
     * @param yCoord
     * @param zCoord
     * @param range
     * @return Nearest energy provider.
     */
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

    private static World getWorld(){
        return MinecraftServer.getServer().worldServers[0];
    }

    private static EnergyNetwork getNetwork(String playerName){
        World world = getWorld();
        return (EnergyNetwork)world.loadItemData(EnergyNetwork.class, "em_" + playerName);
    }
}
