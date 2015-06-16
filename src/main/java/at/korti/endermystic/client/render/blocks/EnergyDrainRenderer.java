package at.korti.endermystic.client.render.blocks;

import at.korti.endermystic.client.model.blocks.EnergyDrainModel;
import at.korti.endermystic.tileEntity.TileEntityEnergyDrain;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

/**
 * Created by Korti on 13.04.2015.
 */
public class EnergyDrainRenderer extends TileEntityBlockRenderer{

    public EnergyDrainRenderer(){
        super(new EnergyDrainModel(), "textures/model/EnergyDrain.png");
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float scale) {
        super.renderTileEntityAt(tileEntity, x, y, z, scale);
        TileEntityEnergyDrain drain = (TileEntityEnergyDrain)tileEntity;

        if(drain.getStackInSlot(0) != null){
            GL11.glPushMatrix();
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            GL11.glRotatef(180F, 0F, 0F, 1F);
            ((EnergyDrainModel) this.model).renderCrystal(0.0625F);
            GL11.glPopMatrix();
        }
    }
}
