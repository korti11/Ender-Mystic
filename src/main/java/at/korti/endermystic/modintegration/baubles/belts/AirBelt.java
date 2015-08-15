package at.korti.endermystic.modintegration.baubles.belts;

import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetworkHandler;
import at.korti.endermystic.items.orbs.OrbStats;
import baubles.api.BaubleType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

/**
 * Created by Korti on 02.06.2015.
 */
public class AirBelt extends Belt {

    public AirBelt() {
        super("AirBelt", 0x2db895);
    }

    @Override
    public void onWornTick(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        if (itemStack.stackTagCompound == null) {
            itemStack.stackTagCompound = new NBTTagCompound();
        }

        String playerName = itemStack.stackTagCompound.getString("em_owner");

        if (EnergyNetworkHandler.isEnoughEnergy(OrbStats.usageSwiftness, playerName)) {
            entityLivingBase.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 50));
            if (entityLivingBase.moveForward > 0.01F || entityLivingBase.moveForward < -0.01F || entityLivingBase.moveStrafing > 0.01F || entityLivingBase.moveStrafing < -0.01F) {
                EnergyNetworkHandler.decEnergy(OrbStats.usageSwiftness, playerName);
            }
        }
    }
}
