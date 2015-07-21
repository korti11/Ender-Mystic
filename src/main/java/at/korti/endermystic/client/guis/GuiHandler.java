package at.korti.endermystic.client.guis;

import at.korti.endermystic.EnderMystic;
import at.korti.endermystic.client.containers.BookContainer;
import at.korti.endermystic.client.containers.EnderTransferContainer;
import at.korti.endermystic.client.guis.book.BookPage;
import at.korti.endermystic.items.ModItems;
import at.korti.endermystic.tileEntity.TileEntityEnderTranfer;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Korti on 09.12.2014.
 */
public class GuiHandler implements IGuiHandler {

    public GuiHandler() {
        NetworkRegistry.INSTANCE.registerGuiHandler(EnderMystic.instance, this);
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID){
            case 1:
                ItemStack stack = player.inventory.getCurrentItem();
                if (stack.getItem() == ModItems.bookItem) {
                    return new BookContainer(stack);
                }
                break;
            case 2:
                return new EnderTransferContainer(player.inventory, (TileEntityEnderTranfer) world.getTileEntity(x, y, z));
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID){
            case 1:
                ItemStack stack = player.inventory.getCurrentItem();
                if (stack.getItem() == ModItems.bookItem) {
                    return new BookPage(true);
                }
                break;
            case 2:
                return new GuiEnderTransfer(player.inventory, (TileEntityEnderTranfer) world.getTileEntity(x, y, z));
        }
        return null;
    }
}
