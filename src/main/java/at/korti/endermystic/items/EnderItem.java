package at.korti.endermystic.items;

import at.korti.endermystic.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

/**
 * Created by Korti on 17.05.2015.
 */
public class EnderItem extends ModItem{

    private final int itemCount = 3;
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public EnderItem() {
        super("EnderItem");

        setHasSubtypes(true);
        icons = new IIcon[itemCount];
    }

    @Override
    public void registerIcons(IIconRegister register) {
        icons[0] = register.registerIcon(ModInfo.MODID + ":EnderShard");
        icons[1] = register.registerIcon(ModInfo.MODID + ":EnderIngot");
        icons[2] = register.registerIcon(ModInfo.MODID + ":EnderRod");
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        String subName;
        switch (stack.getItemDamage()) {
            case 0:
                subName = "EnderShard";
                break;
            case 1:
                subName = "EnderIngot";
                break;
            case 2:
                subName = "EnderRod";
                break;
            default:
                subName = "EnderItem";
        }
        return super.getUnlocalizedName(stack) + "." + subName;
    }

    @Override
    public IIcon getIconFromDamage(int meta) {
        return icons[meta];
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tabs, List list) {
        for (int i = 0; i < itemCount; i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }
}
