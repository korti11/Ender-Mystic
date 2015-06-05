package at.korti.endermystic.modintegration.cofh.blocks;

import at.korti.endermystic.EnderMystic;
import at.korti.endermystic.ModInfo;
import at.korti.endermystic.modintegration.cofh.tileentity.TileEntityMysticDynamo;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Korti on 05.06.2015.
 */
public class MysticDynamo extends BlockContainer {

    public MysticDynamo() {
        super(Material.rock);

        setBlockName(ModInfo.MODID + "MysticDynamo");
        setStepSound(soundTypeStone);
        setCreativeTab(EnderMystic.tab);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityMysticDynamo();
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
