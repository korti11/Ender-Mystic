package at.korti.endermystic.proxy;

import at.korti.endermystic.blocks.ModBlocks;
import at.korti.endermystic.client.keybinding.KeyHandler;
import at.korti.endermystic.client.model.blocks.EnderZarModel;
import at.korti.endermystic.client.model.blocks.EnergyCrystalStorageModel;
import at.korti.endermystic.client.model.blocks.EnergyRelayModel;
import at.korti.endermystic.client.model.items.TeleportWandModel;
import at.korti.endermystic.client.model.items.ThunderWand;
import at.korti.endermystic.client.render.RenderConfig;
import at.korti.endermystic.client.render.blocks.*;
import at.korti.endermystic.client.render.items.ItemRenderer;
import at.korti.endermystic.client.render.items.TileEntityItemRenderer;
import at.korti.endermystic.items.ModItems;
import at.korti.endermystic.modintegration.ModIntegrationManager;
import at.korti.endermystic.tileEntity.*;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.MinecraftForgeClient;

/**
 * Created by Korti on 15.10.2014.
 */
public class ClientProxy extends CommonProxy {

    public static void registerTileEntityRenderer(Block block, Class<? extends TileEntity> tileEntityClass, ModelBase model, String texture){
        registerTileEntityRenderer(Item.getItemFromBlock(block), tileEntityClass, model, texture);
    }

    private static void registerTileEntityRenderer(Item item, Class<? extends TileEntity> tileEntityClass, ModelBase model, String texture) {
        try {
            TileEntityBlockRenderer renderer = new TileEntityBlockRenderer(model, texture);
            ClientRegistry.bindTileEntitySpecialRenderer(tileEntityClass, renderer);
            MinecraftForgeClient.registerItemRenderer(item, new TileEntityItemRenderer(renderer, tileEntityClass.newInstance()));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

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

        MinecraftForgeClient.registerItemRenderer(ModItems.teleportWand, new ItemRenderer(new TeleportWandModel(), "textures/model/TeleportWand.png"));
        MinecraftForgeClient.registerItemRenderer(ModItems.thunderWand, new ItemRenderer(new ThunderWand(), "textures/model/Mjoelnir.png"));
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
