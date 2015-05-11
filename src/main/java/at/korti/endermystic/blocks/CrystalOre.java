package at.korti.endermystic.blocks;

import at.korti.endermystic.EnderMystic;
import at.korti.endermystic.ModInfo;
import at.korti.endermystic.client.render.blocks.BlockRenderConfig;
import at.korti.endermystic.items.ModItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Korti on 04.04.2015.
 */
public class CrystalOre extends Block {

    public final int oreCount = 4;
    public static final int[] colors = {13260, 16711680, 3381555, 16777011};

    public CrystalOre() {
        super(Material.rock);

        this.setBlockName(ModInfo.MODID + ".CrystalOre");
        this.setCreativeTab(EnderMystic.tab);
        this.setHarvestLevel("pickaxe", 2);
        this.setStepSound(soundTypeStone);
        this.setHardness(3F);
    }

    @SideOnly(Side.CLIENT)
    public IIcon crystalIcon;
    @SideOnly(Side.CLIENT)
    public IIcon stoneIcon;

    @Override
    public void registerBlockIcons(IIconRegister register) {
        crystalIcon = register.registerIcon(ModInfo.MODID + ":CrystalOre");
        stoneIcon = register.registerIcon(ModInfo.MODID + ":CrystalOreStone");
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs p_149666_2_, List list) {
        for(int i = 0; i < oreCount; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {

        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();

        int count = quantityDropped(metadata, fortune, world.rand);
        for (int i = 0; i < count; i++) {
            drops.add(new ItemStack(ModItems.crystalItem, 1, metadata));
        }

        return drops;
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
        return BlockRenderConfig.CrystelOreRenderId;
    }
}
