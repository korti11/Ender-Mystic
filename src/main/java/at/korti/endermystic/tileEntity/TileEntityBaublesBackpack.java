package at.korti.endermystic.tileEntity;

import at.korti.endermystic.modintegration.baubles.api.IBauble;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Korti on 05.12.2014.
 */
public class TileEntityBaublesBackpack extends TileEntity implements IInventory {

    private ItemStack[] inventory;

    public TileEntityBaublesBackpack() {
        inventory = new ItemStack[36];
    }

    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        ItemStack stack = getStackInSlot(slot);

        if(stack != null){
            if(stack.stackSize <= amount){
                setInventorySlotContents(slot, null);
            }
            else{
                stack = stack.splitStack(amount);
            }
        }
        return stack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        return getStackInSlot(slot);
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        if(stack != null && stack.stackSize <= getInventoryStackLimit()){
            stack.stackSize = getInventoryStackLimit();
        }

        inventory[slot] = stack;
    }

    @Override
    public String getInventoryName() {
        return "Baubles Backpack";
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
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        return stack.getItem() instanceof IBauble;
    }
}
