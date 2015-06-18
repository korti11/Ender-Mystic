package at.korti.endermystic.items.armor;

import at.korti.endermystic.ModInfo;
import at.korti.endermystic.api.crafting.IItemBookCrafting;
import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetworkHandler;
import at.korti.endermystic.client.model.armor.EnderSoulArmorModel;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Korti on 10.06.2015.
 */
public class EnderSoulArmor extends ItemArmor implements IItemBookCrafting{

    @SideOnly(Side.CLIENT)
    private IIcon helmet;
    @SideOnly(Side.CLIENT)
    private IIcon chestplate;
    @SideOnly(Side.CLIENT)
    private IIcon leggings;

    private final int energyUse = 40;

    public EnderSoulArmor(int armorType) {
        super(ArmorMaterials.enderSoulMaterial, 0, armorType);

        setUnlocalizedName(ModInfo.MODID + ".EnderSoulArmor");
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean p_77624_4_) {
        super.addInformation(stack, player, list, p_77624_4_);

        if (stack.stackTagCompound == null) {
            stack.stackTagCompound = new NBTTagCompound();
        }

        if (stack.stackTagCompound.hasKey("em_owner")) {
            list.add("Owner: " + stack.stackTagCompound.getString("em_owner"));
        }
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
    public void registerIcons(IIconRegister register) {
        this.helmet = register.registerIcon(ModInfo.MODID + ":EnderSoulArmorHelmet");
        this.chestplate = register.registerIcon(ModInfo.MODID + ":EnderSoulArmorChestplate");
        this.leggings = register.registerIcon(ModInfo.MODID + ":EnderSoulArmorLeggings");
    }

    @Override
    public IIcon getIconIndex(ItemStack stack) {
        ItemArmor itemArmor = (ItemArmor) stack.getItem();
        if (itemArmor.armorType == 0) {
            return helmet;
        }
        else if (itemArmor.armorType == 1) {
            return chestplate;
        }
        else if (itemArmor.armorType == 2) {
            return leggings;
        } else {
            return getIconIndex(stack);
        }
    }

    @SideOnly(Side.CLIENT)
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

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (stack.stackTagCompound == null) {
            stack.stackTagCompound = new NBTTagCompound();
        }

        if (!stack.stackTagCompound.hasKey("em_owner")) {
            stack.stackTagCompound.setString("em_owner", player.getDisplayName());
        }

        return super.onItemRightClick(stack, world, player);
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_) {
        super.onUpdate(stack, world, entity, p_77663_4_, p_77663_5_);

        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            for (int i = 0; i < player.inventory.armorInventory.length; i++) {
                if (player.inventory.armorInventory[i] != null && player.inventory.armorInventory[i].equals(stack))  {
                    if(stack.stackTagCompound == null || !stack.stackTagCompound.hasKey("em_owner")){
                        player.addChatMessage(new ChatComponentText(stack.getDisplayName() + " is not bound to a player"));
                    }
                    else if (stack.stackTagCompound != null && EnergyNetworkHandler.isEnoughEnergy(energyUse, stack.stackTagCompound.getString("em_owner"))) {
                        EnergyNetworkHandler.decEnergy(energyUse, stack.stackTagCompound.getString("em_owner"));
                        stack.setItemDamage(0);
                    }
                }
            }
        }
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        super.onArmorTick(world, player, itemStack);

        for (int i = 0; i < player.inventory.armorInventory.length; i++) {
            if (player.inventory.armorInventory[i] != null && player.inventory.armorInventory[i].equals(itemStack))  {
                if (itemStack.stackTagCompound != null && EnergyNetworkHandler.isEnoughEnergy(energyUse, itemStack.stackTagCompound.getString("em_owner")) && itemStack.isItemDamaged()) {
                    EnergyNetworkHandler.decEnergy(energyUse, itemStack.stackTagCompound.getString("em_owner"));
                    itemStack.setItemDamage(0);
                }
            }
        }
    }
}
