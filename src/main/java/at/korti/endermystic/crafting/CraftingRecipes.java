package at.korti.endermystic.crafting;

import at.korti.endermystic.api.crafting.CraftingRegistry;
import at.korti.endermystic.blocks.ModBlocks;
import at.korti.endermystic.items.ModItem;
import at.korti.endermystic.items.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Korti on 11.04.2015.
 */
public class CraftingRecipes {

    public static void registerCrystalCombinerRecipes(){
        CraftingRegistry registry = CraftingRegistry.getInstance();

        registry.addCrystalCombinerRecipe(30, 5, new ItemStack(ModItems.crystalItem, 1, 4),  //Life
                new ItemStack(ModItems.crystalItem, 1, 0),      //Water
                new ItemStack(ModItems.crystalItem, 1, 2)       //Earth
        );

        registry.addCrystalCombinerRecipe(35, 6, new ItemStack(ModItems.crystalItem, 1, 5),   //Grain
                new ItemStack(ModItems.crystalItem, 1, 0),      //Water
                new ItemStack(ModItems.crystalItem, 1, 2),      //Earth
                new ItemStack(ModItems.crystalItem, 1, 4)       //Life
        );

        registry.addCrystalCombinerRecipe(35, 6, new ItemStack(ModItems.crystalItem, 1, 6),   //Human
                new ItemStack(ModItems.crystalItem, 1, 0),      //Water
                new ItemStack(ModItems.crystalItem, 1, 4),      //Life
                new ItemStack(ModItems.crystalItem, 1, 5)       //Grain
        );

        registry.addCrystalCombinerRecipe(60, 10, new ItemStack(ModItems.enderItem, 1, 1),
                new ItemStack(ModItems.enderItem, 1, 0),
                new ItemStack(Items.iron_ingot)
        );
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
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.enderSoulFill, 4, 0), new ItemStack(ModItems.enderSacrifice), new ItemStack(Items.glass_bottle));
        for(int i = 0; i < 4; i++) {
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.enderItem), new ItemStack(ModItems.enderSoulFill, 1, 1), new ItemStack(ModItems.crystalItem, 1, i));
        }

        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.energyRelay), new ItemStack(ModItems.crystalItem, 1, 7), new ItemStack(Blocks.obsidian));

        //Items
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
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.enderItem, 1, 2),
                "  S",
                " C ",
                "S  ", 'S', new ItemStack(ModItems.enderItem, 1, 0), 'C', new ItemStack(ModItems.crystalItem, 1, 7)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.enderSoulSword),
                "I",
                "I",
                "R", 'I', new ItemStack(ModItems.enderItem, 1, 1), 'R', new ItemStack(ModItems.enderItem, 1, 2)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.enderSoulPickaxe),
                "III",
                " R ",
                " R ", 'I', new ItemStack(ModItems.enderItem, 1, 1), 'R', new ItemStack(ModItems.enderItem, 1, 2)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.enderSoulShovel),
                "I",
                "R",
                "R", 'I', new ItemStack(ModItems.enderItem, 1, 1), 'R', new ItemStack(ModItems.enderItem, 1, 2)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.enderSoulHammer),
                "III",
                "III",
                " R ", 'I', new ItemStack(ModItems.enderItem, 1, 1), 'R', new ItemStack(ModItems.enderItem, 1, 2)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.enderSoulExcavator),
                "I I",
                "III",
                " R ", 'I', new ItemStack(ModItems.enderItem, 1, 1), 'R', new ItemStack(ModItems.enderItem, 1, 2)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.crystalItem, 1, 7),
                " F ",
                "ASE",
                " W ", 'F', new ItemStack(ModItems.crystalItem, 1, 1), 'A', new ItemStack(ModItems.crystalItem, 1, 3), 'S', new ItemStack(ModItems.enderSoulFill, 1, 1), 'E', new ItemStack(ModItems.crystalItem, 1, 2), 'W', new ItemStack(ModItems.crystalItem, 1, 0)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.enderSacrifice),
                "I",
                "S", 'I', new ItemStack(Items.iron_ingot), 'S', new ItemStack(Items.stick)
        );

        //Blocks
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.crystalCombiner),
                "GSG",
                " C ",
                "SWS", 'G', new ItemStack(Blocks.glass), 'S', new ItemStack(Blocks.stone_slab, 1, 3), 'C', new ItemStack(ModItems.crystalItem, 1, 7), 'W', new ItemStack(Blocks.cobblestone_wall)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.energyDrain),
                " S ",
                " E ",
                "CHC", 'S', new ItemStack(Blocks.stone_slab, 1, 4), 'E', new ItemStack(ModItems.crystalItem, 1, 7), 'H', new ItemStack(Blocks.hardened_clay), 'C', new ItemStack(Blocks.stone_slab, 1, 3)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.orbInfuser),
                " E ",
                "HCH",
                "HHH", 'E', new ItemStack(Items.ender_eye), 'H', new ItemStack(Blocks.hardened_clay), 'C', new ItemStack(ModItems.crystalItem, 1, 7)
        );
    }

}
