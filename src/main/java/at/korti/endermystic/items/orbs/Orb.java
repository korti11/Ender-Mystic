package at.korti.endermystic.items.orbs;

import at.korti.endermystic.ModInfo;
import at.korti.endermystic.items.EnergyItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

/**
 * Created by Korti on 09.05.2015.
 */
public class Orb extends EnergyItem {

    @SideOnly(Side.CLIENT)
    private IIcon outerIcon;
    @SideOnly(Side.CLIENT)
    private IIcon innerIcon;

    private int color;

    public Orb(String name, int color) {
        super(name);

        this.color = color;
    }

    @Override
    public void registerIcons(IIconRegister register) {
        outerIcon = register.registerIcon(ModInfo.MODID + ":OrbOuter");
        innerIcon = register.registerIcon(ModInfo.MODID + ":OrbCore");
    }

    @Override
    public IIcon getIcon(ItemStack stack, int pass) {
        if(pass == 0){
            return outerIcon;
        }
        else if (pass == 1) {
            return innerIcon;
        }
        else {
            return super.getIcon(stack, pass);
        }
    }

    @Override
    public boolean requiresMultipleRenderPasses() {
        return true;
    }

    @Override
    public int getColorFromItemStack(ItemStack stack, int pass) {
        if (pass == 1) {
            return this.color;
        }
        return super.getColorFromItemStack(stack, pass);
    }
}
