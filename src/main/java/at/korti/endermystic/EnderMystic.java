package at.korti.endermystic;

import at.korti.endermystic.api.tools.ToolLevelHandler;
import at.korti.endermystic.blocks.ModBlocks;
import at.korti.endermystic.client.guis.GuiHandler;
import at.korti.endermystic.command.AddUpgradeCommand;
import at.korti.endermystic.command.AddXpCommand;
import at.korti.endermystic.crafting.CraftingManager;
import at.korti.endermystic.event.EventManager;
import at.korti.endermystic.items.ModItems;
import at.korti.endermystic.modintegration.ModIntegration;
import at.korti.endermystic.network.PacketPipeline;
import at.korti.endermystic.potion.PotionHelper;
import at.korti.endermystic.proxy.CommonProxy;
import at.korti.endermystic.tileEntity.TileEntities;
import at.korti.endermystic.util.UpdateChecker;
import at.korti.endermystic.world.OreGeneration;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Korti on 15.10.2014.
 */
@Mod(modid = ModInfo.MODID, name = ModInfo.NAME, version = ModInfo.VERSION, dependencies = "after:Baubles; after:Waila; after:CoFhCore; after:ThermalExpansion")
public class EnderMystic {

    @Mod.Instance(ModInfo.MODID)
    public static EnderMystic instance;

    @SidedProxy(clientSide = "at.korti.endermystic.proxy.ClientProxy", serverSide = "at.korti.endermystic.proxy.CommonProxy")
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

        UpdateChecker.getInstance().checkForUpdate();

        ModBlocks.init();
        ModBlocks.load();

        ModItems.init();
        ModItems.load();

        PotionHelper.preInit();
        ModIntegration.preInit();

        proxy.initKeys();

        MinecraftForge.EVENT_BUS.register(new EventManager());

        GameRegistry.registerWorldGenerator(new OreGeneration(), 1);

        ToolLevelHandler.getInstance().initToolLevelSystem();
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event){

        pipeline.initialise();

        PotionHelper.init();

        TileEntities.init();
        ModIntegration.inti();

        proxy.initRenderes();
        proxy.registerDisplayInfromation();

        CraftingManager.registerCrystalCombinerRecipes();
        CraftingManager.registerOrbInfuserRecipes();
        CraftingManager.registerVanillaRecipes();
        CraftingManager.registerBookRecipes();

        new GuiHandler();
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event){
        pipeline.postInitialise();

        CraftingManager.loadRecipes();

        ModIntegration.postInit();

        config.save();
    }

    @Mod.EventHandler
    public static void serverload(FMLServerStartingEvent event) {
        event.registerServerCommand(new AddUpgradeCommand());
        event.registerServerCommand(new AddXpCommand());
    }

}
