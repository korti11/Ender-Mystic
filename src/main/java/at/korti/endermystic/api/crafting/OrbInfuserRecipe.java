package at.korti.endermystic.api.crafting;

import net.minecraft.item.ItemStack;

/**
 * Created by Korti on 13.05.2015.
 */
public class OrbInfuserRecipe extends CraftingRecipe{
    public OrbInfuserRecipe(int timeToCraft, int energyUsePerTick, ItemStack result, ItemStack... requirements) {
        super(timeToCraft, energyUsePerTick, result, requirements, 9);
    }
}
