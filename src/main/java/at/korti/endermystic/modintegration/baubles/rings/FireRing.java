package at.korti.endermystic.modintegration.baubles.rings;

import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetworkHandler;
import at.korti.endermystic.items.orbs.OrbStats;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

/**
 * Created by Korti on 02.06.2015.
 */
public class FireRing extends Ring{

    public FireRing() {
        super("FireRing", 0xd43535);
    }

    @Override
    public void onWornTick(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        if (itemStack.stackTagCompound == null) {
            itemStack.stackTagCompound = new NBTTagCompound();
        }

        if (EnergyNetworkHandler.isEnoughEnergy(OrbStats.usageFireResistance, itemStack.stackTagCompound.getString("em_owner"))) {
            entityLivingBase.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 50));
            if(entityLivingBase.isBurning()) {
                EnergyNetworkHandler.decEnergy(OrbStats.usageFireResistance, itemStack.stackTagCompound.getString("em_owner"));
            }
        }
    }
}
