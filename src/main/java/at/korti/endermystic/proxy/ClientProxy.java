package at.korti.endermystic.proxy;

import at.korti.endermystic.blocks.ModBlocks;
import at.korti.endermystic.client.keybinding.KeyHandler;
import at.korti.endermystic.client.render.blocks.*;
import at.korti.endermystic.client.render.items.TileEntityItemRenderer;
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
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEnergyRelay.class, new EnergyRelayRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEnderZar.class, new EnderZarRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOrbInfuser.class, new OrbInfuserRenderer());

        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.energyDrain), new TileEntityItemRenderer(new EnergyDrainRenderer(), new TileEntityEnergyDrain()));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.energyRelay), new TileEntityItemRenderer(new EnergyRelayRenderer(), new TileEntityEnergyRelay()));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.crystalCombiner), new TileEntityItemRenderer(new CrystalCombinerRenderer(), new TileEntityCrystalCombiner()));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.enderZar), new TileEntityItemRenderer(new EnderZarRenderer(), new TileEntityEnderZar()));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.orbInfuser), new TileEntityItemRenderer(new OrbInfuserRenderer(), new TileEntityOrbInfuser()));
    }

    @Override
    public void registerDisplayInfromation() {
        BlockRenderConfig.CrystelOreRenderId = RenderingRegistry.getNextAvailableRenderId();
        this.registerBlockRendere(new CrystalOreRenderer());
    }

    private void registerBlockRendere(ISimpleBlockRenderingHandler renderer){
        RenderingRegistry.registerBlockHandler(renderer);
    }

    @Override
    public void initKeys() {
        KeyHandler.init();
    }
}
