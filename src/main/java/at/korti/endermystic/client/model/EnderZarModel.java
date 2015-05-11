package at.korti.endermystic.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Ender Zar - Korti
 * Created using Tabula 4.1.1
 */
public class EnderZarModel extends ModelBase {
    public ModelRenderer Core;
    public ModelRenderer Border;
    public ModelRenderer Border_1;
    public ModelRenderer Border_2;
    public ModelRenderer Border_3;

    public EnderZarModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Core = new ModelRenderer(this, 0, 2);
        this.Core.setRotationPoint(-3.0F, 22.0F, -3.0F);
        this.Core.addBox(0.0F, 0.0F, 0.0F, 6, 2, 6, 0.0F);
        this.Border_2 = new ModelRenderer(this, 0, 0);
        this.Border_2.setRotationPoint(-4.0F, 23.0F, 4.0F);
        this.Border_2.addBox(0.0F, 0.0F, 0.0F, 8, 1, 1, 0.0F);
        this.setRotateAngle(Border_2, 0.0F, 1.5707963267948966F, 0.0F);
        this.Border_1 = new ModelRenderer(this, 0, 0);
        this.Border_1.setRotationPoint(-4.0F, 23.0F, -4.0F);
        this.Border_1.addBox(0.0F, 0.0F, 0.0F, 8, 1, 1, 0.0F);
        this.Border = new ModelRenderer(this, 0, 0);
        this.Border.setRotationPoint(-4.0F, 23.0F, 3.0F);
        this.Border.addBox(0.0F, 0.0F, 0.0F, 8, 1, 1, 0.0F);
        this.Border_3 = new ModelRenderer(this, 0, 0);
        this.Border_3.setRotationPoint(3.0F, 23.0F, 4.0F);
        this.Border_3.addBox(0.0F, 0.0F, 0.0F, 8, 1, 1, 0.0F);
        this.setRotateAngle(Border_3, 0.0F, 1.5707963267948966F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Core.render(f5);
        this.Border_2.render(f5);
        this.Border_1.render(f5);
        this.Border.render(f5);
        this.Border_3.render(f5);
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
