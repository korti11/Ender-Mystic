package at.korti.endermystic.modintegration.ee3;

import at.korti.endermystic.api.crafting.CraftingRecipe;
import at.korti.endermystic.api.crafting.CraftingRegistry;
import com.pahimar.ee3.api.RecipeRegistryProxy;
import net.minecraft.item.ItemStack;

import java.util.Arrays;

/**
 * Created by Korti on 04.09.2015.
 */
public class RecipeEnergyValueLoader {

    public static void loadRecipes() {

    }

    private static void addRecipe(ItemStack output, ItemStack... input) {
        RecipeRegistryProxy.addRecipe(output, Arrays.asList(input));
    }

}
