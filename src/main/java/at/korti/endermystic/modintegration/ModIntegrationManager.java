package at.korti.endermystic.modintegration;

import at.korti.endermystic.ModInfo;
import at.korti.endermystic.modintegration.baubles.Baubles;
import at.korti.endermystic.modintegration.cofh.Cofh;
import at.korti.endermystic.modintegration.ee3.EquivalentExchange;
import at.korti.endermystic.modintegration.nei.NEI;
import at.korti.endermystic.modintegration.waila.Waila;
import cpw.mods.fml.common.Loader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Korti on 02.06.2015.
 */
public class ModIntegrationManager {

    private static final List<IIntegration> integtrationMods = new ArrayList<>();

    public static void initManager() {
        Map<String, Class<? extends IIntegration>> integrationClasses = new HashMap<>();
        try {
            integrationClasses.put(ModInfo.BAUBLES, Baubles.class);
            integrationClasses.put(ModInfo.COFH, Cofh.class);
            integrationClasses.put(ModInfo.WAILA, Waila.class);
            integrationClasses.put(ModInfo.EQUIVALENTEXCHANGE, EquivalentExchange.class);
            integrationClasses.put(ModInfo.NEI, NEI.class);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, Class<? extends IIntegration>> entry : integrationClasses.entrySet()) {
            if (Loader.isModLoaded(entry.getKey())) {
                try {
                    integtrationMods.add(entry.getValue().newInstance());
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void preInit() {
        for (IIntegration mod : integtrationMods) {
            mod.preInit();
        }
    }

    public static void inti() {
        for (IIntegration mod : integtrationMods) {
            mod.init();
        }
    }

    public static void postInit() {
        for (IIntegration mod : integtrationMods) {
            mod.posInit();
        }
    }

    public static void clientInit() {
        for (IIntegration mod : integtrationMods) {
            mod.clientInit();
        }
    }

    public static void constructCraftingRecipes() {
        for (IIntegration mod : integtrationMods) {
            mod.constructCraftingRecipes();
        }
    }

}
