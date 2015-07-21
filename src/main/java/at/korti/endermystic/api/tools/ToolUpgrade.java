package at.korti.endermystic.api.tools;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.util.EnumChatFormatting;

/**
 * Created by Korti on 16.05.2015.
 */
public class ToolUpgrade {

    private String color;
    private String locolizeKey;
    private int upgradeID;
    private int maxLevel;

    private static final String locKey = "upgrade.endermystic.";
    public static ToolUpgrade luck = new ToolUpgrade(0, EnumChatFormatting.BLUE.toString(), locKey + "luck", 3);
    public static ToolUpgrade haste = new ToolUpgrade(1, EnumChatFormatting.RED.toString(), locKey + "haste", 5);
    public static ToolUpgrade silkTouch = new ToolUpgrade(2, EnumChatFormatting.GREEN.toString(), locKey + "silktouch", 1);
    public static ToolUpgrade sharpness = new ToolUpgrade(3, EnumChatFormatting.WHITE.toString(), locKey + "sharpness", 5);
    public static ToolUpgrade autoSmelt = new ToolUpgrade(4, EnumChatFormatting.GOLD.toString(), locKey + "autosmelt", 1);
    public static ToolUpgrade firey = new ToolUpgrade(5, EnumChatFormatting.GOLD.toString(), locKey + "firey", 2);

    ToolUpgrade(int id, String color, String locolizeKey, int maxLevel) {
        this.upgradeID = id;
        this.color = color;
        this.locolizeKey = locolizeKey;
        this.maxLevel = maxLevel;
        ToolLevelHandler.getInstance().addUpgradeToSystem(this);
    }

    public String getName() {
        String name = LanguageRegistry.instance().getStringLocalization(locolizeKey);
        if (name.equals("")) {
            name = LanguageRegistry.instance().getStringLocalization(locolizeKey, "en_US");
        }
        return name;
    }

    public String getLocolizeKey() {
        return locolizeKey;
    }

    public String getColor() {
        return color;
    }

    public int getId() {
        return upgradeID;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

}
