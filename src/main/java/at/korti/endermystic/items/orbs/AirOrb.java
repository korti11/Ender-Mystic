package at.korti.endermystic.items.orbs;

import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetworkHandler;
import at.korti.endermystic.potion.PotionHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Korti on 20.10.2014.
 */
public class AirOrb extends Orb {

    public AirOrb() {
        super("AirOrb", 0x2db895);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer p_77624_2_, List list, boolean p_77624_4_) {
        super.addInformation(stack, p_77624_2_, list, p_77624_4_);

        if(stack.stackTagCompound != null){

            if(stack.stackTagCompound.getBoolean("em_active")){
                list.add("Breathing: Activated");
            }
            else{
                list.add("Breathing: Deactivated");
            }

        }

    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        super.onItemRightClick(stack, world, player);

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

            return stack;
        }

        if(!world.isRemote){

            if (EnergyNetworkHandler.decEnergy(OrbStats.usageAirOrb, stack.stackTagCompound.getString("em_owner"))) {
                stack.stackTagCompound.setBoolean("em_fly", true);
            }
        }
        else if(stack.stackTagCompound.getBoolean("em_fly")){

            Vec3 vec = player.getLookVec();
            double moveVec = 1.6;

            player.motionX = vec.xCoord * moveVec;
            player.motionY = vec.yCoord * moveVec;
            player.motionZ = vec.zCoord * moveVec;
            player.fallDistance = 0;

        }

        return stack;
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_) {

        if(entity instanceof EntityPlayer){

            if(stack.stackTagCompound == null){
                stack.stackTagCompound = new NBTTagCompound();
            }

            if(stack.stackTagCompound.getBoolean("em_active") && EnergyNetworkHandler.decEnergy(OrbStats.usageBreathing, stack.stackTagCompound.getString("em_owner"))){
                ((EntityPlayer)entity).addPotionEffect(new PotionEffect(PotionHelper.waterBreathing.getId(), 50));
            }

        }

    }
}
