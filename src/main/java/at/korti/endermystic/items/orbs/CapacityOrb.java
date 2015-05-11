package at.korti.endermystic.items.orbs;

import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetworkHandler;
import at.korti.endermystic.items.EnergyItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Korti on 15.10.2014.
 */
public class CapacityOrb extends Orb {

    private int maxCapacity;

    public CapacityOrb(String name, int color, int capacity) {
        super(name, color);
        this.maxCapacity = capacity;

        setNoRepair();
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer p_77624_2_, List list, boolean p_77624_4_) {
        super.addInformation(stack, p_77624_2_, list, p_77624_4_);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if(!world.isRemote) {
            if (itemStack.stackTagCompound == null) {
                itemStack.stackTagCompound = new NBTTagCompound();
            }

            if (!itemStack.stackTagCompound.hasKey("em_owner")) {
                if(EnergyNetworkHandler.AddCapacity(maxCapacity, player.getDisplayName())) {
                    super.onItemRightClick(itemStack, world, player);
                }
            }
        }
        return itemStack;
    }
}
