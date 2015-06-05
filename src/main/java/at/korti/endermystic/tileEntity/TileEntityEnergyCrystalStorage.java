package at.korti.endermystic.tileEntity;

import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetworkHandler;
import at.korti.endermystic.api.mysticEnergyNetwork.IEnergyProvider;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Korti on 02.06.2015.
 */
public class TileEntityEnergyCrystalStorage extends TileEntity implements IEnergyProvider {

    private int maxStorage;
    private int currentStorage;
    private final int range = 15;
    private final int transferRate = 100;

    public TileEntityEnergyCrystalStorage(){
        this.maxStorage = 50000;
        this.currentStorage = 0;
    }

    @Override
    public void updateEntity() {
        if(!worldObj.isRemote) {
            IEnergyProvider provider = EnergyNetworkHandler.getProvider(worldObj, xCoord, yCoord, zCoord, range);
            if (provider != null && transferRate <= provider.getEnergyToProvide() && currentStorage + transferRate <= maxStorage) {
                currentStorage += provider.decrEnergy(transferRate);
            }
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);
        tagCompound.setInteger("MaxStorage", maxStorage);
        tagCompound.setInteger("CurrentStorage", currentStorage);
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);
        maxStorage = tagCompound.getInteger("MaxStorage");
        currentStorage = tagCompound.getInteger("CurrentStorage");
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tagCompound = new NBTTagCompound();
        this.writeToNBT(tagCompound);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tagCompound);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        readFromNBT(pkt.func_148857_g());
    }

    @Override
    public int getEnergyToProvide() {
        return currentStorage;
    }

    @Override
    public int decrEnergy(int energyUse) {
        this.currentStorage -= energyUse;
        return energyUse;
    }

    @Override
    public boolean canProvideEnergy() {
        return true;
    }

    @Override
    public boolean hasEnoughEnergy(int toUse) {
        return currentStorage >= toUse;
    }

    public int getMaxStorage() {
        return maxStorage;
    }
}
