package at.korti.endermystic.blocks;

import at.korti.endermystic.ModInfo;
import at.korti.endermystic.tileEntity.TileEntityEnergyCrystalStorage;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Korti on 02.06.2015.
 */
public class EnergyCrystalStorage extends BlockContainer{

    protected EnergyCrystalStorage() {
        super(Material.rock);

        setBlockName(ModInfo.MODID + ".EnergyCrystalStorage");
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityEnergyCrystalStorage();
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
