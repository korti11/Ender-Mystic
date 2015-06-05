package at.korti.endermystic.blocks;

import at.korti.endermystic.EnderMystic;
import at.korti.endermystic.ModInfo;
import at.korti.endermystic.tileEntity.TileEntityEnergyDrain;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Korti on 13.04.2015.
 */
public class EnergyDrain extends BlockContainer {


    protected EnergyDrain() {
        super(Material.rock);

        setCreativeTab(EnderMystic.tab);
        setBlockName(ModInfo.MODID + ".EnergyDrain");
        setBlockBounds(0F, 0F, 0F, 1F, 1.5F, 1F);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityEnergyDrain();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {

        TileEntityEnergyDrain drain = (TileEntityEnergyDrain) world.getTileEntity(x, y, z);
        ItemStack currentStack = player.inventory.getCurrentItem();
        if(drain.getStackInSlot(0) == null && player.inventory.getStackInSlot(player.inventory.currentItem) != null) {
            ItemStack stackToAdd = new ItemStack(currentStack.getItem(), 1, currentStack.getItemDamage());
            stackToAdd.stackTagCompound = currentStack.stackTagCompound;
            drain.setInventorySlotContents(0, stackToAdd);
            player.inventory.setInventorySlotContents(player.inventory.currentItem, player.inventory.decrStackSize(player.inventory.currentItem, currentStack.stackSize - 1));
        }
        else if (player.inventory.getStackInSlot(player.inventory.currentItem) == null && drain.getStackInSlot(0) != null) {
            player.inventory.addItemStackToInventory(drain.getStackInSlot(0));
            drain.setInventorySlotContents(0, null);
        }

        return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderType() {
        return -1;
    }
}
