package at.korti.endermystic.client.render.items;

import at.korti.endermystic.ModInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * Created by Korti on 09.06.2015.
 */
public class ItemArmorRenderer implements IItemRenderer{

    private ModelBiped armorModel;
    private String texture;

    public ItemArmorRenderer(ModelBiped modelBase, String texture) {
        this.armorModel = modelBase;
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
        if(item.getItem() instanceof ItemArmor) {
            ItemArmor itemArmor = (ItemArmor) item.getItem();
            GL11.glPushMatrix();
            GL11.glTranslatef(-0.5F, 0, -0.5F);
            ResourceLocation resourceLocation = new ResourceLocation(ModInfo.MODID + ":" + texture);
            Minecraft.getMinecraft().renderEngine.bindTexture(resourceLocation);

            GL11.glPushMatrix();
            GL11.glRotatef(180F, 0F, 0F, 1F);
//            if (itemArmor.armorType == 0) {
//                armorModel.addHelm(null, 0F, 0F, -0.1F, 0F, 0F, 0.0625F);
//            }
//            else if (itemArmor.armorType == 1) {
//                armorModel.addBreastplate(null, 0F, 0F, -0.1F, 0F, 0F, 0.0625F);
//            }
//            else if (itemArmor.armorType == 2) {
//                armorModel.addLegs(null, 0F, 0F, -0.1F, 0F, 0F, 0.0625F);
//            }
            GL11.glPopMatrix();
            GL11.glPopMatrix();
        }
    }
}
