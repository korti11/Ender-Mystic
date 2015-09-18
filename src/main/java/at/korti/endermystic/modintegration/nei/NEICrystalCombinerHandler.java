package at.korti.endermystic.modintegration.nei;

import at.korti.endermystic.ModInfo;
import at.korti.endermystic.api.crafting.CraftingRegistry;
import at.korti.endermystic.api.crafting.CrystalCombinerRecipe;
import codechicken.lib.gui.GuiDraw;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.api.IOverlayHandler;
import codechicken.nei.api.IRecipeOverlayRenderer;
import codechicken.nei.recipe.TemplateRecipeHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Korti on 18.09.2015.
 */
public class NEICrystalCombinerHandler extends TemplateRecipeHandler {

    public class CachedCrystalCombinerRecipe extends CachedRecipe {

        private List<PositionedStack> input;
        private PositionedStack output;
        private int energyUse;

        public CachedCrystalCombinerRecipe(CrystalCombinerRecipe recipe) {
            this.input = new LinkedList<>();
            for (int i = 0; i < recipe.getRequirements().length; i++) {
                if (recipe.getRequirement(i) != null) {
                    input.add(new PositionedStack(recipe.getRequirement(i), getXForSlot(i), getYForSlot(i), false));
                }
            }
            this.output = new PositionedStack(recipe.getResult(), 64, 40, false);
            this.energyUse = recipe.getEnergyUsePerTick() * recipe.getTimeToCraft();
        }

        private int getXForSlot(int slot) {
            switch (slot) {
                case 0:
                    return 64;
                case 1:
                    return 32;
                case 2:
                    return 64;
                case 3:
                    return 96;
                default:
                    return 0;
            }
        }

        private int getYForSlot(int slot) {
            switch (slot) {
                case 0:
                    return 8;
                case 1:
                    return 40;
                case 2:
                    return 72;
                case 3:
                    return 40;
                default:
                    return 0;
            }
        }

        @Override
        public List<PositionedStack> getIngredients() {
            return input;
        }

        @Override
        public PositionedStack getResult() {
            return output;
        }
    }

    @Override
    public void loadCraftingRecipes(ItemStack result) {
        CrystalCombinerRecipe recipe = CraftingRegistry.getInstance().getCrystalCombinerRecipe(result);
        if(recipe != null && recipe.getResult() != null) {
            if (NEIServerUtils.areStacksSameTypeCrafting(recipe.getResult(), result)) {
                arecipes.add(new CachedCrystalCombinerRecipe(recipe));
            }
        }
    }

    @Override
    public void drawBackground(int recipe) {
        GL11.glColor4f(1, 1, 1, 1);
        GuiDraw.changeTexture(getGuiTexture());
        GuiDraw.drawTexturedModalRect(0, 0, 5, 11, 117, 117);
    }

    @Override
    public void drawExtras(int recipe) {
        CachedCrystalCombinerRecipe combinerRecipe = (CachedCrystalCombinerRecipe) arecipes.get(recipe);
        Minecraft.getMinecraft().fontRenderer.drawString("Energy: " + combinerRecipe.energyUse, 90, 76, 0);
    }

    @Override
    public String getGuiTexture() {
        return new ResourceLocation(ModInfo.MODID, "textures/gui/nei/crystalcombiner.png").toString();
    }

    @Override
    public String getRecipeName() {
        return "Crystal Combiner";
    }
}
