package at.korti.endermystic.api.crafting;

import net.minecraft.item.ItemStack;

/**
 * Created by Korti on 11.04.2015.
 */
public class CrystalCombinerRecipe extends CraftingRecipe{
    public CrystalCombinerRecipe(int timeToCraft, int energyUsePerTick, ItemStack result, ItemStack... requirements){
        super(timeToCraft, energyUsePerTick, result, requirements, 4);
    }
}
