package at.korti.endermystic.api.crafting;

import net.minecraft.item.ItemStack;

/**
 * Created by Korti on 11.04.2015.
 */
public class CrystalCombinerRecipe {

    private ItemStack result;
    private ItemStack[] requirements;
    private int timeToCraft;
    private int energyUsePerTick;
    private int requirementsCount;

    public CrystalCombinerRecipe(int timeToCraft, int energyUsePerTick, ItemStack result, ItemStack... requirements){
        this.result = result;
        this.timeToCraft = timeToCraft;
        this.energyUsePerTick = energyUsePerTick;
        this.requirements = new ItemStack[4];
        this.requirementsCount = Math.min(4, requirements.length);

        for(int i = 0; i < requirements.length; i++){
            if(i == 4){
                break;
            }

            this.requirements[i] = requirements[i];
        }
    }

    public ItemStack getResult() {
        return result;
    }

    public ItemStack getRequirements(int slot) {
        return requirements[slot];
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
