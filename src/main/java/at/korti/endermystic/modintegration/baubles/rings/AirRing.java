package at.korti.endermystic.modintegration.baubles.rings;

import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetworkHandler;
import at.korti.endermystic.items.orbs.OrbStats;
import at.korti.endermystic.potion.PotionHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;

/**
 * Created by Korti on 05.11.2014.
 */
public class AirRing extends Ring{

    public AirRing() {
        super("AirRing", 0x2db895);
    }

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
        if(itemstack.stackTagCompound == null){
            itemstack.stackTagCompound = new NBTTagCompound();
        }

        if(EnergyNetworkHandler.isEnoughEnergy(OrbStats.usageBreathing, itemstack.stackTagCompound.getString("em_owner"))){
            player.addPotionEffect(new PotionEffect(PotionHelper.waterBreathing.getId(), 50));
            if(player.getAir() <= 10 && player.isInWater()) {
                EnergyNetworkHandler.decEnergy(OrbStats.usageBreathing, itemstack.stackTagCompound.getString("em_owner"));
            }
        }
    }
}
