package at.korti.endermystic.tileEntity;

import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Korti on 30.10.2014.
 */
public class TileEntities {

    public static void init(){
        GameRegistry.registerTileEntity(TileEntityCrystalCombiner.class, "tileEntityCrystalCombiner");
        GameRegistry.registerTileEntity(TileEntityEnergyDrain.class, "tileEntityEnergyDrain");
        GameRegistry.registerTileEntity(TileEntityEnergyRelay.class, "tileEntityEnergyRelay");
        GameRegistry.registerTileEntity(TileEntityEnderZar.class, "tileEntityEnderZar");
        GameRegistry.registerTileEntity(TileEntityOrbInfuser.class, "tileEntityOrbInfuser");
        GameRegistry.registerTileEntity(TileEntityEnergyCrystalStorage.class, "tileEntityEnergyCrystalStorage");
    }

}
