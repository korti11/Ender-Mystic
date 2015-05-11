package at.korti.endermystic.client.render.blocks;

import at.korti.endermystic.ModInfo;
import at.korti.endermystic.client.model.EnderZarModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by Korti on 07.05.2015.
 */
public class EnderZarRenderer extends TileEntitySpecialRenderer {

    private EnderZarModel model;

    public EnderZarRenderer() {
        model = new EnderZarModel();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float scale) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ModInfo.MODID + ":textures/model/Ender Zar.png"));

        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0F, 0F, 1F);
        this.model.render(null, 0F, 0F, -0.1F, 0F, 0F, 0.0625F);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}
