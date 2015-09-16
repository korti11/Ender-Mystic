package at.korti.endermystic.modintegration.cofh.blocks;

import at.korti.endermystic.EnderMystic;
import at.korti.endermystic.ModInfo;
import at.korti.endermystic.api.crafting.IItemBookCrafting;
import at.korti.endermystic.blocks.ModelBlock;
import at.korti.endermystic.modintegration.cofh.tileentity.TileEntityMysticConverter;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Korti on 05.06.2015.
 */
public class MysticConverter extends ModelBlock implements IItemBookCrafting{

    public MysticConverter() {
        super(Material.rock, TileEntityMysticConverter.class);

        setBlockName(ModInfo.MODID + ".MysticConverter");
        setStepSound(soundTypeStone);
        setCreativeTab(EnderMystic.tab);
    }
}
