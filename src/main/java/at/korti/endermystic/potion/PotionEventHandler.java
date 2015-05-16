package at.korti.endermystic.potion;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingEvent;

/**
 * Created by Korti on 27.10.2014.
 */
public class PotionEventHandler {

    @SubscribeEvent
    public void onEntityUpdate(LivingEvent.LivingUpdateEvent event){

        EntityLivingBase entity = event.entityLiving;

        if(entity.isPotionActive(PotionHelper.enderHeartBleed)){
            if(entity.worldObj.rand.nextInt(20) == 0){
                entity.attackEntityFrom(DamageSource.generic, 1);
            }
        }
        else if(entity.isPotionActive(PotionHelper.waterBreathing)){

            if(entity instanceof EntityPlayer){

                EntityPlayer player = (EntityPlayer)entity;

                if(player.isInWater() && player.getAir() <= 10){
                    player.setAir(20);
                }

            }

        }
        else if(entity.isPotionActive(PotionHelper.enderScream)){

            if(entity instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) entity;
                player.playSound("mob.endermen.scream", 1.0F, 1.0F);
            }
        }

    }

}
