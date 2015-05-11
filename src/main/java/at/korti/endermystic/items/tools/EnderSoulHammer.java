package at.korti.endermystic.items.tools;

import at.korti.endermystic.EnderMystic;
import at.korti.endermystic.ModInfo;
import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetwork;
import at.korti.endermystic.api.tools.AbilityHelper;
import at.korti.endermystic.items.orbs.OrbStats;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Korti on 02.12.2014.
 */
public class EnderSoulHammer extends ItemPickaxe {

    public EnderSoulHammer() {
        super(ToolMaterials.enderSoul);

        setCreativeTab(EnderMystic.tab);
        setMaxDamage(ToolMaterials.enderSoul.getMaxUses());
        setUnlocalizedName(ModInfo.MODID + ".EnderSoulHammer");
    }

    @SideOnly(Side.CLIENT)
    IIcon active;
    @SideOnly(Side.CLIENT)
    IIcon deactive;

    @Override
    public void registerIcons(IIconRegister register) {
        itemIcon = active = register.registerIcon(ModInfo.MODID + ":EnderSoulHammer");
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
    public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase player) {

        if(!world.isRemote){

            MovingObjectPosition mop = AbilityHelper.raytraceFromEntity(world, player, false, 4.5D);

            if(mop == null){
                return super.onBlockDestroyed(stack, world, block, x, y, z, player);
            }

            AbilityHelper.BreakMultiBlocks(player, stack, world, x, y, z, mop.sideHit, 3);
        }
        return super.onBlockDestroyed(stack, world, block, x, y, z, player);
    }

    @Override
    public void onUpdate(ItemStack stack, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
        if(stack.isItemDamaged()){
            stack.setItemDamage(0);
        }
    }

    @Override
    public float getDigSpeed(ItemStack stack, Block block, int meta) {
        if(!stack.stackTagCompound.hasKey("em_owner") || !stack.stackTagCompound.getBoolean("em_active")){
            return 0.0F;
        }

        return super.getDigSpeed(stack, block, meta);
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
