package at.korti.endermystic.api.crafting;

import net.minecraft.item.ItemStack;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Korti on 11.04.2015.
 */
public class CrystalCombinerRegistry {

    private static CrystalCombinerRegistry instance;
    private List<CrystalCombinerRecipe> recipes;

    private CrystalCombinerRegistry() {
        recipes = new LinkedList<CrystalCombinerRecipe>();
    }

    public static CrystalCombinerRegistry getInstance(){
        if(instance == null){
            instance = new CrystalCombinerRegistry();
        }

        return instance;
    }

    public void addRecipe(int timeToCraft, int energyUsePerTick, ItemStack result, ItemStack... requirements) {
        recipes.add(new CrystalCombinerRecipe(timeToCraft, energyUsePerTick, result, requirements));
    }

    public CrystalCombinerRecipe getRecipe(int slot){
        return recipes.get(slot);
    }

    public CrystalCombinerRecipe getRecipe(ItemStack result){
        for(CrystalCombinerRecipe recipe:recipes) {
            if (result.getItem() == recipe.getResult().getItem()) {
                return recipe;
            }
        }

        return null;
    }

    public void deleteRecipe(CrystalCombinerRecipe recipe){
        recipes.remove(recipe);
    }

    public int recipeCount(){
        return recipes.size();
    }
}
