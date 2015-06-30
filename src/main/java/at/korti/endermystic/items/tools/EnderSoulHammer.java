package at.korti.endermystic.items.tools;

import at.korti.endermystic.EnderMystic;
import at.korti.endermystic.ModInfo;
import at.korti.endermystic.api.tools.IEnderSoulTool;
import at.korti.endermystic.api.tools.ToolLevelHandler;
import at.korti.endermystic.api.util.AbilityHelper;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Korti on 02.12.2014.
 */
public class EnderSoulHammer extends ItemPickaxe implements IEnderSoulTool{

    public EnderSoulHammer() {
        super(ToolMaterials.enderSoul);

        setCreativeTab(EnderMystic.tab);
        setMaxDamage(ToolMaterials.enderSoul.getMaxUses());
        setUnlocalizedName(ModInfo.MODID + ".EnderSoulHammer");
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List info, boolean p_77624_4_) {

        if(stack.getTagCompound() == null){
            stack.setTagCompound(new NBTTagCompound());
        }

        if (!ToolLevelHandler.getInstance().isItemInited(stack)) {
            ToolLevelHandler.getInstance().initItem(stack);
        }

        if(stack.getTagCompound().hasKey("em_owner")){
            info.add("Owner: " + stack.getTagCompound().getString("em_owner"));
        }

        if(stack.getTagCompound().getBoolean("em_active")){
            info.add("Activated");
        }
        else{
            info.add("Deactivated");
        }
        info.add("");
        info.add("Level: " + ToolLevelHandler.getInstance().getLevelName(stack));
        info.add("Xp: " + ToolLevelHandler.getInstance().getXp(stack) + "/" + ToolLevelHandler.getInstance().getMaxXp(stack));
        ToolLevelHandler.getInstance().writeInfo(stack, info);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {

        if(stack.getTagCompound() == null){
            stack.setTagCompound(new NBTTagCompound());
        }

        if(!stack.getTagCompound().hasKey("em_owner")){
            stack.getTagCompound().setString("em_owner", player.getDisplayNameString());
        }

        if(player.isSneaking()){
            if(stack.getTagCompound().getBoolean("em_active")){
                stack.getTagCompound().setBoolean("em_active", false);
            }
            else{
                stack.getTagCompound().setBoolean("em_active", true);
            }
        }

        return stack;
    }

    @Override
    public void onUpdate(ItemStack stack, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
        if(stack.isItemDamaged()){
            stack.setItemDamage(0);
        }
    }

    @Override
    public float getDigSpeed(ItemStack stack, IBlockState state) {
        if(!stack.getTagCompound().hasKey("em_owner") || !stack.getTagCompound().getBoolean("em_active")){
            return 0.0F;
        }

        return super.getDigSpeed(stack, state) +  + ToolLevelHandler.getInstance().handleHasteUpgrade(stack);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, Block blockIn, BlockPos pos, EntityLivingBase playerIn) {
        if(!worldIn.isRemote) {
            MovingObjectPosition mop = AbilityHelper.raytraceFromEntity(worldIn, playerIn, false, 4.5D);
            if (mop != null) {
                AbilityHelper.BreakMultiBlocks((EntityPlayer) playerIn, stack, worldIn, pos.getX(), pos.getY(), pos.getZ(), mop.sideHit.getIndex(), 3);
            }
        }
        return super.onBlockDestroyed(stack, worldIn, blockIn, pos, playerIn);
    }
}
