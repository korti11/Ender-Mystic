package at.korti.endermystic.modintegration;

/**
 * Created by Korti on 02.06.2015.
 */
public interface IIntegration {

    void preInit();

    void init();

    void posInit();

    void clientPostInit();

    void constructCraftingRecipes();

}
