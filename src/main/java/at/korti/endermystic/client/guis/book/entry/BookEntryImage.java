package at.korti.endermystic.client.guis.book.entry;

import at.korti.endermystic.client.guis.book.BookPage;
import at.korti.endermystic.client.guis.book.button.ImageButton;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Korti on 18.05.2015.
 */
public class BookEntryImage extends BookEntry {

    protected List<ItemStackImage> itemStackImages;
    private boolean renderToolTip;

    public BookEntryImage(String name, BookPage prevEntry, boolean renderToolTip, boolean showText) {
        super(name, prevEntry, showText);
        itemStackImages = new LinkedList<>();
        this.renderToolTip = renderToolTip;
    }

    public BookEntryImage(String name, String title, BookPage prevEntry, boolean renderToolTip, boolean showText) {
        super(name, title, prevEntry, showText);

        itemStackImages = new LinkedList<>();
        this.renderToolTip = renderToolTip;
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

        if (renderToolTip) {
            for (int i = 0; i < itemStackImages.size(); i++) {
                ItemStackImage image = itemStackImages.get(i);
                if (x >= this.posX + image.getPosX() && x < this.posX + image.getPosX() + 16 && y >= this.posY + image.getPosY() && y < this.posY + image.getPosY() + 16 && image.getStack() != null) {
                    this.renderToolTip(image.getStack(), x, y);
                }
            }
            for (int i = 0; i < buttonList.size(); i++) {
                if (buttonList.get(i) instanceof ImageButton) {
                    ImageButton button = (ImageButton) buttonList.get(i);
                    if (x >= button.xPosition && x < button.xPosition + 16 && y >= button.yPosition && y < button.yPosition + 16) {
                        this.renderToolTip(button.getStack(), x, y);
                    }
                }
            }
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

    public class ItemStackImage{

        private ItemStack stack;
        private int posX;
        private int posY;

        public ItemStackImage(ItemStack stack, int posX, int posY) {
            this.stack = stack;
            this.posX = posX;
            this.posY = posY;
        }

        public ItemStack getStack() {
            return stack;
        }

        public int getPosX() {
            return posX;
        }

        public int getPosY() {
            return posY;
        }
    }
}
