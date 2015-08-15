package at.korti.endermystic.blocks;

import at.korti.endermystic.EnderMystic;
import at.korti.endermystic.ModInfo;
import at.korti.endermystic.api.util.AbilityHelper;
import at.korti.endermystic.tileEntity.TileEntityEnderTranfer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Korti on 21.06.2015.
 */
public class EnderPicker extends BlockContainer {

    public EnderPicker() {
        super(Material.iron);

        this.setBlockName(ModInfo.MODID + ".EnderPicker");
        this.setCreativeTab(EnderMystic.tab);
        this.setStepSound(soundTypeMetal);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityEnderTranfer();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if(!player.isSneaking()) {
            AbilityHelper.setStackInSlot(0, player, (TileEntityEnderTranfer) world.getTileEntity(x, y, z));
        }
        return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z)) {
            TileEntityEnderTranfer tileEnderTransfer = (TileEntityEnderTranfer) world.getTileEntity(x, y, z);
            if (tileEnderTransfer != null) {
                tileEnderTransfer.copyWorld();
            }
        }
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
