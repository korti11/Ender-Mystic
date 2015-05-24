package at.korti.endermystic.client.guis.book.button;

import at.korti.endermystic.api.crafting.CraftingRegistry;
import at.korti.endermystic.client.guis.book.BookPage;
import at.korti.endermystic.client.guis.book.entry.BookCombiCrafting;
import at.korti.endermystic.client.guis.book.entry.BookCraftingTable;
import at.korti.endermystic.client.guis.book.entry.BookEntry;
import at.korti.endermystic.client.guis.book.entry.BookEntryImage;
import at.korti.endermystic.crafting.CraftingManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

/**
 * Created by Korti on 19.05.2015.
 */
public class ImageButton extends GuiButton{

    private RenderItem itemRender;
    private Minecraft mc;
    private FontRenderer fontRendererObj;
    private ItemStack stack;
    private BookPage nextPage;

    public ImageButton(int id, int posX, int posY, ItemStack stack, FontRenderer fontRenderer, BookPage prevPage) {
        super(id, posX, posY, "");

        this.stack = stack;
        this.itemRender = new RenderItem();
        this.mc = Minecraft.getMinecraft();
        this.fontRendererObj = fontRenderer;
        if(CraftingRegistry.getInstance().getCraftingRecipe(stack) != null) {
            this.nextPage = new BookCombiCrafting(stack.getDisplayName(), prevPage, CraftingRegistry.getInstance().getCraftingRecipe(stack));
        }
        else if (CraftingManager.findRecipeFor(stack) != null) {
            this.nextPage = new BookCraftingTable(stack.getDisplayName(), prevPage, stack);
        }
        BookPage prevNext = ((BookEntry)prevPage).getNextEntry();
        BookEntry bookEntry = new BookEntry(stack.getItem().getClass().getSimpleName(), stack.getUnlocalizedName() + ".name", prevPage);
        if (bookEntry.getText() != "" && this.nextPage != null) {
            bookEntry.setNextEntry(this.nextPage);
            ((BookEntry) this.nextPage).setPrevEntry(bookEntry);
            this.nextPage = bookEntry;
        }
        ((BookEntry) prevPage).setNextEntry(prevNext);
    }

    @Override
    public void drawButton(Minecraft mc, int posX, int posY) {
        if (this.visible) {
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            drawItemStack(stack, xPosition, yPosition, "");
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

    public ItemStack getStack() {
        return stack;
    }

    @Override
    public boolean mousePressed(Minecraft mc, int posX, int posY) {
        if (posX >= xPosition && posX < xPosition + 16 && posY >= yPosition && posY < yPosition + 16 && this.nextPage != null) {
            mc.displayGuiScreen(this.nextPage);
        }
        return super.mousePressed(mc, posX, posY);
    }
}
