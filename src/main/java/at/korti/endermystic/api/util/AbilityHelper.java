package at.korti.endermystic.api.util;

import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetworkHandler;
import at.korti.endermystic.api.tools.ToolLevelHandler;
import at.korti.endermystic.items.orbs.EarthOrb;
import at.korti.endermystic.items.orbs.OrbStats;
import at.korti.endermystic.items.tools.EnderSoulSword;
import at.korti.endermystic.items.tools.ToolStats;
import at.korti.endermystic.potion.PotionHelper;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

/**
 * Created by Korti on 03.12.2014.
 */
public class AbilityHelper {

    public static void BreakMultiBlocks(EntityLivingBase player, ItemStack stack, World world, int x, int y, int z, int side, int radius){
        String itemName = stack.stackTagCompound.getString("em_owner");
        boolean isOrb = stack.getItem() instanceof EarthOrb;
        String toolClass = !isOrb ? stack.getItem() instanceof ItemPickaxe ? "pickaxe" : "shovel" : "";

        if (side == 1 || side == 0) {
            for (int i = z - radius / 2; i <= z + radius / 2; i++) {

                for (int j = x - radius / 2; j <= x + radius / 2; j++) {

                    if (setEnergy(stack, world, j, y, i, itemName, toolClass, isOrb) && !handleUpgrades(stack, world, world.getBlock(j, y, i), j, y, i)) {
                        world.getBlock(j, y, i).harvestBlock(world, (EntityPlayer) player, j, y, i, world.getBlock(j, y, i).getDamageValue(world, j, y, i));
                        world.setBlock(j, y, i, Blocks.air);
                    }

                }

            }
        } else {

            int help;

            if (side == 3 || side == 2) {
                help = x;
            } else {
                help = z;
            }

            for (int i = y - radius / 2; i <= y + radius / 2; i++) {

                for (int j = help - radius / 2; j <= help + radius / 2; j++) {

                    if (side == 3 || side == 2) {
                        if (setEnergy(stack, world, j, i, z, itemName, toolClass, isOrb) && !handleUpgrades(stack, world, world.getBlock(j, i, z), j, i, z)) {
                            world.getBlock(j, i, z).harvestBlock(world, (EntityPlayer) player, j, i, z, world.getBlock(j, i, z).getDamageValue(world, j, i, z));
                            world.setBlock(j, i, z, Blocks.air);
                        }
                    } else {
                        if (setEnergy(stack, world, x, i, j, itemName, toolClass, isOrb) && !handleUpgrades(stack, world, world.getBlock(x, i, j), x, i, j)) {
                            world.getBlock(x, i, j).harvestBlock(world, (EntityPlayer) player, x, i, j, world.getBlock(x, i, j).getDamageValue(world, x, i, j));
                            world.setBlock(x, i, j, Blocks.air);
                        }
                    }

                }

            }

        }
    }

    private static boolean setEnergy(ItemStack stack, World world, int x, int y, int z, String itemName, String toolClass, boolean isOrb){

        boolean material = false;

        if(isOrb) {
            if(!world.getBlock(x, y, z).getUnlocalizedName().equals(Blocks.bedrock.getUnlocalizedName())){
                int harvestLevel = world.getBlock(x, y, z).getHarvestLevel(world.getBlock(x, y, z).getDamageValue(world, x, y, z)) == 0 ? 1 : world.getBlock(x, y, z).getHarvestLevel(world.getBlock(x, y, z).getDamageValue(world, x, y, z));
                material = EnergyNetworkHandler.DecEnergy(harvestLevel * OrbStats.usageEarthOrb, itemName);
            }
        }
        else {
            String harvestTool = world.getBlock(x,y,z).getHarvestTool(world.getBlock(x, y, z).getDamageValue(world, x, y, z));
            if(harvestTool != null && harvestTool.equals(toolClass)){
                if(toolClass.equals("pickaxe")){
                    material = EnergyNetworkHandler.DecEnergy(ToolStats.enderSoulPickaxeUsage, itemName);
                }
                else {
                    material = EnergyNetworkHandler.DecEnergy(ToolStats.enderSoulShovelUsage, itemName);
                }
                ToolLevelHandler.getInstance().addXP(stack, 1);
            }
        }

        return material;

    }

    private static boolean handleUpgrades(ItemStack stack, World world, Block block, int x, int y, int z) {
        return ToolLevelHandler.getInstance().handleLuckUpgrade(stack, world, block, x, y, z) || ToolLevelHandler.getInstance().handleSilkTouchUpgrade(stack, world, block, x, y, z, Minecraft.getMinecraft().thePlayer) || ToolLevelHandler.getInstance().handleAutoSmeltUpgrade(stack, world, block, x, y, z);
    }

    public static MovingObjectPosition raytraceFromEntity (World world, Entity player, boolean par3, double range)
    {
        float f = 1.0F;
        float f1 = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * f;
        float f2 = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * f;
        double d0 = player.prevPosX + (player.posX - player.prevPosX) * (double) f;
        double d1 = player.prevPosY + (player.posY - player.prevPosY) * (double) f;
        if (!world.isRemote && player instanceof EntityPlayer)
            d1 += 1.62D;
        double d2 = player.prevPosZ + (player.posZ - player.prevPosZ) * (double) f;
        Vec3 vec3 = Vec3.createVectorHelper(d0, d1, d2);
        float f3 = MathHelper.cos(-f2 * 0.017453292F - (float) Math.PI);
        float f4 = MathHelper.sin(-f2 * 0.017453292F - (float) Math.PI);
        float f5 = -MathHelper.cos(-f1 * 0.017453292F);
        float f6 = MathHelper.sin(-f1 * 0.017453292F);
        float f7 = f4 * f5;
        float f8 = f3 * f5;
        double d3 = range;
        if (player instanceof EntityPlayerMP)
        {
            d3 = ((EntityPlayerMP) player).theItemInWorldManager.getBlockReachDistance();
        }
        Vec3 vec31 = vec3.addVector((double) f7 * d3, (double) f6 * d3, (double) f8 * d3);
        return world.func_147447_a(vec3, vec31, par3, !par3, par3);
    }

    public static void SetBlock(int x, int y, int z, int side, Block block, World world) {

        switch (side){
            case 1:
                if (canSetBlock(x, y, z, side, world)) {
                    world.setBlock(x, y + 1, z, block);
                }
                break;
            case 2:
                if (canSetBlock(x, y, z, side, world)) {
                    world.setBlock(x, y, z - 1, block);
                }
                break;
            case 3:
                if (canSetBlock(x, y, z, side, world)) {
                    world.setBlock(x, y, z + 1, block);
                }
                break;
            case 4:
                if (canSetBlock(x, y, z, side, world)) {
                    world.setBlock(x - 1, y, z, block);
                }
                break;
            case 5:
                if (canSetBlock(x, y, z, side, world)) {
                    world.setBlock(x + 1, y, z, block);
                }
                break;
            default:
                break;
        }

    }

    public static void createTileEntity(int x, int y, int z, int side, TileEntity tileEntity, World world) {
        switch (side) {
            case 1:
                if (canSetBlock(x, y, z, side, world)) {
                    world.setTileEntity(x, y + 1, z, tileEntity);
                }
                break;
            case 2:
                if (canSetBlock(x, y, z, side, world)) {
                    world.setTileEntity(x, y, z - 1, tileEntity);
                }
                break;
            case 3:
                if (canSetBlock(x, y, z, side, world)) {
                    world.setTileEntity(x, y, z, tileEntity);
                }
                break;
            case 4:
                if (canSetBlock(x, y, z, side, world)) {
                    world.setTileEntity(x, y, z, tileEntity);
                }
                break;
            case 5:
                if (canSetBlock(x, y, z, side, world)) {
                    world.setTileEntity(x, y, z, tileEntity);
                }
                break;
            default:
                break;
        }
    }

    private static boolean canSetBlock(int x, int y, int z, int side, World world){
        switch (side){
            case 0:
                return world.isAirBlock(x, y - 1, z);
            case 1:
                return world.isAirBlock(x, y + 1, z);
            case 2:
                return world.isAirBlock(x, y, z - 1);
            case 3:
                return world.isAirBlock(x, y, z + 1);
            case 4:
                return world.isAirBlock(x - 1, y, z);
            case 5:
                return world.isAirBlock(x + 1, y, z);
            default:
                return false;
        }
    }

    public static TileEntity getTileEntityFromSide(int x, int y, int z, int side, World world){
        switch (side){
            case 0:
                return world.getTileEntity(x, y - 1, z);
            case 1:
                return world.getTileEntity(x, y + 1, z);
            case 2:
                return world.getTileEntity(x, y, z - 1);
            case 3:
                return world.getTileEntity(x, y, z + 1);
            case 4:
                return world.getTileEntity(x - 1, y, z);
            case 5:
                return world.getTileEntity(x + 1, y, z);
            default:
                return null;
        }
    }

    public static boolean isBetween(float min, float max, float current){
        return (((float)(int)(current * 100)) / 100) >= min && (((float)(int)(current * 100)) / 100) <= max;
    }

    public static void setStackInSlot(int slot, EntityPlayer player, IInventory inventory){
        if(inventory.getStackInSlot(slot) == null && player.inventory.getCurrentItem() != null && inventory.isItemValidForSlot(slot, player.inventory.getCurrentItem())) {
            inventory.setInventorySlotContents(slot, player.inventory.getCurrentItem().copy());
            player.inventory.setInventorySlotContents(player.inventory.currentItem, player.inventory.decrStackSize(player.inventory.currentItem, player.inventory.getStackInSlot(player.inventory.currentItem).stackSize - 1));
        }
        else if(player.inventory.getCurrentItem() == null) {
            player.inventory.addItemStackToInventory(inventory.getStackInSlot(slot));
            inventory.setInventorySlotContents(slot, null);
        }
    }

    public static void addEnderHeartBleedPotion(ItemStack stack, EntityLivingBase entity) {
        if(stack.getItem() instanceof EnderSoulSword) {
            if (stack.stackTagCompound == null) {
                stack.stackTagCompound = new NBTTagCompound();
            }

            if (EnergyNetworkHandler.DecEnergy(ToolStats.enderSoulSwordUsage, stack.stackTagCompound.getString("em_owner"))) {
                if (stack.stackTagCompound.hasKey("em_owner") && stack.stackTagCompound.getBoolean("em_active")) {
                    entity.addPotionEffect(new PotionEffect(PotionHelper.enderHeartBleed.getId(), 200));
                }
            }
        }
    }

}
