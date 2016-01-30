package at.korti.endermystic.client.model.items;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * TeleportWand - Korti
 * Created using Tabula 4.1.1
 */
public class TeleportWandModel extends ModelBase {
    public ModelRenderer Rod;
    public ModelRenderer EnergyCube;
    public ModelRenderer Holder;
    public ModelRenderer Holder_1;
    public ModelRenderer EnderCube;
    public ModelRenderer EnderCube_1;

    public TeleportWandModel() {
        this.textureWidth = 32;
        this.textureHeight = 16;
        this.Rod = new ModelRenderer(this, 20, 0);
        this.Rod.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.Rod.addBox(-0.5F, 0.0F, -0.5F, 1, 12, 1, 0.0F);
        this.EnderCube_1 = new ModelRenderer(this, 0, 0);
        this.EnderCube_1.setRotationPoint(-4.5F, 9.5F, 0.0F);
        this.EnderCube_1.addBox(-1.5F, 0.0F, -1.5F, 3, 3, 3, 0.0F);
        this.EnergyCube = new ModelRenderer(this, 12, 0);
        this.EnergyCube.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.EnergyCube.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F);
        this.EnderCube = new ModelRenderer(this, 0, 0);
        this.EnderCube.setRotationPoint(4.5F, 9.5F, 0.0F);
        this.EnderCube.addBox(-1.5F, 0.0F, -1.5F, 3, 3, 3, 0.0F);
        this.Holder_1 = new ModelRenderer(this, 4, 8);
        this.Holder_1.setRotationPoint(1.0F, 10.5F, 0.0F);
        this.Holder_1.addBox(0.0F, 0.0F, -0.5F, 2, 1, 1, 0.0F);
        this.Holder = new ModelRenderer(this, 4, 8);
        this.Holder.setRotationPoint(-1.0F, 10.5F, 0.0F);
        this.Holder.addBox(-2.0F, 0.0F, -0.5F, 2, 1, 1, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Rod.render(f5);
        this.EnderCube_1.render(f5);
        this.EnergyCube.render(f5);
        this.EnderCube.render(f5);
        this.Holder_1.render(f5);
        this.Holder.render(f5);
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
