package at.korti.endermystic.client.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

/**
 * Created by Korti on 18.05.2015.
 */
public class BookContainer extends Container {

    public BookContainer(ItemStack stack) {

    }

    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_) {
        return true;
    }
}
