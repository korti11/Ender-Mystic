package at.korti.endermystic.items.orbs;

import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetworkHandler;
import at.korti.endermystic.api.helper.WorldHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Korti on 16.10.2014.
 */
public class WaterOrb extends Orb{

    public WaterOrb() {
        super("WaterOrb", 0x29a4a4);

        setNoRepair();
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer p_77624_2_, List list, boolean p_77624_4_) {
        super.addInformation(stack, p_77624_2_, list, p_77624_4_);
    }

    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {

        if(!world.isRemote){

            if(stack.stackTagCompound == null){

                stack.stackTagCompound = new NBTTagCompound();

            }

            if (EnergyNetworkHandler.decEnergy(OrbStats.usageWaterOrb, stack.stackTagCompound.getString("em_owner"))) {
                WorldHelper.setBlock(x, y, z, side, Blocks.water, world);
            }

        }

        return super.onItemUseFirst(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
    }
}
