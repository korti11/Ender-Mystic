package at.korti.endermystic.items.tools;

import at.korti.endermystic.EnderMystic;
import at.korti.endermystic.ModInfo;
import at.korti.endermystic.api.tools.IEnderSoulTool;
import at.korti.endermystic.api.tools.ToolLevelHandler;
import at.korti.endermystic.api.util.AbilityHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Korti on 27.10.2014.
 */
public class EnderSoulSword extends ItemSword implements IEnderSoulTool{

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

        if (!ToolLevelHandler.getInstance().isItemInited(stack)) {
            ToolLevelHandler.getInstance().initItem(stack);
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

        info.add("");
        ToolLevelHandler.getInstance().writeAttackDamage(stack, info);
        info.add("");
        info.add("Level: " + ToolLevelHandler.getInstance().getLevelName(stack));
        info.add("Xp: " + ToolLevelHandler.getInstance().getXp(stack) + "/" + ToolLevelHandler.getInstance().getMaxXp(stack));
        ToolLevelHandler.getInstance().writeInfo(stack, info);

    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase entity, EntityLivingBase player) {
        AbilityHelper.addEnderHeartBleedPotion(stack, entity);
        ToolLevelHandler.getInstance().addXP(stack, 1, (EntityPlayer) player);
        ToolLevelHandler.getInstance().handleSharpnessUpgrade((EntityPlayer) player, entity);
        ToolLevelHandler.getInstance().handleFireyUpgrade((EntityPlayer) player, entity);
//        if (entity.) {
//            ToolLevelHandler.getInstance().handleLuckUpgrade((EntityPlayer) player, entity);
//        }
        return super.hitEntity(stack, entity, player);
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

        if(stack.stackTagCompound.getBoolean("em_active")) {
            return super.onItemRightClick(stack, world, player);
        }
        else{
            return stack;
        }
    }

    @Override
    public void onUpdate(ItemStack stack, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
        if(stack.isItemDamaged()){
            stack.setItemDamage(0);
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
