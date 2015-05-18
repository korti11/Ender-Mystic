package at.korti.endermystic.client.guis.book.entry;

import at.korti.endermystic.client.guis.book.BookPage;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Korti on 18.05.2015.
 */
public class BookEntryItem extends BookEntry {

    private List<ItemStackImage> itemStackImages;

    public BookEntryItem(String name, BookPage prevEntry) {
        super(name, prevEntry);
        itemStackImages = new LinkedList<>();
    }

    public void addStackImage(ItemStack stack, int posX, int posY) {
        this.itemStackImages.add(new ItemStackImage(stack, posX, posY));
    }

    @Override
    public void drawScreen(int x, int y, float scale) {
        super.drawScreen(x, y, scale);
        for (int i = 0; i < itemStackImages.size(); i++) {
            ItemStackImage stackImage = itemStackImages.get(i);
            drawItemStack(stackImage.stack, this.posX + stackImage.posX, this.posY + stackImage.posY, "");
        }

    }

    private void drawItemStack(ItemStack stack, int posX, int posY, String p_146982_4_)
    {
        GL11.glTranslatef(0.0F, 0.0F, 32.0F);
        this.zLevel = 200.0F;
        itemRender.zLevel = 200.0F;
        FontRenderer font = null;
        if (stack != null) font = stack.getItem().getFontRenderer(stack);
        if (font == null) font = fontRendererObj;
        itemRender.renderItemAndEffectIntoGUI(font, this.mc.getTextureManager(), stack, posX, posY);
        itemRender.renderItemOverlayIntoGUI(font, this.mc.getTextureManager(), stack, posX, posY, p_146982_4_);
        this.zLevel = 0.0F;
        itemRender.zLevel = 0.0F;
    }

    class ItemStackImage{

        private ItemStack stack;
        private int posX;
        private int posY;

        public ItemStackImage(ItemStack stack, int posX, int posY) {
            this.stack = stack;
            this.posX = posX;
            this.posY = posY;
        }
    }
}
