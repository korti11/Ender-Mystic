package at.korti.endermystic.client.guis.book.entry;

import at.korti.endermystic.ModInfo;
import at.korti.endermystic.api.crafting.CraftingRecipe;
import at.korti.endermystic.client.guis.book.BookPage;
import at.korti.endermystic.client.guis.book.button.ImageButton;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Korti on 19.05.2015.
 */
public class BookCombiCrafting extends BookEntryImage{

    private CraftingRecipe recipe;

    public BookCombiCrafting(String name, BookPage prevEntry, CraftingRecipe recipe) {
        super(name, prevEntry, true, true);

        this.recipe = recipe;
        this.texture = new ResourceLocation(ModInfo.MODID + ":textures/gui/book/book_combi_crafting.png");
        this.setTextPosY(120);
    }

    @Override
    public void setWorldAndResolution(Minecraft mc, int width, int height) {
        super.setWorldAndResolution(mc, width, height);
        generateRecipe();
    }

    @Override
    public String getTitle() {
        if (recipe != null) {
            return recipe.getResult().getDisplayName();
        }
        return "";
    }

    @Override
    public String getText() {
        String timeToCraftText = LanguageRegistry.instance().getStringLocalization("book.crafting.timetocraft.name");
        String energyUseText = LanguageRegistry.instance().getStringLocalization("book.crafting.energyuse.name");
        if (timeToCraftText.equals("")) {
            timeToCraftText = LanguageRegistry.instance().getStringLocalization("book.crafting.timetocraft.name", "en_US");
        }
        if (energyUseText.equals("")) {
            energyUseText = LanguageRegistry.instance().getStringLocalization("book.crafting.energyuse.name", "en_US");
        }
        if(recipe.getTimeToCraft() != 0 && recipe.getEnergyUsePerTick() != 0) {
            return timeToCraftText + ": " + recipe.getTimeToCraft() + "    " + energyUseText + ": " + (recipe.getTimeToCraft() * recipe.getEnergyUsePerTick());
        }
        return "";
    }

    private void generateRecipe() {
        if(recipe != null) {
            int stackPerLine = recipe.requirementsCount() <= 5 ? recipe.requirementsCount() : recipe.requirementsCount() / 2;
            int y = recipe.requirementsCount() == stackPerLine ? this.posY + 45 : this.posY + 29;
            int x = (this.bookImageWidth / 2) - (stackPerLine * 16) + (8 * (stackPerLine - 1));
            for (int i = 0; i < recipe.requirementsCount(); i++) {
                if (i % stackPerLine == 0 && i != 0) {
                    y += 20;
                }
                //this.addStackImage(recipe.getRequirement(i), x + (16 * (i % stackPerLine)), y);
                this.buttonList.add(new ImageButton(2, this.posX + x + (16 * (i % stackPerLine)), y, recipe.getRequirement(i), fontRendererObj, this));
            }
            this.addStackImage(recipe.getResult(), (this.bookImageWidth / 2) - 13, this.posY + 95);
        }
    }
}
