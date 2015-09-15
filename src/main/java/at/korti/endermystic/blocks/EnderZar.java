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
public class EnderZar extends ModelBlock implements IItemBookCrafting {

    protected EnderZar() {
        super(Material.iron, TileEntityEnderZar.class);

        setCreativeTab(EnderMystic.tab);
        setBlockName(ModInfo.MODID + ".EnderZar");
        setBlockBounds(0.2F, 0F, 0.2F, 0.8F, 0.1F, 0.8F);
        setStepSound(soundTypeStone);
    }
}
