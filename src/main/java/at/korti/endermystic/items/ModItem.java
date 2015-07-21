package at.korti.endermystic.items;

import at.korti.endermystic.EnderMystic;
import at.korti.endermystic.ModInfo;
import at.korti.endermystic.api.crafting.IItemBookCrafting;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

/**
 * Created by Korti on 15.10.2014.
 */
public class ModItem extends Item implements IItemBookCrafting{

    private String name;

    public ModItem(String name) {

        this.name = name;

        this.setCreativeTab(EnderMystic.tab);
        this.setUnlocalizedName(ModInfo.MODID + "." + name);
    }

    public ModItem(String name, int maxStackSize){
        this(name);

        setMaxStackSize(maxStackSize);
    }

    public String getName() {
        return name;
    }

    @Override
    public void registerIcons(IIconRegister register) {
        itemIcon = register.registerIcon(ModInfo.MODID + ":" + name);
    }
}
