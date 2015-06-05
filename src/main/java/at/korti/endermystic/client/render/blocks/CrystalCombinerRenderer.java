package at.korti.endermystic.client.render.blocks;

import at.korti.endermystic.client.model.CrystalCombinerModel;
import at.korti.endermystic.tileEntity.TileEntityCrystalCombiner;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

/**
 * Created by Korti on 11.04.2015.
 */
public class CrystalCombinerRenderer extends TileEntityBlockRenderer{

    public CrystalCombinerRenderer(){
        super(new CrystalCombinerModel(), "textures/model/CrystalCombiner.png");
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float scale) {

        TileEntityCrystalCombiner combiner = (TileEntityCrystalCombiner)tileEntity;

        super.renderTileEntityAt(tileEntity, x, y, z, scale);

        for(int i = 0; i < combiner.getSizeInventory(); i++){
            if(combiner.getStackInSlot(i) != null) {
                EntityItem entityItem = new EntityItem(combiner.getWorldObj(), x, y, z, combiner.getStackInSlot(i));
                GL11.glPushMatrix();
                entityItem.hoverStart = 0F;
                RenderItem.renderInFrame = true;
                GL11.glTranslatef((float)x + getXForSlot(i), (float)y + getYForSlot(i), (float)z + getZForSlot(i));
                GL11.glRotatef(180, 0, 1, 1);
                RenderManager.instance.renderEntityWithPosYaw(entityItem, 0D, 0D, 0D, 0F, 0F);
                RenderItem.renderInFrame = false;
                GL11.glPopMatrix();
            }
        }
    }

    private float getXForSlot(int slot){
        switch (slot){
            case 0:
                return -0.125F;
            case 2:
                return 1.025F;
            default:
                return 0.5F;
        }
    }

    private float getYForSlot(int slot){
        switch (slot){
            case 0:
                return 0.7F;
            case 1:
                return 0.9F;
            case 2:
                return 0.7F;
            case 3:
                return 0.9F;
            default:
                return 0.8F;
        }
    }

    private float getZForSlot(int slot){
        switch (slot){
            case 1:
                return -0.3F;
            case 3:
                return 0.925F;
            default:
                return 0.325F;
        }
    }

}
