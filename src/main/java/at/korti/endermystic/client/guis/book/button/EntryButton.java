package at.korti.endermystic.client.guis.book.button;

import at.korti.endermystic.client.guis.book.entry.BookEntry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import org.lwjgl.opengl.GL11;

/**
 * Created by Korti on 18.05.2015.
 */
public class EntryButton extends GuiButton {

    private FontRenderer fontRenderer;
    private BookEntry entry;

    public EntryButton(int id, int x, int y, FontRenderer fontRenderer, BookEntry entry) {
        super(id, x, y, "");

        this.fontRenderer = fontRenderer;
        this.entry = entry;
    }

    @Override
    public void drawButton(Minecraft mc, int posX, int posY) {
        if (this.visible) {
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            if (posX >= xPosition && posX < xPosition + fontRenderer.getStringWidth(entry.getTitle()) && posY >= yPosition && posY < yPosition + fontRenderer.FONT_HEIGHT) {
                fontRenderer.drawString(entry.getTitle(), this.xPosition, this.yPosition, 0xFF9933);
            } else {
                fontRenderer.drawString(entry.getTitle(), this.xPosition, this.yPosition, 0);
            }
        }
    }

    @Override
    public boolean mousePressed(Minecraft mc, int x, int y) {
        if(x >= xPosition && x < xPosition + fontRenderer.getStringWidth(entry.getTitle()) && y >= yPosition && y < yPosition + fontRenderer.FONT_HEIGHT) {
            mc.displayGuiScreen(entry);
        }
        return super.mousePressed(mc, x, y);
    }
}
