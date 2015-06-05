package at.korti.endermystic.modintegration.cofh;

import at.korti.endermystic.ModInfo;
import at.korti.endermystic.modintegration.IIntegration;
import at.korti.endermystic.modintegration.cofh.blocks.MysticDynamo;
import at.korti.endermystic.modintegration.cofh.tileentity.TileEntities;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Korti on 05.06.2015.
 */
public class Cofh implements IIntegration{

    public static boolean isLoaded = false;

    public static MysticDynamo mysticDynamo;

    private void initBlocks() {
        mysticDynamo = new MysticDynamo();
    }

    private void loadBlocks() {
        GameRegistry.registerBlock(mysticDynamo, "MysticDynamo");
    }

    @Override
    public void preInit() {
        isLoaded = Loader.isModLoaded(ModInfo.COFH);
    }

    @Override
    public void init() {
        if(isLoaded) {
            TileEntities.init();
            initBlocks();
            loadBlocks();
        }
    }

    @Override
    public void posInit() {

    }
}
