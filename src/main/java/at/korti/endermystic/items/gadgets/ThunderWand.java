package at.korti.endermystic.items.gadgets;

import at.korti.endermystic.api.helper.EntityHelper;
import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetworkHandler;
import at.korti.endermystic.items.EnergyItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Korti on 23.09.2015.
 */
public class ThunderWand extends EnergyItem{

    private final int range = 12;

    public ThunderWand() {
        super("ThunderWand");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {

        String owner = EnergyNetworkHandler.getOwner(stack);

        if(!owner.isEmpty()) {
            List mobs = world.getEntitiesWithinAABB(IMob.class, AxisAlignedBB.getBoundingBox(player.posX - range, player.posY - range, player.posZ - range, player.posX + range, player.posY + range, player.posZ + range));

            while (mobs.size() > 0) {
                Entity e = (Entity) mobs.get(world.rand.nextInt(mobs.size()));
                if (!(e instanceof EntityLivingBase)) {
                    mobs.remove(e);
                    continue;
                }

                if (EntityHelper.canEntitySeeSky(e, world) && EnergyNetworkHandler.isEnoughEnergy(250, owner)) {
                    world.addWeatherEffect(new EntityLightningBolt(world, e.posX, e.posY, e.posZ));
                    EnergyNetworkHandler.decEnergy(250, owner);
                }
                break;
            }
        }

        return super.onItemRightClick(stack, world, player);
    }
}
