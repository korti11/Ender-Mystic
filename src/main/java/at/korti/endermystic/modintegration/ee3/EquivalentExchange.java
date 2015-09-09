package at.korti.endermystic.modintegration.ee3;

import at.korti.endermystic.ModInfo;
import at.korti.endermystic.items.ModItems;
import at.korti.endermystic.modintegration.IIntegration;
import com.pahimar.ee3.api.exchange.EnergyValueRegistryProxy;
import cpw.mods.fml.common.Loader;
import net.minecraft.item.ItemStack;

/**
 * Created by Korti on 04.09.2015.
 */
public class EquivalentExchange implements IIntegration {

    public boolean isLoaded = false;

    public static float getEMCValue(ItemStack stack) {
        return EnergyValueRegistryProxy.getEnergyValueForStack(stack).getValue();
    }

    @Override
    public void preInit() {
        isLoaded = Loader.isModLoaded(ModInfo.EQUIVALENTEXCHANGE);
        if(isLoaded) {
//            EnergyValueRegistryProxy.addPreAssignedEnergyValue(new ItemStack(ModItems.crystalItem, 1, 0), 100F);
//            EnergyValueRegistryProxy.addPreAssignedEnergyValue(new ItemStack(ModItems.crystalItem, 1, 1), 100F);
//            EnergyValueRegistryProxy.addPreAssignedEnergyValue(new ItemStack(ModItems.crystalItem, 1, 2), 100F);
//            EnergyValueRegistryProxy.addPreAssignedEnergyValue(new ItemStack(ModItems.crystalItem, 1, 3), 100F);
        }
        EnergyValueRegistryProxy.addPreAssignedEnergyValue(ModItems.enderSacrifice, 260);

    }

    @Override
    public void init() {

    }

    @Override
    public void posInit() {

    }

    @Override
    public void clientInit() {

    }

    @Override
    public void constructCraftingRecipes() {

    }
}
