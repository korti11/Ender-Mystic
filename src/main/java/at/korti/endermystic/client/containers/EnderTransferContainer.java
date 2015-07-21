package at.korti.endermystic.client.containers;

import at.korti.endermystic.items.WorldStorage;
import at.korti.endermystic.tileEntity.TileEntityEnderTranfer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by Korti on 21.06.2015.
 */
public class EnderTransferContainer extends Container {

    private TileEntityEnderTranfer tileEnderTransfer;

    public EnderTransferContainer(InventoryPlayer inventoryPlayer, TileEntityEnderTranfer tileEnderTransfer) {
        this.tileEnderTransfer = tileEnderTransfer;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (int i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }
        this.addSlotToContainer(new SlotWorldStorage(tileEnderTransfer, 0, 80, 35));
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.tileEnderTransfer.isUseableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotInt) {
        Slot slot = this.getSlot(slotInt);

        if (slot != null && slot.getHasStack()) {
            ItemStack stack = slot.getStack();
            ItemStack result = stack.copy();

            if (slotInt >= 36) {
                if (!mergeItemStack(stack, 0, 36, false)) {
                    return null;
                }
            }
            else if (!(stack.getItem() instanceof WorldStorage) || !mergeItemStack(stack, 36, 36 + tileEnderTransfer.getSizeInventory(), false)) {
                return null;
            }

            if (stack.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }

            slot.onPickupFromSlot(player, stack);

            return result;
        }
        return null;
    }

    private class SlotWorldStorage extends Slot {

        public SlotWorldStorage(IInventory inventory, int slotIndex, int x, int y) {
            super(inventory, slotIndex, x, y);
        }

        @Override
        public boolean isItemValid(ItemStack stack) {
            return stack.getItem() instanceof WorldStorage;
        }
    }
}
