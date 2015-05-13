package at.korti.endermystic.api.crafting;

import net.minecraft.item.ItemStack;

/**
 * Created by Korti on 13.05.2015.
 */
public class OrbInfuserRecipe {

    private ItemStack result;
    private ItemStack[] requirements;
    private int timeToCraft;
    private int energyUsePerTick;
    private int requirementCount;

    public OrbInfuserRecipe(int timeToCraft, int energyUsePerTick, ItemStack result, ItemStack... requirements) {
        this.timeToCraft = timeToCraft;
        this.energyUsePerTick = energyUsePerTick;
        this.requirementCount = Math.min(requirements.length, 8);
        this.result = result;
        this.requirements = new ItemStack[8];

        for (int i = 0; i < requirements.length; i++) {
            this.requirements[i] = requirements[i];
        }
    }

    public ItemStack getResult() {
        return result;
    }

    public ItemStack getRequirements(int slot) {
        return requirements[slot];
    }

    public int getTimeToCraft() {
        return timeToCraft;
    }

    public int getEnergyUsePerTick() {
        return energyUsePerTick;
    }

    public int requirementsCount() {
        return requirementCount;
    }
}
