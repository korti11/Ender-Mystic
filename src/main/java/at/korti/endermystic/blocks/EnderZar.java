package at.korti.endermystic.blocks;

import at.korti.endermystic.EnderMystic;
import at.korti.endermystic.ModInfo;
import at.korti.endermystic.api.crafting.IItemBookCrafting;
import at.korti.endermystic.tileEntity.TileEntityEnderZar;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Korti on 07.05.2015.
 */
public class EnderZar extends BlockContainer implements IItemBookCrafting {

    protected EnderZar() {
        super(Material.iron);

        setCreativeTab(EnderMystic.tab);
        setBlockName(ModInfo.MODID + ".EnderZar");
        setBlockBounds(0.2F, 0F, 0.2F, 0.8F, 0.1F, 0.8F);
        setStepSound(soundTypeStone);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityEnderZar();
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
