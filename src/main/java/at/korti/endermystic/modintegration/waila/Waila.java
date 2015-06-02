package at.korti.endermystic.modintegration.waila;

import at.korti.endermystic.modintegration.IIntegration;
import at.korti.endermystic.tileEntity.*;
import cpw.mods.fml.common.event.FMLInterModComms;
import mcp.mobius.waila.api.IWailaRegistrar;

/**
 * Created by Korti on 02.06.2015.
 */
public class Waila implements IIntegration {
    @Override
    public void preInit() {

    }

    @Override
    public void init() {
        FMLInterModComms.sendMessage("Waila", "register", "at.korti.endermystic.modintegration.waila.Waila.wailaRegister");
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

        registrar.registerNBTProvider(new WailaCrystalCombinerHandler(), TileEntityCrystalCombiner.class);
        registrar.registerNBTProvider(new WailaEnergyDrainHandler(), TileEntityEnergyDrain.class);
        registrar.registerNBTProvider(new WailaOrbInfuserHandler(), TileEntityOrbInfuser.class);
        registrar.registerNBTProvider(new WailaEnergyRelayHandler(), TileEntityEnergyRelay.class);
        registrar.registerNBTProvider(new WailaEnderZarHandler(), TileEntityEnderZar.class);
    }
}
