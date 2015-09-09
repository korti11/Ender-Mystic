package at.korti.endermystic.modintegration.ee3;

import at.korti.endermystic.api.crafting.CraftingRecipe;
import at.korti.endermystic.api.crafting.CraftingRegistry;
import at.korti.endermystic.items.ModItems;
import at.korti.endermystic.modintegration.IIntegration;
import com.pahimar.ee3.api.EnergyValueRegistryProxy;
import com.pahimar.ee3.api.RecipeRegistryProxy;
import net.minecraft.item.ItemStack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Korti on 04.09.2015.
 */
public class EquivalentExchange implements IIntegration {

    public static float getEMCValue(ItemStack stack) {
        return EnergyValueRegistryProxy.getEnergyValueForStack(stack).getValue();
    }

    @Override
    public void preInit() {
        for (int i = 0; i < 4; i++) {
            EnergyValueRegistryProxy.addPreAssignedEnergyValue(new ItemStack(ModItems.crystalItem, 1, i), 100F);
        }

    }

    @Override
    public void init() {

    }

    @Override
    public void posInit() {
        CraftingRegistry registry = CraftingRegistry.getInstance();
        List<ItemStack> stacks = new LinkedList<>();
        for (int i = 0; i < registry.recipeCount(); i++) {
            CraftingRecipe recipe = registry.getCraftingRecipe(i);
            for (ItemStack stack : recipe.getRequirements()) {
                if(stack != null) {
                    stacks.add(stack);
                }
            }
            RecipeRegistryProxy.addRecipe(recipe.getResult(), stacks);
            RecipeRegistryProxy.dumpRecipeRegistryToLog();
            stacks.clear();
        }

    }

    @Override
    public void clientInit() {

    }

    @Override
    public void constructCraftingRecipes() {

    }
}
