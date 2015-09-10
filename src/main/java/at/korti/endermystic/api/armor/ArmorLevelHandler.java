package at.korti.endermystic.api.armor;

import at.korti.endermystic.EnderMystic;
import net.minecraftforge.common.config.Property;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Korti on 10.09.2015.
 */
public class ArmorLevelHandler {

    private static ArmorLevelHandler instance;

    private Random random;

    private Property maxXpProperty;
    private String[] levelNames;
    private int[] maxXpForLevels;
    private List<ArmorUpgrade> upgrades;

    private ArmorLevelHandler() {
        random = new Random();
        upgrades = new ArrayList<>();
    }

    public static ArmorLevelHandler getInstance() {
        if (instance == null) {
            instance = new ArmorLevelHandler();
        }
        return instance;
    }

    //region System Init
    public void initLevelSystem() {
        levelNames = EnderMystic.config.getStringList("Armor Level Names", "Armor Level System", new String[]{"Bad", "Clumsy", "Good", "Epic", "Legendary"}, "The count of level names equals the max level of the armors.");
        maxXpProperty = EnderMystic.config.get("Armor Level System", "Max xp per level", new int[]{160, 235, 327, 452, 590},
                "The count of max xp values must equals the count of level names." +
                        " If the count of max xp values is less then the count of level names, it auto generate ah max xp value for the rest levels"
        );
        maxXpForLevels = maxXpProperty.getIntList();
        if (maxXpForLevels.length < levelNames.length) {
            generateMaxXpValues();
        }
    }

    private void generateMaxXpValues() {
        int[] newMaxXpForLevels = new int[levelNames.length];
        for (int i = 0; i < maxXpForLevels.length; i++) {
            newMaxXpForLevels[i] = maxXpForLevels[i];
        }
        int pos = maxXpForLevels.length - 1;
        for (int i = maxXpForLevels.length; i < levelNames.length; i++) {
            newMaxXpForLevels[i] = ((newMaxXpForLevels[pos++] / 100) * 100) + 100 + random.nextInt(100);
        }
        maxXpForLevels = newMaxXpForLevels;
        maxXpProperty.set(maxXpForLevels);
    }

    public void addUpgradeToSystem(ArmorUpgrade armorUpgrade) {
        upgrades.add(armorUpgrade);
    }
    //endregion

}
