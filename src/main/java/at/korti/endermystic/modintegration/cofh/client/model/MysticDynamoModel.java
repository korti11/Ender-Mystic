package at.korti.endermystic.modintegration.cofh.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * MysticDynamo - Korti
 * Created using Tabula 4.1.1
 */
public class MysticDynamoModel extends ModelBase {
    public ModelRenderer Base;
    public ModelRenderer Corner;
    public ModelRenderer Corner_1;
    public ModelRenderer Corner_2;
    public ModelRenderer Corner_3;
    public ModelRenderer Top;
    public ModelRenderer Crystal;
    public ModelRenderer Crystal_1;
    public ModelRenderer Crystal_2;
    public ModelRenderer Crystal_3;
    public ModelRenderer Crystal_4;
    public ModelRenderer Crystal_5;
    public ModelRenderer Crystal_6;
    public ModelRenderer Crystal_7;
    public ModelRenderer Base_1;
    public ModelRenderer IronRod;
    public ModelRenderer IronRod_1;
    public ModelRenderer IronRod_2;
    public ModelRenderer IronRod_3;
    public ModelRenderer IronRod_4;
    public ModelRenderer IronRod_5;
    public ModelRenderer IronRod_6;

    public MysticDynamoModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.IronRod_2 = new ModelRenderer(this, 16, 17);
        this.IronRod_2.setRotationPoint(7.0F, 9.5F, 7.0F);
        this.IronRod_2.addBox(0.0F, -0.5F, -0.5F, 11, 1, 1, 0.0F);
        this.setRotateAngle(IronRod_2, 1.0471975511965976F, 2.530727415391778F, -0.7853981633974483F);
        this.Crystal_6 = new ModelRenderer(this, 0, 0);
        this.Crystal_6.setRotationPoint(1.0F, 19.0F, 0.0F);
        this.Crystal_6.addBox(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Crystal_6, 0.0F, 0.0F, -0.4363323129985824F);
        this.Corner_1 = new ModelRenderer(this, 49, 0);
        this.Corner_1.setRotationPoint(7.0F, 9.0F, -7.0F);
        this.Corner_1.addBox(-1.0F, 0.0F, -1.0F, 2, 14, 2, 0.0F);
        this.Top = new ModelRenderer(this, 0, 0);
        this.Top.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.Top.addBox(-8.0F, 0.0F, -8.0F, 16, 1, 16, 0.0F);
        this.IronRod_5 = new ModelRenderer(this, 16, 19);
        this.IronRod_5.setRotationPoint(-7.0F, 8.0F, 0.0F);
        this.IronRod_5.addBox(0.0F, 0.0F, -0.5F, 9, 1, 1, 0.0F);
        this.setRotateAngle(IronRod_5, 0.0F, 0.0F, 0.7853981633974483F);
        this.Base = new ModelRenderer(this, 0, 0);
        this.Base.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.Base.addBox(-8.0F, 0.0F, -8.0F, 16, 1, 16, 0.0F);
        this.Crystal_7 = new ModelRenderer(this, 0, 0);
        this.Crystal_7.setRotationPoint(-1.0F, 19.0F, 0.0F);
        this.Crystal_7.addBox(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Crystal_7, 0.0F, 0.0F, 0.4363323129985824F);
        this.Base_1 = new ModelRenderer(this, 5, 0);
        this.Base_1.setRotationPoint(0.0F, 22.0F, 0.0F);
        this.Base_1.addBox(-1.0F, 0.0F, -1.0F, 2, 1, 2, 0.0F);
        this.IronRod = new ModelRenderer(this, 16, 17);
        this.IronRod.setRotationPoint(-7.0F, 9.5F, 7.0F);
        this.IronRod.addBox(0.0F, -0.5F, -0.5F, 11, 1, 1, 0.0F);
        this.setRotateAngle(IronRod, -1.0471975511965976F, 0.6108652381980153F, 0.7853981633974483F);
        this.Crystal_1 = new ModelRenderer(this, 0, 0);
        this.Crystal_1.setRotationPoint(-1.0F, 21.0F, 0.0F);
        this.Crystal_1.addBox(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Crystal_1, 0.0F, 0.0F, -0.4363323129985824F);
        this.Crystal_3 = new ModelRenderer(this, 0, 0);
        this.Crystal_3.setRotationPoint(0.0F, 21.0F, 1.0F);
        this.Crystal_3.addBox(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Crystal_3, -0.4363323129985824F, 0.0F, 0.0F);
        this.IronRod_6 = new ModelRenderer(this, 16, 19);
        this.IronRod_6.setRotationPoint(7.0F, 8.0F, 0.0F);
        this.IronRod_6.addBox(-9.0F, 0.0F, -0.5F, 9, 1, 1, 0.0F);
        this.setRotateAngle(IronRod_6, 0.0F, 0.0F, -0.7853981633974483F);
        this.IronRod_4 = new ModelRenderer(this, 8, 17);
        this.IronRod_4.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.IronRod_4.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
        this.Crystal = new ModelRenderer(this, 0, 0);
        this.Crystal.setRotationPoint(1.0F, 21.0F, 0.0F);
        this.Crystal.addBox(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Crystal, 0.0F, 0.0F, 0.4363323129985824F);
        this.IronRod_3 = new ModelRenderer(this, 16, 17);
        this.IronRod_3.setRotationPoint(7.0F, 9.5F, -7.0F);
        this.IronRod_3.addBox(0.0F, -0.5F, -0.5F, 11, 1, 1, 0.0F);
        this.setRotateAngle(IronRod_3, -1.0471975511965976F, -2.530727415391778F, -0.7853981633974483F);
        this.Crystal_5 = new ModelRenderer(this, 0, 0);
        this.Crystal_5.setRotationPoint(0.0F, 19.0F, -1.0F);
        this.Crystal_5.addBox(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Crystal_5, -0.4363323129985824F, 0.0F, 0.0F);
        this.Crystal_2 = new ModelRenderer(this, 0, 0);
        this.Crystal_2.setRotationPoint(0.0F, 21.0F, -1.0F);
        this.Crystal_2.addBox(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Crystal_2, 0.4363323129985824F, 0.0F, 0.0F);
        this.Crystal_4 = new ModelRenderer(this, 0, 0);
        this.Crystal_4.setRotationPoint(0.0F, 19.0F, 1.0F);
        this.Crystal_4.addBox(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Crystal_4, 0.4363323129985824F, 0.0F, 0.0F);
        this.Corner_2 = new ModelRenderer(this, 49, 0);
        this.Corner_2.setRotationPoint(-7.0F, 9.0F, 7.0F);
        this.Corner_2.addBox(-1.0F, 0.0F, -1.0F, 2, 14, 2, 0.0F);
        this.Corner = new ModelRenderer(this, 49, 0);
        this.Corner.setRotationPoint(-7.0F, 9.0F, -7.0F);
        this.Corner.addBox(-1.0F, 0.0F, -1.0F, 2, 14, 2, 0.0F);
        this.Corner_3 = new ModelRenderer(this, 49, 0);
        this.Corner_3.setRotationPoint(7.0F, 9.0F, 7.0F);
        this.Corner_3.addBox(-1.0F, 0.0F, -1.0F, 2, 14, 2, 0.0F);
        this.IronRod_1 = new ModelRenderer(this, 16, 17);
        this.IronRod_1.setRotationPoint(-7.0F, 9.5F, -7.0F);
        this.IronRod_1.addBox(0.0F, -0.5F, -0.5F, 11, 1, 1, 0.0F);
        this.setRotateAngle(IronRod_1, 1.0471975511965976F, -0.6108652381980153F, 0.7853981633974483F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.IronRod_2.render(f5);
        this.Crystal_6.render(f5);
        this.Corner_1.render(f5);
        this.Top.render(f5);
        this.IronRod_5.render(f5);
        this.Base.render(f5);
        this.Crystal_7.render(f5);
        this.Base_1.render(f5);
        this.IronRod.render(f5);
        this.Crystal_1.render(f5);
        this.Crystal_3.render(f5);
        this.IronRod_6.render(f5);
        this.IronRod_4.render(f5);
        this.Crystal.render(f5);
        this.IronRod_3.render(f5);
        this.Crystal_5.render(f5);
        this.Crystal_2.render(f5);
        this.Crystal_4.render(f5);
        this.Corner_2.render(f5);
        this.Corner.render(f5);
        this.Corner_3.render(f5);
        this.IronRod_1.render(f5);
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
