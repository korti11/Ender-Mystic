package at.korti.endermystic.client.guis.book;

import at.korti.endermystic.ModInfo;
import at.korti.endermystic.api.tools.ToolLevelHandler;
import at.korti.endermystic.api.tools.ToolUpgrade;
import at.korti.endermystic.blocks.ModBlocks;
import at.korti.endermystic.client.guis.book.button.EntryButton;
import at.korti.endermystic.client.guis.book.button.NextPageButton;
import at.korti.endermystic.client.guis.book.entry.BookEntry;
import at.korti.endermystic.client.guis.book.entry.BookEntryImage;
import at.korti.endermystic.client.guis.book.entry.BookEntryItemList;
import at.korti.endermystic.items.ModItems;
import at.korti.endermystic.modintegration.baubles.Baubles;
import at.korti.endermystic.modintegration.cofh.Cofh;
import cpw.mods.fml.common.Loader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Korti on 16.04.2015.
 */
public class BookPage extends GuiScreen implements Cloneable {

    public static ResourceLocation defaultTexture = new ResourceLocation(ModInfo.MODID + ":textures/gui/book/book.png");
    public ResourceLocation texture = defaultTexture;
    protected int bookImageWidth = 192;
    protected int bookImageHeigth = 192;
    private boolean mainPage;
    private List<BookEntry> entries;

    public BookPage(boolean mainPage) {
        this.mainPage = mainPage;
        if(mainPage) {
            entries = new ArrayList<>();
            generateEntries();
        }
    }

    public void generateEntries() {
        //Blocks
        BookEntryItemList blockList = new BookEntryItemList("Blocks", this);
        blockList.addItem(new ItemStack(ModBlocks.crystalCombiner));
        blockList.addItem(new ItemStack(ModBlocks.orbInfuser));
        blockList.addItem(new ItemStack(ModBlocks.energyDrain));
        blockList.addItem(new ItemStack(ModBlocks.energyRelay));
        blockList.addItem(new ItemStack(ModBlocks.energyCrystalStorage));
        blockList.addItem(new ItemStack(ModBlocks.enderPicker));
        blockList.addItem(new ItemStack(ModBlocks.enderInjector));

        //Crystals and Crystal Combiner
        BookEntry crystalCombiner = new BookEntry("CrystalCombiner", this);
        BookEntry crystalEntry = new BookEntry("Crystal", crystalCombiner);
        BookEntryItemList crystalList = new BookEntryItemList("CrystalList", crystalEntry, ModItems.crystalItem);

        //Orb Infuser
        BookEntry orbInfuser = new BookEntry("OrbInfuser", this);
        BookEntryItemList orbCoreList = new BookEntryItemList("OrbCoreList", orbInfuser, ModItems.orbCoreItem);

        //Energy Network
        BookEntry energyNetwork = new BookEntry("Network", this);

        BookEntryImage energyDrainSub = new BookEntryImage("EnergyDrain", energyNetwork, false);
        energyDrainSub.addStackImage(new ItemStack(ModBlocks.energyDrain), 38, 22);
        energyDrainSub.addStackImage(new ItemStack(ModItems.crystalItem, 1, 7), 130, 18);

        BookEntryImage energyCrystalStorage = new BookEntryImage("EnergyCrystalStorage", energyDrainSub, false);
        energyCrystalStorage.addStackImage(new ItemStack(ModBlocks.energyCrystalStorage), 38, 22);

        BookEntryImage energyCrystal = new BookEntryImage("EnergyCrystal", energyCrystalStorage, false);
        energyCrystal.addStackImage(new ItemStack(ModItems.crystalItem, 1, 7), 34, 18);

        //Player Network
        BookEntry playerNetwork = new BookEntry("PlayerNetwork", this);

        BookEntryImage enderSacfrice = new BookEntryImage("EnderSacrifice", ModItems.enderSacrifice.getUnlocalizedName() + ".name", playerNetwork, false);
        enderSacfrice.addStackImage(new ItemStack(ModItems.enderSacrifice), 34, 22);
        BookEntry capacityOrb = new BookEntry("CapacityOrb", enderSacfrice);

        //Orbs
        BookEntry orbEntry = new BookEntry("Orb", this);

        BookEntryItemList orbList = new BookEntryItemList("OrbList", orbEntry);
        orbList.addItem(new ItemStack(ModItems.enderOrb));
        orbList.addItem(new ItemStack(ModItems.apprenticeOrb));
        orbList.addItem(new ItemStack(ModItems.guardiansOrb));
        orbList.addItem(new ItemStack(ModItems.masterOrb));
        orbList.addItem(new ItemStack(ModItems.galaxyOrb));
        orbList.addItem(new ItemStack(ModItems.universeOrb));
        orbList.addItem(new ItemStack(ModItems.airOrb));
        orbList.addItem(new ItemStack(ModItems.emeraldOrb));
        orbList.addItem(new ItemStack(ModItems.earthOrb));
        orbList.addItem(new ItemStack(ModItems.enderZarOrb));
        orbList.addItem(new ItemStack(ModItems.fireOrb));
        orbList.addItem(new ItemStack(ModItems.waterOrb));

        //Tools
        BookEntryItemList toolList = new BookEntryItemList("ToolList", this);
        toolList.addItem(new ItemStack(ModItems.enderSoulSword));
        toolList.addItem(new ItemStack(ModItems.enderSoulPickaxe));
        toolList.addItem(new ItemStack(ModItems.enderSoulShovel));
        toolList.addItem(new ItemStack(ModItems.enderSoulHammer));
        toolList.addItem(new ItemStack(ModItems.enderSoulExcavator));

        BookEntry toolLevel = new BookEntry("ToolLevel", toolList);

        BookEntryImage luckEntry = new BookEntryImage("Luck", ToolUpgrade.luck.getLocolizeKey(), toolLevel, true);
        ItemStack tool = new ItemStack(ModItems.enderSoulPickaxe);
        ToolLevelHandler.getInstance().addUpgrad(tool, ToolUpgrade.luck.getId(), ToolUpgrade.luck.getMaxLevel());
        luckEntry.addStackImage(tool, 38, 22);

        BookEntryImage hasteEntry = new BookEntryImage("Haste", ToolUpgrade.haste.getLocolizeKey(), luckEntry, true);
        tool = new ItemStack(ModItems.enderSoulPickaxe);
        ToolLevelHandler.getInstance().addUpgrad(tool, ToolUpgrade.haste.getId(), ToolUpgrade.haste.getMaxLevel());
        hasteEntry.addStackImage(tool, 38, 22);

        BookEntryImage silkEntry = new BookEntryImage("SilkTouch", ToolUpgrade.silkTouch.getLocolizeKey(), hasteEntry, true);
        tool = new ItemStack(ModItems.enderSoulPickaxe);
        ToolLevelHandler.getInstance().addUpgrad(tool, ToolUpgrade.silkTouch.getId(), ToolUpgrade.silkTouch.getMaxLevel());
        silkEntry.addStackImage(tool, 38, 22);

        BookEntryImage sharpnessEntry = new BookEntryImage("Sharpness", ToolUpgrade.sharpness.getLocolizeKey(), silkEntry, true);
        tool = new ItemStack(ModItems.enderSoulSword);
        ToolLevelHandler.getInstance().addUpgrad(tool, ToolUpgrade.sharpness.getId(), ToolUpgrade.sharpness.getMaxLevel());
        sharpnessEntry.addStackImage(tool, 38, 22);

        BookEntryImage autoSmeltEntry = new BookEntryImage("AutoSmelt", ToolUpgrade.autoSmelt.getLocolizeKey(), sharpnessEntry, true);
        tool = new ItemStack(ModItems.enderSoulPickaxe);
        ToolLevelHandler.getInstance().addUpgrad(tool, ToolUpgrade.autoSmelt.getId(), ToolUpgrade.autoSmelt.getMaxLevel());
        autoSmeltEntry.addStackImage(tool, 38, 22);

        BookEntryImage fireyEntry = new BookEntryImage("Firey", ToolUpgrade.firey.getLocolizeKey(), autoSmeltEntry, true);
        tool = new ItemStack(ModItems.enderSoulSword);
        ToolLevelHandler.getInstance().addUpgrad(tool, ToolUpgrade.firey.getId(), ToolUpgrade.firey.getMaxLevel());
        fireyEntry.addStackImage(tool, 38, 22);

        //Armor
        BookEntry enderSoulArmorEntry = new BookEntry("EnderSoulArmorBook", this);
        BookEntryItemList enderSoulArmorList = new BookEntryItemList("EnderSoulArmorBook", enderSoulArmorEntry);
        enderSoulArmorList.addItem(new ItemStack(ModItems.enderSoulHelmet));
        enderSoulArmorList.addItem(new ItemStack(ModItems.enderSoulBreastplate));
        enderSoulArmorList.addItem(new ItemStack(ModItems.enderSoulLegs));

        //Util
        BookEntryItemList utilEntry = new BookEntryItemList("Util", this);
        utilEntry.addItem(new ItemStack(ModItems.enderSacrifice));
        utilEntry.addItem(new ItemStack(ModItems.enderSoulFill));
        utilEntry.addItem(new ItemStack(ModItems.worldStorageLevelOne));
        utilEntry.addItem(new ItemStack(ModItems.worldStorageLevelTwo));
        utilEntry.addItem(new ItemStack(ModItems.worldStorageLevelThree));
        utilEntry.addItem(new ItemStack(ModItems.worldStorageLevelFour));

        entries.add(blockList);
        entries.add(crystalCombiner);
        entries.add(orbInfuser);
        entries.add(energyNetwork);
        entries.add(playerNetwork);
        entries.add(orbEntry);
        entries.add(toolList);
        entries.add(enderSoulArmorEntry);
        entries.add(utilEntry);

        if (Loader.isModLoaded(ModInfo.BAUBLES)) {
            entries.add(Baubles.addBookEntry(this));
        }
        if (Loader.isModLoaded(ModInfo.COFH)) {
            entries.add(Cofh.addBookEntrys(this));
        }
    }

    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.clear();

        int posX = (this.width - this.bookImageWidth) / 2;
        int posY = 2;

        if(!mainPage) {
            if(((BookEntry)this).getNextEntry() != null) {
                this.buttonList.add(new NextPageButton(0, posX + 120, posY + 154, true, (BookEntry) this));
            }
            this.buttonList.add(new NextPageButton(1, posX + 38, posY + 154, false, (BookEntry)this));
        }
        else {
            drawEntrys();
        }
    }

    @Override
    public void drawScreen(int x, int y, float scale) {
        super.drawDefaultBackground();
        GL11.glColor4f(1F, 1F, 1F, 1F);
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        int posX = (super.width - this.bookImageWidth) / 2;
        int posY = 2;
        super.drawTexturedModalRect(posX, posY, 0, 0, this.bookImageWidth, this.bookImageHeigth);
        super.drawScreen(x, y, scale);
    }

    private void drawEntrys() {
        if (entries != null) {
            int posX = (this.width - this.bookImageWidth) / 2;
            int posY = 2;
            for (int i = 0; i < entries.size(); i++) {
                this.buttonList.add(new EntryButton(i, posX + 38, posY + 22 + (12 * i), fontRendererObj, entries.get(i)));
            }
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    public BookPage clone() {
        try {
            return (BookPage) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setEntries(List<BookEntry> entries) {
        this.entries = entries;
    }
}
