package at.korti.endermystic.api.helper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;

/**
 * Created by Korti on 21.09.2015.
 */
public class InventoryHelper {

    public static void setStackInSlot(int slot, EntityPlayer player, IInventory inventory){
        if(inventory.getStackInSlot(slot) == null && player.inventory.getCurrentItem() != null && inventory.isItemValidForSlot(slot, player.inventory.getCurrentItem())) {
            inventory.setInventorySlotContents(slot, player.inventory.getCurrentItem().copy());
            player.inventory.setInventorySlotContents(player.inventory.currentItem, player.inventory.decrStackSize(player.inventory.currentItem, player.inventory.getStackInSlot(player.inventory.currentItem).stackSize - 1));
        }
        else if(player.inventory.getCurrentItem() == null) {
            player.inventory.addItemStackToInventory(inventory.getStackInSlot(slot));
            inventory.setInventorySlotContents(slot, null);
        }
    }

    public static boolean isBetween(float min, float max, float current){
        return (((float)(int)(current * 100)) / 100) >= min && (((float)(int)(current * 100)) / 100) <= max;
    }

}
