package at.korti.endermystic.blocks;

import at.korti.endermystic.items.blockitems.CrystalOreItemBlock;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Korti on 30.10.2014.
 */
public class ModBlocks {

    public static CrystalOre crystalOre;
    public static CrystalCombiner crystalCombiner;
    public static EnergyDrain energyDrain;
    public static EnergyRelay energyRelay;
    public static EnderZar enderZar;

    public static void init(){
        crystalOre = new CrystalOre();
        crystalCombiner = new CrystalCombiner();
        energyDrain = new EnergyDrain();
        energyRelay = new EnergyRelay();
        enderZar = new EnderZar();
    }

    public static void load(){
        GameRegistry.registerBlock(crystalOre, CrystalOreItemBlock.class, "CrystalOre");
        GameRegistry.registerBlock(crystalCombiner, "CrystalCombiner");
        GameRegistry.registerBlock(energyDrain, "EnergyDrain");
        GameRegistry.registerBlock(energyRelay, "EnergyRelay");
        GameRegistry.registerBlock(enderZar, "EnderZar");
    }

}
