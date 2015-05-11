package at.korti.endermystic.client.render.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

/**
 * Created by Korti on 04.04.2015.
 */
public class BlockRenderer {

    public static void drawFaces(RenderBlocks renderer, Block block, IIcon icon, boolean solidtop){
        drawFaces(renderer, block, icon, icon, icon, icon, icon, icon, solidtop);
    }

    public static void drawFaces(RenderBlocks renderer, Block block, IIcon i1, IIcon i2, IIcon i3, IIcon i4, IIcon i5, IIcon i6, boolean solidtop){
        Tessellator tessellator = Tessellator.instance;
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        tessellator.startDrawingQuads();
        tessellator.addTranslation(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, i1);
        tessellator.draw();
        if(solidtop){
            GL11.glDisable(3008);
        }

        tessellator.startDrawingQuads();
        tessellator.addTranslation(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, i2);
        tessellator.draw();
        if(solidtop){
            GL11.glDisable(3008);
        }

        tessellator.startDrawingQuads();
        tessellator.addTranslation(0.0F, 0.0F, 1.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, -1.0D, i3);
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.addTranslation(0.0F, 0.0F, -1.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, i4);
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.addTranslation(1.0F, 0.0F, 0.0F);
        renderer.renderFaceZNeg(block, -1.0D, 0.0D, 0.0D, i5);
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.addTranslation(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, i6);
        tessellator.draw();
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }

    public static int setBrightness(IBlockAccess blockAccess, int i, int j, int k, Block block){
        Tessellator tessellator = Tessellator.instance;

        int mb = block.getMixedBrightnessForBlock(blockAccess, i, j, k);
        tessellator.setBrightness(mb);
        float f = 1.0F;
        int l = block.getLightValue(blockAccess, i, j, k);
        float f1 = (float)(l >> 16 & 255) / 255.0F;
        float f2 = (float)(l >> 8 & 255) / 255.0F;
        float f3 = (float)(l & 255) / 255.0F;
        if(EntityRenderer.anaglyphEnable){
            float f6 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
            float f4 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
            float f7 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
            f1 = f6;
            f2 = f4;
            f3 = f7;
        }

        tessellator.setNormal(f * f1, f * f2, f * f3);
        //tessellator.setColorOpaque_F(f * f1, f * f2, f * f3);
        return mb;
    }

    protected static void renderAllSides(IBlockAccess world, int x, int y, int z, Block block, RenderBlocks renderer, IIcon tex, boolean allsides){
        if(allsides || block.shouldSideBeRendered(world, x + 1, y, z, 6)){
            renderer.renderFaceXPos(block, (double)x, (double)y, (double)z, tex);
        }

        if(allsides || block.shouldSideBeRendered(world, x - 1, y, z, 6)) {
            renderer.renderFaceXNeg(block, (double)x, (double)y, (double)z, tex);
        }

        if(allsides || block.shouldSideBeRendered(world, x, y, z + 1, 6)) {
            renderer.renderFaceZPos(block, (double)x, (double)y, (double)z, tex);
        }

        if(allsides || block.shouldSideBeRendered(world, x, y, z - 1, 6)) {
            renderer.renderFaceZNeg(block, (double)x, (double)y, (double)z, tex);
        }

        if(allsides || block.shouldSideBeRendered(world, x, y + 1, z, 6)) {
            renderer.renderFaceYPos(block, (double)x, (double)y, (double)z, tex);
        }

        if(allsides || block.shouldSideBeRendered(world, x, y - 1, z, 6)) {
            renderer.renderFaceYNeg(block, (double)x, (double)y, (double)z, tex);
        }
    }

}
