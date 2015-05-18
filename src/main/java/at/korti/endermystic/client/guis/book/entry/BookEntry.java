package at.korti.endermystic.client.guis.book.entry;

import at.korti.endermystic.client.guis.book.BookPage;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.client.Minecraft;

import java.util.List;

/**
 * Created by Korti on 18.05.2015.
 */
public class BookEntry extends BookPage {

    private String name;
    private BookPage prevEntry;
    private BookPage nextEntry;
    protected int posX;
    protected int posY;
    protected int textPosX;
    protected int textPosY;

    public BookEntry(String name, BookPage prevEntry) {
        super(false);
        this.name = name;
        this.prevEntry = prevEntry;
        this.textPosX = 38;
        this.textPosY = 46;
    }

    public String getTitle() {
        return LanguageRegistry.instance().getStringLocalization("book.entry." + name + ".title");
    }

    public String getText() {
        return LanguageRegistry.instance().getStringLocalization("book.entry." + name + ".text");
    }

    public BookPage getPrevEntry() {
        return prevEntry;
    }

    public BookPage getNextEntry() {
        return nextEntry;
    }

    public void setNextEntry(BookEntry entry) {
        this.nextEntry = entry;
    }

    public void setTextPosX(int posX) {
        this.textPosX = posX;
    }

    public void setTextPosY(int posY) {
        this.textPosY = posY;
    }

    @Override
    public void setWorldAndResolution(Minecraft mc, int width, int height) {
        super.setWorldAndResolution(mc, width, height);
        this.posX = (this.width - this.bookImageWidth) / 2;
        this.posY = 2;
    }

    @Override
    public void drawScreen(int x, int y, float scale) {
        super.drawScreen(x, y, scale);
        this.fontRendererObj.drawString(getTitle(), posX + (this.bookImageWidth / 2) - (fontRendererObj.getStringWidth(getTitle()) / 2) - 5, posY + 22, 0);
        List<String> lines = this.fontRendererObj.listFormattedStringToWidth(getText(), (this.bookImageWidth / 2) + 14);
        for (int i = 0; i < lines.size(); i++) {
            this.fontRendererObj.drawString(lines.get(i), posX + 38, posY + 46 + (12 * i), 0);
        }
    }
}