package at.korti.endermystic.crafting;

import at.korti.endermystic.api.crafting.CraftingRegistry;
import at.korti.endermystic.api.crafting.IItemBookCrafting;
import at.korti.endermystic.blocks.ModBlocks;
import at.korti.endermystic.items.ModItems;
import at.korti.endermystic.modintegration.ModIntegrationManager;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Korti on 11.04.2015.
 */
public class CraftingManager {

    private static List<IRecipe> loadedRecipes = new ArrayList<>();

    public static void registerCrystalCombinerRecipes(){
        CraftingRegistry registry = CraftingRegistry.getInstance();

        registry.registerCrystalCombinerRecipe(30, 50, new ItemStack(ModItems.crystalItem, 1, 4),  //Life
                new ItemStack(ModItems.crystalItem, 1, 0),      //Water
                new ItemStack(ModItems.crystalItem, 1, 2)       //Earth
        );

        registry.registerCrystalCombinerRecipe(35, 60, new ItemStack(ModItems.crystalItem, 1, 5),   //Grain
                new ItemStack(ModItems.crystalItem, 1, 0),      //Water
                new ItemStack(ModItems.crystalItem, 1, 2),      //Earth
                new ItemStack(ModItems.crystalItem, 1, 4)       //Life
        );

        registry.registerCrystalCombinerRecipe(35, 60, new ItemStack(ModItems.crystalItem, 1, 6),   //Human
                new ItemStack(ModItems.crystalItem, 1, 0),      //Water
                new ItemStack(ModItems.crystalItem, 1, 4),      //Life
                new ItemStack(ModItems.crystalItem, 1, 5)       //Grain
        );

        registry.registerCrystalCombinerRecipe(20, 40, new ItemStack(ModItems.crystalItem, 1, 9),
                new ItemStack(ModItems.crystalItem, 1, 0),
                new ItemStack(ModItems.crystalItem, 1, 1),
                new ItemStack(ModItems.crystalItem, 1, 2)
        );

        registry.registerCrystalCombinerRecipe(25, 40, new ItemStack(ModItems.crystalItem, 1, 10),
                new ItemStack(ModItems.crystalItem, 1, 9),
                new ItemStack(ModItems.crystalItem, 1, 1)
        );

        registry.registerCrystalCombinerRecipe(30, 50, new ItemStack(ModItems.crystalItem, 1, 8),
                new ItemStack(ModItems.crystalItem, 1, 10),
                new ItemStack(ModItems.crystalItem, 1, 6),
                new ItemStack(ModItems.crystalItem, 1, 1)
        );

        registry.registerCrystalCombinerRecipe(20, 50, new ItemStack(ModItems.crystalItem, 1, 12),
                new ItemStack(ModItems.crystalItem, 1, 1),
                new ItemStack(ModItems.crystalItem, 1, 3)
        );

        registry.registerCrystalCombinerRecipe(30, 60, new ItemStack(ModItems.crystalItem, 1, 11),
                new ItemStack(ModItems.crystalItem, 1, 0),
                new ItemStack(ModItems.crystalItem, 1, 1),
                new ItemStack(ModItems.crystalItem, 1, 2),
                new ItemStack(ModItems.crystalItem, 1, 3)
        );

        registry.registerCrystalCombinerRecipe(35, 60, new ItemStack(ModItems.crystalItem, 1, 13),
                new ItemStack(ModItems.crystalItem, 1, 12),
                new ItemStack(ModItems.crystalItem, 1, 11)
        );

        registry.registerCrystalCombinerRecipe(25, 30, new ItemStack(ModItems.crystalItem, 1, 14),
                new ItemStack(ModItems.crystalItem, 1, 11),
                new ItemStack(Items.emerald)
        );

        registry.registerCrystalCombinerRecipe(60, 10, new ItemStack(ModItems.enderItem, 1, 1),
                new ItemStack(ModItems.enderItem, 1, 0),
                new ItemStack(Items.iron_ingot)
        );
    }

    public static void registerOrbInfuserRecipes(){
        CraftingRegistry registry = CraftingRegistry.getInstance();

        registry.registerOrbInfuserRecipe(30, 50, new ItemStack(ModItems.orbCoreItem, 1, 4), //Fire Core
                new ItemStack(ModItems.crystalItem, 1, 1),  //Fire Crystal
                new ItemStack(ModItems.crystalItem, 1, 1),  //Fire Crystal
                new ItemStack(ModItems.crystalItem, 1, 1),  //Fire Crystal
                new ItemStack(ModItems.crystalItem, 1, 1),  //Fire Crystal
                new ItemStack(Items.ender_pearl)
        );

        registry.registerOrbInfuserRecipe(30, 50, new ItemStack(ModItems.orbCoreItem, 1, 5), //Water Core
                new ItemStack(ModItems.crystalItem, 1, 0),  //Water Crystal
                new ItemStack(ModItems.crystalItem, 1, 0),  //Water Crystal
                new ItemStack(ModItems.crystalItem, 1, 0),  //Water Crystal
                new ItemStack(ModItems.crystalItem, 1, 0),  //Water Crystal
                new ItemStack(Items.ender_pearl)
        );

        registry.registerOrbInfuserRecipe(30, 50, new ItemStack(ModItems.orbCoreItem, 1, 1), //Earth Core
                new ItemStack(ModItems.crystalItem, 1, 2),  //Earth Crystal
                new ItemStack(ModItems.crystalItem, 1, 2),  //Earth Crystal
                new ItemStack(ModItems.crystalItem, 1, 2),  //Earth Crystal
                new ItemStack(ModItems.crystalItem, 1, 2),  //Earth Crystal
                new ItemStack(Items.ender_pearl)
        );

        registry.registerOrbInfuserRecipe(30, 50, new ItemStack(ModItems.orbCoreItem, 1, 0), //Air Core
                new ItemStack(ModItems.crystalItem, 1, 3),  //Air Crystal
                new ItemStack(ModItems.crystalItem, 1, 3),  //Air Crystal
                new ItemStack(ModItems.crystalItem, 1, 3),  //Air Crystal
                new ItemStack(ModItems.crystalItem, 1, 3),  //Air Crystal
                new ItemStack(Items.ender_pearl)
        );

        registry.registerOrbInfuserRecipe(40, 250, new ItemStack(ModItems.orbCoreItem, 1, 7),
                new ItemStack(ModItems.crystalItem, 1, 0),
                new ItemStack(ModItems.crystalItem, 1, 1),
                new ItemStack(ModItems.crystalItem, 1, 2),
                new ItemStack(ModItems.crystalItem, 1, 3),
                new ItemStack(Items.ender_pearl)
        );

        registry.registerOrbInfuserRecipe(60, 416, new ItemStack(ModItems.orbCoreItem, 1, 8),
                new ItemStack(ModItems.crystalItem, 1, 8),
                new ItemStack(ModItems.crystalItem, 1, 8),
                new ItemStack(ModItems.crystalItem, 1, 8),
                new ItemStack(ModItems.crystalItem, 1, 8),
                new ItemStack(ModItems.crystalItem, 1, 8),
                new ItemStack(ModItems.crystalItem, 1, 8),
                new ItemStack(ModItems.crystalItem, 1, 8),
                new ItemStack(ModItems.crystalItem, 1, 8),
                new ItemStack(Items.ender_pearl)
        );

        registry.registerOrbInfuserRecipe(80, 500, new ItemStack(ModItems.orbCoreItem, 1, 9),
                new ItemStack(ModItems.crystalItem, 1, 0),
                new ItemStack(ModItems.crystalItem, 1, 1),
                new ItemStack(ModItems.crystalItem, 1, 2),
                new ItemStack(ModItems.crystalItem, 1, 3),
                new ItemStack(ModItems.crystalItem, 1, 0),
                new ItemStack(ModItems.crystalItem, 1, 1),
                new ItemStack(ModItems.crystalItem, 1, 2),
                new ItemStack(ModItems.crystalItem, 1, 3),
                new ItemStack(Items.ender_pearl)
        );

        registry.registerOrbInfuserRecipe(90, 611, new ItemStack(ModItems.orbCoreItem, 1, 10),
                new ItemStack(ModItems.crystalItem, 1, 13),
                new ItemStack(ModItems.crystalItem, 1, 13),
                new ItemStack(ModItems.crystalItem, 1, 0),
                new ItemStack(ModItems.crystalItem, 1, 1),
                new ItemStack(ModItems.crystalItem, 1, 2),
                new ItemStack(ModItems.crystalItem, 1, 3),
                new ItemStack(Items.ender_pearl)
        );

        registry.registerOrbInfuserRecipe(100, 700, new ItemStack(ModItems.orbCoreItem, 1, 11),
                new ItemStack(ModItems.crystalItem, 1, 13),
                new ItemStack(ModItems.crystalItem, 1, 13),
                new ItemStack(ModItems.crystalItem, 1, 13),
                new ItemStack(ModItems.crystalItem, 1, 13),
                new ItemStack(ModItems.crystalItem, 1, 0),
                new ItemStack(ModItems.crystalItem, 1, 1),
                new ItemStack(ModItems.crystalItem, 1, 2),
                new ItemStack(ModItems.crystalItem, 1, 3),
                new ItemStack(Items.ender_pearl)
        );

        registry.registerOrbInfuserRecipe(50, 40, new ItemStack(ModItems.orbCoreItem, 1, 2),
                new ItemStack(ModItems.crystalItem, 1, 14),
                new ItemStack(ModItems.crystalItem, 1, 14),
                new ItemStack(ModItems.crystalItem, 1, 11),
                new ItemStack(ModItems.crystalItem, 1, 11),
                new ItemStack(Items.ender_pearl)
        );

        registry.registerOrbInfuserRecipe(60, 80, new ItemStack(ModItems.orbCoreItem, 1, 3),
                new ItemStack(ModItems.crystalItem, 1, 11),
                new ItemStack(ModItems.crystalItem, 1, 10),
                new ItemStack(ModItems.crystalItem, 1, 13),
                new ItemStack(ModItems.crystalItem, 1, 7),
                new ItemStack(ModItems.crystalItem, 1, 1),
                new ItemStack(ModItems.crystalItem, 1, 2),
                new ItemStack(Items.ender_pearl)
        );
    }

    public static void registerVanillaRecipes(){
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.orbCoreItem, 1, 6), new ItemStack(ModItems.enderSoulFill, 1, 1), new ItemStack(Items.ender_pearl));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.enderSoulFill, 4, 0), new ItemStack(ModItems.enderSacrifice), new ItemStack(Items.glass_bottle));
        for(int i = 0; i < 4; i++) {
            GameRegistry.addShapelessRecipe(new ItemStack(ModItems.enderItem), new ItemStack(ModItems.enderSoulFill, 1, 1), new ItemStack(ModItems.crystalItem, 1, i));
        }
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.bookItem), new ItemStack(ModItems.enderSoulFill, 1, 1) , new ItemStack(Items.book));

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
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.apprenticeOrb),
                " G ",
                "GCG",
                " G ", 'G', new ItemStack(Items.gold_ingot), 'C', new ItemStack(ModItems.orbCoreItem, 1, 7)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.guardiansOrb),
                " G ",
                "GCG",
                " G ", 'G', new ItemStack(Items.gold_ingot), 'C', new ItemStack(ModItems.orbCoreItem, 1, 8)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.masterOrb),
                " G ",
                "GCG",
                " G ", 'G', new ItemStack(Items.gold_ingot), 'C', new ItemStack(ModItems.orbCoreItem, 1, 9)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.galaxyOrb),
                " G ",
                "GCG",
                " G ", 'G', new ItemStack(Items.gold_ingot), 'C', new ItemStack(ModItems.orbCoreItem, 1, 10)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.universeOrb),
                " G ",
                "GCG",
                " G ", 'G', new ItemStack(Items.gold_ingot), 'C', new ItemStack(ModItems.orbCoreItem, 1, 11)
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
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.enderSoulHelmet),
                "III",
                "I I", 'I', new ItemStack(ModItems.enderItem, 0, 1)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.enderSoulBreastplate),
                "I I",
                "III",
                "III",'I', new ItemStack(ModItems.enderItem, 0, 1)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.enderSoulLegs),
                "III",
                "I I",
                "I I", 'I', new ItemStack(ModItems.enderItem, 0, 1)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.worldStorageLevelOne),
                " P ",
                "PEP",
                " P ", 'P', new ItemStack(Items.paper), 'E', new ItemStack(Items.ender_pearl)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.worldStorageLevelTwo),
                " P ",
                "PWP",
                " P ", 'P', new ItemStack(Items.paper), 'W', new ItemStack(ModItems.worldStorageLevelOne)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.worldStorageLevelThree),
                " P ",
                "PWP",
                " P ", 'P', new ItemStack(Items.paper), 'W', new ItemStack(ModItems.worldStorageLevelTwo)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.worldStorageLevelFour),
                " P ",
                "PWP",
                " P ", 'P', new ItemStack(Items.paper), 'W', new ItemStack(ModItems.worldStorageLevelThree)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.orbCoreItem, 1, 12),
                " W ",
                "FPE",
                " A ", 'W', new ItemStack(ModItems.crystalItem, 1, 0), 'F', new ItemStack(ModItems.crystalItem, 1, 1), 'P', new ItemStack(Items.ender_pearl), 'E', new ItemStack(ModItems.crystalItem, 1, 2), 'A', new ItemStack(ModItems.crystalItem, 1, 3)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.activationOrb),
                " G ",
                "GCG",
                " G ", 'G', new ItemStack(Items.gold_ingot), 'C', new ItemStack(ModItems.orbCoreItem, 1, 12)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.thunderWand),
                "IEI",
                "IEI",
                " S ", 'I', new ItemStack(ModItems.enderItem, 0, 1), 'E', new ItemStack(ModItems.crystalItem, 1, 7), 'S', new ItemStack(ModItems.enderItem, 1, 2)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.teleportWand),
                "ESE",
                " R ",
                " R ", 'E', new ItemStack(Items.ender_pearl), 'S', new ItemStack(ModItems.crystalItem, 1, 7), 'R', new ItemStack(ModItems.enderItem, 1, 2)
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
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.energyCrystalStorage),
                "HHH",
                "AEA",
                "HHH", 'H', new ItemStack(Blocks.hardened_clay), 'A', new ItemStack(ModItems.apprenticeOrb), 'E', new ItemStack(ModItems.crystalItem, 1, 7)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.enderPicker),
                "HSH",
                "QEQ",
                "HPH", 'H', new ItemStack(Blocks.hardened_clay), 'S', new ItemStack(Blocks.sticky_piston), 'E', new ItemStack(ModItems.crystalItem, 1, 7), 'Q', new ItemStack(Blocks.quartz_block), 'P', new ItemStack(Items.ender_pearl)
        );
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.enderInjector),
                "HSH",
                "QEQ",
                "HPH", 'H', new ItemStack(Blocks.hardened_clay), 'S', new ItemStack(Blocks.piston), 'E', new ItemStack(ModItems.crystalItem, 1, 7), 'Q', new ItemStack(Blocks.quartz_block), 'P', new ItemStack(Items.ender_pearl)
        );
    }

    public static void registerBookRecipes() {
        CraftingRegistry.getInstance().registerCraftingRecipe(new ItemStack(ModItems.crystalItem, 1, 0), new ItemStack(ModBlocks.crystalOre, 1, 0), new ItemStack(Items.iron_pickaxe));
        CraftingRegistry.getInstance().registerCraftingRecipe(new ItemStack(ModItems.crystalItem, 1, 1), new ItemStack(ModBlocks.crystalOre, 1, 1), new ItemStack(Items.iron_pickaxe));
        CraftingRegistry.getInstance().registerCraftingRecipe(new ItemStack(ModItems.crystalItem, 1, 2), new ItemStack(ModBlocks.crystalOre, 1, 2), new ItemStack(Items.iron_pickaxe));
        CraftingRegistry.getInstance().registerCraftingRecipe(new ItemStack(ModItems.crystalItem, 1, 3), new ItemStack(ModBlocks.crystalOre, 1, 3), new ItemStack(Items.iron_pickaxe));
    }

    public static void registerIntegrationRecipes() {
        ModIntegrationManager.constructCraftingRecipes();
    }

    public static void loadRecipes() {
        List recipes = net.minecraft.item.crafting.CraftingManager.getInstance().getRecipeList();
        for (int i = 0; i < recipes.size(); i++) {
            IRecipe iRecipe = (IRecipe) recipes.get(i);
            if(iRecipe != null && iRecipe.getRecipeOutput() != null && (iRecipe.getRecipeOutput().getItem() instanceof IItemBookCrafting || Block.getBlockFromItem(iRecipe.getRecipeOutput().getItem()) instanceof IItemBookCrafting)) {
                loadedRecipes.add(iRecipe);
            }
        }
    }

    public static IRecipe findRecipeFor(ItemStack item) {
        for (int i = 0; i < loadedRecipes.size(); i++) {
            IRecipe iRecipe = loadedRecipes.get(i);
            if (iRecipe.getRecipeOutput().getItem() == item.getItem() && iRecipe.getRecipeOutput().getItemDamage() == item.getItemDamage()) {
                return iRecipe;
            }
        }
        return null;
    }

}
