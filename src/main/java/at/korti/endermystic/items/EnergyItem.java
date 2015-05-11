package at.korti.endermystic.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Korti on 05.11.2014.
 */
public class EnergyItem extends ModItem {

    public EnergyItem(String name) {
        super(name, 1);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer p_77624_2_, List list, boolean p_77624_4_) {

        if(stack.stackTagCompound == null){
            stack.stackTagCompound = new NBTTagCompound();
        }

        if(stack.stackTagCompound != null){

            if(stack.stackTagCompound.hasKey("em_owner")){

                list.add("Owner: " + stack.stackTagCompound.getString("em_owner"));

            }

        }

        super.addInformation(stack, p_77624_2_, list, p_77624_4_);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World p_77659_2_, EntityPlayer player) {

        if(stack.stackTagCompound == null){
            stack.stackTagCompound = new NBTTagCompound();
        }

        if(!stack.stackTagCompound.hasKey("em_owner")) {
            stack.stackTagCompound.setString("em_owner", player.getDisplayName());
        }

        return super.onItemRightClick(stack, p_77659_2_, player);
    }
}
