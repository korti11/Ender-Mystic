package at.korti.endermystic.modintegration.baubles;

import at.korti.endermystic.ModInfo;
import at.korti.endermystic.modintegration.IIntegration;
import at.korti.endermystic.modintegration.baubles.belts.AirBelt;
import at.korti.endermystic.modintegration.baubles.rings.AirRing;
import at.korti.endermystic.modintegration.baubles.rings.FireRing;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Korti on 02.06.2015.
 */
public class Baubles implements IIntegration{

    public static boolean isLoaded = false;
    public static final String baublesVersion = baubles.common.Baubles.class.getAnnotation(Mod.class).version();

    public static AirRing airRing;
    public static FireRing fireRing;
    public static AirBelt airBelt;

    private void initItems(){
        airRing = new AirRing();
        fireRing = new FireRing();
        airBelt = new AirBelt();
    }

    private void loadItems() {
        GameRegistry.registerItem(airRing, airRing.getName());
        GameRegistry.registerItem(fireRing, fireRing.getName());
        GameRegistry.registerItem(airBelt, airBelt.getName());
    }

    @Override
    public void preInit() {
        isLoaded = Loader.isModLoaded(ModInfo.BAUBLES);
        if (isLoaded) {
            initItems();
            loadItems();
        }
    }

    @Override
    public void init() {

    }

    @Override
    public void posInit() {

    }
}
