package at.korti.endermystic.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

/**
 * Created by Korti on 27.10.2014.
 */
public class ChangeItemPacket extends AbstractPacket {

    private ItemStack stack;

    @Override
    public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
        ByteBufUtils.writeItemStack(buffer, stack);
    }

    @Override
    public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
        stack = ByteBufUtils.readItemStack(buffer);
    }

    @Override
    public void handleClientSide(EntityPlayer player) {

    }

    @Override
    public void handleServerSide(EntityPlayer player) {
        player.inventory.setInventorySlotContents(player.inventory.currentItem, stack);
    }

    public void setStack(ItemStack stack) {
        this.stack = stack;
    }
}
