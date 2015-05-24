package at.korti.endermystic.client.guis.book.button;

import at.korti.endermystic.client.guis.book.BookPage;
import at.korti.endermystic.client.guis.book.entry.BookEntry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import org.lwjgl.opengl.GL11;

/**
 * Created by Korti on 18.05.2015.
 */
public class NextPageButton extends GuiButton {

    private boolean nextButton;
    private BookEntry entry;

    public NextPageButton(int id, int posX, int posY, boolean nextButton, BookEntry entry) {
        super(id, posX, posY, 23, 13, "");
        this.nextButton = nextButton;

        this.entry = entry;
    }

    @Override
    public void drawButton(Minecraft mc, int posX, int posY) {
        if (this.visible) {
            boolean flag = posX >= this.xPosition && posY >= this.yPosition && posX < this.xPosition + this.width && posY < this.yPosition + this.height;
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            mc.renderEngine.bindTexture(BookPage.defaultTexture);
            int k = 0;
            int l = 192;

            if(flag) {
                k += 23;
            }

            if (!nextButton) {
                l += 13;
            }

            this.drawTexturedModalRect(this.xPosition, this.yPosition, k, l, 23, 13);
        }
    }

    @Override
    public boolean mousePressed(Minecraft mc, int x, int y) {
        if (nextButton && entry.getNextEntry() != null && x >= this.xPosition && x < this.xPosition + 23 && y >= this.yPosition && y < this.yPosition + 13) {
            mc.displayGuiScreen(entry.getNextEntry());
        }
        else if (x >= this.xPosition && x < this.xPosition + 23 && y >= this.yPosition && y < this.yPosition + 13) {
            mc.displayGuiScreen(entry.getPrevEntry());
        }
        return super.mousePressed(mc, x, y);
    }
}
