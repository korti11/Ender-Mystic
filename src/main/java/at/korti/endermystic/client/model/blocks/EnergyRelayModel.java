package at.korti.endermystic.client.model.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * EnergyRelay - Korti
 * Created using Tabula 4.1.1
 */
public class EnergyRelayModel extends ModelBase {
    public ModelRenderer Crystal;
    public ModelRenderer Crystal_1;
    public ModelRenderer Crystal_2;
    public ModelRenderer Crystal_3;
    public ModelRenderer Crystal_4;
    public ModelRenderer Crystal_5;
    public ModelRenderer Crystal_6;
    public ModelRenderer Crystal_7;
    public ModelRenderer Crystal_8;
    public ModelRenderer Holder;
    public ModelRenderer Holder_1;
    public ModelRenderer Holder_2;
    public ModelRenderer Holder_3;

    public EnergyRelayModel() {
        this.textureWidth = 32;
        this.textureHeight = 16;
        this.Crystal_1 = new ModelRenderer(this, 0, 0);
        this.Crystal_1.setRotationPoint(-0.5F, 13.0F, -0.5F);
        this.Crystal_1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Crystal_1, 0.0F, 0.0F, 0.4363323129985824F);
        this.Holder_2 = new ModelRenderer(this, 6, 3);
        this.Holder_2.setRotationPoint(-1.5F, 14.5F, -1.5F);
        this.Holder_2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
        this.Crystal = new ModelRenderer(this, 0, 0);
        this.Crystal.setRotationPoint(-0.5F, 13.0F, -0.5F);
        this.Crystal.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.Crystal_5 = new ModelRenderer(this, 0, 0);
        this.Crystal_5.setRotationPoint(-0.5F, 13.0F, -0.5F);
        this.Crystal_5.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Crystal_5, -0.4363323129985824F, 0.0F, 0.0F);
        this.Crystal_6 = new ModelRenderer(this, 0, 0);
        this.Crystal_6.setRotationPoint(-0.5F, 13.43F, -0.4F);
        this.Crystal_6.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Crystal_6, 0.4363323129985824F, 0.0F, 0.0F);
        this.Crystal_2 = new ModelRenderer(this, 0, 0);
        this.Crystal_2.setRotationPoint(-0.4F, 13.43F, -0.5F);
        this.Crystal_2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Crystal_2, 0.0F, 0.0F, -0.4363323129985824F);
        this.Holder_3 = new ModelRenderer(this, 6, 3);
        this.Holder_3.setRotationPoint(0.5F, 14.5F, -1.5F);
        this.Holder_3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
        this.Crystal_3 = new ModelRenderer(this, 0, 0);
        this.Crystal_3.setRotationPoint(-1.35F, 15.2F, -0.5F);
        this.Crystal_3.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Crystal_3, 0.0F, 0.0F, -0.4363323129985824F);
        this.Crystal_4 = new ModelRenderer(this, 0, 0);
        this.Crystal_4.setRotationPoint(0.45F, 14.78F, -0.5F);
        this.Crystal_4.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Crystal_4, 0.0F, 0.0F, 0.4363323129985824F);
        this.Holder_1 = new ModelRenderer(this, 6, 0);
        this.Holder_1.setRotationPoint(-1.5F, 14.5F, 0.5F);
        this.Holder_1.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
        this.Crystal_8 = new ModelRenderer(this, 0, 0);
        this.Crystal_8.setRotationPoint(-0.5F, 15.2F, -1.35F);
        this.Crystal_8.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Crystal_8, 0.4363323129985824F, 0.0F, 0.0F);
        this.Holder = new ModelRenderer(this, 6, 0);
        this.Holder.setRotationPoint(-1.5F, 14.5F, -1.5F);
        this.Holder.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
        this.Crystal_7 = new ModelRenderer(this, 0, 0);
        this.Crystal_7.setRotationPoint(-0.5F, 14.78F, 0.45F);
        this.Crystal_7.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Crystal_7, -0.4363323129985824F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Crystal_1.render(f5);
        this.Holder_2.render(f5);
        this.Crystal.render(f5);
        this.Crystal_5.render(f5);
        this.Crystal_6.render(f5);
        this.Crystal_2.render(f5);
        this.Holder_3.render(f5);
        this.Crystal_3.render(f5);
        this.Crystal_4.render(f5);
        this.Holder_1.render(f5);
        this.Crystal_8.render(f5);
        this.Holder.render(f5);
        this.Crystal_7.render(f5);
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
