package at.korti.endermystic.client.guis.book;

import at.korti.endermystic.ModInfo;
import at.korti.endermystic.blocks.ModBlocks;
import at.korti.endermystic.client.guis.book.button.EntryButton;
import at.korti.endermystic.client.guis.book.button.NextPageButton;
import at.korti.endermystic.client.guis.book.entry.BookEntry;
import at.korti.endermystic.client.guis.book.entry.BookEntryItem;
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
public class BookPage extends GuiScreen{

    public static ResourceLocation texture = new ResourceLocation(ModInfo.MODID + ":textures/gui/book/book.png");
    protected int bookImageWidth = 192;
    protected int bookImageHeigth = 192;
    private boolean mainPage;
    private List<BookEntry> entries;

    public BookPage(boolean mainPage) {
        this.mainPage = mainPage;
        if(mainPage) {
            entries = new ArrayList<>();
            generateBookEntries();
        }
    }

    private void generateBookEntries() {
        BookEntry crystalCombiner = new BookEntry("CrystalCombiner", this);
        BookEntry crystalCombiner1 = new BookEntry("CrystalCombiner1", crystalCombiner);
        crystalCombiner.setNextEntry(crystalCombiner1);

        BookEntry orbInfuser = new BookEntry("OrbInfuser", this);
        BookEntry orbInfuser1 = new BookEntry("OrbInfuser1", orbInfuser);
        orbInfuser.setNextEntry(orbInfuser1);

        BookEntry energyNetwork = new BookEntry("Network", this);
        BookEntryItem energyDrainSub = new BookEntryItem("EnergyDrain", energyNetwork);
        energyDrainSub.addStackImage(new ItemStack(ModBlocks.energyDrain), 38, 22);
        energyDrainSub.setTextPosY(35);
        BookEntryItem energyDrainMain = new BookEntryItem("EnergyDrain", this);
        energyDrainMain.addStackImage(new ItemStack(ModBlocks.energyDrain), 38, 22);
        energyDrainMain.setTextPosY(35);
        energyNetwork.setNextEntry(energyDrainSub);

        entries.add(crystalCombiner);
        entries.add(orbInfuser);
        entries.add(energyNetwork);
        entries.add(energyDrainMain);
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
        //drawEntrys();
        super.drawScreen(x, y, scale);
    }

    private void drawEntrys() {
        if (entries != null) {
            int posX = (this.width - this.bookImageWidth) / 2;
            int posY = 2;
            for (int i = 0; i < entries.size(); i++) {
                //super.fontRendererObj.drawString(entries.get(i).getTitle(), posX + 38, posY + 22 + (12 * i), 0);
                this.buttonList.add(new EntryButton(i, posX + 38, posY + 22 + (12 * i), fontRendererObj, entries.get(i)));
            }
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
