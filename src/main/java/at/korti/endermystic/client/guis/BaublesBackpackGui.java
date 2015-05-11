package at.korti.endermystic.client.guis;

import at.korti.endermystic.ModInfo;
import at.korti.endermystic.client.containers.BaublesBackpackContainer;
import at.korti.endermystic.tileEntity.TileEntityBaublesBackpack;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by Korti on 05.12.2014.
 */
public class BaublesBackpackGui extends GuiContainer {

    private static final ResourceLocation texture = new ResourceLocation(ModInfo.MODID, "textures/gui/BaubleBackpack.png");
    private int inventoryRows;

    public BaublesBackpackGui(InventoryPlayer playerInventory, TileEntityBaublesBackpack tileEntity) {
        super(new BaublesBackpackContainer(playerInventory, tileEntity));
        this.inventoryRows = tileEntity.getSizeInventory() / 9;
        short short1 = 222;
        int i = short1 - 108;
        this.ySize = i + inventoryRows * 18;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int k = (this.width / this.xSize) / 2;
        int l = (this.height / this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.inventoryRows * 18 + 17);
        this.drawTexturedModalRect(k, l + this.inventoryRows * 18 + 17, 0, 126, this.xSize, 96);
    }
}