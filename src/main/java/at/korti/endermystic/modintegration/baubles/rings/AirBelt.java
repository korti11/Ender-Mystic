package at.korti.endermystic.modintegration.baubles.rings;

import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetworkHandler;
import at.korti.endermystic.items.EnergyItem;
import at.korti.endermystic.items.orbs.OrbStats;
import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;

/**
 * Created by Korti on 02.06.2015.
 */
public class AirBelt extends EnergyItem implements IBauble {

    public AirBelt() {
        super("AirBelt");
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return BaubleType.BELT;
    }

    @Override
    public void onWornTick(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        if (itemStack.stackTagCompound == null) {
            itemStack.stackTagCompound = new NBTTagCompound();
        }

        String playerName = itemStack.stackTagCompound.getString("em_owner");

        if (EnergyNetworkHandler.IsEnoughEnergy(OrbStats.usageSwiftness, playerName)) {
            entityLivingBase.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 200));
            if (entityLivingBase.moveForward > 0.01F || entityLivingBase.moveForward < -0.01F || entityLivingBase.moveStrafing > 0.01F || entityLivingBase.moveStrafing < -0.01F) {
                EnergyNetworkHandler.DecEnergy(OrbStats.usageSwiftness, playerName);
            }
        }
    }

    @Override
    public void onEquipped(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        if(itemStack.stackTagCompound == null){
            itemStack.stackTagCompound = new NBTTagCompound();
        }

        if(!itemStack.stackTagCompound.hasKey("em_owner")){
            ((EntityPlayer)entityLivingBase).addChatMessage(new ChatComponentText("The Belt has no owner"));
        }
    }

    @Override
    public void onUnequipped(ItemStack itemStack, EntityLivingBase entityLivingBase) {

    }

    @Override
    public boolean canEquip(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        return true;
    }

    @Override
    public boolean canUnequip(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        return true;
    }
}
