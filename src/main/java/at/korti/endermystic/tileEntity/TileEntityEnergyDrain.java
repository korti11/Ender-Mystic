package at.korti.endermystic.tileEntity;

import at.korti.endermystic.EnderMystic;
import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetworkHandler;
import at.korti.endermystic.api.mysticEnergyNetwork.IEnergyProvider;
import at.korti.endermystic.items.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Korti on 13.04.2015.
 */
public class TileEntityEnergyDrain extends TileEntity implements IInventory, IEnergyProvider{

    public ItemStack inventory = null;

    @Override
    public int getSizeInventory() {
        return 1;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return inventory;
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        if(inventory != null){
            if(inventory.stackSize <= amount){
                setInventorySlotContents(0, null);
            }
            else {
                inventory = inventory.splitStack(amount);
            }
        }
        return inventory;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        return inventory;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        if(isItemValidForSlot(slot, stack)) {
            inventory = stack;
            if (stack != null && stack.stackSize > getInventoryStackLimit()) {
                stack.stackSize = getInventoryStackLimit();
            }
            markDirty();
        }
    }

    @Override
    public String getInventoryName() {
        return "EnergyDrain";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 1;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) <= 64;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public void updateEntity() {
        for (int l = 0; l < 128 && getStackInSlot(0) != null; ++l)
        {
            if(worldObj.rand.nextFloat() < 0.1F)
                this.worldObj.spawnParticle("portal", xCoord + 0.5, yCoord + 0.75, zCoord + 0.5, 0, -0.5, 0);

        }
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        if(inventory != null) {
            NBTTagList tagList = new NBTTagList();
            NBTTagCompound temp = new NBTTagCompound();
            temp.setByte("Slot", (byte) 0);
            inventory.writeToNBT(temp);
            tagList.appendTag(temp);
            compound.setTag("Inventory", tagList);
        }
        super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        NBTTagList tagList = compound.getTagList("Inventory" ,10);
        NBTTagCompound temp = tagList.getCompoundTagAt(0);
        byte slot = temp.getByte("Slot");
        setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(temp));
        super.readFromNBT(compound);
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        this.writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        readFromNBT(pkt.func_148857_g());
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        return stack == null || stack.getItem() == ModItems.crystalItem && stack.getItemDamage() == 7;
    }

    private String getOwner(ItemStack stack){
        if(stack != null && stack.stackTagCompound != null) {
            return stack.stackTagCompound.getString("em_owner");
        }
        return "";
    }

    @Override
    public int getEnergyToProvide() {
        ItemStack stack = getStackInSlot(0);
        if (stack != null) {
            return EnergyNetworkHandler.getEnergy(getOwner(stack));
        }

        return 0;
    }

    @Override
    public int decrEnergy(int energyUse) {
        ItemStack stack = getStackInSlot(0);
        if(stack != null && getEnergyToProvide() >= 0) {
            EnergyNetworkHandler.decEnergy(energyUse, getOwner(stack));
            return energyUse;
        }
        return 0;
    }

    @Override
    public boolean canProvideEnergy() {
        return inventory != null && inventory.stackTagCompound != null && inventory.stackTagCompound.hasKey("em_owner");
    }

    @Override
    public boolean hasEnoughEnergy(int toUse) {
        return getEnergyToProvide() >= toUse;
    }
}
