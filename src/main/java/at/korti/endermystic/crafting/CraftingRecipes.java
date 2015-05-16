package at.korti.endermystic.crafting;

import at.korti.endermystic.api.crafting.CraftingRegistry;
import at.korti.endermystic.items.ModItem;
import at.korti.endermystic.items.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by Korti on 11.04.2015.
 */
public class CraftingRecipes {

    public static void registerCrystalCombinerRecipes(){
        CraftingRegistry registry = CraftingRegistry.getInstance();

        registry.addCrystalCombinerRecipe(30, 5, new ItemStack(ModItems.crystalItem, 1, 4),  //Life
                new ItemStack(ModItems.crystalItem, 1, 0),      //Water
                new ItemStack(ModItems.crystalItem, 1, 2));     //Earth

        registry.addCrystalCombinerRecipe(35, 6, new ItemStack(ModItems.crystalItem, 1, 5),   //Grain
                new ItemStack(ModItems.crystalItem, 1, 0),      //Water
                new ItemStack(ModItems.crystalItem, 1, 2),      //Earth
                new ItemStack(ModItems.crystalItem, 1, 4));     //Life

        registry.addCrystalCombinerRecipe(35, 6, new ItemStack(ModItems.crystalItem, 1, 6),   //Human
                new ItemStack(ModItems.crystalItem, 1, 0),      //Water
                new ItemStack(ModItems.crystalItem, 1, 4),      //Life
                new ItemStack(ModItems.crystalItem, 1, 5));     //Grain
    }

    public static void registerOrbInfuserRecipes(){
        CraftingRegistry registry = CraftingRegistry.getInstance();

        registry.addOrbInfuserRecipe(30, 5, new ItemStack(ModItems.orbCoreItem, 1, 4), //Fire Core
                new ItemStack(ModItems.crystalItem, 1, 1),  //Fire Crystal
                new ItemStack(ModItems.crystalItem, 1, 1),  //Fire Crystal
                new ItemStack(ModItems.crystalItem, 1, 1),  //Fire Crystal
                new ItemStack(ModItems.crystalItem, 1, 1),  //Fire Crystal
                new ItemStack(Items.ender_pearl)
        );

        registry.addOrbInfuserRecipe(30, 5, new ItemStack(ModItems.orbCoreItem, 1, 5), //Water Core
                new ItemStack(ModItems.crystalItem, 1, 0),  //Water Crystal
                new ItemStack(ModItems.crystalItem, 1, 0),  //Water Crystal
                new ItemStack(ModItems.crystalItem, 1, 0),  //Water Crystal
                new ItemStack(ModItems.crystalItem, 1, 0),  //Water Crystal
                new ItemStack(Items.ender_pearl)
        );

        registry.addOrbInfuserRecipe(30, 5, new ItemStack(ModItems.orbCoreItem, 1, 1), //Earth Core
                new ItemStack(ModItems.crystalItem, 1, 2),  //Earth Crystal
                new ItemStack(ModItems.crystalItem, 1, 2),  //Earth Crystal
                new ItemStack(ModItems.crystalItem, 1, 2),  //Earth Crystal
                new ItemStack(ModItems.crystalItem, 1, 2),  //Earth Crystal
                new ItemStack(Items.ender_pearl)
        );

        registry.addOrbInfuserRecipe(30, 5, new ItemStack(ModItems.orbCoreItem, 1, 0), //Air Core
                new ItemStack(ModItems.crystalItem, 1, 3),  //Air Crystal
                new ItemStack(ModItems.crystalItem, 1, 3),  //Air Crystal
                new ItemStack(ModItems.crystalItem, 1, 3),  //Air Crystal
                new ItemStack(ModItems.crystalItem, 1, 3),  //Air Crystal
                new ItemStack(Items.ender_pearl)
        );
    }

    public static void registerVanillaRecipes(){
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.orbCoreItem, 1, 6), new ItemStack(ModItems.enderSoulFill, 1, 1), new ItemStack(Items.ender_pearl));

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.airOrb),
                " G ",
                "GCG",
                " G ", 'G', new ItemStack(Items.gold_ingot), 'C', new ItemStack(ModItems.orbCoreItem, 1, 0)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.earthOrb),
                " G ",
                "GCG",
                " G ", 'G', new ItemStack(Items.gold_ingot), 'C', new ItemStack(ModItems.orbCoreItem, 1, 1)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.emeraldOrb),
                " G ",
                "GCG",
                " G ", 'G', new ItemStack(Items.gold_ingot), 'C', new ItemStack(ModItems.orbCoreItem, 1, 2)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.enderZarOrb, 1, ModItems.enderZarOrb.getMaxDamage() - 1),
                " G ",
                "GCG",
                " G ", 'G', new ItemStack(Items.gold_ingot), 'C', new ItemStack(ModItems.orbCoreItem, 1, 3)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.fireOrb),
                " G ",
                "GCG",
                " G ", 'G', new ItemStack(Items.gold_ingot), 'C', new ItemStack(ModItems.orbCoreItem, 1, 4)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.waterOrb),
                " G ",
                "GCG",
                " G ", 'G', new ItemStack(Items.gold_ingot), 'C', new ItemStack(ModItems.orbCoreItem, 1, 5)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.enderOrb),
                " G ",
                "GCG",
                " G ", 'G', new ItemStack(Items.gold_ingot), 'C', new ItemStack(ModItems.orbCoreItem, 1, 6)
        );
    }

}
