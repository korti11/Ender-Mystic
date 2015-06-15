package at.korti.endermystic.modintegration;

import at.korti.endermystic.EnderMystic;
import at.korti.endermystic.modintegration.baubles.Baubles;
import at.korti.endermystic.modintegration.cofh.Cofh;
import at.korti.endermystic.modintegration.waila.Waila;
import at.korti.endermystic.util.Logger;

/**
 * Created by Korti on 02.06.2015.
 */
public class ModIntegration {

    private static IIntegration waila = new Waila();
    private static IIntegration baubles = new Baubles();
    private static IIntegration cofh = new Cofh();

    public static void preInit(){
        EnderMystic.logger.addMessage(Logger.LoggingLevel.INFO, "Pre Init mod integration.");
        waila.preInit();
        baubles.preInit();
        cofh.preInit();
    }

    public static void inti(){
        EnderMystic.logger.addMessage(Logger.LoggingLevel.INFO, "Init mod integration.");
        waila.init();
        baubles.init();
        cofh.init();
    }

    public static void postInit(){
        EnderMystic.logger.addMessage(Logger.LoggingLevel.INFO, "Post Init mod integration.");
        waila.posInit();
        baubles.posInit();
        cofh.posInit();
    }
}
