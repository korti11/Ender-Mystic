package at.korti.endermystic.client.render.blocks;

import at.korti.endermystic.client.model.blocks.EnderTransferModel;
import at.korti.endermystic.tileEntity.TileEntityEnderTranfer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;


/**
 * Created by Korti on 15.08.2015.
 */
public class EnderTransferRenderer extends TileEntityBlockRenderer {

    private float rotationY = 0;

    public EnderTransferRenderer() {
        super(new EnderTransferModel(), "textures/model/EnderTransfer.png");
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float scale) {
        super.renderTileEntityAt(tileEntity, x, y, z, scale);
        TileEntityEnderTranfer enderTranfer = (TileEntityEnderTranfer) tileEntity;

        if (enderTranfer.getStackInSlot(0) != null) {
            EntityItem item = new EntityItem(tileEntity.getWorldObj(), x, y, z, enderTranfer.getStackInSlot(0));
            GL11.glPushMatrix();
            item.hoverStart = 0F;
            RenderItem.renderInFrame = true;
            GL11.glTranslatef((float) x + 0.5F, (float) y + 0.40F, (float) z + 0.5F);
            GL11.glScalef(0.5F, 0.5F, 0.5F);
            rotationY = rotationY < 360 ? rotationY + 2.5F : 0;
            GL11.glRotatef(rotationY, 0, 1, 0);
            RenderManager.instance.renderEntityWithPosYaw(item, 0D, 0D, 0D, 0F, 0F);
            RenderItem.renderInFrame = false;
            GL11.glPopMatrix();
        }
    }
}
