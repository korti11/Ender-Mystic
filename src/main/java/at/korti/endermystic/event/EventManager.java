package at.korti.endermystic.event;

import at.korti.endermystic.api.tools.ToolLevelHandler;
import at.korti.endermystic.api.util.AbilityHelper;
import at.korti.endermystic.items.ModItem;
import at.korti.endermystic.items.ModItems;
import at.korti.endermystic.items.tools.EnderSoulExcavator;
import at.korti.endermystic.items.tools.EnderSoulHammer;
import at.korti.endermystic.potion.PotionHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.world.BlockEvent;

import java.time.LocalTime;
import java.util.Random;

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
                    entity.entityDropItem(new ItemStack(ModItems.enderItem, entity.worldObj.rand.nextInt(2) + 1, 0), 0.0F);
                }
            }

        }

    }

    @SubscribeEvent
    public void onEntityAttack(LivingAttackEvent event) {
        boolean check = ToolLevelHandler.getInstance().handleSharpnessUpgrade(event) || ToolLevelHandler.getInstance().handleFireyUpgrade(event);
        EntityPlayer player = (EntityPlayer) event.source.getSourceOfDamage();
        if(player != null) {
            AbilityHelper.addEnderHeartBleedPotion(player.inventory.getCurrentItem(), event.entityLiving);
            if(check) {
                ToolLevelHandler.getInstance().cancleEventIf(event, player.inventory.getCurrentItem());
            }
        }
    }

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent event) {
        boolean check = handleBreak(event);
        handleMultiBreak(event.getPlayer().inventory.getCurrentItem(), event.world, event.getPlayer(), event.x, event.y, event.z);
        if (check) {
            ToolLevelHandler.getInstance().cancleEventIf(event, event.getPlayer().inventory.getCurrentItem());
        }
    }

    private void handleMultiBreak(ItemStack stack, World world, EntityPlayer player, int x, int y, int z) {
        if (stack.getItem() instanceof EnderSoulHammer || stack.getItem() instanceof EnderSoulExcavator) {
            MovingObjectPosition mop = AbilityHelper.raytraceFromEntity(world, player, false, 4.5D);
            if (mop != null) {
                AbilityHelper.BreakMultiBlocks(player, stack, world, x, y, z, mop.sideHit, 3);
            } else {
                return;
            }
        }
    }

    private boolean handleBreak(BlockEvent.BreakEvent event) {
        ToolLevelHandler.getInstance().addXP(event.getPlayer().inventory.getCurrentItem(), 1);
        return ToolLevelHandler.getInstance().handleLuckUpgrade(event) || ToolLevelHandler.getInstance().handleSilkTouchUpgrade(event) || ToolLevelHandler.getInstance().handleAutoSmeltUpgrade(event);
    }
}
