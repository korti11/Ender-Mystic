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

    public void addCraftingRecipe(ItemStack result, ItemStack... requirements) {
        recipes.add(new CraftingRecipe(0, 0, result, requirements, requirements.length));
    }

    public void addCrystalCombinerRecipe(int timeToCraft, int energyUsePerTick, ItemStack result, ItemStack... requirements) {
        recipes.add(new CrystalCombinerRecipe(timeToCraft, energyUsePerTick, result, requirements));
    }

    public CrystalCombinerRecipe getCrystalCombinerRecipe(int slot){
        CraftingRecipe recipe = recipes.get(slot);
        if (recipe instanceof CrystalCombinerRecipe) {
            return (CrystalCombinerRecipe) recipe;
        }
        return null;
    }

    public void addOrbInfuserRecipe(int timeToCraft, int energyUsePerTick, ItemStack result, ItemStack... requirements) {
        recipes.add(new OrbInfuserRecipe(timeToCraft, energyUsePerTick, result, requirements));
    }

    public OrbInfuserRecipe getOrbInfuserRecipe(int slot) {
        CraftingRecipe recipe = recipes.get(slot);
        if (recipe instanceof OrbInfuserRecipe) {
            return (OrbInfuserRecipe) recipe;
        }
        return null;
    }

    public CraftingRecipe getCraftingRecipe(ItemStack stack) {
        for (CraftingRecipe recipe : recipes) {
            if (recipe.getResult().getItem() == stack.getItem() && recipe.getResult().getItemDamage() == stack.getItemDamage()) {
                return recipe;
            }
        }
        return null;
    }

    public int recipeCount() {
        return recipes.size();
    }

}
