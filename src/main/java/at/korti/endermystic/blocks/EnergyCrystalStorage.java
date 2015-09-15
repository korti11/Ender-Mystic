package at.korti.endermystic.blocks;

import at.korti.endermystic.EnderMystic;
import at.korti.endermystic.ModInfo;
import at.korti.endermystic.api.crafting.IItemBookCrafting;
import at.korti.endermystic.tileEntity.TileEntityEnergyCrystalStorage;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Korti on 02.06.2015.
 */
public class EnergyCrystalStorage extends ModelBlock implements IItemBookCrafting {

    protected EnergyCrystalStorage() {
        super(Material.rock, TileEntityEnergyCrystalStorage.class);

        setCreativeTab(EnderMystic.tab);
        setBlockName(ModInfo.MODID + ".EnergyCrystalStorage");
        setStepSound(soundTypeStone);
    }
}
