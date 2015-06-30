package at.korti.endermystic.items.orbs;

import at.korti.endermystic.items.EnergyItem;
import net.minecraft.item.ItemStack;

/**
 * Created by Korti on 09.05.2015.
 */
public class Orb extends EnergyItem {

    private int color;

    public Orb(String name, int color) {
        super(name);

        this.color = color;
    }

    @Override
    public int getColorFromItemStack(ItemStack stack, int pass) {
        if (pass == 1) {
            return this.color;
        }
        return super.getColorFromItemStack(stack, pass);
    }
}
