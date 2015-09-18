package at.korti.endermystic.modintegration.nei;

import at.korti.endermystic.ModInfo;
import at.korti.endermystic.modintegration.IIntegration;
import codechicken.nei.api.API;
import cpw.mods.fml.common.Loader;

/**
 * Created by Korti on 17.09.2015.
 */
public class NEI implements IIntegration {

    private boolean loaded = false;

    @Override
    public void preInit() {
        loaded = Loader.isModLoaded(ModInfo.NEI);
    }

    @Override
    public void init() {
        API.registerRecipeHandler(new NEICrystalCombinerHandler());
        API.registerUsageHandler(new NEICrystalCombinerHandler());
        API.registerRecipeHandler(new NEIOrbInfuserHandler());
        API.registerUsageHandler(new NEIOrbInfuserHandler());
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
