package at.korti.endermystic.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * EnergyDrain - Korti
 * Created using Tabula 4.1.1
 */
public class EnergyDrainModel extends ModelBase {
    public ModelRenderer Core;
    public ModelRenderer Bottom;
    public ModelRenderer Bottom_1;
    public ModelRenderer Bottom_2;
    public ModelRenderer Bottom_3;
    public ModelRenderer Border;
    public ModelRenderer Border_1;
    public ModelRenderer Border_2;
    public ModelRenderer Border_3;
    public ModelRenderer Top;
    public ModelRenderer Top_1;
    public ModelRenderer Top_2;
    public ModelRenderer Holder;
    public ModelRenderer Drain;
    public ModelRenderer Drain_1;
    public ModelRenderer Drain_2;
    public ModelRenderer Drain_3;
    public ModelRenderer Holder_1;
    public ModelRenderer Holder_2;
    public ModelRenderer Holder_3;
    public ModelRenderer Holder_4;
    public ModelRenderer Crystal;
    public ModelRenderer Crystal_1;
    public ModelRenderer Crystal_2;
    public ModelRenderer Crystal_3;
    public ModelRenderer Crystal_4;

    public EnergyDrainModel() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Core = new ModelRenderer(this, 52, 39);
        this.Core.setRotationPoint(-3.0F, 11.0F, -3.0F);
        this.Core.addBox(0.0F, 0.0F, 0.0F, 6, 10, 6, 0.0F);
        this.Drain_1 = new ModelRenderer(this, 8, 0);
        this.Drain_1.setRotationPoint(-2.9F, 3.4F, -0.5F);
        this.Drain_1.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(Drain_1, 0.0F, 0.0F, -0.4363323129985824F);
        this.Drain_2 = new ModelRenderer(this, 8, 0);
        this.Drain_2.setRotationPoint(-0.5F, 3.4F, -3.0F);
        this.Drain_2.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(Drain_2, 0.4363323129985824F, 0.0F, 0.0F);
        this.Drain_3 = new ModelRenderer(this, 8, 0);
        this.Drain_3.setRotationPoint(-0.5F, 3.0F, 2.0F);
        this.Drain_3.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(Drain_3, -0.4363323129985824F, 0.0F, 0.0F);
        this.Holder = new ModelRenderer(this, 0, 0);
        this.Holder.setRotationPoint(-0.5F, 4.0F, -0.5F);
        this.Holder.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.Top = new ModelRenderer(this, 0, 19);
        this.Top.setRotationPoint(-4.0F, 3.0F, -4.0F);
        this.Top.addBox(0.0F, 0.0F, 0.0F, 8, 1, 8, 0.0F);
        this.Border_2 = new ModelRenderer(this, 20, 0);
        this.Border_2.setRotationPoint(3.0F, 4.0F, 3.0F);
        this.Border_2.addBox(0.0F, 0.0F, 0.0F, 1, 6, 1, 0.0F);
        this.Bottom_3 = new ModelRenderer(this, 0, 10);
        this.Bottom_3.setRotationPoint(-4.0F, 10.0F, -4.0F);
        this.Bottom_3.addBox(0.0F, 0.0F, 0.0F, 8, 1, 8, 0.0F);
        this.Top_1 = new ModelRenderer(this, 0, 28);
        this.Top_1.setRotationPoint(-3.0F, 2.0F, -3.0F);
        this.Top_1.addBox(0.0F, 0.0F, 0.0F, 6, 1, 6, 0.0F);
        this.Bottom_1 = new ModelRenderer(this, 52, 15);
        this.Bottom_1.setRotationPoint(-6.0F, 22.0F, -6.0F);
        this.Bottom_1.addBox(0.0F, 0.0F, 0.0F, 12, 1, 12, 0.0F);
        this.Border_1 = new ModelRenderer(this, 20, 0);
        this.Border_1.setRotationPoint(-4.0F, 4.0F, 3.0F);
        this.Border_1.addBox(0.0F, 0.0F, 0.0F, 1, 6, 1, 0.0F);
        this.Holder_1 = new ModelRenderer(this, 14, 0);
        this.Holder_1.setRotationPoint(1.0F, 8.5F, -0.5F);
        this.Holder_1.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(Holder_1, 0.0F, 0.0F, 0.4363323129985824F);
        this.Drain = new ModelRenderer(this, 8, 0);
        this.Drain.setRotationPoint(2.0F, 3.0F, -0.5F);
        this.Drain.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(Drain, 0.0F, 0.0F, 0.4550073359949217F);
        this.Holder_2 = new ModelRenderer(this, 14, 0);
        this.Holder_2.setRotationPoint(-1.9F, 8.9F, -0.5F);
        this.Holder_2.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(Holder_2, 0.0F, 0.0F, -0.4363323129985824F);
        this.Holder_3 = new ModelRenderer(this, 14, 0);
        this.Holder_3.setRotationPoint(-0.5F, 8.9F, -1.9F);
        this.Holder_3.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(Holder_3, 0.4363323129985824F, 0.0F, 0.0F);
        this.Holder_4 = new ModelRenderer(this, 14, 0);
        this.Holder_4.setRotationPoint(-0.5F, 8.5F, 1.0F);
        this.Holder_4.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(Holder_4, -0.4363323129985824F, 0.0F, 0.0F);
        this.Bottom = new ModelRenderer(this, 52, 0);
        this.Bottom.setRotationPoint(-7.0F, 23.0F, -7.0F);
        this.Bottom.addBox(0.0F, 0.0F, 0.0F, 14, 1, 14, 0.0F);
        this.Border_3 = new ModelRenderer(this, 20, 0);
        this.Border_3.setRotationPoint(3.0F, 4.0F, -4.0F);
        this.Border_3.addBox(0.0F, 0.0F, 0.0F, 1, 6, 1, 0.0F);
        this.Border = new ModelRenderer(this, 20, 0);
        this.Border.setRotationPoint(-4.0F, 4.0F, -4.0F);
        this.Border.addBox(0.0F, 0.0F, 0.0F, 1, 6, 1, 0.0F);
        this.Top_2 = new ModelRenderer(this, 0, 35);
        this.Top_2.setRotationPoint(-2.0F, 1.0F, -2.0F);
        this.Top_2.addBox(0.0F, 0.0F, 0.0F, 4, 1, 4, 0.0F);
        this.Bottom_2 = new ModelRenderer(this, 52, 28);
        this.Bottom_2.setRotationPoint(-5.0F, 21.0F, -5.0F);
        this.Bottom_2.addBox(0.0F, 0.0F, 0.0F, 10, 1, 10, 0.0F);

        //Crystal
        this.Crystal = new ModelRenderer(this, 25, 0);
        this.Crystal.setRotationPoint(-0.5F, 8.0F, -0.5F);
        this.Crystal.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.Crystal_1 = new ModelRenderer(this, 25, 0);
        this.Crystal_1.setRotationPoint(0.15F, 8.0F, -0.5F);
        this.Crystal_1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Crystal_1, 0.0F, 0.0F, 0.4363323129985824F);
        this.Crystal_2 = new ModelRenderer(this, 25, 0);
        this.Crystal_2.setRotationPoint(-1.05F, 8.43F, -0.5F);
        this.Crystal_2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Crystal_2, 0.0F, 0.0F, -0.4363323129985824F);
        this.Crystal_3 = new ModelRenderer(this, 25, 0);
        this.Crystal_3.setRotationPoint(-0.5F, 8.43F, -1.03F);
        this.Crystal_3.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Crystal_3, 0.4363323129985824F, 0.0F, 0.0F);
        this.Crystal_4 = new ModelRenderer(this, 25, 0);
        this.Crystal_4.setRotationPoint(-0.5F, 8.0F, 0.13F);
        this.Crystal_4.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Crystal_4, -0.4363323129985824F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Core.render(f5);
        this.Drain_1.render(f5);
        this.Drain_2.render(f5);
        this.Drain_3.render(f5);
        this.Holder.render(f5);
        this.Top.render(f5);
        this.Border_2.render(f5);
        this.Bottom_3.render(f5);
        this.Top_1.render(f5);
        this.Bottom_1.render(f5);
        this.Border_1.render(f5);
        this.Holder_1.render(f5);
        this.Drain.render(f5);
        this.Holder_2.render(f5);
        this.Holder_3.render(f5);
        this.Holder_4.render(f5);
        this.Bottom.render(f5);
        this.Border_3.render(f5);
        this.Border.render(f5);
        this.Top_2.render(f5);
        this.Bottom_2.render(f5);
    }

    public void renderCrystal(float f){
        this.Crystal.render(f);
        this.Crystal_1.render(f);
        this.Crystal_2.render(f);
        this.Crystal_3.render(f);
        this.Crystal_4.render(f);
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
