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
public class EnergyRelay extends ModelBlock implements IItemBookCrafting {

    public EnergyRelay() {
        super(Material.rock, TileEntityEnergyRelay.class);

        this.setBlockBounds(0.4F, 0.45F, 0.4F, 0.6F, 0.75F, 0.6F);
        this.setCreativeTab(EnderMystic.tab);
        this.setBlockName(ModInfo.MODID + ".EnergyRelay");
        this.setStepSound(soundTypeStone);
    }
}
