package at.korti.endermystic.modintegration.baubles.rings;

import at.korti.endermystic.api.helper.EntityHelper;
import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetwork;
import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetworkHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Korti on 21.09.2015.
 */
public class WaterShieldRing extends Ring {

    private final int range = 10;

    public WaterShieldRing() {
        super("WaterShieldRing", 13260);
    }

    @Override
    public void onWornTick(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        String owner = EnergyNetworkHandler.getOwner(itemStack);
        World world = entityLivingBase.worldObj;
        List<Entity> endermans = world.getEntitiesWithinAABB(EntityEnderman.class, AxisAlignedBB.getBoundingBox(entityLivingBase.posX - (range / 2), entityLivingBase.posY - 1, entityLivingBase.posZ - (range / 2), entityLivingBase.posX + (range / 2), entityLivingBase.posY + 1, entityLivingBase.posZ + (range / 2)));
        if(EnergyNetworkHandler.isEnoughEnergy(100 * endermans.size(), owner)) {
            for (Entity entity : endermans) {
                if (entity instanceof EntityEnderman) {
                    EntityEnderman enderman = (EntityEnderman) entity;
                    enderman.attackEntityFrom(DamageSource.drown, 1.0F);
                    EntityHelper.randomTeleport(enderman, true);
                    EnergyNetworkHandler.decEnergy(100, owner);
                }
            }
        }
    }
}
