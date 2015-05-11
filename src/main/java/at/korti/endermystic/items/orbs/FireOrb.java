package at.korti.endermystic.items.orbs;

import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetwork;
import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetworkHandler;
import at.korti.endermystic.api.tools.AbilityHelper;
import at.korti.endermystic.items.EnergyItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Korti on 16.10.2014.
 */
public class FireOrb extends Orb {

    public FireOrb() {
        super("FireOrb", 0xd43535);

        setNoRepair();
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer p_77624_2_, List list, boolean p_77624_4_) {

        super.addInformation(stack, p_77624_2_, list, p_77624_4_);

        if(stack.stackTagCompound != null){

            if(stack.stackTagCompound.getBoolean("em_active")){
                list.add("Fire Resistance: Activated");
            }
            else{
                list.add("Fire Resistance: Deactivated");
            }

        }

    }

    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {

        if(!world.isRemote) {

            if (stack.stackTagCompound == null) {
                stack.stackTagCompound = new NBTTagCompound();
            }

            if (!player.isSneaking()) {
                if (EnergyNetworkHandler.DecEnergy(OrbStats.usageFireOrb, stack.stackTagCompound.getString("em_owner"))) {
                    AbilityHelper.SetBlock(x, y, z, side, Blocks.lava, world);
                }
            }
        }

        return super.onItemUseFirst(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World p_77659_2_, EntityPlayer player) {
        super.onItemRightClick(stack, p_77659_2_, player);

        if(player.isSneaking()){

            if(stack.stackTagCompound.hasKey("em_active")){

                if(stack.stackTagCompound.getBoolean("em_active")){
                    stack.stackTagCompound.setBoolean("em_active", false);
                }
                else{
                    stack.stackTagCompound.setBoolean("em_active", true);
                }

            }
            else{
                stack.stackTagCompound.setBoolean("em_active", true);
            }

        }

        return stack;
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_) {

        if(!world.isRemote && entity instanceof EntityPlayer){

            if(stack.stackTagCompound == null){
                stack.stackTagCompound = new NBTTagCompound();
            }

            if (stack.stackTagCompound.getBoolean("em_active") && EnergyNetworkHandler.DecEnergy(OrbStats.usageFireResistance, stack.stackTagCompound.getString("em_owner"))) {
                ((EntityPlayer) entity).addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 50));
            }
        }
    }
}
