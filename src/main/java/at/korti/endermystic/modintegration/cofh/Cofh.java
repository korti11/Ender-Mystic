package at.korti.endermystic.modintegration.cofh;

import at.korti.endermystic.EnderMystic;
import at.korti.endermystic.ModInfo;
import at.korti.endermystic.modintegration.IIntegration;
import at.korti.endermystic.modintegration.cofh.blocks.MysticDynamo;
import at.korti.endermystic.modintegration.cofh.tileentity.TileEntities;
import at.korti.endermystic.util.Logger;
import cofh.CoFHCore;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Korti on 05.06.2015.
 */
public class Cofh implements IIntegration{

    public static boolean isLoaded = false;
    public static String cofhVersion = CoFHCore.class.getAnnotation(Mod.class).version();

    public static MysticDynamo mysticDynamo;

    private void initBlocks() {
        EnderMystic.logger.addMessage(Logger.LoggingLevel.INFO, "Init CoFH blocks.");
        mysticDynamo = new MysticDynamo();
    }

    private void loadBlocks() {
        EnderMystic.logger.addMessage(Logger.LoggingLevel.INFO, "Load CoFH blocks.");
        GameRegistry.registerBlock(mysticDynamo, "MysticDynamo");
    }

    @Override
    public void preInit() {
        isLoaded = Loader.isModLoaded(ModInfo.COFH);
    }

    @Override
    public void init() {
        if(isLoaded) {
            EnderMystic.logger.addMessage(Logger.LoggingLevel.INFO, "Init CoFH integration.");
            TileEntities.init();
            initBlocks();
            loadBlocks();
        }
    }

    @Override
    public void posInit() {

    }
}
