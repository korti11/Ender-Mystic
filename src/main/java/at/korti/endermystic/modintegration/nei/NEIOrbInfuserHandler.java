package at.korti.endermystic.modintegration.nei;

import at.korti.endermystic.ModInfo;
import at.korti.endermystic.api.crafting.CraftingRecipe;
import at.korti.endermystic.api.crafting.CraftingRegistry;
import at.korti.endermystic.api.crafting.CrystalCombinerRecipe;
import at.korti.endermystic.api.crafting.OrbInfuserRecipe;
import at.korti.endermystic.blocks.OrbInfuser;
import codechicken.lib.gui.GuiDraw;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Korti on 18.09.2015.
 */
public class NEIOrbInfuserHandler extends TemplateRecipeHandler {

    public class CachedOrbInfuserRecipe extends CachedRecipe{

        private List<PositionedStack> input;
        private PositionedStack output;
        private int energyUse;

        public CachedOrbInfuserRecipe(OrbInfuserRecipe recipe) {
            input = new LinkedList<>();
            for (int i = 0; i < recipe.requirementsCount(); i++) {
                ItemStack stack = recipe.getRequirement(i);
                if (stack != null && stack.getItem().equals(Items.ender_pearl)) {
                    input.add(new PositionedStack(stack, 64, 40, false));
                } else if (stack != null) {
                    input.add(new PositionedStack(stack, getXForSlot(i), getYForSlot(i), false));
                }
            }
            output = new PositionedStack(recipe.getResult(), 64, 106, false);
            energyUse = recipe.getEnergyUsePerTick() * recipe.getTimeToCraft();
        }

        private int getXForSlot(int slot) {
            switch (slot) {
                case 0:
                    return 32;
                case 1:
                    return 64;
                case 2:
                    return 96;
                case 3:
                    return 96;
                case 4:
                    return 96;
                case 5:
                    return 64;
                case 6:
                    return 32;
                case 7:
                    return 32;
                default:
                    return 0;
            }
        }

        private int getYForSlot(int slot) {
            switch (slot) {
                case 0:
                    return 8;
                case 1:
                    return 8;
                case 2:
                    return 8;
                case 3:
                    return 40;
                case 4:
                    return 72;
                case 5:
                    return 72;
                case 6:
                    return 72;
                case 7:
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
        OrbInfuserRecipe recipe = CraftingRegistry.getInstance().getOrbInfuserRecipe(result);
        if(recipe != null && recipe.getResult() != null) {
            if (NEIServerUtils.areStacksSameTypeCrafting(recipe.getResult(), result)) {
                arecipes.add(new CachedOrbInfuserRecipe(recipe));
            }
        }
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient) {
        List<CraftingRecipe> recipes = CraftingRegistry.getInstance().getCraftingRecipes(ingredient);
        for (CraftingRecipe recipe : recipes) {
            if (recipe instanceof OrbInfuserRecipe) {
                arecipes.add(new CachedOrbInfuserRecipe((OrbInfuserRecipe) recipe));
            }
        }
    }

    @Override
    public void drawBackground(int recipe) {
        GL11.glColor4f(1, 1, 1, 1);
        GuiDraw.changeTexture(getGuiTexture());
        GuiDraw.drawTexturedModalRect(0, 0, 5, 11, 117, 130);
    }

    @Override
    public void drawExtras(int recipe) {
        CachedOrbInfuserRecipe combinerRecipe = (CachedOrbInfuserRecipe) arecipes.get(recipe);
        Minecraft.getMinecraft().fontRenderer.drawString("Energy: " + combinerRecipe.energyUse, 90, 110, 0);
    }

    @Override
    public int recipiesPerPage() {
        return 1;
    }

    @Override
    public String getGuiTexture() {
        return new ResourceLocation(ModInfo.MODID, "textures/gui/nei/orbinfuser.png").toString();
    }

    @Override
    public String getRecipeName() {
        return "Orb Infuser";
    }
}
