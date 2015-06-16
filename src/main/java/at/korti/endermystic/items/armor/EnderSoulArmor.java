package at.korti.endermystic.items.armor;

import at.korti.endermystic.ModInfo;
import at.korti.endermystic.client.model.armor.EnderSoulArmorModel;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

/**
 * Created by Korti on 10.06.2015.
 */
public class EnderSoulArmor extends ItemArmor {

    public EnderSoulArmor(int armorType) {
        super(ArmorMaterials.enderSoulMaterial, 0, armorType);

        setUnlocalizedName(ModInfo.MODID + ".EnderSoulArmor");
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        String subName;

        switch (((ItemArmor)stack.getItem()).armorType) {
            case 0:
                subName = "Helmet";
                break;
            case 1:
                subName = "Breastplate";
                break;
            case 2:
                subName = "Legs";
                break;
            default:
                subName = "Armor";
        }

        return super.getUnlocalizedName() + "." + subName;
    }

    @Override
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {

        int type = ((ItemArmor) itemStack.getItem()).armorType;
        ModelBiped model1 = new EnderSoulArmorModel(1.0F, true, true, false);
        ModelBiped model2 = new EnderSoulArmorModel(0.5F, false, false, true);
        ModelBiped model = null;

        if (type == 1 || type == 0) {
            model = model1;
        }
        else {
            model = model2;
        }

        if (model != null) {
            model.bipedHead.showModel = (type == 0);
            model.bipedHeadwear.showModel = (type == 0);
            model.bipedBody.showModel = (type == 1);
            model.bipedLeftArm.showModel = (type == 1);
            model.bipedRightArm.showModel = (type == 1);
            model.bipedLeftLeg.showModel = (type == 2);
            model.bipedRightLeg.showModel = (type == 2);

            model.isSneak = entityLiving.isSneaking();
            model.isRiding = entityLiving.isRiding();
            model.isChild = entityLiving.isChild();

            model.aimedBow = false;
            model.heldItemRight = (entityLiving.getHeldItem() != null ? 1 : 0);

            if (entityLiving instanceof EntityPlayer) {
                if (((EntityPlayer) entityLiving).getItemInUseDuration() > 0) {
                    EnumAction enumAction = ((EntityPlayer) entityLiving).getItemInUse().getItemUseAction();
                    if (enumAction == EnumAction.block) {
                        model.heldItemRight = 3;
                    }
                    else if (enumAction == EnumAction.bow) {
                        model.aimedBow = true;
                    }
                }
            }
            return model;
        }
        else {
            return this.getArmorModel(entityLiving, itemStack, armorSlot);
        }
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return ModInfo.MODID + ":textures/model/EnderSoulArmor.png";
    }
}
