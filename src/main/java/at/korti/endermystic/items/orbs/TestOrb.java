package at.korti.endermystic.items.orbs;

import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetwork;
import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetworkHandler;
import at.korti.endermystic.items.ModItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Korti on 20.10.2014.
 */
public class TestOrb extends ModItem {

    public TestOrb() {
        super("TestOrb", 1);

        setNoRepair();
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {

        if(!world.isRemote){
            EnergyNetworkHandler.AddEnergy(EnergyNetworkHandler.GetCapacity(player.getDisplayName()), player.getDisplayName());
        }

        return stack;
    }
}
