package at.korti.endermystic.modintegration.cofh;

import at.korti.endermystic.ModInfo;
import at.korti.endermystic.client.render.blocks.TileEntityBlockRenderer;
import at.korti.endermystic.client.render.items.TileEntityItemRenderer;
import at.korti.endermystic.items.ModItems;
import at.korti.endermystic.modintegration.IIntegration;
import at.korti.endermystic.modintegration.cofh.blocks.MysticConverter;
import at.korti.endermystic.modintegration.cofh.client.model.MysticConverterModel;
import at.korti.endermystic.modintegration.cofh.tileentity.TileEntities;
import at.korti.endermystic.modintegration.cofh.tileentity.TileEntityMysticConverter;
import at.korti.endermystic.proxy.ClientProxy;
import cofh.thermalexpansion.item.TEItems;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;

/**
 * Created by Korti on 05.06.2015.
 */
public class Cofh implements IIntegration {

    public static MysticConverter mysticConverter;

    private void initBlocks() {
        mysticConverter = new MysticConverter();
    }

    private void loadBlocks() {
        GameRegistry.registerBlock(mysticConverter, "MysticConverter");
    }

    @Override
    public void preInit() {

    }

    @Override
    public void init() {
        TileEntities.init();
        initBlocks();
        loadBlocks();
    }

    @Override
    public void posInit() {

    }

    @Override
    public void clientInit() {
        ClientProxy.registerTileEntityRenderer(mysticConverter, TileEntityMysticConverter.class, new MysticConverterModel(), "textures/model/MysticDynamo.png");
    }

    @Override
    public void constructCraftingRecipes() {
        if (Loader.isModLoaded(ModInfo.THERMALEXPANSION)) {
            GameRegistry.addShapedRecipe(new ItemStack(Cofh.mysticConverter),
                    "HCH",
                    "IEI",
                    "HHH", 'H', new ItemStack(Blocks.hardened_clay), 'C', TEItems.powerCoilGold.copy(), 'I', new ItemStack(Items.iron_ingot), 'E', new ItemStack(ModItems.crystalItem, 1, 7)
            );
        } else if(Loader.isModLoaded(ModInfo.COFH)) {
            GameRegistry.addShapedRecipe(new ItemStack(Cofh.mysticConverter),
                    "HIH",
                    "IEI",
                    "HHH", 'H', new ItemStack(Blocks.hardened_clay), 'I', new ItemStack(Items.iron_ingot), 'E', new ItemStack(ModItems.crystalItem, 1, 7)
            );
        }
    }
}
