package at.korti.endermystic.client.render.items;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * Created by Korti on 15.04.2015.
 */
public class EnergyDrainItemRenderer implements IItemRenderer {

    private TileEntitySpecialRenderer renderer;
    private TileEntity entity;

    public EnergyDrainItemRenderer(TileEntitySpecialRenderer renderer, TileEntity entity) {
        this.renderer = renderer;
        this.entity = entity;
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        if(type == ItemRenderType.ENTITY) {
            GL11.glTranslatef(-0.5F, 0.0F, -0.5F);
        }
        this.renderer.renderTileEntityAt(this.entity, 0, 0, 0, 0F);
    }
}
