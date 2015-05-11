package at.korti.endermystic.client.render.blocks;

import at.korti.endermystic.ModInfo;
import at.korti.endermystic.client.model.EnergyDrainModel;
import at.korti.endermystic.tileEntity.TileEntityEnergyDrain;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * Created by Korti on 13.04.2015.
 */
public class EnergyDrainRenderer extends TileEntitySpecialRenderer{

    private EnergyDrainModel model;

    public EnergyDrainRenderer(){
        model = new EnergyDrainModel();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float scale) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        ResourceLocation texture = new ResourceLocation(ModInfo.MODID + ":textures/model/EnergyDrain.png");
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);

        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0F, 0F, 1F);
        this.model.render(null, 0F, 0F, -0.1F, 0F, 0F, 0.0625F);
        TileEntityEnergyDrain drain = (TileEntityEnergyDrain)tileEntity;

        if(drain.getStackInSlot(0) != null){
            this.model.renderCrystal(0.0625F);
        }
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}
