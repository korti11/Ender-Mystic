package at.korti.endermystic.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Korti on 15.09.2015.
 */
public class ModelBlock extends BlockContainer {

    private Class tileEntityClass;

    public ModelBlock(Material material, Class tileEntityClass) {
        super(material);
        this.tileEntityClass = tileEntityClass;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int p_149915_2_) {
        TileEntity tileEntity = null;
        try {
            tileEntity = (TileEntity) tileEntityClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        tileEntity.setWorldObj(world);
        return tileEntity;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getRenderType() {
        return -1;
    }
}
