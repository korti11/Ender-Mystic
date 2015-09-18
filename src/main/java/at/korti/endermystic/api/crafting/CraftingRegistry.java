package at.korti.endermystic.api.crafting;

import net.minecraft.item.ItemStack;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Korti on 11.04.2015.
 */
public class CraftingRegistry {

    private static CraftingRegistry instance;
    private List<CraftingRecipe> recipes;

    private CraftingRegistry() {
        recipes = new LinkedList<>();
    }

    public static CraftingRegistry getInstance(){
        if(instance == null){
            instance = new CraftingRegistry();
        }
        return instance;
    }

    /**
     * Register a simple crafting recipe to show it in the book.
     * @param result
     * @param requirements
     */
    public void registerCraftingRecipe(ItemStack result, ItemStack... requirements) {
        recipes.add(new CraftingRecipe(0, 0, result, requirements, requirements.length));
    }

    /**
     * Register a crystal combiner crafting recipe.
     * The max amount of requirements is 4.
     * At the time the crystal combiner can't handle more then one item each.
     * @param timeToCraft
     * @param energyUsePerTick
     * @param result
     * @param requirements
     */
    public void registerCrystalCombinerRecipe(int timeToCraft, int energyUsePerTick, ItemStack result, ItemStack... requirements) {
        recipes.add(new CrystalCombinerRecipe(timeToCraft, energyUsePerTick, result, requirements));
    }

    /**
     * Get the crystal combiner recipe at the list position pos.
     * If the recipe at the list position pos, isn't a crystal combiner recipe,
     * then the return value is null.
     * @param pos
     * @return Crystal combiner recipe at the list position pos or null.
     */
    public CrystalCombinerRecipe getCrystalCombinerRecipe(int pos){
        CraftingRecipe recipe = recipes.get(pos);
        if (recipe instanceof CrystalCombinerRecipe) {
            return (CrystalCombinerRecipe) recipe;
        }
        return null;
    }

    /**
     * Get the crystal combiner recipe of the result stack.
     * If the result stack item has no crystal combiner recipe,
     * then the return value is null.
     * @param resultStack
     * @return Crystal combiner recipe of the result stack.
     */
    public CrystalCombinerRecipe getCrystalCombinerRecipe(ItemStack resultStack) {
        CraftingRecipe recipe = getCraftingRecipe(resultStack);
        return recipe instanceof CrystalCombinerRecipe ? (CrystalCombinerRecipe) recipe : null;
    }

    /**
     * Register a orb infuser crafting recipe.
     * The max amount of requirements is 8.
     * This machine can handle more then one of each item.
     * @param timeToCraft
     * @param energyUsePerTick
     * @param result
     * @param requirements
     */
    public void registerOrbInfuserRecipe(int timeToCraft, int energyUsePerTick, ItemStack result, ItemStack... requirements) {
        recipes.add(new OrbInfuserRecipe(timeToCraft, energyUsePerTick, result, requirements));
    }

    /**
     * Get the orb infuser recipe at the list position pos.
     * If the recipe at the list position pos, isn't a orb infuser recipe,
     * then the return value is null.
     * @param pos
     * @return Orb infuser recipe at the list position pos or null.
     */
    public OrbInfuserRecipe getOrbInfuserRecipe(int pos) {
        CraftingRecipe recipe = recipes.get(pos);
        if (recipe instanceof OrbInfuserRecipe) {
            return (OrbInfuserRecipe) recipe;
        }
        return null;
    }

    /**
     * Get the orb infuser recipe of the result stack.
     * If the stack has no orb infuser recipe, then the return value is null.
     * @param resultStack
     * @return Orb infuser recipe of the recipe result stack or null.
     */
    public OrbInfuserRecipe getOrbInfuserRecipe(ItemStack resultStack) {
        CraftingRecipe recipe = getCraftingRecipe(resultStack);
        return recipe instanceof OrbInfuserRecipe ? (OrbInfuserRecipe) recipe : null;
    }

    /**
     * Get the simple crafting recipe of the result stack.
     * @param resultStack
     * @return Simple crafting recipe of the result stack.
     */
    public CraftingRecipe getCraftingRecipe(ItemStack resultStack) {
        for (CraftingRecipe recipe : recipes) {
            if (recipe.getResult().getItem() == resultStack.getItem() && recipe.getResult().getItemDamage() == resultStack.getItemDamage()) {
                return recipe;
            }
        }
        return null;
    }

    /**
     * Get the simple crafting recipe of the index.
     * @param index
     * @return Simple crafting recipe of the index.
     */
    public CraftingRecipe getCraftingRecipe(int index) {
        return recipes.get(index);
    }

    /**
     * Get all recipes with the item in the requirements.
     * @param requirement
     * @return Recipes with the item in the requirements.
     */
    public List<CraftingRecipe> getCraftingRecipes(ItemStack requirement) {
        List<CraftingRecipe> temp = new LinkedList<>();
        for (CraftingRecipe recipe : recipes) {
            if (recipe.containsRequirement(requirement)) {
                temp.add(recipe);
            }
        }
        return temp;
    }

    /**
     * Get the amount of all recipes.
     * @return Amount of all recipes.
     */
    public int recipeCount() {
        return recipes.size();
    }

}
