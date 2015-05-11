package at.korti.endermystic.items.tools;

import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetwork;
import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetworkHandler;
import at.korti.endermystic.items.ModItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

/**
 * Created by Korti on 15.10.2014.
 */
public class EnderSacrifice extends ModItem {

    public EnderSacrifice() {
        super("EnderSacrifice", 1);

        setNoRepair();
    }

    @Override
    public boolean hitEntity(ItemStack p_77644_1_, EntityLivingBase entity, EntityLivingBase player) {

        if(!entity.worldObj.isRemote){
            if(entity instanceof EntityEnderman){
                if(EnergyNetworkHandler.AddEnergy(700, ((EntityPlayer)player).getDisplayName())){
                    entity.setDead();
                    return true;
                }
            }
        }

        return false;
    }
}
