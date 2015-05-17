package at.korti.endermystic.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;

/**
 * Created by Korti on 11.04.2015.
 */
public class CrystalItem extends ModItem {

    private int crystalCount = 8;

    public CrystalItem() {
        super("Crystal");

        setHasSubtypes(true);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean p_77624_4_) {
        if (stack.getItemDamage() == 7) {
            if(stack.stackTagCompound == null){
                stack.stackTagCompound = new NBTTagCompound();
            }

            if (stack.stackTagCompound.hasKey("em_owner")) {
                list.add("Owner: " + stack.stackTagCompound.getString("em_owner"));
            }
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (stack.getItemDamage() == 7) {
            if(stack.stackTagCompound == null){
                stack.stackTagCompound = new NBTTagCompound();
            }

            if (!stack.stackTagCompound.hasKey("em_owner")) {
                stack.stackTagCompound.setString("em_owner", player.getDisplayName());
            }
        }

        return stack;
    }

    @Override
    public int getColorFromItemStack(ItemStack stack, int p_82790_2_) {
        switch (stack.getItemDamage()){
            case 0:
                return 13260;
            case 1:
                return 16711680;
            case 2:
                return 3381555;
            case 3:
                return 16777011;
            case 4:
                return 16711731;
            case 5:
                return 13434726;
            case 6:
                return 10053171;
            case 7:
                return 16777062;
            default:
                return 0;
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        String subName;
        switch (stack.getItemDamage()){
            case 0:
                subName = "Water";
                break;
            case 1:
                subName = "Fire";
                break;
            case 2:
                subName = "Earth";
                break;
            case 3:
                subName = "Air";
                break;
            case 4:
                subName = "Life";
                break;
            case 5:
                subName = "Grain";
                break;
            case 6:
                subName = "Human";
                break;
            case 7:
                subName = "Energy";
                break;
            default:
                subName = "Crystal";
                break;
        }

        return getUnlocalizedName() + "." + subName;
    }

    @Override
    public void getSubItems(Item item, CreativeTabs p_150895_2_, List list) {
        for(int i = 0; i < crystalCount; i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }
}
