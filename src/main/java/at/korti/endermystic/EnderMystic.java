package at.korti.endermystic;

import at.korti.endermystic.api.tools.ToolLevelHandler;
import at.korti.endermystic.blocks.ModBlocks;
import at.korti.endermystic.client.guis.GuiHandler;
import at.korti.endermystic.command.AddUpgradeCommand;
import at.korti.endermystic.crafting.CraftingRecipes;
import at.korti.endermystic.event.EventManager;
import at.korti.endermystic.network.PacketPipeline;
import at.korti.endermystic.potion.PotionHelper;
import at.korti.endermystic.proxy.CommonProxy;
import at.korti.endermystic.items.ModItems;
import at.korti.endermystic.tileEntity.TileEntities;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by Korti on 15.10.2014.
 */
@Mod(modid = ModInfo.MODID, name = ModInfo.NAME, version = ModInfo.VERSION)
public class EnderMystic {

    @Mod.Instance(ModInfo.MODID)
    public static EnderMystic instance;

    @SidedProxy(clientSide = "at.korti.endermystic.proxy.ClientProxy", serverSide = "at.korti.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static CreativeTabs tab = new CreativeTabs(ModInfo.MODID) {
        @Override
        public Item getTabIconItem() {
            return Items.ender_pearl;
        }
    };

    public static PacketPipeline pipeline = new PacketPipeline();
    public static Configuration config;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        ModBlocks.init();
        ModBlocks.load();
        ModItems.init();
        ModItems.load();
        PotionHelper.preInit();
        proxy.initKeys();
        MinecraftForge.EVENT_BUS.register(new EventManager());

        CraftingRecipes.registerCrystalCombinerRecipes();
        CraftingRecipes.registerOrbInfuserRecipes();
        CraftingRecipes.registerVanillaRecipes();

        ToolLevelHandler.getInstance().initToolLevelSystem();
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event){
        pipeline.initialise();
        PotionHelper.init();
        proxy.initRenderes();
        proxy.registerDisplayInfromation();
        TileEntities.init();
        new GuiHandler();
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event){
        pipeline.postInitialise();
        config.save();
    }

    @Mod.EventHandler
    public static void serverload(FMLServerStartingEvent event) {
        event.registerServerCommand(new AddUpgradeCommand());
    }

}