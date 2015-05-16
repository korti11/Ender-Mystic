package at.korti.endermystic.event;

import at.korti.endermystic.api.tools.ToolLevelHandler;
import at.korti.endermystic.api.tools.ToolUpgrade;
import at.korti.endermystic.api.util.AbilityHelper;
import at.korti.endermystic.items.ModItems;
import at.korti.endermystic.potion.PotionHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.world.BlockEvent;

/**
 * Created by Korti on 27.10.2014.
 */
public class EventManager {

    @SubscribeEvent
    public void onEntityDeath(LivingDeathEvent event){

        EntityLivingBase entity = event.entityLiving;

        if(entity.isPotionActive(PotionHelper.enderHeartBleed)){

            if(entity instanceof EntityMob || entity instanceof IMob){
                if(entity.worldObj.rand.nextInt(3) == 1) {
                    entity.dropItem(ModItems.enderShard, 1);
                }
            }

        }

    }

    @SubscribeEvent
    public void onEntityAttack(LivingAttackEvent event) {
        ToolLevelHandler.getInstance().handleSharpnessUpgrade(event);
        ToolLevelHandler.getInstance().handleFireyUpgrade(event);
        EntityPlayer player = (EntityPlayer) event.source.getSourceOfDamage();
        if(player != null) {
            AbilityHelper.addEnderHeartBleedPotion(player.inventory.getCurrentItem(), event.entityLiving);
            ToolLevelHandler.getInstance().cancleEventIf(event, player.inventory.getCurrentItem());
        }
    }

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent event) {
        ToolLevelHandler.getInstance().addXP(event.getPlayer().inventory.getCurrentItem(), 1);
        ToolLevelHandler.getInstance().handleLuckUpgrade(event);
        ToolLevelHandler.getInstance().handleSilkTouchUpgrade(event);
        ToolLevelHandler.getInstance().handleAutoSmeltUpgrade(event);
        ToolLevelHandler.getInstance().cancleEventIf(event, event.getPlayer().inventory.getCurrentItem());
    }
}
