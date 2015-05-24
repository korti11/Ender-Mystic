package at.korti.endermystic.client.guis.book.entry;

import at.korti.endermystic.ModInfo;
import at.korti.endermystic.client.guis.book.BookPage;
import at.korti.endermystic.client.guis.book.button.ImageButton;
import at.korti.endermystic.crafting.CraftingManager;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Korti on 20.05.2015.
 */
public class BookCraftingTable extends BookEntryImage{

    private IRecipe recipe;

    public BookCraftingTable(String name, BookPage prevEntry, ItemStack stackToCraft) {
        super(name, prevEntry, true);

        recipe = CraftingManager.findRecipeFor(stackToCraft);
        this.texture = new ResourceLocation(ModInfo.MODID + ":textures/gui/book/book_craftingtable.png");
    }

    @Override
    public void setWorldAndResolution(Minecraft mc, int width, int height) {
        super.setWorldAndResolution(mc, width, height);

        generateRecipe();
    }

    @Override
    public String getTitle() {
        return recipe.getRecipeOutput().getDisplayName();
    }

    private void generateRecipe() {
        ItemStack[] requirements = new ItemStack[9];
        int craftingWidth = 3;
        if (this.recipe instanceof ShapedRecipes) {
            ShapedRecipes recipe = (ShapedRecipes) this.recipe;
            requirements = recipe.recipeItems;
            craftingWidth = recipe.recipeWidth;
        } else {
            ShapelessRecipes recipe = (ShapelessRecipes) this.recipe;
            for (int i = 0; i < recipe.recipeItems.size(); i++) {
                if (i == 9) {
                    break;
                }
                requirements[i] = (ItemStack) recipe.recipeItems.get(i);
            }
        }

        int y = this.posY + 36;

        for (int i = 0; i < requirements.length; i++) {
            if (i % craftingWidth == 0 && i != 0) {
                y += 26;
            }
            //addStackImage(requirements[i], 55 + (25 * (i % craftingWidth)), y);
            if(requirements[i] != null) {
                this.buttonList.add(new ImageButton(2, this.posX + 55 + (25 * (i % craftingWidth)), y, requirements[i], fontRendererObj, this));
            }
        }

        addStackImage(recipe.getRecipeOutput(), 80, 125);
    }
}
