package at.korti.endermystic.client.guis.book.entry;

import at.korti.endermystic.client.guis.book.BookPage;
import at.korti.endermystic.client.guis.book.button.ImageButton;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Korti on 19.05.2015.
 */
public class BookEntryItemList extends BookEntry {

    private List<ItemStack> items;

    public BookEntryItemList(String name, BookPage prevEntry, Item item) {
        this(name, prevEntry);

        item.getSubItems(item, null, items);
    }

    public BookEntryItemList(String name, BookPage prevEntry) {
        super(name, prevEntry);

        items = new ArrayList<>();
    }

    @Override
    public void initGui() {
        super.initGui();

    }

    @Override
    public void setWorldAndResolution(Minecraft mc, int width, int height) {
        super.setWorldAndResolution(mc, width, height);
        generateButtons();
    }

    @Override
    public void drawScreen(int x, int y, float scale) {
        super.drawScreen(x, y, scale);

        for (int i = 0; i < buttonList.size(); i++) {
            if (buttonList.get(i) instanceof ImageButton) {
                ImageButton button = (ImageButton) buttonList.get(i);
                if (x >= button.xPosition && x < button.xPosition + 16 && y >= button.yPosition && y < button.yPosition + 16) {
                    this.renderToolTip(button.getStack(), x, y);
                }
            }
        }
    }

    public void generateButtons() {
        int y = this.posY + 35;
        for (int i = 0; i < items.size(); i++) {
            if (i % 7 == 0 && i != 0) {
                y += 16;
            }
            buttonList.add(new ImageButton(i + 2, this.posX + 38 + (16 * (i % 7)), y, items.get(i), fontRendererObj, this));
        }
    }

    public void addItem(ItemStack stack) {
        items.add(stack);
    }
}
