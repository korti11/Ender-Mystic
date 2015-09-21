package at.korti.endermystic.proxy;

import at.korti.endermystic.blocks.ModBlocks;
import at.korti.endermystic.client.keybinding.KeyHandler;
import at.korti.endermystic.client.model.blocks.EnderZarModel;
import at.korti.endermystic.client.model.blocks.EnergyCrystalStorageModel;
import at.korti.endermystic.client.model.blocks.EnergyRelayModel;
import at.korti.endermystic.client.render.RenderConfig;
import at.korti.endermystic.client.render.blocks.*;
import at.korti.endermystic.client.render.items.TileEntityItemRenderer;
import at.korti.endermystic.modintegration.ModIntegrationManager;
import at.korti.endermystic.tileEntity.*;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

/**
 * Created by Korti on 15.10.2014.
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void initRenderes() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrystalCombiner.class, new CrystalCombinerRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEnergyDrain.class, new EnergyDrainRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEnergyRelay.class, new TileEntityBlockRenderer(new EnergyRelayModel(), "textures/model/EnergyRelay.png"));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEnderZar.class, new TileEntityBlockRenderer(new EnderZarModel(), "textures/model/Ender Zar.png"));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOrbInfuser.class, new OrbInfuserRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEnergyCrystalStorage.class, new TileEntityBlockRenderer(new EnergyCrystalStorageModel(), "textures/model/EnergyCrystalStorage.png"));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEnderTranfer.class, new EnderTransferRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEnderTranfer.class, new EnderTransferRenderer());

        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.energyDrain), new TileEntityItemRenderer(new EnergyDrainRenderer(), new TileEntityEnergyDrain()));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.energyRelay), new TileEntityItemRenderer(new TileEntityBlockRenderer(new EnergyRelayModel(), "textures/model/EnergyRelay.png"), new TileEntityEnergyRelay()));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.crystalCombiner), new TileEntityItemRenderer(new CrystalCombinerRenderer(), new TileEntityCrystalCombiner()));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.enderZar), new TileEntityItemRenderer(new TileEntityBlockRenderer(new EnderZarModel(), "textures/model/Ender Zar.png"), new TileEntityEnderZar()));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.orbInfuser), new TileEntityItemRenderer(new OrbInfuserRenderer(), new TileEntityOrbInfuser()));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.energyCrystalStorage), new TileEntityItemRenderer(new TileEntityBlockRenderer(new EnergyCrystalStorageModel(), "textures/model/EnergyCrystalStorage.png"), new TileEntityEnergyCrystalStorage()));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.enderPicker), new TileEntityItemRenderer(new EnderTransferRenderer(), new TileEntityEnderTranfer()));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.enderInjector), new TileEntityItemRenderer(new EnderTransferRenderer(), new TileEntityEnderTranfer()));
//        MinecraftForgeClient.registerItemRenderer(ModItems.enderSoulHelmet, new ItemEnderSoulArmorRenderer());
//        MinecraftForgeClient.registerItemRenderer(ModItems.enderSoulBreastplate, new ItemEnderSoulArmorRenderer());
//        MinecraftForgeClient.registerItemRenderer(ModItems.enderSoulLegs, new ItemEnderSoulArmorRenderer());

    }

    @Override
    public void registerDisplayInfromation() {
        RenderConfig.CrystelOreRenderId = RenderingRegistry.getNextAvailableRenderId();
        this.registerBlockRendere(new CrystalOreRenderer());
    }

    private void registerBlockRendere(ISimpleBlockRenderingHandler renderer){
        RenderingRegistry.registerBlockHandler(renderer);
    }

    @Override
    public void initKeys() {
        KeyHandler.init();
    }

    @Override
    public void postInitIntegration() {
        ModIntegrationManager.clientInit();
    }

}
