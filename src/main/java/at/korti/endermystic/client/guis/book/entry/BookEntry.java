package at.korti.endermystic.client.guis.book.entry;

import at.korti.endermystic.client.guis.book.BookPage;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.registry.LanguageRegistry;

import java.util.List;

/**
 * Created by Korti on 18.05.2015.
 */
public class BookEntry extends BookPage {

    private String name;
    private String title;
    private BookPage prevEntry;
    private BookPage nextEntry;
    protected int posX;
    protected int posY;
    protected int textPosX;
    protected int textPosY;
    protected boolean showText;

    public BookEntry(String name, BookPage prevEntry) {
        super(false);
        this.name = name;
        this.prevEntry = prevEntry;
        this.textPosX = 38;
        this.textPosY = 46;
        this.showText = true;
        boolean isListEntry = prevEntry instanceof BookCraftingTable || prevEntry instanceof BookCombiCrafting ? !(((BookEntry)prevEntry).getPrevEntry() instanceof BookEntryItemList) : true;
        if(prevEntry instanceof BookEntry && isListEntry) {
            ((BookEntry) prevEntry).setNextEntry(this);
        }
    }

    public BookEntry(String name, String title, BookPage prevEntry) {
        this(name, prevEntry);

        this.title = title;
    }

    public BookEntry(String name, BookPage prevEntry, boolean showText) {
        this(name, prevEntry);

        this.showText = showText;
    }

    public BookEntry(String name, String title, BookPage prevEntry, boolean showText) {
        this(name, title, prevEntry);

        this.showText = showText;
    }

    public String getTitle() {
        if(this.title == null) {
            String title = LanguageRegistry.instance().getStringLocalization("book.entry." + name + ".title");
            if (title.equals("")) {
                return LanguageRegistry.instance().getStringLocalization("book.entry." + name + ".title", "en_US");
            }
            return title;
        }
        else {
            String title = LanguageRegistry.instance().getStringLocalization(this.title);
            if (title.equals("")) {
                return LanguageRegistry.instance().getStringLocalization(this.title, "en_US");
            }
            return title;
        }
    }

    public String getText() {
        String text = LanguageRegistry.instance().getStringLocalization("book.entry." + name + ".text");
        if (text.equals("")) {
            return LanguageRegistry.instance().getStringLocalization("book.entry." + name + ".text", "en_US");
        }
        return text;
    }

    public BookPage getPrevEntry() {
        return prevEntry;
    }

    public void setPrevEntry(BookPage entry){
        this.prevEntry = entry;
    }

    public BookPage getNextEntry() {
        return nextEntry;
    }

    public void setNextEntry(BookPage entry) {
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
        if(showText) {
            List<String> lines = this.fontRendererObj.listFormattedStringToWidth(getText(), (this.bookImageWidth / 2) + 14);
            for (int i = 0; i < lines.size(); i++) {
                this.fontRendererObj.drawString(lines.get(i), posX + textPosX, posY + textPosY + (12 * i), 0);
            }
        }
    }
}