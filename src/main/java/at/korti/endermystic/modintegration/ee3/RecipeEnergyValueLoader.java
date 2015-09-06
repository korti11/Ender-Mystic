package at.korti.endermystic.modintegration.ee3;

import at.korti.endermystic.items.ModItems;
import com.pahimar.ee3.api.exchange.RecipeRegistryProxy;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.Arrays;

/**
 * Created by Korti on 04.09.2015.
 */
public class RecipeEnergyValueLoader {

    public static void loadOrbInfuserRecipes() {
        addRecipe(new ItemStack(ModItems.orbCoreItem, 1, 4),
                new ItemStack(ModItems.crystalItem, 1, 1),
                new ItemStack(ModItems.crystalItem, 1, 1),
                new ItemStack(ModItems.crystalItem, 1, 1),
                new ItemStack(ModItems.crystalItem, 1, 1)
        );

        addRecipe(new ItemStack(ModItems.orbCoreItem, 1, 5), //Water Core
                new ItemStack(ModItems.crystalItem, 1, 0),  //Water Crystal
                new ItemStack(ModItems.crystalItem, 1, 0),  //Water Crystal
                new ItemStack(ModItems.crystalItem, 1, 0),  //Water Crystal
                new ItemStack(ModItems.crystalItem, 1, 0)  //Water Crystal
        );

        addRecipe(new ItemStack(ModItems.orbCoreItem, 1, 1), //Earth Core
                new ItemStack(ModItems.crystalItem, 1, 2),  //Earth Crystal
                new ItemStack(ModItems.crystalItem, 1, 2),  //Earth Crystal
                new ItemStack(ModItems.crystalItem, 1, 2),  //Earth Crystal
                new ItemStack(ModItems.crystalItem, 1, 2)  //Earth Crystal
        );
    }

    private static void addRecipe(ItemStack output, ItemStack... input) {
        RecipeRegistryProxy.addRecipe(output, Arrays.asList(input));
    }

}
