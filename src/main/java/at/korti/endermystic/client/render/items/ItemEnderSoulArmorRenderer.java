package at.korti.endermystic.client.render.items;

import at.korti.endermystic.client.model.armor.EnderSoulArmorModel;

/**
 * Created by Korti on 09.06.2015.
 */
public class ItemEnderSoulArmorRenderer extends ItemArmorRenderer {
    public ItemEnderSoulArmorRenderer() {
        super(new EnderSoulArmorModel(1.0F, true, true, true), "textures/model/EnderSoulArmor.png");
    }
}
