package at.korti.endermystic.client.model.items;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Mjoelnir - Korti
 * Created using Tabula 4.1.1
 */
public class ThunderWand extends ModelBase {
    public ModelRenderer RodEnd;
    public ModelRenderer Rod;
    public ModelRenderer HammerHead;

    public ThunderWand() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Rod = new ModelRenderer(this, 0, 0);
        this.Rod.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.Rod.addBox(-1.0F, 0.0F, -1.0F, 2, 10, 2, 0.0F);
        this.RodEnd = new ModelRenderer(this, 8, 0);
        this.RodEnd.setRotationPoint(0.0F, 22.0F, 0.0F);
        this.RodEnd.addBox(-1.5F, 0.0F, -1.5F, 3, 2, 3, 0.0F);
        this.HammerHead = new ModelRenderer(this, 16, 0);
        this.HammerHead.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.HammerHead.addBox(-5.0F, 0.0F, -3.0F, 10, 5, 6, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Rod.render(f5);
        this.RodEnd.render(f5);
        this.HammerHead.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
