package at.korti.endermystic.event;

import at.korti.endermystic.ModInfo;
import at.korti.endermystic.api.tools.ToolLevelHandler;
import at.korti.endermystic.api.util.AbilityHelper;
import at.korti.endermystic.items.ModItems;
import at.korti.endermystic.items.tools.EnderSoulExcavator;
import at.korti.endermystic.items.tools.EnderSoulHammer;
import at.korti.endermystic.potion.PotionHelper;
import at.korti.endermystic.util.UpdateChecker;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent;

/**
 * Created by Korti on 27.10.2014.
 */
public class EventManager {

    @SubscribeEvent
    public void onEntityDeath(LivingDeathEvent event){

        EntityLivingBase entity = event.entityLiving;

        if(entity != null && entity.isPotionActive(PotionHelper.enderHeartBleed)){

            if(entity instanceof EntityMob || entity instanceof IMob){
                if(entity.worldObj.rand.nextInt(3) == 1) {
                    entity.entityDropItem(new ItemStack(ModItems.enderItem, entity.worldObj.rand.nextInt(2) + 1, 0), 0.0F);
                }
            }

        }

    }

    @SubscribeEvent
    public void onPlayerJoin(EntityJoinWorldEvent event) {
        if (event.world.isRemote) {
            if (event.entity instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) event.entity;
                if(UpdateChecker.getInstance().getStatus() == UpdateChecker.UpdateStatus.ISNOTUPTODATE) {
                    player.addChatMessage(new ChatComponentText("There is a newer version then " + EnumChatFormatting.GOLD.toString() + ModInfo.VERSION + EnumChatFormatting.RESET.toString() + " of " + EnumChatFormatting.DARK_GREEN.toString() + ModInfo.NAME + EnumChatFormatting.RESET.toString() + "!"));
                }
                else if (UpdateChecker.getInstance().getStatus() == UpdateChecker.UpdateStatus.ISUPTODATE) {
                    player.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_GREEN.toString() + ModInfo.NAME + EnumChatFormatting.RESET.toString() + " is up to date!"));
                } else {
                    player.addChatMessage(new ChatComponentText("There is no status about the version of " + EnumChatFormatting.DARK_GREEN.toString() + ModInfo.NAME + EnumChatFormatting.RESET.toString() + "!"));
                }
            }
        }
    }
}
