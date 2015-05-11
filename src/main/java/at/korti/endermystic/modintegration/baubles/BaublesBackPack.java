package at.korti.endermystic.modintegration.baubles;

import at.korti.endermystic.EnderMystic;
import at.korti.endermystic.items.ModItem;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Korti on 05.12.2014.
 */
public class BaublesBackPack extends ModItem {

    public BaublesBackPack(String name) {
        super(name, 1);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if(!world.isRemote){
            FMLNetworkHandler.openGui(player, EnderMystic.instance, 0, world, (int)player.posX, (int)player.posY, (int)player.posZ);
        }

        return super.onItemRightClick(stack, world, player);
    }
}
