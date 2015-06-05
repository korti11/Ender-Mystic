package at.korti.endermystic.client.render.blocks;

import at.korti.endermystic.client.model.OrbInfuserModel;
import at.korti.endermystic.tileEntity.TileEntityOrbInfuser;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

/**
 * Created by Korti on 13.05.2015.
 */
public class OrbInfuserRenderer extends TileEntityBlockRenderer {

    public OrbInfuserRenderer(){
        super(new OrbInfuserModel(), "textures/model/OrbInfuser.png");
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float scale) {

        TileEntityOrbInfuser orbInfuser = (TileEntityOrbInfuser) tileEntity;
        super.renderTileEntityAt(tileEntity,x,y,z,scale);

        for (int i = 0; i < orbInfuser.getSizeInventory(); i++) {
            if (orbInfuser.getStackInSlot(i) != null) {
                EntityItem item = new EntityItem(tileEntity.getWorldObj(), x, y, z, orbInfuser.getStackInSlot(i));
                GL11.glPushMatrix();
                item.hoverStart = 0F;
                RenderItem.renderInFrame = true;
                GL11.glTranslatef((float) x + getXForSlot(i), (float) y + 0.64F, (float) z + getZForSlot(i));
                rotateItem(i);
                GL11.glScalef(0.5F, 0.5F, 0.5F);
                RenderManager.instance.renderEntityWithPosYaw(item, 0D, 0D, 0D, 0F, 0F);
                RenderItem.renderInFrame = false;
                GL11.glPopMatrix();
            }
        }
    }

    private float getXForSlot(int slot) {
        switch (slot) {
            case 0:
                return 0.50F;
            case 1:
                return 0.17F;
            case 2:
                return 0.16F;
            case 3:
                return 0.18F;
            case 4:
                return 0.50F;
            case 5:
                return 0.80F;
            case 6:
                return 0.85F;
            case 7:
                return 0.81F;
            case 8:
                return 0.5F;
            default:
                return 0;
        }
    }

    private void rotateItem(int slot) {
        if (slot == 0 || slot == 4) {
            GL11.glRotatef(180, 0, 1, 0);
        }
        else if (slot == 2 || slot == 6) {
            GL11.glRotatef(90, 0, 1, 0);
        }
        else if (slot == 8) {
            GL11.glRotatef(180, 0, 1, 1);
        }
        else if(slot == 1 || slot == 5){
            GL11.glRotatef(-45, 0, 1, 0);
        }
        else {
            GL11.glRotatef(45, 0, 1, 0);
        }
    }

    private float getZForSlot(int slot) {
        switch (slot) {
            case 0:
                return 0.84F;
            case 1:
                return 0.80F;
            case 2:
                return 0.51F;
            case 3:
                return 0.20F;
            case 4:
                return 0.15F;
            case 5:
                return 0.18F;
            case 6:
                return 0.51F;
            case 7:
                return 0.81F;
            case 8:
                return 0.4F;
            default:
                return 0;
        }
    }
}
