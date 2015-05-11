package at.korti.endermystic.events;

import at.korti.endermystic.items.ModItems;
import at.korti.endermystic.potion.PotionHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

/**
 * Created by Korti on 27.10.2014.
 */
public class MobDropsEvents {

    @SubscribeEvent
    public void EntityDeathEvent(LivingDeathEvent event){

        EntityLivingBase entity = event.entityLiving;

        if(entity.isPotionActive(PotionHelper.enderHeartBleed)){

            if(entity instanceof EntityMob || entity instanceof IMob){
                if(entity.worldObj.rand.nextInt(3) == 1) {
                    entity.dropItem(ModItems.enderShard, 1);
                }
            }

        }

    }

}
