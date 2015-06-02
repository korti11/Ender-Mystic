package at.korti.endermystic.modintegration;

import at.korti.endermystic.modintegration.waila.Waila;

/**
 * Created by Korti on 02.06.2015.
 */
public class ModIntegration {

    private static IIntegration waila = new Waila();

    public static void preInit(){
        waila.preInit();
    }

    public static void inti(){
        waila.init();
    }

    public static void postInit(){
        waila.posInit();
    }
}
