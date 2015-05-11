package at.korti.endermystic.crafting;

import at.korti.endermystic.api.crafting.CrystalCombinerRegistry;
import at.korti.endermystic.items.ModItems;
import net.minecraft.item.ItemStack;

/**
 * Created by Korti on 11.04.2015.
 */
public class CrystalCombinerRecipes {

    public static void registerRecipes(){
        CrystalCombinerRegistry registry = CrystalCombinerRegistry.getInstance();

        registry.addRecipe(30, 5, new ItemStack(ModItems.crystalItem, 1, 4),  //Life
                new ItemStack(ModItems.crystalItem, 1, 0),      //Water
                new ItemStack(ModItems.crystalItem, 1, 2));     //Earth

        registry.addRecipe(35, 6, new ItemStack(ModItems.crystalItem, 1, 5),   //Grain
                new ItemStack(ModItems.crystalItem, 1, 0),      //Water
                new ItemStack(ModItems.crystalItem, 1, 2),      //Earth
                new ItemStack(ModItems.crystalItem, 1, 4));     //Life

        registry.addRecipe(35, 6, new ItemStack(ModItems.crystalItem, 1, 6),   //Human
                new ItemStack(ModItems.crystalItem, 1, 0),      //Water
                new ItemStack(ModItems.crystalItem, 1, 4),      //Life
                new ItemStack(ModItems.crystalItem, 1, 5));     //Grain
    }

}
