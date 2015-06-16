package at.korti.endermystic.client.model.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * OrbInfuser - Korti
 * Created using Tabula 4.1.1
 */
public class OrbInfuserModel extends ModelBase {
    public ModelRenderer Bottom;
    public ModelRenderer Corner;
    public ModelRenderer Corner_1;
    public ModelRenderer Corner_2;
    public ModelRenderer Corner_3;
    public ModelRenderer Bottom_1;
    public ModelRenderer Bottom_2;
    public ModelRenderer Holder;
    public ModelRenderer Holder_1;
    public ModelRenderer Holder_2;
    public ModelRenderer Holder_3;
    public ModelRenderer Holder_4;
    public ModelRenderer Holder_5;
    public ModelRenderer Holder_6;
    public ModelRenderer Holder_7;
    public ModelRenderer Top;
    public ModelRenderer Top_1;
    public ModelRenderer Top_2;
    public ModelRenderer Bottom_3;
    public ModelRenderer Top_3;
    public ModelRenderer Holder_8;
    public ModelRenderer Holder_9;
    public ModelRenderer Holder_10;
    public ModelRenderer Holder_11;
    public ModelRenderer Holder_12;
    public ModelRenderer Holder_13;
    public ModelRenderer Holder_14;
    public ModelRenderer Holder_15;
    public ModelRenderer OrbHolder;
    public ModelRenderer OrbHolder_1;
    public ModelRenderer OrbHolder_2;
    public ModelRenderer OrbHolder_3;

    public OrbInfuserModel() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Top_1 = new ModelRenderer(this, 100, 5);
        this.Top_1.setRotationPoint(-2.0F, 15.5F, -2.0F);
        this.Top_1.addBox(0.0F, 0.0F, 0.0F, 4, 1, 4, 0.0F);
        this.Corner = new ModelRenderer(this, 84, 0);
        this.Corner.setRotationPoint(3.0F, 15.0F, -5.0F);
        this.Corner.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.OrbHolder_2 = new ModelRenderer(this, 15, 17);
        this.OrbHolder_2.setRotationPoint(-3.5F, 13.0F, 2.5F);
        this.OrbHolder_2.addBox(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F);
        this.setRotateAngle(OrbHolder_2, 0.0F, 1.5707963267948966F, 0.0F);
        this.Holder_8 = new ModelRenderer(this, 0, 0);
        this.Holder_8.setRotationPoint(-0.5F, 13.0F, 5.0F);
        this.Holder_8.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.Holder_11 = new ModelRenderer(this, 0, 0);
        this.Holder_11.setRotationPoint(-6.0F, 13.0F, -0.5F);
        this.Holder_11.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.Bottom_3 = new ModelRenderer(this, 100, 5);
        this.Bottom_3.setRotationPoint(-2.0F, 21.0F, -2.0F);
        this.Bottom_3.addBox(0.0F, 0.0F, 0.0F, 4, 1, 4, 0.0F);
        this.Holder_3 = new ModelRenderer(this, 94, 0);
        this.Holder_3.setRotationPoint(-1.8F, 18.8F, -0.5F);
        this.Holder_3.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Holder_3, 0.0F, 0.0F, -0.4363323129985824F);
        this.Top = new ModelRenderer(this, 100, 0);
        this.Top.setRotationPoint(-1.0F, 16.5F, -1.0F);
        this.Top.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
        this.Holder_13 = new ModelRenderer(this, 0, 0);
        this.Holder_13.setRotationPoint(-5.0F, 13.0F, 5.0F);
        this.Holder_13.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(Holder_13, 0.0F, 0.7853981633974483F, 0.0F);
        this.Corner_1 = new ModelRenderer(this, 84, 0);
        this.Corner_1.setRotationPoint(-5.0F, 15.0F, -5.0F);
        this.Corner_1.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.Holder_14 = new ModelRenderer(this, 0, 0);
        this.Holder_14.setRotationPoint(5.0F, 13.0F, -5.0F);
        this.Holder_14.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(Holder_14, 0.0F, 0.7853981633974483F, 0.0F);
        this.OrbHolder = new ModelRenderer(this, 0, 17);
        this.OrbHolder.setRotationPoint(-3.5F, 13.0F, -3.5F);
        this.OrbHolder.addBox(0.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
        this.Bottom_2 = new ModelRenderer(this, 100, 0);
        this.Bottom_2.setRotationPoint(-1.0F, 20.0F, -1.0F);
        this.Bottom_2.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
        this.Holder_5 = new ModelRenderer(this, 94, 0);
        this.Holder_5.setRotationPoint(-0.5F, 17.4F, 0.05F);
        this.Holder_5.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Holder_5, 0.4363323129985824F, 0.0F, 0.0F);
        this.Holder_9 = new ModelRenderer(this, 0, 0);
        this.Holder_9.setRotationPoint(-0.5F, 13.0F, -6.0F);
        this.Holder_9.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.Top_3 = new ModelRenderer(this, 0, 0);
        this.Top_3.setRotationPoint(-7.0F, 14.0F, -7.0F);
        this.Top_3.addBox(0.0F, 0.0F, 0.0F, 14, 1, 14, 0.0F);
        this.Bottom = new ModelRenderer(this, 42, 0);
        this.Bottom.setRotationPoint(-5.0F, 23.0F, -5.0F);
        this.Bottom.addBox(0.0F, 0.0F, 0.0F, 10, 1, 10, 0.0F);
        this.Holder_4 = new ModelRenderer(this, 94, 0);
        this.Holder_4.setRotationPoint(-0.5F, 17.0F, -0.95F);
        this.Holder_4.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Holder_4, -0.4363323129985824F, 0.0F, 0.0F);
        this.Holder_7 = new ModelRenderer(this, 94, 0);
        this.Holder_7.setRotationPoint(0.05F, 17.4F, -0.5F);
        this.Holder_7.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Holder_7, 0.0F, 0.0F, -0.4363323129985824F);
        this.Corner_2 = new ModelRenderer(this, 84, 0);
        this.Corner_2.setRotationPoint(3.0F, 15.0F, 3.0F);
        this.Corner_2.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.Holder_1 = new ModelRenderer(this, 94, 0);
        this.Holder_1.setRotationPoint(-0.5F, 18.35F, 0.9F);
        this.Holder_1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Holder_1, -0.4363323129985824F, 0.0F, 0.0F);
        this.Corner_3 = new ModelRenderer(this, 84, 0);
        this.Corner_3.setRotationPoint(-5.0F, 15.0F, 3.0F);
        this.Corner_3.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.OrbHolder_3 = new ModelRenderer(this, 15, 17);
        this.OrbHolder_3.setRotationPoint(2.5F, 13.0F, 2.5F);
        this.OrbHolder_3.addBox(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F);
        this.setRotateAngle(OrbHolder_3, 0.0F, 1.5707963267948966F, 0.0F);
        this.Holder_15 = new ModelRenderer(this, 0, 0);
        this.Holder_15.setRotationPoint(5.0F, 13.0F, 5.0F);
        this.Holder_15.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(Holder_15, 0.0F, 0.7853981633974483F, 0.0F);
        this.Holder_6 = new ModelRenderer(this, 94, 0);
        this.Holder_6.setRotationPoint(-0.95F, 17.0F, -0.5F);
        this.Holder_6.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Holder_6, 0.0F, 0.0F, 0.4363323129985824F);
        this.Bottom_1 = new ModelRenderer(this, 100, 11);
        this.Bottom_1.setRotationPoint(-3.0F, 22.0F, -3.0F);
        this.Bottom_1.addBox(0.0F, 0.0F, 0.0F, 6, 1, 6, 0.0F);
        this.Holder_12 = new ModelRenderer(this, 0, 0);
        this.Holder_12.setRotationPoint(-5.0F, 13.0F, -5.0F);
        this.Holder_12.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(Holder_12, 0.0F, 0.7853981633974483F, 0.0F);
        this.OrbHolder_1 = new ModelRenderer(this, 0, 17);
        this.OrbHolder_1.setRotationPoint(-3.5F, 13.0F, 2.5F);
        this.OrbHolder_1.addBox(0.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
        this.Top_2 = new ModelRenderer(this, 100, 11);
        this.Top_2.setRotationPoint(-3.0F, 14.5F, -3.0F);
        this.Top_2.addBox(0.0F, 0.0F, 0.0F, 6, 1, 6, 0.0F);
        this.Holder_2 = new ModelRenderer(this, 94, 0);
        this.Holder_2.setRotationPoint(0.9F, 18.35F, -0.5F);
        this.Holder_2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Holder_2, 0.0F, 0.0F, 0.4363323129985824F);
        this.Holder = new ModelRenderer(this, 94, 0);
        this.Holder.setRotationPoint(-0.5F, 18.8F, -1.8F);
        this.Holder.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Holder, 0.4363323129985824F, 0.0F, 0.0F);
        this.Holder_10 = new ModelRenderer(this, 0, 0);
        this.Holder_10.setRotationPoint(5.0F, 13.0F, -0.5F);
        this.Holder_10.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Top_1.render(f5);
        this.Corner.render(f5);
        this.OrbHolder_2.render(f5);
        this.Holder_8.render(f5);
        this.Holder_11.render(f5);
        this.Bottom_3.render(f5);
        this.Holder_3.render(f5);
        this.Top.render(f5);
        this.Holder_13.render(f5);
        this.Corner_1.render(f5);
        this.Holder_14.render(f5);
        this.OrbHolder.render(f5);
        this.Bottom_2.render(f5);
        this.Holder_5.render(f5);
        this.Holder_9.render(f5);
        this.Top_3.render(f5);
        this.Bottom.render(f5);
        this.Holder_4.render(f5);
        this.Holder_7.render(f5);
        this.Corner_2.render(f5);
        this.Holder_1.render(f5);
        this.Corner_3.render(f5);
        this.OrbHolder_3.render(f5);
        this.Holder_15.render(f5);
        this.Holder_6.render(f5);
        this.Bottom_1.render(f5);
        this.Holder_12.render(f5);
        this.OrbHolder_1.render(f5);
        this.Top_2.render(f5);
        this.Holder_2.render(f5);
        this.Holder.render(f5);
        this.Holder_10.render(f5);
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
