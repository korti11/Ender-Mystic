package at.korti.endermystic.api.tools;

import at.korti.endermystic.EnderMystic;
import at.korti.endermystic.items.tools.ToolMaterials;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Korti on 14.05.2015.
 */
public class ToolLevelHandler {

    private static ToolLevelHandler instance;

    private String LEVEL_TAG = "em_toolLevel";
    private String LEVEL_NAME_TAG = "em_toolLevelName";
    private String XP_TAG = "em_toolXp";
    private String MAX_XP_TAG = "em_maxToolXp";

    private Random random;

    private Property maxXpProperty;
    private String[] levelNames;
    private int[] maxXpForLevels;
    private List<ToolUpgrade> upgrades;

    private ToolLevelHandler() {
        random = new Random(LocalTime.now().getNano());
        upgrades = new ArrayList<>();
    }

    public static ToolLevelHandler getInstance(){
        if (instance == null) {
            instance = new ToolLevelHandler();
        }
        return instance;
    }

    //region System Init
    public void initToolLevelSystem(){
        levelNames = EnderMystic.config.getStringList("Tool Level Names", "Tool Level System", new String[]{"Bad", "Clumsy", "Good", "Epic", "Legendary"}, "The count of level names equals the max level of the tools.");
        maxXpProperty = EnderMystic.config.get("Tool Level System", "Max xp per level", new int[]{160, 235, 327, 452, 590},
                "The count of max xp values must equals the count of level names." +
                        " If the count of max xp values is less then the count of level names, it auto generate ah max xp value for the rest levels"
        );
        maxXpForLevels = maxXpProperty.getIntList();
        if (maxXpForLevels.length < levelNames.length) {
            generateMaxXpValues();
        }
    }

    private void generateMaxXpValues() {
        int[] newMaxXpForLavels = new int[levelNames.length];
        for (int i = 0; i < maxXpForLevels.length; i++) {
            newMaxXpForLavels[i] = maxXpForLevels[i];
        }
        int pos = maxXpForLevels.length - 1;
        for (int i = maxXpForLevels.length; i < levelNames.length; i++) {
            newMaxXpForLavels[i] = ((newMaxXpForLavels[pos++] / 100) * 100) + 100 + random.nextInt(100);
        }
        maxXpForLevels = newMaxXpForLavels;
        maxXpProperty.set(maxXpForLevels);
    }

    public void addUpgradeToSystem(ToolUpgrade toolUpgrade) {
        upgrades.add(toolUpgrade);
    }
    //endregion

    //region Item Init
    public void initItem(ItemStack stack) {
        if (stack.stackTagCompound == null) {
            stack.stackTagCompound = new NBTTagCompound();
        }

        stack.stackTagCompound.setString(LEVEL_NAME_TAG, levelNames[0]);
        stack.stackTagCompound.setInteger(LEVEL_TAG, 0);
        stack.stackTagCompound.setInteger(XP_TAG, 0);
        stack.stackTagCompound.setInteger(MAX_XP_TAG, maxXpForLevels[0]);
    }

    public boolean isItemInited(ItemStack stack) {
        return stack.stackTagCompound.hasKey(LEVEL_TAG);
    }
    //endregion

    //region Xp Handeling
    public void addXP(ItemStack stack, int xp) {
        if(stack.getItem() instanceof IEnderSoulTool) {
            if (stack.stackTagCompound.getInteger(XP_TAG) + xp >= stack.stackTagCompound.getInteger(MAX_XP_TAG)) {
                if(stack.stackTagCompound.getInteger(LEVEL_TAG) < levelNames.length) {
                    stack.stackTagCompound.setInteger(XP_TAG, 0);
                    stack.stackTagCompound.setInteger(LEVEL_TAG, stack.stackTagCompound.getInteger(LEVEL_TAG) + 1);
                    stack.stackTagCompound.setInteger(MAX_XP_TAG, maxXpForLevels[stack.stackTagCompound.getInteger(LEVEL_TAG)]);
                    stack.stackTagCompound.setString(LEVEL_NAME_TAG, levelNames[stack.stackTagCompound.getInteger(LEVEL_TAG)]);
                    addRandomUpgrade(stack);
                }
                else if (stack.stackTagCompound.getInteger(LEVEL_TAG) == levelNames.length) {
                    stack.stackTagCompound.setInteger(XP_TAG, maxXpForLevels[levelNames.length - 1]);
                    stack.stackTagCompound.setInteger(LEVEL_TAG, stack.stackTagCompound.getInteger(LEVEL_TAG) + 1);
                    addRandomUpgrade(stack);
                }
            } else {
                stack.stackTagCompound.setInteger(XP_TAG, stack.stackTagCompound.getInteger(XP_TAG) + xp);
            }
        }
    }

    public String getLevelName(ItemStack stack) {
        return stack.stackTagCompound.getString(LEVEL_NAME_TAG);
    }

    public int getXp(ItemStack stack) {
        return stack.stackTagCompound.getInteger(XP_TAG);
    }

    public int getMaxXp(ItemStack stack) {
        return stack.stackTagCompound.getInteger(MAX_XP_TAG);
    }
    //endregion


    //region Upgrade Handeling
    public boolean addUpgrad(ItemStack stack, String upgradeId, String level, boolean showChatMessage) {
        if (stack.getItem() instanceof IEnderSoulTool) {
            if (stack.stackTagCompound == null) {
                stack.stackTagCompound = new NBTTagCompound();
            }
            NBTTagList tagList = stack.stackTagCompound.getTagList("Upgrades", 10);
            ToolUpgrade toolUpgrade = getUpgradeById(Integer.parseInt(upgradeId));
            if (hasUpgrade(stack, toolUpgrade) && canAddLevel(stack, toolUpgrade, Integer.parseInt(level))) {
                for (int i = 0; i < tagList.tagCount(); i++) {
                    NBTTagCompound tagCompound = tagList.getCompoundTagAt(i);
                    if (tagCompound.getInteger("Upgrade") == toolUpgrade.getId()) {
                        tagCompound.setInteger("Level", tagCompound.getInteger("Level") + Integer.parseInt(level));
                        stack.stackTagCompound.setTag("Upgrades", tagList);
                        if(showChatMessage) {
                            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Added " + level + " level(s) to " + toolUpgrade.getColor() + toolUpgrade.getName() + EnumChatFormatting.RESET.toString() + " on " + stack.getDisplayName()));
                        }
                        return true;
                    }
                }
            } else if (isUpgradeValid(toolUpgrade, stack) && canAddLevel(stack, toolUpgrade, Integer.parseInt(level))) {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setInteger("Upgrade", toolUpgrade.getId());
                tagCompound.setInteger("Level", Integer.parseInt(level));
                tagList.appendTag(tagCompound);
                stack.stackTagCompound.setTag("Upgrades", tagList);
                if(showChatMessage) {
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Added " + toolUpgrade.getColor() + toolUpgrade.getName() + EnumChatFormatting.RESET.toString() + " with " + level + " level(s) on " + stack.getDisplayName()));
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean addUpgrad(ItemStack stack, int id, int level) {
        return addUpgrad(stack, String.valueOf(id), String.valueOf(level), false);
    }

    public boolean addRandomUpgrade(ItemStack stack) {
        int id;
        boolean check;
        List<Integer> checkedUpgrades = new ArrayList<>();
        do {
            id = random.nextInt(upgrades.size());
            if (!checkedUpgrades.contains(id)) {
                checkedUpgrades.add(id);
            }
        }while (check = (!isUpgradeValid(getUpgradeById(id), stack) || !canAddLevel(stack, getUpgradeById(id), 1)) && checkedUpgrades.size() != 6);
        if(!check) {
            return addUpgrad(stack, String.valueOf(id), "1", true);
        }
        return false;
    }

    private boolean isUpgradeValid(ToolUpgrade upgrade, ItemStack stack) {
        Item item = stack.getItem();
        boolean check = false;
        if (ToolUpgrade.luck == upgrade) {
            check = item instanceof ItemPickaxe || item instanceof ItemSpade || item instanceof ItemSword;
            if (ToolUpgrade.luck == upgrade) {
                check = !hasUpgrade(stack, ToolUpgrade.silkTouch);
            }
        }
        else if (ToolUpgrade.haste == upgrade || ToolUpgrade.silkTouch == upgrade || ToolUpgrade.autoSmelt == upgrade) {
            check = item instanceof ItemPickaxe || item instanceof ItemSpade;
            if(ToolUpgrade.silkTouch == upgrade) {
                if (hasUpgrade(stack, ToolUpgrade.luck) || hasUpgrade(stack, ToolUpgrade.autoSmelt)) {
                    check = false;
                }
            }
            else if (ToolUpgrade.autoSmelt == upgrade) {
                check = !hasUpgrade(stack, ToolUpgrade.silkTouch);
            }
        }
        else if (ToolUpgrade.sharpness == upgrade || ToolUpgrade.firey == upgrade) {
            check = item instanceof ItemSword;
        }
        return check;
    }

    private boolean canAddLevel(ItemStack stack, ToolUpgrade upgrade, int levels) {
        NBTTagList tagList = stack.stackTagCompound.getTagList("Upgrades", 10);
        if(hasUpgrade(stack, upgrade)){
            for (int i = 0; i < tagList.tagCount(); i++) {
                NBTTagCompound tagCompound = tagList.getCompoundTagAt(i);
                if (upgrade.getId() == tagCompound.getInteger("Upgrade") && tagCompound.getInteger("Level") + levels <= upgrade.getMaxLevel()) {
                    return true;
                }
            }
        }
        else if(levels <= upgrade.getMaxLevel()){
            return true;
        }
        return false;
    }

    public boolean hasUpgrade(ItemStack stack, ToolUpgrade upgrade) {
        boolean check = false;
        if(stack.getItem() instanceof IEnderSoulTool) {
            NBTTagList tagList = stack.stackTagCompound.getTagList("Upgrades", 10);
            for (int i = 0; i < tagList.tagCount() && !check && stack.getItem() instanceof IEnderSoulTool; i++) {
                NBTTagCompound tagCompound = tagList.getCompoundTagAt(i);
                check = tagCompound.getInteger("Upgrade") == upgrade.getId();
            }
        }
        return check;
    }

    public List getUpgradeNames() {
        List<String> args = new ArrayList<>();
        for (int i = 0; i < args.size(); i++) {
            args.add(upgrades.get(i).getName());
        }
        return args;
    }

    private ToolUpgrade getUpgradeById(int id) {
        for (int i = 0; i < upgrades.size(); i++) {
            if (upgrades.get(i).getId() == id) {
                return upgrades.get(i);
            }
        }
        return null;
    }

    private ToolUpgrade getUpgradeByName(String name) {
        for (int i = 0; i < upgrades.size(); i++) {
            if (upgrades.get(i).getName().equals(name)) {
                return upgrades.get(i);
            }
        }
        return null;
    }

    public void writeInfo(ItemStack stack, List info) {
        NBTTagList nbtTagList = stack.stackTagCompound.getTagList("Upgrades", 10);
        if (nbtTagList.tagCount() > 0) {
            info.add("");
        }
        for (int i = 0; i < nbtTagList.tagCount(); i++) {
            NBTTagCompound tagCompound = nbtTagList.getCompoundTagAt(i);
            info.add(getUpgradeById(tagCompound.getInteger("Upgrade")).getColor() + getUpgradeById(tagCompound.getInteger("Upgrade")).getName() + " " + tagCompound.getInteger("Level") + EnumChatFormatting.RESET.toString());
        }
    }

    public void writeAttackDamage(ItemStack stack, List info) {
        info.add("Attack Damage: " + calcAttackDamage(stack) / 2 + " Hearths");
    }

    private int getLevelOfUpgrade(ItemStack stack, ToolUpgrade upgrade) {
        NBTTagList tagList = stack.stackTagCompound.getTagList("Upgrades", 10);
        int level = 0;
        for (int i = 0; i < tagList.tagCount(); i++) {
            NBTTagCompound tagCompound = tagList.getCompoundTagAt(i);
            if(tagCompound.getInteger("Upgrade") == upgrade.getId()) {
                level = tagCompound.getInteger("Level");
            }
        }
        return level;
    }

    private float calcAttackDamage(ItemStack stack) {
        float damage = 4.0F + ToolMaterials.enderSoul.getDamageVsEntity();
        if (hasUpgrade(stack, ToolUpgrade.sharpness)) {
            damage += 3.0F * getLevelOfUpgrade(stack, ToolUpgrade.sharpness);
        }
        return damage;
    }

    private void spawnItem(World world, ItemStack stack, int x, int y, int z) {
        float f = 0.7F;
        double d0 = (double) (random.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
        double d1 = (double) (random.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
        double d2 = (double) (random.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
        EntityItem entityItem = new EntityItem(world, x + d0, y + d1, z + d2, stack);
        entityItem.delayBeforeCanPickup = 10;
        world.spawnEntityInWorld(entityItem);
    }

    public void cancleEventIf(Event event, ItemStack stack) {
        if (stack.getItem() instanceof IEnderSoulTool) {
            event.setCanceled(true);
        }
    }

    public float handleHasteUpgrade(ItemStack stack) {
        if (hasUpgrade(stack, ToolUpgrade.haste)) {
            return getLevelOfUpgrade(stack, ToolUpgrade.haste) * 3.0F;
        }
        return 0.0F;
    }

    public boolean handleLuckUpgrade(BlockEvent.BreakEvent event) {
        return handleLuckUpgrade(event.getPlayer().inventory.getCurrentItem(), event.world, event.block, event.x, event.y, event.z);
    }

    public boolean handleLuckUpgrade(LivingDropsEvent event) {
        if(event.source.getSourceOfDamage() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.source.getSourceOfDamage();
            if (player != null) {
                ItemStack stack = player.inventory.getCurrentItem();
                if (hasUpgrade(stack, ToolUpgrade.luck)) {
                    List<EntityItem> drops = event.drops;
                    List<EntityItem> newDrops = new ArrayList<>();
                    for (int i = 0; i < drops.size(); i++) {
                        EntityItem item = drops.get(i);
                        for (int j = 0; i < getLevelOfUpgrade(stack, ToolUpgrade.luck) * (random.nextInt(1) + 1) + 1; j++) {
                            newDrops.add(new EntityItem(item.worldObj, item.posX, item.posY, item.posZ, item.getEntityItem().copy()));
                        }
                    }
                    for (int i = 0; i < newDrops.size(); i++) {
                        drops.add(newDrops.get(i));
                    }
                }
            }
        }
        return false;
    }

    public boolean handleLuckUpgrade(ItemStack stack, World world, Block block, int x, int y, int z) {
        if (hasUpgrade(stack, ToolUpgrade.luck)) {
            Item item = block.getDrops(world, x, y, z, block.getDamageValue(world, x, y, z), 0).get(0).getItem();
            if (!(item instanceof ItemBlock)) {
                block.dropBlockAsItemWithChance(world, x, y, z, block.getDamageValue(world, x, y, z), random.nextFloat(), getLevelOfUpgrade(stack, ToolUpgrade.luck) * (random.nextInt(1) + 1));
            }
        }
        return false;
    }

    public boolean handleSilkTouchUpgrade(BlockEvent.BreakEvent event) {
        return handleSilkTouchUpgrade(event.getPlayer().inventory.getCurrentItem(), event.world, event.block, event.x, event.y, event.z, event.getPlayer());
    }

    public boolean handleSilkTouchUpgrade(ItemStack stack, World world, Block block, int x, int y, int z, EntityPlayer player) {
        if (hasUpgrade(stack, ToolUpgrade.silkTouch) && block.canSilkHarvest(world, player, x, y, z, block.getDamageValue(world, x, y, z))) {
            world.setBlockToAir(x, y, z);
            spawnItem(world, new ItemStack(block, 1, block.getDamageValue(world, x, y, z)), x, y, z);
            return true;
        }
        return false;
    }

    public boolean handleAutoSmeltUpgrade(BlockEvent.BreakEvent event) {
        return handleAutoSmeltUpgrade(event.getPlayer().inventory.getCurrentItem(), event.world, event.block, event.x, event.y, event.z);
    }

    public boolean handleAutoSmeltUpgrade(ItemStack stack, World world, Block block, int x, int y, int z) {
        if (hasUpgrade(stack, ToolUpgrade.autoSmelt)) {
            List<ItemStack> drops = block.getDrops(world, x, y, z, block.getDamageValue(world, x, y, z), 0);
            ItemStack result = FurnaceRecipes.smelting().getSmeltingResult(drops.get(0));
            int dropAmount = drops.size();
            if (result != null) {
                world.setBlockToAir(x, y, z);
                if (hasUpgrade(stack, ToolUpgrade.luck) && random.nextInt(5) == 2 && !(result.getItem() instanceof ItemBlock)) {
                    dropAmount += getLevelOfUpgrade(stack, ToolUpgrade.luck) * (random.nextInt(1) + 1);
                }
                for (int i = 0; i < dropAmount; i++) {
                    spawnItem(world, result.copy(), x, y, z);
                }
                return true;
            }
        }
        return false;
    }

    public boolean handleSharpnessUpgrade(LivingAttackEvent event) {
        if(event.source.getSourceOfDamage() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.source.getSourceOfDamage();
            if (player != null) {
                ItemStack stack = player.inventory.getCurrentItem();
                if (hasUpgrade(stack, ToolUpgrade.sharpness)) {
                    float amount = calcAttackDamage(stack);
                    event.entityLiving.attackEntityFrom(DamageSource.generic, amount);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean handleFireyUpgrade(LivingAttackEvent event) {
        if (event.source.getSourceOfDamage() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.source.getSourceOfDamage();
            if (player != null) {
                ItemStack stack = player.inventory.getCurrentItem();
                if (hasUpgrade(stack, ToolUpgrade.firey)) {
                    event.entityLiving.setFire(5 * getLevelOfUpgrade(stack, ToolUpgrade.firey));
                    return true;
                }
            }
        }
        return false;
    }


    //endregion
}
