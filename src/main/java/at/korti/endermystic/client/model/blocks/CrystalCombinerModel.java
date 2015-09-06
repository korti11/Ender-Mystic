package at.korti.endermystic.client.model.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * CrystalCombiner - Korti
 * Created using Tabula 4.1.1
 */
public class CrystalCombinerModel extends ModelBase {
    public ModelRenderer Core;
    public ModelRenderer Bottom;
    public ModelRenderer Bottom_1;
    public ModelRenderer Bottom_2;
    public ModelRenderer Middel;
    public ModelRenderer Bottom_3;
    public ModelRenderer GlassDome;
    public ModelRenderer Bottom_4;
    public ModelRenderer GlassDome_1;
    public ModelRenderer Bottom_5;
    public ModelRenderer GlassDome_2;
    public ModelRenderer Bottom_6;
    public ModelRenderer GlassDome_3;
    public ModelRenderer Bottom_7;
    public ModelRenderer GlassDome_4;

    private boolean[] direction = {false, false, true, true};

    public CrystalCombinerModel() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Bottom_7 = new ModelRenderer(this, 0, 6);
        this.Bottom_7.setRotationPoint(-0.5F, 3F, -0.5F);
        this.Bottom_7.addBox(0.0F, 0.0F, 0.0F, 7, 1, 7, 0.0F);
        this.Bottom = new ModelRenderer(this, 43, 0);
        this.Bottom.setRotationPoint(-7.0F, 23.0F, -7.0F);
        this.Bottom.addBox(0.0F, 0.0F, 0.0F, 14, 1, 14, 0.0F);
        this.Middel = new ModelRenderer(this, 43, 52);
        this.Middel.setRotationPoint(-4.5F, 13.0F, -4.5F);
        this.Middel.addBox(0.0F, 0.0F, 0.0F, 9, 1, 9, 0.0F);
        this.Bottom_6 = new ModelRenderer(this, 0, 6);
        this.Bottom_6.setRotationPoint(-0.5F, 3F, -0.5F);
        this.Bottom_6.addBox(0.0F, 0.0F, 0.0F, 7, 1, 7, 0.0F);
        this.Bottom_4 = new ModelRenderer(this, 0, 6);
        this.Bottom_4.setRotationPoint(-0.5F, 3F, -0.5F);
        this.Bottom_4.addBox(0.0F, 0.0F, 0.0F, 7, 1, 7, 0.0F);
        this.Bottom_3 = new ModelRenderer(this, 0, 6);
        this.Bottom_3.setRotationPoint(-3.5F, 12.0F, -3.5F);
        this.Bottom_3.addBox(0.0F, 0.0F, 0.0F, 7, 1, 7, 0.0F);
        this.GlassDome = new ModelRenderer(this, 0, 15);
        this.GlassDome.setRotationPoint(-3.0F, 9.0F, -3.0F);
        this.GlassDome.addBox(0.0F, 0.0F, 0.0F, 6, 3, 6, 0.0F);
        this.Bottom_2 = new ModelRenderer(this, 43, 28);
        this.Bottom_2.setRotationPoint(-5.0F, 21.0F, -5.0F);
        this.Bottom_2.addBox(0.0F, 0.0F, 0.0F, 10, 1, 10, 0.0F);
        this.Bottom_5 = new ModelRenderer(this, 0, 6);
        this.Bottom_5.setRotationPoint(-0.5F, 3F, -0.5F);
        this.Bottom_5.addBox(0.0F, 0.0F, 0.0F, 7, 1, 7, 0.0F);
        this.GlassDome_2 = new ModelRenderer(this, 0, 15);
        this.GlassDome_2.setRotationPoint(-13.0F, 10.0F, -3.0F);
        this.GlassDome_2.addBox(0.0F, 0.0F, 0.0F, 6, 3, 6, 0.0F);
        this.GlassDome_3 = new ModelRenderer(this, 0, 15);
        this.GlassDome_3.setRotationPoint(-3.0F, 8.0F, 7.0F);
        this.GlassDome_3.addBox(0.0F, 0.0F, 0.0F, 6, 3, 6, 0.0F);
        this.GlassDome_1 = new ModelRenderer(this, 0, 15);
        this.GlassDome_1.setRotationPoint(7.0F, 10.0F, -3.0F);
        this.GlassDome_1.addBox(0.0F, 0.0F, 0.0F, 6, 3, 6, 0.0F);
        this.GlassDome_4 = new ModelRenderer(this, 0, 15);
        this.GlassDome_4.setRotationPoint(-3.0F, 8.0F, -13.0F);
        this.GlassDome_4.addBox(0.0F, 0.0F, 0.0F, 6, 3, 6, 0.0F);
        this.Core = new ModelRenderer(this, 43, 39);
        this.Core.setRotationPoint(-3.0F, 14.0F, -3.0F);
        this.Core.addBox(0.0F, 0.0F, 0.0F, 6, 7, 6, 0.0F);
        this.Bottom_1 = new ModelRenderer(this, 43, 15);
        this.Bottom_1.setRotationPoint(-6.0F, 22.0F, -6.0F);
        this.Bottom_1.addBox(0.0F, 0.0F, 0.0F, 12, 1, 12, 0.0F);

        this.GlassDome_1.addChild(Bottom_4);
        this.GlassDome_2.addChild(Bottom_5);
        this.GlassDome_3.addChild(Bottom_6);
        this.GlassDome_4.addChild(Bottom_7);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        //changeDomeYPositions();
        //this.Bottom_7.render(f5);
        this.Bottom.render(f5);
        this.Middel.render(f5);
        //this.Bottom_6.render(f5);
        //this.Bottom_4.render(f5);
        this.Bottom_3.render(f5);
        this.GlassDome.render(f5);
        this.Bottom_2.render(f5);
        //this.Bottom_5.render(f5);
        this.GlassDome_2.render(f5);
        this.GlassDome_3.render(f5);
        this.GlassDome_1.render(f5);
        this.GlassDome_4.render(f5);
        this.Core.render(f5);
        this.Bottom_1.render(f5);
    }

    private void changeDomeYPositions() {
        changeDomeYPosition(GlassDome_1, 8, 18, 0);
        changeDomeYPosition(GlassDome_2, 8, 18, 1);
        changeDomeYPosition(GlassDome_3, 6, 16, 2);
        changeDomeYPosition(GlassDome_4, 6, 16, 3);
    }

    private void changeDomeYPosition(ModelRenderer box, float upperLine, float lowerLine, int dome) {
        if (box.rotationPointY <= lowerLine && !direction[dome]) {
            box.rotationPointY += 0.1;
            if (box.rotationPointY >= lowerLine) {
                direction[dome] = true;
            }
        } else {
            box.rotationPointY -= 0.1;
            if (box.rotationPointY <= upperLine) {
                direction[dome] = false;
            }
        }
    }

    public float getYForSlot(int slot) {
        switch (slot) {
            case 0:
                return ((GlassDome_1.rotationPointY / 10) - 0.1F);
            case 2:
                return ((GlassDome_1.rotationPointY / 10) - 0.1F);
            case 1:
                return ((GlassDome_3.rotationPointY / 10) - 0.1F);
            case 3:
                return ((GlassDome_3.rotationPointY / 10) - 0.1F);
            default:
                return 0.8F;
        }
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
