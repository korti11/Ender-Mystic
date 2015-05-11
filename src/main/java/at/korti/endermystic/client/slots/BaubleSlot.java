package at.korti.endermystic.client.slots;

import at.korti.endermystic.modintegration.baubles.api.IBauble;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by Korti on 05.12.2014.
 */
public class BaubleSlot extends Slot {

    public BaubleSlot(IInventory inventory, int id, int x, int y) {
        super(inventory, id, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return stack.getItem() instanceof IBauble;
    }
}
