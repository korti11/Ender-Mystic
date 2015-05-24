package at.korti.endermystic.items;

import at.korti.endermystic.EnderMystic;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Korti on 18.05.2015.
 */
public class BookItem extends ModItem {
    public BookItem() {
        super("Book", 1);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if(world.isRemote) {
            FMLNetworkHandler.openGui(player, EnderMystic.instance, 1, world, (int) player.posX, (int) player.posY, (int) player.posZ);
        }
        return super.onItemRightClick(stack, world, player);
    }
}
