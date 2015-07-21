package at.korti.endermystic.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.List;

/**
 * Created by Korti on 21.06.2015.
 */
public class WorldStorage extends ModItem {

    private int storageSize;

    public WorldStorage(int storageSize) {
        super("WorldStorage");

        this.storageSize = storageSize;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean p_77624_4_) {
        super.addInformation(stack, player, list, p_77624_4_);

        list.add("Storage Size: " + storageSize + " x " + storageSize + " x " + storageSize);

        if (stack.stackTagCompound == null) {
            stack.stackTagCompound = new NBTTagCompound();
        }

        if (stack.stackTagCompound.hasKey("World")) {
            list.add("World stored");
        }
    }

    public int getStorageSize() {
        return storageSize;
    }
}
