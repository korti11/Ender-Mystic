package at.korti.endermystic.modintegration.baubles;

import at.korti.endermystic.ModInfo;
import at.korti.endermystic.client.guis.book.BookPage;
import at.korti.endermystic.client.guis.book.entry.BookEntry;
import at.korti.endermystic.client.guis.book.entry.BookEntryItemList;
import at.korti.endermystic.items.ModItems;
import at.korti.endermystic.modintegration.IIntegration;
import at.korti.endermystic.modintegration.baubles.belts.AirBelt;
import at.korti.endermystic.modintegration.baubles.rings.AirRing;
import at.korti.endermystic.modintegration.baubles.rings.FireRing;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by Korti on 02.06.2015.
 */
public class Baubles implements IIntegration{

    public static boolean isLoaded = false;
    public static final String baublesVersion = baubles.common.Baubles.class.getAnnotation(Mod.class).version();

    public static AirRing airRing;
    public static FireRing fireRing;
    public static AirBelt airBelt;

    private void initItems(){
        airRing = new AirRing();
        fireRing = new FireRing();
        airBelt = new AirBelt();
    }

    private void loadItems() {
        GameRegistry.registerItem(airRing, airRing.getName());
        GameRegistry.registerItem(fireRing, fireRing.getName());
        GameRegistry.registerItem(airBelt, airBelt.getName());
    }

    @Override
    public void preInit() {
        isLoaded = Loader.isModLoaded(ModInfo.BAUBLES);
        if (isLoaded) {
            initItems();
            loadItems();
        }
    }

    @Override
    public void init() {

    }

    @Override
    public void posInit() {

    }

    @Override
    public void clientPostInit() {

    }

    @Override
    public void constructCraftingRecipes() {
        if(Baubles.isLoaded) {
            GameRegistry.addShapedRecipe(new ItemStack(Baubles.airBelt),
                    " L ",
                    "L L",
                    "OL ", 'L', new ItemStack(Items.leather), 'O', new ItemStack(ModItems.airOrb)
            );
            GameRegistry.addShapedRecipe(new ItemStack(Baubles.airRing),
                    "OG ",
                    "G G",
                    " G ", 'G', new ItemStack(Items.gold_ingot), 'O', new ItemStack(ModItems.airOrb)
            );
            GameRegistry.addShapedRecipe(new ItemStack(Baubles.fireRing),
                    "OG ",
                    "G G",
                    " G ", 'G', new ItemStack(Items.gold_ingot), 'O', new ItemStack(ModItems.fireOrb)
            );
        }
    }

    public static BookEntry addBookEntry(BookPage mainPage) {
        BookEntry baubles = new BookEntry("Baubles", mainPage);
        BookEntryItemList baublesItems = new BookEntryItemList("BaublesItems", baubles);
        baublesItems.addItem(new ItemStack(Baubles.airBelt));
        baublesItems.addItem(new ItemStack(Baubles.airRing));
        baublesItems.addItem(new ItemStack(Baubles.fireRing));

        return baubles;
    }
}
