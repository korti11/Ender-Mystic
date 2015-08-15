package at.korti.endermystic.client.model.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * EnderPicker - Korti
 * Created using Tabula 4.1.1
 */
public class EnderTransferModel extends ModelBase {
    public ModelRenderer Top;
    public ModelRenderer Corner;
    public ModelRenderer Corner_1;
    public ModelRenderer Corner_2;
    public ModelRenderer Corner_3;
    public ModelRenderer Bottom;
    public ModelRenderer Bottom_1;
    public ModelRenderer Bottom_2;
    public ModelRenderer Bottom_3;
    public ModelRenderer Bottom_4;
    public ModelRenderer Bottom_5;
    public ModelRenderer Top_1;
    public ModelRenderer Top_2;
    public ModelRenderer Top_3;
    public ModelRenderer Top_4;
    public ModelRenderer Top_5;
    public ModelRenderer Corner_4;
    public ModelRenderer Corner_5;
    public ModelRenderer Corner_6;
    public ModelRenderer Corner_7;
    public ModelRenderer Corner_8;
    public ModelRenderer Corner_9;
    public ModelRenderer Corner_10;
    public ModelRenderer Corner_11;
    public ModelRenderer Corner_12;
    public ModelRenderer Corner_13;
    public ModelRenderer Corner_14;
    public ModelRenderer Corner_15;
    public ModelRenderer Corner_16;
    public ModelRenderer Corner_17;
    public ModelRenderer Corner_18;
    public ModelRenderer Corner_19;

    public EnderTransferModel() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Bottom_3 = new ModelRenderer(this, 32, 13);
        this.Bottom_3.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.Bottom_3.addBox(-4.0F, 0.0F, -4.0F, 8, 1, 8, 0.0F);
        this.Top_5 = new ModelRenderer(this, 20, 7);
        this.Top_5.setRotationPoint(0.0F, 13.0F, 0.0F);
        this.Top_5.addBox(-2.0F, 0.0F, -2.0F, 4, 1, 4, 0.0F);
        this.Corner_14 = new ModelRenderer(this, 0, 0);
        this.Corner_14.setRotationPoint(5.0F, 11.0F, -4.0F);
        this.Corner_14.addBox(-1.0F, 0.0F, -1.0F, 1, 10, 1, 0.0F);
        this.Corner_5 = new ModelRenderer(this, 0, 0);
        this.Corner_5.setRotationPoint(-4.0F, 11.0F, -4.0F);
        this.Corner_5.addBox(-1.0F, 0.0F, -1.0F, 1, 10, 1, 0.0F);
        this.Corner_15 = new ModelRenderer(this, 0, 0);
        this.Corner_15.setRotationPoint(6.0F, 10.0F, -5.0F);
        this.Corner_15.addBox(-1.0F, 0.0F, -1.0F, 1, 12, 1, 0.0F);
        this.Top_4 = new ModelRenderer(this, 20, 0);
        this.Top_4.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.Top_4.addBox(-3.0F, 0.0F, -3.0F, 6, 1, 6, 0.0F);
        this.Bottom_4 = new ModelRenderer(this, 20, 0);
        this.Bottom_4.setRotationPoint(0.0F, 19.0F, 0.0F);
        this.Bottom_4.addBox(-3.0F, 0.0F, -3.0F, 6, 1, 6, 0.0F);
        this.Bottom_5 = new ModelRenderer(this, 20, 7);
        this.Bottom_5.setRotationPoint(0.0F, 18.0F, 0.0F);
        this.Bottom_5.addBox(-2.0F, 0.0F, -2.0F, 4, 1, 4, 0.0F);
        this.Top_1 = new ModelRenderer(this, 32, 0);
        this.Top_1.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.Top_1.addBox(-6.0F, 0.0F, -6.0F, 12, 1, 12, 0.0F);
        this.Corner_11 = new ModelRenderer(this, 0, 0);
        this.Corner_11.setRotationPoint(3.0F, 13.0F, 3.0F);
        this.Corner_11.addBox(-1.0F, 0.0F, -1.0F, 1, 6, 1, 0.0F);
        this.Bottom_2 = new ModelRenderer(this, 64, 17);
        this.Bottom_2.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.Bottom_2.addBox(-5.0F, 0.0F, -5.0F, 10, 1, 10, 0.0F);
        this.Corner_4 = new ModelRenderer(this, 0, 0);
        this.Corner_4.setRotationPoint(-5.0F, 10.0F, -5.0F);
        this.Corner_4.addBox(-1.0F, 0.0F, -1.0F, 1, 12, 1, 0.0F);
        this.Bottom = new ModelRenderer(this, 64, 0);
        this.Bottom.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.Bottom.addBox(-8.0F, 0.0F, -8.0F, 16, 1, 16, 0.0F);
        this.Corner_19 = new ModelRenderer(this, 0, 0);
        this.Corner_19.setRotationPoint(-5.0F, 10.0F, 6.0F);
        this.Corner_19.addBox(-1.0F, 0.0F, -1.0F, 1, 12, 1, 0.0F);
        this.Bottom_1 = new ModelRenderer(this, 32, 0);
        this.Bottom_1.setRotationPoint(0.0F, 22.0F, 0.0F);
        this.Bottom_1.addBox(-6.0F, 0.0F, -6.0F, 12, 1, 12, 0.0F);
        this.Top_3 = new ModelRenderer(this, 32, 13);
        this.Top_3.setRotationPoint(0.0F, 11.0F, 0.0F);
        this.Top_3.addBox(-4.0F, 0.0F, -4.0F, 8, 1, 8, 0.0F);
        this.Corner_3 = new ModelRenderer(this, 10, 0);
        this.Corner_3.setRotationPoint(7.0F, 9.0F, 7.0F);
        this.Corner_3.addBox(-1.0F, 0.0F, -1.0F, 2, 14, 2, 0.0F);
        this.Corner_13 = new ModelRenderer(this, 0, 0);
        this.Corner_13.setRotationPoint(4.0F, 12.0F, -3.0F);
        this.Corner_13.addBox(-1.0F, 0.0F, -1.0F, 1, 8, 1, 0.0F);
        this.Corner_6 = new ModelRenderer(this, 0, 0);
        this.Corner_6.setRotationPoint(-3.0F, 12.0F, -3.0F);
        this.Corner_6.addBox(-1.0F, 0.0F, -1.0F, 1, 8, 1, 0.0F);
        this.Corner_1 = new ModelRenderer(this, 10, 0);
        this.Corner_1.setRotationPoint(7.0F, 9.0F, -7.0F);
        this.Corner_1.addBox(-1.0F, 0.0F, -1.0F, 2, 14, 2, 0.0F);
        this.Corner_8 = new ModelRenderer(this, 0, 0);
        this.Corner_8.setRotationPoint(6.0F, 10.0F, 6.0F);
        this.Corner_8.addBox(-1.0F, 0.0F, -1.0F, 1, 12, 1, 0.0F);
        this.Corner_10 = new ModelRenderer(this, 0, 0);
        this.Corner_10.setRotationPoint(4.0F, 12.0F, 4.0F);
        this.Corner_10.addBox(-1.0F, 0.0F, -1.0F, 1, 8, 1, 0.0F);
        this.Corner_16 = new ModelRenderer(this, 0, 0);
        this.Corner_16.setRotationPoint(-2.0F, 13.0F, 3.0F);
        this.Corner_16.addBox(-1.0F, 0.0F, -1.0F, 1, 6, 1, 0.0F);
        this.Corner_2 = new ModelRenderer(this, 10, 0);
        this.Corner_2.setRotationPoint(-7.0F, 9.0F, 7.0F);
        this.Corner_2.addBox(-1.0F, 0.0F, -1.0F, 2, 14, 2, 0.0F);
        this.Corner_17 = new ModelRenderer(this, 0, 0);
        this.Corner_17.setRotationPoint(-3.0F, 12.0F, 4.0F);
        this.Corner_17.addBox(-1.0F, 0.0F, -1.0F, 1, 8, 1, 0.0F);
        this.Top_2 = new ModelRenderer(this, 64, 17);
        this.Top_2.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.Top_2.addBox(-5.0F, 0.0F, -5.0F, 10, 1, 10, 0.0F);
        this.Corner_7 = new ModelRenderer(this, 0, 0);
        this.Corner_7.setRotationPoint(-2.0F, 13.0F, -2.0F);
        this.Corner_7.addBox(-1.0F, 0.0F, -1.0F, 1, 6, 1, 0.0F);
        this.Corner_18 = new ModelRenderer(this, 0, 0);
        this.Corner_18.setRotationPoint(-4.0F, 11.0F, 5.0F);
        this.Corner_18.addBox(-1.0F, 0.0F, -1.0F, 1, 10, 1, 0.0F);
        this.Top = new ModelRenderer(this, 64, 0);
        this.Top.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.Top.addBox(-8.0F, 0.0F, -8.0F, 16, 1, 16, 0.0F);
        this.Corner = new ModelRenderer(this, 10, 0);
        this.Corner.setRotationPoint(-7.0F, 9.0F, -7.0F);
        this.Corner.addBox(-1.0F, 0.0F, -1.0F, 2, 14, 2, 0.0F);
        this.Corner_9 = new ModelRenderer(this, 0, 0);
        this.Corner_9.setRotationPoint(5.0F, 11.0F, 5.0F);
        this.Corner_9.addBox(-1.0F, 0.0F, -1.0F, 1, 10, 1, 0.0F);
        this.Corner_12 = new ModelRenderer(this, 0, 0);
        this.Corner_12.setRotationPoint(3.0F, 13.0F, -2.0F);
        this.Corner_12.addBox(-1.0F, 0.0F, -1.0F, 1, 6, 1, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Bottom_3.render(f5);
        this.Top_5.render(f5);
        this.Corner_14.render(f5);
        this.Corner_5.render(f5);
        this.Corner_15.render(f5);
        this.Top_4.render(f5);
        this.Bottom_4.render(f5);
        this.Bottom_5.render(f5);
        this.Top_1.render(f5);
        this.Corner_11.render(f5);
        this.Bottom_2.render(f5);
        this.Corner_4.render(f5);
        this.Bottom.render(f5);
        this.Corner_19.render(f5);
        this.Bottom_1.render(f5);
        this.Top_3.render(f5);
        this.Corner_3.render(f5);
        this.Corner_13.render(f5);
        this.Corner_6.render(f5);
        this.Corner_1.render(f5);
        this.Corner_8.render(f5);
        this.Corner_10.render(f5);
        this.Corner_16.render(f5);
        this.Corner_2.render(f5);
        this.Corner_17.render(f5);
        this.Top_2.render(f5);
        this.Corner_7.render(f5);
        this.Corner_18.render(f5);
        this.Top.render(f5);
        this.Corner.render(f5);
        this.Corner_9.render(f5);
        this.Corner_12.render(f5);
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
