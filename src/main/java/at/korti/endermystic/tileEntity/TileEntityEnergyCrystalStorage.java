package at.korti.endermystic.tileEntity;

import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetworkHandler;
import at.korti.endermystic.api.mysticEnergyNetwork.EnergyStorage;
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

    private EnergyStorage storage;
    private final int range = 15;

    public TileEntityEnergyCrystalStorage(){
        storage = new EnergyStorage(50000, 100, 100);
    }

    @Override
    public void updateEntity() {
        if(!worldObj.isRemote) {
            IEnergyProvider provider = EnergyNetworkHandler.getProvider(worldObj, xCoord, yCoord, zCoord, range);
            if (provider != null && storage.getMaxTransferIn() <= provider.getEnergyToProvide()) {
                storage.transferEnergyIn(provider.decrEnergy(storage.getMaxTransferIn()));
            }
        }
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);
        tagCompound.setInteger("CurrentStorage", storage.getCurrentEnergy());
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);
        storage.setCurrentEnergy(tagCompound.getInteger("CurrentStorage"));
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
        return storage.getCurrentEnergy();
    }

    @Override
    public int decrEnergy(int energyUse) {
        return storage.transferEnergyOut(energyUse);
    }

    @Override
    public boolean canProvideEnergy() {
        return true;
    }

    @Override
    public boolean hasEnoughEnergy(int toUse) {
        return storage.getCurrentEnergy() >= toUse;
    }

    public int getMaxStorage() {
        return storage.getMaxStorage();
    }
}
