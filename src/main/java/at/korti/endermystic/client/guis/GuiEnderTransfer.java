package at.korti.endermystic.client.guis;

import at.korti.endermystic.ModInfo;
import at.korti.endermystic.client.containers.EnderTransferContainer;
import at.korti.endermystic.tileEntity.TileEntityEnderTranfer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by Korti on 21.06.2015.
 */
public class GuiEnderTransfer extends GuiContainer {

    private static final ResourceLocation guiTexture = new ResourceLocation(ModInfo.MODID + ":textures/gui/EnderTransfer.png");

    public GuiEnderTransfer(InventoryPlayer inventoryPlayer, TileEntityEnderTranfer tileEnderTransfer) {
        super(new EnderTransferContainer(inventoryPlayer, tileEnderTransfer));
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(guiTexture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }
}
