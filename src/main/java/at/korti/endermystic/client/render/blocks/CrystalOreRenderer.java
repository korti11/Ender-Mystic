package at.korti.endermystic.client.render.blocks;

import at.korti.endermystic.blocks.CrystalOre;
import at.korti.endermystic.client.render.RenderConfig;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

import java.awt.*;

/**
 * Created by Korti on 04.04.2015.
 */
public class CrystalOreRenderer extends BlockRenderer implements ISimpleBlockRenderingHandler {

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
        block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        renderer.setRenderBoundsFromBlock(block);
        drawFaces(renderer, block, ((CrystalOre)block).stoneIcon, false);
        Color color = new Color(CrystalOre.colors[metadata]);
        float r = (float)color.getRed() / 255.0F;
        float g = (float)color.getGreen() / 255.0F;
        float b = (float)color.getBlue() / 255.0F;
        GL11.glColor3f(r, g, b);
        drawFaces(renderer, block, ((CrystalOre) block).crystalIcon, false);
        GL11.glColor3f(1.0F, 1.0F, 1.0F);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        int bb = setBrightness(world, x, y, z, block);
        int metadata = world.getBlockMetadata(x, y, z);
        block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        renderer.setRenderBoundsFromBlock(block);
        Tessellator t = Tessellator.instance;
        t.setColorOpaque_I(CrystalOre.colors[metadata]);
        renderAllSides(world, x, y, z, block, renderer, ((CrystalOre) block).crystalIcon, false);
        t.setBrightness(bb);
        t.setBrightness(Math.max(bb, 160));
        t.setColorOpaque_I(8947848);
        renderAllSides(world, x, y, z, block, renderer, ((CrystalOre) block).stoneIcon, false);
        return true;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return true;
    }

    @Override
    public int getRenderId() {
        return RenderConfig.CrystelOreRenderId;
    }
}
