package at.korti.endermystic.modintegration.cofh.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Korti on 05.06.2015.
 */
public class TileEntities {

    public static void init() {
        GameRegistry.registerTileEntity(TileEntityMysticConverter.class, "tileEntityMysticDynamo");
    }

}
