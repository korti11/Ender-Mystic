package at.korti.endermystic.items;

import at.korti.endermystic.EnderMystic;
import at.korti.endermystic.ModInfo;
import at.korti.endermystic.items.armor.EnderSoulArmor;
import at.korti.endermystic.items.orbs.*;
import at.korti.endermystic.items.tools.*;
import at.korti.endermystic.util.Logger;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Korti on 15.10.2014.
 */
public class ModItems {

    public static CapacityOrb enderOrb;
    public static CapacityOrb apprenticeOrb;
    public static CapacityOrb guardiansOrb;
    public static CapacityOrb masterOrb;
    public static CapacityOrb galaxyOrb;
    public static CapacityOrb universeOrb;

    public static EmeraldOrb emeraldOrb;
    public static WaterOrb waterOrb;
    public static FireOrb fireOrb;
    public static EarthOrb earthOrb;
    public static AirOrb airOrb;
    public static EnderZarOrb enderZarOrb;

    public static TestOrb testOrb;

    public static EnderSacrifice enderSacrifice;
    public static EnderSoulSword enderSoulSword;
    public static EnderSoulPickaxe enderSoulPickaxe;
    public static EnderSoulShovel enderSoulShovel;
    public static EnderSoulHammer enderSoulHammer;
    public static EnderSoulExcavator enderSoulExcavator;

    public static EnderSoulArmor enderSoulHelmet;
    public static EnderSoulArmor enderSoulBreastplate;
    public static EnderSoulArmor enderSoulLegs;

    public static EnderItem enderItem;
    public static EnderSoulFill enderSoulFill;
    public static CrystalItem crystalItem;
    public static OrbCoreItem orbCoreItem;
    public static BookItem bookItem;

    //Baubles integration
//    public static AirRing airRing;
//    public static BaublesBackPack baublesBackPack;

    public static void init(){
        EnderMystic.logger.addMessage(Logger.LoggingLevel.INFO, "Init mod items.");
        enderOrb = new CapacityOrb("BasicEnderOrb", 0x258474, 10000);
        apprenticeOrb = new CapacityOrb("ApprenticeOrb", 0x3C3C8D, 25000);
        guardiansOrb = new CapacityOrb("GuardiansOrb", 0x620000, 40000);
        masterOrb = new CapacityOrb("MasterOrb", 0x00A6CF, 55000);
        galaxyOrb = new CapacityOrb("GalaxyOrb", 0x000066, 70000);
        universeOrb = new CapacityOrb("UniverseOrb", 0x00001F, 85000);

        emeraldOrb = new EmeraldOrb();
        waterOrb = new WaterOrb();
        fireOrb = new FireOrb();
        earthOrb = new EarthOrb();
        airOrb = new AirOrb();
        enderZarOrb = new EnderZarOrb();

        testOrb = new TestOrb();

        enderSacrifice = new EnderSacrifice();
        enderSoulSword = new EnderSoulSword();
        enderSoulPickaxe = new EnderSoulPickaxe();
        enderSoulShovel = new EnderSoulShovel();
        enderSoulHammer = new EnderSoulHammer();
        enderSoulExcavator = new EnderSoulExcavator();

        enderSoulHelmet = new EnderSoulArmor(0);
        enderSoulBreastplate = new EnderSoulArmor(1);
        enderSoulLegs = new EnderSoulArmor(2);

        enderItem = new EnderItem();
        enderSoulFill = new EnderSoulFill();
        crystalItem = new CrystalItem();
        orbCoreItem = new OrbCoreItem();
        bookItem = new BookItem();

//        airRing = new AirRing();
//        baublesBackPack = new BaublesBackPack("Baubles Back Pack");

    }

    public static void load(){
        EnderMystic.logger.addMessage(Logger.LoggingLevel.INFO, "Load mod items.");
        GameRegistry.registerItem(bookItem, bookItem.getName(), ModInfo.MODID);

        GameRegistry.registerItem(enderOrb, enderOrb.getName(), ModInfo.MODID);
        GameRegistry.registerItem(apprenticeOrb, apprenticeOrb.getName());
        GameRegistry.registerItem(guardiansOrb, guardiansOrb.getName());
        GameRegistry.registerItem(masterOrb, masterOrb.getName());
        GameRegistry.registerItem(galaxyOrb, galaxyOrb.getName());
        GameRegistry.registerItem(universeOrb, universeOrb.getName());

        GameRegistry.registerItem(airOrb, airOrb.getName(), ModInfo.MODID);
        GameRegistry.registerItem(earthOrb, earthOrb.getName(), ModInfo.MODID);
        GameRegistry.registerItem(emeraldOrb, emeraldOrb.getName(), ModInfo.MODID);
        GameRegistry.registerItem(enderZarOrb, enderZarOrb.getName(), ModInfo.MODID);
        GameRegistry.registerItem(waterOrb, waterOrb.getName(), ModInfo.MODID);
        GameRegistry.registerItem(fireOrb, fireOrb.getName(), ModInfo.MODID);

        GameRegistry.registerItem(testOrb, testOrb.getName(), ModInfo.MODID);

        GameRegistry.registerItem(enderSacrifice, enderSacrifice.getName(), ModInfo.MODID);
        GameRegistry.registerItem(enderSoulSword, "EnderSoulSword", ModInfo.MODID);
        GameRegistry.registerItem(enderSoulPickaxe, "EnderSoulPickaxe", ModInfo.MODID);
        GameRegistry.registerItem(enderSoulShovel, "EnderSoulShovel", ModInfo.MODID);
        GameRegistry.registerItem(enderSoulHammer, "EnderSoulHammer", ModInfo.MODID);
        GameRegistry.registerItem(enderSoulExcavator, "EnderSoulExcavator", ModInfo.MODID);

        GameRegistry.registerItem(enderSoulHelmet, "EnderSoulHelmet");
        GameRegistry.registerItem(enderSoulBreastplate, "EnderSoulBreastplate");
        GameRegistry.registerItem(enderSoulLegs, "EnderSoulLegs");

        GameRegistry.registerItem(enderItem, enderItem.getName(), ModInfo.MODID);
        GameRegistry.registerItem(enderSoulFill, enderSoulFill.getName(), ModInfo.MODID);
        GameRegistry.registerItem(crystalItem, crystalItem.getName(), ModInfo.MODID);
        GameRegistry.registerItem(orbCoreItem, orbCoreItem.getName(), ModInfo.MODID);

//        GameRegistry.registerItem(airRing, airRing.getName(), ModInfo.MODID);
//        GameRegistry.registerItem(baublesBackPack, baublesBackPack.getName(), ModInfo.MODID);

    }

}
