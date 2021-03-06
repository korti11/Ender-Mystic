package at.korti.endermystic.modintegration.cofh.tileentity;

import at.korti.endermystic.api.mysticEnergyNetwork.EnergyStorage;
import at.korti.endermystic.api.mysticEnergyNetwork.IEnergyProvider;
import cofh.api.energy.IEnergyHandler;
import cofh.api.tileentity.IEnergyInfo;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Korti on 05.06.2015.
 */
public class TileEntityMysticConverter extends TileEntity implements IEnergyHandler, IEnergyInfo, IEnergyProvider {

    private EnergyStorage energyStorage;

    public TileEntityMysticConverter() {
        energyStorage = new EnergyStorage(10000, 100, 100);
    }

    @Override
    public int receiveEnergy(ForgeDirection forgeDirection, int receiveEnergy, boolean simulate) {
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        markDirty();
        return energyStorage.transferEnergyIn(receiveEnergy / 2);
    }

    @Override
    public int extractEnergy(ForgeDirection forgeDirection, int i, boolean b) {
        return 0;
    }

    @Override
    public int getEnergyStored(ForgeDirection forgeDirection) {
        return energyStorage.getCurrentEnergy();
    }

    @Override
    public int getMaxEnergyStored(ForgeDirection forgeDirection) {
        return energyStorage.getMaxStorage();
    }

    @Override
    public boolean canConnectEnergy(ForgeDirection forgeDirection) {
        return forgeDirection == ForgeDirection.UP || forgeDirection == ForgeDirection.DOWN;
    }

    @Override
    public int getEnergyToProvide() {
        return energyStorage.getCurrentEnergy();
    }

    @Override
    public int decrEnergy(int energyUse) {
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        markDirty();
        return energyStorage.transferEnergyOut(energyUse);
    }

    @Override
    public boolean canProvideEnergy() {
        return true;
    }

    @Override
    public boolean hasEnoughEnergy(int toUse) {
        return energyStorage.getCurrentEnergy() >= toUse;
    }

    @Override
    public int getInfoEnergyPerTick() {
        return 0;
    }

    @Override
    public int getInfoMaxEnergyPerTick() {
        return 0;
    }

    @Override
    public int getInfoEnergyStored() {
        return 0;
    }

    @Override
    public int getInfoMaxEnergyStored() {
        return 0;
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);
        tagCompound.setInteger("Energy", energyStorage.getCurrentEnergy());
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);
        energyStorage.setCurrentEnergy(tagCompound.getInteger("Energy"));
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tagCompound = new NBTTagCompound();
        writeToNBT(tagCompound);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tagCompound);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        readFromNBT(pkt.func_148857_g());
    }
}
