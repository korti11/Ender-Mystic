package at.korti.endermystic.items.tools;

import at.korti.endermystic.EnderMystic;
import at.korti.endermystic.ModInfo;
import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetworkHandler;
import at.korti.endermystic.api.tools.AbilityHelper;
import at.korti.endermystic.potion.PotionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Korti on 27.10.2014.
 */
public class EnderSoulSword extends ItemSword {

    public EnderSoulSword() {
        super(ToolMaterials.enderSoul);

        setCreativeTab(EnderMystic.tab);
        setUnlocalizedName(ModInfo.MODID + ".EnderSoulSword");
    }

    @SideOnly(Side.CLIENT)
    IIcon active;
    @SideOnly(Side.CLIENT)
    IIcon deactive;

    @Override
    public void registerIcons(IIconRegister register) {
        itemIcon = active = register.registerIcon(ModInfo.MODID + ":EnderSoulSword");
        deactive = register.registerIcon(ModInfo.MODID + ":EnderSoulTool");
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List info, boolean p_77624_4_) {

        if(stack.stackTagCompound == null){
            stack.stackTagCompound = new NBTTagCompound();
        }

        if(stack.stackTagCompound.hasKey("em_owner")){
            info.add("Owner: " + stack.stackTagCompound.getString("em_owner"));
        }

        if(stack.stackTagCompound.getBoolean("em_active")){
            info.add("Activated");
        }
        else{
            info.add("Deactivated");
        }

    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {

        if(stack.stackTagCompound == null){
            stack.stackTagCompound = new NBTTagCompound();
        }

        if(stack.stackTagCompound.hasKey("em_owner")){
            return !stack.stackTagCompound.getBoolean("em_active");
        }

        return true;
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase entity, EntityLivingBase player) {

        if(stack.stackTagCompound == null){
            stack.stackTagCompound = new NBTTagCompound();
        }

        if(EnergyNetworkHandler.DecEnergy(ToolStats.enderSoulSwordUsage, stack.stackTagCompound.getString("em_owner"))){
            if(stack.stackTagCompound.hasKey("em_owner") && stack.stackTagCompound.getBoolean("em_active")) {
                entity.addPotionEffect(new PotionEffect(PotionHelper.enderHeartBleed.getId(), 200));
            }
            return true;
        }

        return false;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {

        if(stack.stackTagCompound == null){
            stack.stackTagCompound = new NBTTagCompound();
        }

        if(!stack.stackTagCompound.hasKey("em_owner")){
            stack.stackTagCompound.setString("em_owner", player.getDisplayName());
        }

        if(player.isSneaking()){
            if(stack.stackTagCompound.getBoolean("em_active")){
                stack.stackTagCompound.setBoolean("em_active", false);
            }
            else{
                stack.stackTagCompound.setBoolean("em_active", true);
            }
        }

        return stack;
    }

    @Override
    public void onUpdate(ItemStack stack, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
        if(stack.isItemDamaged()){
            if(EnergyNetworkHandler.DecEnergy(ToolStats.enderSoulSwordUsage, stack.stackTagCompound.getString("em_owner"))){
                stack.setItemDamage(0);
            }
        }
    }

    @Override
    public IIcon getIcon(ItemStack stack, int pass) {
        if(stack.stackTagCompound.getBoolean("em_active")){
            return active;
        }
        else {
            return deactive;
        }
    }
}
