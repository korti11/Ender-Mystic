package at.korti.endermystic.items.orbs;

import at.korti.endermystic.api.helper.WorldHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Korti on 16.10.2014.
 */
public class EarthOrb extends Orb {

    public EarthOrb() {
        super("EarthOrb" , 0x29a452);

        setNoRepair();
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer p_77624_2_, List list, boolean p_77624_4_) {
        super.addInformation(stack, p_77624_2_, list, p_77624_4_);

        if(stack.stackTagCompound != null){

            if(stack.stackTagCompound.hasKey("em_radius")){
                list.add("Radius: " + stack.stackTagCompound.getInteger("em_radius"));
            }

        }

    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World p_77659_2_, EntityPlayer player) {
        super.onItemRightClick(stack, p_77659_2_, player);

        if (player.isSneaking()) {

            if (stack.stackTagCompound.getInteger("em_radius") == 7 || !stack.stackTagCompound.hasKey("em_radius")) {

                stack.stackTagCompound.setInteger("em_radius", 3);

            } else {

                stack.stackTagCompound.setInteger("em_radius", stack.stackTagCompound.getInteger("em_radius") + 2);

            }

        }

        return stack;

    }

    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {

        if(!world.isRemote) {

            if (!player.isSneaking()) {
                WorldHelper.breakMultiBlocks(player, stack, world, x, y, z, side, stack.stackTagCompound.getInteger("em_radius"));
            }
        }

        return super.onItemUseFirst(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
    }
}
