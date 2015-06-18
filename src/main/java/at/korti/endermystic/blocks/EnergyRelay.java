package at.korti.endermystic.blocks;

import at.korti.endermystic.EnderMystic;
import at.korti.endermystic.ModInfo;
import at.korti.endermystic.api.crafting.IItemBookCrafting;
import at.korti.endermystic.tileEntity.TileEntityEnergyRelay;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Korti on 14.04.2015.
 */
public class EnergyRelay extends BlockContainer implements IItemBookCrafting {

    public EnergyRelay() {
        super(Material.rock);

        this.setBlockBounds(0.4F, 0.45F, 0.4F, 0.6F, 0.75F, 0.6F);
        this.setCreativeTab(EnderMystic.tab);
        this.setBlockName(ModInfo.MODID + ".EnergyRelay");
        this.setStepSound(soundTypeStone);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityEnergyRelay();
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
