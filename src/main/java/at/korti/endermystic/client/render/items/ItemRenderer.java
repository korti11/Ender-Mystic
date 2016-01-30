package at.korti.endermystic.client.render.items;

import at.korti.endermystic.ModInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * Created by Korti on 29.01.2016.
 */
public class ItemRenderer implements IItemRenderer {

    protected ModelBase model;
    protected String texture;

    public ItemRenderer(ModelBase model, String texture) {
        this.model = model;
        this.texture = texture;
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        GL11.glPushMatrix();
        Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ModInfo.MODID + ":" + texture));
        switch (type){
            case INVENTORY:
                GL11.glTranslatef(0F, 1F, 0F);
                GL11.glRotatef(180F, 0F, 0F, 1F);
                break;
            case ENTITY:
                GL11.glTranslatef(0F, 1.5F, 0F);
                GL11.glRotatef(180F, 0F, 0F, 1F);
                break;
            case EQUIPPED_FIRST_PERSON:
                GL11.glTranslatef(0F, 2F, 0.5F);
                GL11.glRotatef(180F, 0F, 0F, 1F);
                GL11.glRotatef(90F, 0F, 1F, 0F);
                break;
            case EQUIPPED:
                GL11.glTranslatef(-0.5F, 1.55F, -0.15F);
                GL11.glRotatef(135F, 1F, 0F, 0F);
                GL11.glRotatef(-45F, 0F, 0F, 1F);
                GL11.glScalef(1.5F, 1.5F, 1.5F);
                break;
        }
        model.render(null, 0F, 0F, -0.1F, 0F, 0F, 0.0625F);
        GL11.glPopMatrix();
    }
}
