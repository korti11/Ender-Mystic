package at.korti.endermystic.items;

import at.korti.endermystic.ModInfo;
import at.korti.endermystic.blocks.EnderZar;
import at.korti.endermystic.modintegration.baubles.BaublesBackPack;
import at.korti.endermystic.modintegration.baubles.rings.AirRing;
import at.korti.endermystic.items.orbs.*;
import at.korti.endermystic.items.tools.*;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Korti on 15.10.2014.
 */
public class ModItems {

    public static CapacityOrb enderOrb;
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

    public static ModItem enderShard;
    public static EnderSoulFill enderSoulFill;
    public static CrystalItem crystalItem;
    public static OrbCoreItem orbCoreItem;

    //Baubles integration
    public static AirRing airRing;
    public static BaublesBackPack baublesBackPack;

    public static void init(){
        enderOrb = new CapacityOrb("BasicEnderOrb", 0x258474, 10000);
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

        enderShard = new ModItem("EnderShard");
        enderSoulFill = new EnderSoulFill();
        crystalItem = new CrystalItem("Crystal");
        orbCoreItem = new OrbCoreItem();

        airRing = new AirRing();
        baublesBackPack = new BaublesBackPack("Baubles Back Pack");

    }

    public static void load(){

        GameRegistry.registerItem(enderOrb, enderOrb.getName(), ModInfo.MODID);
        GameRegistry.registerItem(emeraldOrb, emeraldOrb.getName(), ModInfo.MODID);
        GameRegistry.registerItem(waterOrb, waterOrb.getName(), ModInfo.MODID);
        GameRegistry.registerItem(fireOrb, fireOrb.getName(), ModInfo.MODID);
        GameRegistry.registerItem(earthOrb, earthOrb.getName(), ModInfo.MODID);
        GameRegistry.registerItem(airOrb, airOrb.getName(), ModInfo.MODID);
        GameRegistry.registerItem(enderZarOrb, enderZarOrb.getName(), ModInfo.MODID);

        GameRegistry.registerItem(testOrb, testOrb.getName(), ModInfo.MODID);

        GameRegistry.registerItem(enderSacrifice, enderSacrifice.getName(), ModInfo.MODID);
        GameRegistry.registerItem(enderSoulSword, "EnderSoulSword", ModInfo.MODID);
        GameRegistry.registerItem(enderSoulPickaxe, "EnderSoulPickaxe", ModInfo.MODID);
        GameRegistry.registerItem(enderSoulShovel, "EnderSoulShovel", ModInfo.MODID);
        GameRegistry.registerItem(enderSoulHammer, "EnderSoulHammer", ModInfo.MODID);
        GameRegistry.registerItem(enderSoulExcavator, "EnderSoulExcavator", ModInfo.MODID);

        GameRegistry.registerItem(enderShard, enderShard.getName(), ModInfo.MODID);
        GameRegistry.registerItem(enderSoulFill, enderSoulFill.getName(), ModInfo.MODID);
        GameRegistry.registerItem(crystalItem, crystalItem.getName(), ModInfo.MODID);
        GameRegistry.registerItem(orbCoreItem, orbCoreItem.getName(), ModInfo.MODID);

        GameRegistry.registerItem(airRing, airRing.getName(), ModInfo.MODID);
        GameRegistry.registerItem(baublesBackPack, baublesBackPack.getName(), ModInfo.MODID);

    }

}
