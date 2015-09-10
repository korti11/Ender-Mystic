package at.korti.endermystic.api.armor;

import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * Created by Korti on 10.09.2015.
 */
public class ArmorUpgrade {

    private String color;
    private String locolizedKey;
    private int upgradeID;
    private int maxLevel;

    private ArmorUpgrade(int id, String color, String locolizedKey, int maxLevel) {
        this.upgradeID = id;
        this.color = color;
        this.locolizedKey = locolizedKey;
        this.maxLevel = maxLevel;
        ArmorLevelHandler.getInstance().addUpgradeToSystem(this);
    }

    public String getName() {
        String name = LanguageRegistry.instance().getStringLocalization(locolizedKey);
        if (name.equals("")) {
            name = LanguageRegistry.instance().getStringLocalization(locolizedKey, "en_US");
        }
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getLocolizedKey() {
        return locolizedKey;
    }

    public int getUpgradeID() {
        return upgradeID;
    }

    public int getMaxLevel() {
        return maxLevel;
    }
}
