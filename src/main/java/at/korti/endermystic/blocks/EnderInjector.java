package at.korti.endermystic.blocks;

import at.korti.endermystic.EnderMystic;
import at.korti.endermystic.ModInfo;
import at.korti.endermystic.tileEntity.TileEntityEnderTranfer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Korti on 22.06.2015.
 */
public class EnderInjector extends BlockContainer {

    public EnderInjector() {
        super(Material.iron);

        this.setBlockName(ModInfo.MODID + ".EnderInjector");
        this.setCreativeTab(EnderMystic.tab);
        this.setStepSound(soundTypeMetal);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityEnderTranfer();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float xHit, float yHit, float zHit) {
        player.openGui(EnderMystic.instance, 2, world, x, y, z);
        return super.onBlockActivated(world, x, y, z, player, side, xHit, yHit, zHit);
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z)) {
            TileEntityEnderTranfer tileEnderTransfer = (TileEntityEnderTranfer) world.getTileEntity(x, y, z);
            if (tileEnderTransfer != null) {
                tileEnderTransfer.injectWorld();
            }
        }
    }
}
