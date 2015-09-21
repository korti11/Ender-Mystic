package at.korti.endermystic.blocks;

import at.korti.endermystic.EnderMystic;
import at.korti.endermystic.ModInfo;
import at.korti.endermystic.api.crafting.IItemBookCrafting;
import at.korti.endermystic.api.helper.InventoryHelper;
import at.korti.endermystic.api.helper.WorldHelper;
import at.korti.endermystic.tileEntity.TileEntityCrystalCombiner;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by Korti on 03.04.2015.
 */
public class CrystalCombiner extends ModelBlock implements IItemBookCrafting{

    public CrystalCombiner() {
        super(Material.rock, TileEntityCrystalCombiner.class);

        this.setCreativeTab(EnderMystic.tab);
        this.setBlockName(ModInfo.MODID + ".CrystalCombiner");
        this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
        this.setStepSound(soundTypeStone);
    }

//    @Override
//    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axis, List list, Entity entity) {
//
//        this.setBlockBounds(0.0625F, 0F, 0.0625F, 0.9375F, 0.0625F, 0.9375F);
//        super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
//        this.setBlockBounds(0.125F, 0.0625F, 0.125F, 0.875F, 0.125F, 0.875F);
//        super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
//        this.setBlockBounds(0.1875F, 0.125F, 0.1875F, 0.8125F, 0.1875F, 0.8125F);
//        super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
//        this.setBlockBounds(0.3125F, 0.1875F, 0.3125F, 0.6875F, 0.625F, 0.6875F);
//        super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
//        this.setBlockBounds(0.28125F, 0.625F, 0.28125F, 0.71875F, 0.6875F, 0.71875F);
//        super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
//        this.setBlockBounds(0.34375F, 0.6875F, 0.34375F, 0.65625F, 0.75F, 0.65625F);
//        super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
//        this.setBlockBounds(0.375F, 0.75F, 0.375F, 0.625F, 0.9375F, 0.625F);
//        super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
//        this.setBlockBounds(-0.21875F, 0.625F, 0.34375F, -0.0625F, 0.6875F, 0.65625F);
//        super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
//        this.setBlockBounds(-0.1875F, 0.6875F, 0.375F, -0.09375F, 0.78125F, 0.625F);
//        super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
//
//        //this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
//    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        System.out.println("HitX: " + hitX + ", HitY: " + hitY + ", HitZ: " + hitZ + ", Side: " + side);

        TileEntityCrystalCombiner combiner = (TileEntityCrystalCombiner)world.getTileEntity(x,y,z);

        if(InventoryHelper.isBetween(0.27F, 0.75F, hitZ) && side != 1){
            if(side == 4) {
                InventoryHelper.setStackInSlot(0, player, combiner);
            }
            else {
                InventoryHelper.setStackInSlot(2, player, combiner);
            }
        }
        else if (InventoryHelper.isBetween(0.27F, 0.75F, hitX) && side != 1) {
            if(side == 2) {
                InventoryHelper.setStackInSlot(1, player, combiner);
            }
            else {
                InventoryHelper.setStackInSlot(3, player, combiner);
            }
        }
        else if(InventoryHelper.isBetween(0.3F, 0.7F, hitX) && InventoryHelper.isBetween(0.3F, 0.7F, hitZ)){
            if(player.inventory.getCurrentItem() == null && combiner.getStackInSlot(4) != null){
                player.inventory.addItemStackToInventory(combiner.getStackInSlot(4));
                combiner.setInventorySlotContents(4, null);
            }
        }
        return true;
    }
}
