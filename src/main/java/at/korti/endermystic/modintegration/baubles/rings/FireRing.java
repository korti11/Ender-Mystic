package at.korti.endermystic.modintegration.baubles.rings;

import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetworkHandler;
import at.korti.endermystic.items.EnergyItem;
import at.korti.endermystic.items.orbs.OrbStats;
import at.korti.endermystic.potion.PotionHelper;
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
public class FireRing extends EnergyItem implements IBauble{
    public FireRing() {
        super("FireRing");
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return BaubleType.RING;
    }

    @Override
    public void onWornTick(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        if (itemStack.stackTagCompound == null) {
            itemStack.stackTagCompound = new NBTTagCompound();
        }

        if (EnergyNetworkHandler.IsEnoughEnergy(OrbStats.usageFireResistance, itemStack.stackTagCompound.getString("em_owner")) && entityLivingBase.isBurning()) {
            EnergyNetworkHandler.DecEnergy(OrbStats.usageFireResistance, itemStack.stackTagCompound.getString("em_owner"));
            entityLivingBase.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 200));
        }
    }

    @Override
    public void onEquipped(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        if(itemStack.stackTagCompound == null){
            itemStack.stackTagCompound = new NBTTagCompound();
        }

        if(!itemStack.stackTagCompound.hasKey("em_owner")){
            ((EntityPlayer)entityLivingBase).addChatMessage(new ChatComponentText("The Ring has no owner"));
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
