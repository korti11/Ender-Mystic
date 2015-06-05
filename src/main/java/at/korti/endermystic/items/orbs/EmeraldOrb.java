package at.korti.endermystic.items.orbs;

import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetworkHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Korti on 16.10.2014.
 */
public class EmeraldOrb extends Orb {

    public EmeraldOrb() {
        super("EmeraldOrb", 0x00f200);

        setNoRepair();
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer p_77624_2_, List list, boolean p_77624_4_) {
        super.addInformation(stack, p_77624_2_, list, p_77624_4_);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        super.onItemRightClick(stack, world, player);

        if (!world.isRemote) {
            player.addChatMessage(new ChatComponentText("Mystic Energy: " + EnergyNetworkHandler.getEnergy(stack.stackTagCompound.getString("em_owner")) + " of " + EnergyNetworkHandler.getCapacity(stack.stackTagCompound.getString("em_owner"))));
        }
        return stack;
    }
}
