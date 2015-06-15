package at.korti.endermystic.items.armor;

import at.korti.endermystic.ModInfo;
import at.korti.endermystic.client.model.EnderSoulArmorModel;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

/**
 * Created by Korti on 10.06.2015.
 */
public class EnderSoulArmor extends ItemArmor {

    public EnderSoulArmor(int armorType) {
        super(ArmorMaterial.DIAMOND, 0, armorType);

        setUnlocalizedName(ModInfo.MODID + ".EnderSoulArmor");
    }

    @Override
    public String getUnlocalizedName() {
        String subName;

        switch (armorType) {
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
        return new EnderSoulArmorModel(armorType);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return ModInfo.MODID + ":textures/model/EnderSoulArmor.png";
    }
}
