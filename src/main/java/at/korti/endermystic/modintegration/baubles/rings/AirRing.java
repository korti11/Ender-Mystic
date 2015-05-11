package at.korti.endermystic.modintegration.baubles.rings;

import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetwork;
import at.korti.endermystic.modintegration.baubles.api.BaubleType;
import at.korti.endermystic.modintegration.baubles.api.IBauble;
import at.korti.endermystic.items.EnergyItem;
import at.korti.endermystic.items.orbs.OrbStats;
import at.korti.endermystic.potion.PotionHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;

/**
 * Created by Korti on 05.11.2014.
 */
public class AirRing extends EnergyItem implements IBauble{

    public AirRing() {
        super("AirRing");
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.RING;
    }

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
        if(itemstack.stackTagCompound == null){
            itemstack.stackTagCompound = new NBTTagCompound();
        }

        EnergyNetwork energyNetwork = (EnergyNetwork) player.worldObj.loadItemData(EnergyNetwork.class, itemstack.stackTagCompound.getString("em_owner"));

        if (energyNetwork != null) {

            if(energyNetwork.mysticEnergy - OrbStats.usageWaterAir >= 0){
                player.addPotionEffect(new PotionEffect(PotionHelper.waterBreathing.getId(), 50));
                energyNetwork.mysticEnergy -= OrbStats.usageWaterAir;
            }

        }
    }

    @Override
    public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
        if(itemstack.stackTagCompound == null){
            itemstack.stackTagCompound = new NBTTagCompound();
        }

        if(!itemstack.stackTagCompound.hasKey("em_owner")){
            ((EntityPlayer)player).addChatMessage(new ChatComponentText("The Ring has no owner"));
        }
    }

    @Override
    public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {

    }

    @Override
    public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }

    @Override
    public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }
}
