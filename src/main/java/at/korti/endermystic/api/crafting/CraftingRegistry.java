package at.korti.endermystic.api.crafting;

import net.minecraft.item.ItemStack;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Korti on 11.04.2015.
 */
public class CraftingRegistry {

    private static CraftingRegistry instance;
    private List<CrystalCombinerRecipe> crystalCombinerRecipes;
    private List<OrbInfuserRecipe> orbInfuserRecipes;

    private CraftingRegistry() {
        crystalCombinerRecipes = new LinkedList<CrystalCombinerRecipe>();
        orbInfuserRecipes = new LinkedList<OrbInfuserRecipe>();
    }

    public static CraftingRegistry getInstance(){
        if(instance == null){
            instance = new CraftingRegistry();
        }
        return instance;
    }


    //region Crystal Combiner
    public void addCrystalCombinerRecipe(int timeToCraft, int energyUsePerTick, ItemStack result, ItemStack... requirements) {
        crystalCombinerRecipes.add(new CrystalCombinerRecipe(timeToCraft, energyUsePerTick, result, requirements));
    }

    public CrystalCombinerRecipe getCrystalCombinerRecipe(int slot){
        return crystalCombinerRecipes.get(slot);
    }

    public CrystalCombinerRecipe getCrystalCombinerRecipe(ItemStack result){
        for(CrystalCombinerRecipe recipe : crystalCombinerRecipes) {
            if (result.getItem() == recipe.getResult().getItem()) {
                return recipe;
            }
        }

        return null;
    }

    public void deleteCrystalCombinerRecipe(CrystalCombinerRecipe recipe){
        crystalCombinerRecipes.remove(recipe);
    }

    public int recipeCrystalCombinerCount(){
        return crystalCombinerRecipes.size();
    }
    //endregion

    //region Orb Infuser
    public void addOrbInfuserRecipe(int timeToCraft, int energyUsePerTick, ItemStack result, ItemStack... requirements) {
        orbInfuserRecipes.add(new OrbInfuserRecipe(timeToCraft, energyUsePerTick, result, requirements));
    }

    public OrbInfuserRecipe getOrbInfuserRecipe(int slot) {
        return orbInfuserRecipes.get(slot);
    }

    public OrbInfuserRecipe getOrbInfuserRecipe(ItemStack result) {
        for (OrbInfuserRecipe recipe : orbInfuserRecipes) {
            if (result.getItem() == recipe.getResult().getItem()) {
                return recipe;
            }
        }
        return null;
    }

    public void deletOrbInfuserRecipe(OrbInfuserRecipe recipe) {
        orbInfuserRecipes.remove(recipe);
    }

    public int recipeOrbInfuserRecipe() {
        return orbInfuserRecipes.size();
    }
    //endregion
}
