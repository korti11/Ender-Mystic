package at.korti.endermystic.client.render.blocks;

import at.korti.endermystic.ModInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by Korti on 03.06.2015.
 */
public class TileEntityBlockRenderer extends TileEntitySpecialRenderer {

    protected ModelBase model;
    protected String texture;

    public TileEntityBlockRenderer(ModelBase model, String texture) {
        this.model = model;
        this.texture = texture;
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float scale) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        ResourceLocation texture = new ResourceLocation(ModInfo.MODID + ":" + this.texture);
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);

        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0F, 0F, 1F);
        this.model.render(null, 0F, 0F, -0.1F, 0F, 0F, 0.0625F);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}
