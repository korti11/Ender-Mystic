package at.korti.endermystic.modintegration;

import at.korti.endermystic.modintegration.baubles.Baubles;
import at.korti.endermystic.modintegration.cofh.Cofh;
import at.korti.endermystic.modintegration.waila.Waila;

/**
 * Created by Korti on 02.06.2015.
 */
public class ModIntegration {

    private static IIntegration waila = new Waila();
    private static IIntegration baubles = new Baubles();
    private static IIntegration cofh = new Cofh();

    public static void preInit(){
        waila.preInit();
        baubles.preInit();
        cofh.preInit();
    }

    public static void inti(){
        waila.init();
        baubles.init();
        cofh.init();
    }

    public static void postInit(){
        waila.posInit();
        baubles.posInit();
        cofh.posInit();
    }
}
