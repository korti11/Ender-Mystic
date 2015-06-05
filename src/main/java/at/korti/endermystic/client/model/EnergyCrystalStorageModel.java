package at.korti.endermystic.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * EnergyCrystalStorage - Korti
 * Created using Tabula 4.1.1
 */
public class EnergyCrystalStorageModel extends ModelBase {
    public ModelRenderer Base;
    public ModelRenderer Corner;
    public ModelRenderer Corner_1;
    public ModelRenderer Corner_2;
    public ModelRenderer Corner_3;
    public ModelRenderer Top;
    public ModelRenderer Base_1;
    public ModelRenderer Base_2;
    public ModelRenderer Base_3;
    public ModelRenderer Top_1;
    public ModelRenderer Top_2;
    public ModelRenderer Base_4;
    public ModelRenderer Top_3;
    public ModelRenderer Top_4;
    public ModelRenderer Top_5;
    public ModelRenderer Crystal;
    public ModelRenderer Crystal_1;
    public ModelRenderer Crystal_2;
    public ModelRenderer Crystal_3;
    public ModelRenderer Crystal_4;
    public ModelRenderer Crystal_5;
    public ModelRenderer Crystal_6;
    public ModelRenderer Crystal_7;
    public ModelRenderer Base_5;

    public EnergyCrystalStorageModel() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Top_5 = new ModelRenderer(this, 64, 55);
        this.Top_5.setRotationPoint(0.0F, 13.0F, 0.0F);
        this.Top_5.addBox(-1.0F, 0.0F, -1.0F, 2, 1, 2, 0.0F);
        this.Base_2 = new ModelRenderer(this, 64, 30);
        this.Base_2.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.Base_2.addBox(-5.0F, 0.0F, -5.0F, 10, 1, 10, 0.0F);
        this.Top_3 = new ModelRenderer(this, 64, 30);
        this.Top_3.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.Top_3.addBox(-5.0F, 0.0F, -5.0F, 10, 1, 10, 0.0F);
        this.Corner_1 = new ModelRenderer(this, 15, 0);
        this.Corner_1.setRotationPoint(7.0F, 9.0F, -7.0F);
        this.Corner_1.addBox(-1.0F, 0.0F, -1.0F, 2, 14, 2, 0.0F);
        this.Top_4 = new ModelRenderer(this, 64, 17);
        this.Top_4.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.Top_4.addBox(-6.0F, 0.0F, -6.0F, 12, 1, 12, 0.0F);
        this.Crystal_3 = new ModelRenderer(this, 0, 0);
        this.Crystal_3.setRotationPoint(0.0F, 17.0F, 1.0F);
        this.Crystal_3.addBox(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Crystal_3, -0.4363323129985824F, 0.0F, 0.0F);
        this.Top_2 = new ModelRenderer(this, 64, 41);
        this.Top_2.setRotationPoint(0.0F, 11.0F, 0.0F);
        this.Top_2.addBox(-4.0F, 0.0F, -4.0F, 8, 1, 8, 0.0F);
        this.Crystal_5 = new ModelRenderer(this, 0, 0);
        this.Crystal_5.setRotationPoint(0.0F, 15.0F, -1.0F);
        this.Crystal_5.addBox(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Crystal_5, -0.4363323129985824F, 0.0F, 0.0F);
        this.Crystal_7 = new ModelRenderer(this, 0, 0);
        this.Crystal_7.setRotationPoint(-1.0F, 15.0F, 0.0F);
        this.Crystal_7.addBox(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Crystal_7, 0.0F, 0.0F, 0.4363323129985824F);
        this.Crystal_2 = new ModelRenderer(this, 0, 0);
        this.Crystal_2.setRotationPoint(0.0F, 17.0F, -1.0F);
        this.Crystal_2.addBox(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Crystal_2, 0.4363323129985824F, 0.0F, 0.0F);
        this.Corner_2 = new ModelRenderer(this, 15, 0);
        this.Corner_2.setRotationPoint(-7.0F, 9.0F, 7.0F);
        this.Corner_2.addBox(-1.0F, 0.0F, -1.0F, 2, 14, 2, 0.0F);
        this.Base_5 = new ModelRenderer(this, 64, 55);
        this.Base_5.setRotationPoint(0.0F, 18.0F, 0.0F);
        this.Base_5.addBox(-1.0F, 0.0F, -1.0F, 2, 1, 2, 0.0F);
        this.Corner_3 = new ModelRenderer(this, 15, 0);
        this.Corner_3.setRotationPoint(7.0F, 9.0F, 7.0F);
        this.Corner_3.addBox(-1.0F, 0.0F, -1.0F, 2, 14, 2, 0.0F);
        this.Top = new ModelRenderer(this, 64, 0);
        this.Top.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.Top.addBox(-8.0F, 0.0F, -8.0F, 16, 1, 16, 0.0F);
        this.Base_4 = new ModelRenderer(this, 64, 50);
        this.Base_4.setRotationPoint(0.0F, 19.0F, 0.0F);
        this.Base_4.addBox(-2.0F, 0.0F, -2.0F, 4, 1, 4, 0.0F);
        this.Top_1 = new ModelRenderer(this, 64, 50);
        this.Top_1.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.Top_1.addBox(-2.0F, 0.0F, -2.0F, 4, 1, 4, 0.0F);
        this.Base_3 = new ModelRenderer(this, 64, 41);
        this.Base_3.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.Base_3.addBox(-4.0F, 0.0F, -4.0F, 8, 1, 8, 0.0F);
        this.Corner = new ModelRenderer(this, 15, 0);
        this.Corner.setRotationPoint(-7.0F, 9.0F, -7.0F);
        this.Corner.addBox(-1.0F, 0.0F, -1.0F, 2, 14, 2, 0.0F);
        this.Crystal_4 = new ModelRenderer(this, 0, 0);
        this.Crystal_4.setRotationPoint(0.0F, 15.0F, 1.0F);
        this.Crystal_4.addBox(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Crystal_4, 0.4363323129985824F, 0.0F, 0.0F);
        this.Base = new ModelRenderer(this, 64, 0);
        this.Base.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.Base.addBox(-8.0F, 0.0F, -8.0F, 16, 1, 16, 0.0F);
        this.Crystal_1 = new ModelRenderer(this, 0, 0);
        this.Crystal_1.setRotationPoint(-1.0F, 17.0F, 0.0F);
        this.Crystal_1.addBox(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Crystal_1, 0.0F, 0.0F, -0.4363323129985824F);
        this.Crystal_6 = new ModelRenderer(this, 0, 0);
        this.Crystal_6.setRotationPoint(1.0F, 15.0F, 0.0F);
        this.Crystal_6.addBox(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Crystal_6, 0.0F, 0.0F, -0.4363323129985824F);
        this.Crystal = new ModelRenderer(this, 0, 0);
        this.Crystal.setRotationPoint(1.0F, 17.0F, 0.0F);
        this.Crystal.addBox(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Crystal, 0.0F, 0.0F, 0.4363323129985824F);
        this.Base_1 = new ModelRenderer(this, 64, 17);
        this.Base_1.setRotationPoint(0.0F, 22.0F, 0.0F);
        this.Base_1.addBox(-6.0F, 0.0F, -6.0F, 12, 1, 12, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Top_5.render(f5);
        this.Base_2.render(f5);
        this.Top_3.render(f5);
        this.Corner_1.render(f5);
        this.Top_4.render(f5);
        this.Crystal_3.render(f5);
        this.Top_2.render(f5);
        this.Crystal_5.render(f5);
        this.Crystal_7.render(f5);
        this.Crystal_2.render(f5);
        this.Corner_2.render(f5);
        this.Base_5.render(f5);
        this.Corner_3.render(f5);
        this.Top.render(f5);
        this.Base_4.render(f5);
        this.Top_1.render(f5);
        this.Base_3.render(f5);
        this.Corner.render(f5);
        this.Crystal_4.render(f5);
        this.Base.render(f5);
        this.Crystal_1.render(f5);
        this.Crystal_6.render(f5);
        this.Crystal.render(f5);
        this.Base_1.render(f5);
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
