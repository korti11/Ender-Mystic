package at.korti.endermystic.items.blockitems;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by Korti on 04.04.2015.
 */
public class CrystalOreItemBlock extends ItemBlock{

    public CrystalOreItemBlock(Block block) {
        super(block);

        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        String subName;
        switch (stack.getItemDamage()){
            case 0:
                subName = "Water";
                break;
            case 1:
                subName = "Fire";
                break;
            case 2:
                subName = "Earth";
                break;
            case 3:
                subName = "Air";
                break;
            default:
                subName = "CrystalOre";
                break;
        }

        return getUnlocalizedName() + "." + subName;
    }
}
