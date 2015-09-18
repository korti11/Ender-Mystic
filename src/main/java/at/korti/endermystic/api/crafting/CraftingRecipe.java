package at.korti.endermystic.api.crafting;

import net.minecraft.item.ItemStack;

/**
 * Created by Korti on 19.05.2015.
 */
public class CraftingRecipe {

    private ItemStack result;
    private ItemStack[] requirements;
    private int timeToCraft;
    private int energyUsePerTick;
    private int requirementsCount;

    CraftingRecipe(int timeToCraft, int energyUsePerTick, ItemStack result, ItemStack[] requirements, int maxRequirements){
        this.result = result;
        this.timeToCraft = timeToCraft;
        this.energyUsePerTick = energyUsePerTick;
        this.requirements = new ItemStack[maxRequirements];
        this.requirementsCount = Math.min(maxRequirements, requirements.length);

        for(int i = 0; i < requirements.length; i++){
            if(i == maxRequirements){
                break;
            }

            this.requirements[i] = requirements[i];
        }

    }

    public boolean containsRequirement(ItemStack stack) {
        for (ItemStack itemStack : requirements) {
            if (itemStack != null && stack.getItem().equals(itemStack.getItem()) && stack.getItemDamage() == itemStack.getItemDamage()) {
                return true;
            }
        }
        return false;
    }

    public ItemStack getResult() {
        return result;
    }

    public ItemStack getRequirement(int slot) {
        return requirements[slot];
    }

    public ItemStack[] getRequirements() {
        return requirements;
    }

    public int requirementsCount(){
        return requirementsCount;
    }

    public int getTimeToCraft(){
        return timeToCraft;
    }

    public int getEnergyUsePerTick(){
        return energyUsePerTick;
    }

}
