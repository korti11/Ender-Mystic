package at.korti.endermystic.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Created by Korti on 13.05.2015.
 */
public class OrbCoreItem extends ModItem {

    private final int count = 12;

    public OrbCoreItem() {
        super("OrbCore");

        setHasSubtypes(true);
    }

    @Override
    public int getColorFromItemStack(ItemStack stack, int p_82790_2_) {
        switch (stack.getItemDamage()) {
            case 0:
                return 0x2db895;
            case 1:
                return 0x29a452;
            case 2:
                return 0x00f200;
            case 3:
                return 0x4e447f;
            case 4:
                return 0xd43535;
            case 5:
                return 0x29a4a4;
            case 6:
                return 0x258474;
            case 7:
                return 0x3C3C8D;
            case 8:
                return 0x620000;
            case 9:
                return 0x00A6CF;
            case 10:
                return 0x000066;
            case 11:
                return 0x00001F;
            default:
                return 0;
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        String subName;
        switch (stack.getItemDamage()) {
            case 0:
                subName = "Air";
                break;
            case 1:
                subName = "Earth";
                break;
            case 2:
                subName = "Emerald";
                break;
            case 3:
                subName = "EnderZar";
                break;
            case 4:
                subName = "Fire";
                break;
            case 5:
                subName = "Water";
                break;
            case 6:
                subName = "BasicEnder";
                break;
            case 7:
                subName = "Apprentice";
                break;
            case 8:
                subName = "Guardians";
                break;
            case 9:
                subName = "Master";
                break;
            case 10:
                subName = "Galaxy";
                break;
            case 11:
                subName = "Universe";
                break;
            default:
                subName = "OrbCore";
                break;
        }

        return getUnlocalizedName() + "." + subName;
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tabs, List list) {
        for (int i = 0; i < count; i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }
}
