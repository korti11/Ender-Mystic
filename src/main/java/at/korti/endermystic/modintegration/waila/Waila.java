package at.korti.endermystic.modintegration.waila;

import at.korti.endermystic.ModInfo;
import at.korti.endermystic.modintegration.IIntegration;
import at.korti.endermystic.modintegration.cofh.Cofh;
import at.korti.endermystic.modintegration.cofh.tileentity.TileEntityMysticDynamo;
import at.korti.endermystic.tileEntity.*;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInterModComms;
import mcp.mobius.waila.api.IWailaRegistrar;

/**
 * Created by Korti on 02.06.2015.
 */
public class Waila implements IIntegration {

    public static boolean isLoaded = false;

    @Override
    public void preInit() {
        isLoaded = Loader.isModLoaded(ModInfo.WAILA);
    }

    @Override
    public void init() {
        if(isLoaded) {
            FMLInterModComms.sendMessage("Waila", "register", "at.korti.endermystic.modintegration.waila.Waila.wailaRegister");
        }
    }

    @Override
    public void posInit() {

    }

    public static void wailaRegister(IWailaRegistrar registrar) {
        registrar.registerBodyProvider(new WailaCrystalCombinerHandler(), TileEntityCrystalCombiner.class);
        registrar.registerBodyProvider(new WailaEnergyDrainHandler(), TileEntityEnergyDrain.class);
        registrar.registerBodyProvider(new WailaOrbInfuserHandler(), TileEntityOrbInfuser.class);
        registrar.registerBodyProvider(new WailaEnergyRelayHandler(), TileEntityEnergyRelay.class);
        registrar.registerBodyProvider(new WailaEnderZarHandler(), TileEntityEnderZar.class);
        registrar.registerBodyProvider(new WailaEnergyCrystalStorageHandler(), TileEntityEnergyCrystalStorage.class);

        registrar.registerNBTProvider(new WailaCrystalCombinerHandler(), TileEntityCrystalCombiner.class);
        registrar.registerNBTProvider(new WailaEnergyDrainHandler(), TileEntityEnergyDrain.class);
        registrar.registerNBTProvider(new WailaOrbInfuserHandler(), TileEntityOrbInfuser.class);
        registrar.registerNBTProvider(new WailaEnergyRelayHandler(), TileEntityEnergyRelay.class);
        registrar.registerNBTProvider(new WailaEnderZarHandler(), TileEntityEnderZar.class);
        registrar.registerNBTProvider(new WailaEnergyCrystalStorageHandler(), TileEntityEnergyCrystalStorage.class);

        //CoFH
        if (Cofh.isLoaded) {
            registrar.registerBodyProvider(new WailaMysticDynamoHandler(), TileEntityMysticDynamo.class);
            registrar.registerNBTProvider(new WailaMysticDynamoHandler(), TileEntityMysticDynamo.class);
        }
    }
}
