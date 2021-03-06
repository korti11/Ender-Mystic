package at.korti.endermystic.modintegration.nei;

import at.korti.endermystic.ModInfo;
import at.korti.endermystic.modintegration.IIntegration;
import codechicken.nei.api.API;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by Korti on 17.09.2015.
 */
public class NEI implements IIntegration {

    @Override
    public void preInit() {

    }

    @Override
    public void init() {
        if(FMLCommonHandler.instance().getSide() == Side.CLIENT) {
            API.registerRecipeHandler(new NEICrystalCombinerHandler());
            API.registerUsageHandler(new NEICrystalCombinerHandler());
            API.registerRecipeHandler(new NEIOrbInfuserHandler());
            API.registerUsageHandler(new NEIOrbInfuserHandler());
        }
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
