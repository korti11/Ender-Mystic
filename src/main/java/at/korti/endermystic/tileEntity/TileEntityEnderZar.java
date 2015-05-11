package at.korti.endermystic.tileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Korti on 07.05.2015.
 */
public class TileEntityEnderZar extends TileEntity {

    private int timer = 120;
    private int storedEnergy = 0;

    @Override
    public void updateEntity() {
        if(timer == 0) {
            worldObj.setBlockToAir(xCoord, yCoord, zCoord);
            worldObj.removeTileEntity(xCoord, yCoord, zCoord);
            worldObj.createExplosion(null, xCoord, yCoord, zCoord, storedEnergy / 50, true);
        }
        else if(storedEnergy != 0) {
            timer--;
            spawnParticle();
        }
    }

    private void spawnParticle(){
        for (int l = 0; l < 128; ++l) {
            float f = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
            float f1 = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
            float f2 = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
            this.worldObj.spawnParticle("portal", xCoord + 0.5, yCoord - 0.75, zCoord + 0.5, (double) f, (double) f1, (double) f2);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);
        tagCompound.setShort("Timer", (short) timer);
        tagCompound.setShort("Energy", (short) storedEnergy);
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);
        timer = tagCompound.getShort("Timer");
        storedEnergy = tagCompound.getShort("Energy");
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        this.writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        this.readFromNBT(pkt.func_148857_g());
    }

    public void setStoredEnergy(int storedEnergy) {
        this.storedEnergy = storedEnergy;
    }
}
