package at.korti.endermystic.modintegration.cofh.tileentity;

import at.korti.endermystic.EnderMystic;
import at.korti.endermystic.util.Logger;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Korti on 05.06.2015.
 */
public class TileEntities {

    public static void init() {
        EnderMystic.logger.addMessage(Logger.LoggingLevel.INFO, "Register CoFH tile entities.");
        GameRegistry.registerTileEntity(TileEntityMysticDynamo.class, "tileEntityMysticDynamo");
    }

}
