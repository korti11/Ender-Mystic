package at.korti.endermystic.api.helper;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

import java.util.List;
import java.util.Random;

/**
 * Created by Korti on 21.09.2015.
 */
public class EntityHelper {

    private static Random rand = new Random();

    /**
     * Teleport entity to the positon posX, posY, posZ.
     *
     * Same code that use the enderman to teleport.
     * @param entity
     * @param posX
     * @param posY
     * @param posZ
     * @param spawnParticle
     */
    public static void teleportEntity(Entity entity, double posX, double posY, double posZ, boolean spawnParticle) {
        if (entity == null) {
            return;
        }

        double d3 = entity.posX;
        double d4 = entity.posY;
        double d5 = entity.posZ;
        entity.posX = posX;
        entity.posY = posY;
        entity.posZ = posZ;
        boolean flag = false;
        int i = MathHelper.floor_double(entity.posX);
        int j = MathHelper.floor_double(entity.posY);
        int k = MathHelper.floor_double(entity.posZ);

        if (entity.worldObj.blockExists(i, j, k)) {
            boolean flag1 = false;

            while (!flag1 && j > 0) {
                Block block = entity.worldObj.getBlock(i, j - 1, k);

                if (block.getMaterial().blocksMovement()) {
                    flag1 = true;
                } else {
                    --entity.posY;
                    --j;
                }
            }

            if (flag1) {
                entity.setPosition(entity.posX, entity.posY, entity.posZ);

                if (entity.worldObj.getCollidingBoundingBoxes(entity, entity.boundingBox).isEmpty() && !entity.worldObj.isAnyLiquid(entity.boundingBox)) {
                    flag = true;
                }
            }
        }

        if (!flag) {
            entity.setPosition(d3, d4, d5);
            return;
        } else if (spawnParticle && entity.worldObj.isRemote) {
            short short1 = 128;

            for (int l = 0; l < short1; ++l) {
                double d6 = (double) l / ((double) short1 - 1.0D);
                float f = (rand.nextFloat() - 0.5F) * 0.2F;
                float f1 = (rand.nextFloat() - 0.5F) * 0.2F;
                float f2 = (rand.nextFloat() - 0.5F) * 0.2F;
                double d7 = d3 + (entity.posX - d3) * d6 + (rand.nextDouble() - 0.5D) * (double) entity.width * 2.0D;
                double d8 = d4 + (entity.posY - d4) * d6 + rand.nextDouble() * (double) entity.height;
                double d9 = d5 + (entity.posZ - d5) * d6 + (rand.nextDouble() - 0.5D) * (double) entity.width * 2.0D;
                entity.worldObj.spawnParticle("portal", d7, d8, d9, (double) f, (double) f1, (double) f2);
            }

            return;
        }
    }

    public static void teleportPlayer(EntityPlayer player, double posX, double posY, double posZ, int side, boolean spawnParticle) {
        if (player.worldObj.isRemote && spawnParticle) {
            player.worldObj.spawnParticle("portal", player.posX, player.posY + rand.nextGaussian() * 2.0D, player.posZ, rand.nextGaussian(), 0.0D, rand.nextGaussian());
        } else {
            if (player instanceof EntityPlayerMP) {
                EntityPlayerMP entityPlayerMP = (EntityPlayerMP) player;

                if (entityPlayerMP.playerNetServerHandler.func_147362_b().isChannelOpen()) {

                    boolean above = side == 1 ? WorldHelper.isAirBlock((int) posX, (int) posY, (int) posZ, 1, entityPlayerMP.worldObj) : false;
                    if (above || WorldHelper.isAirBlock((int) posX, (int) posY, (int) posX, side, entityPlayerMP.worldObj)) {
                        entityPlayerMP.posX = posX;
                        entityPlayerMP.posY = posY;
                        entityPlayerMP.posZ = posZ;
                        if (!above) {
                            moveEntityOneBlockOfSide(entityPlayerMP, side);
                        } else {
                            entityPlayerMP.posY++;
                        }

                        EnderTeleportEvent event = new EnderTeleportEvent(entityPlayerMP, entityPlayerMP.posX, entityPlayerMP.posY, entityPlayerMP.posZ, 5.0F);
                        if (!MinecraftForge.EVENT_BUS.post(event)) {
                            if (player.isRiding()) {
                                player.mountEntity(null);
                            }
                            player.setPositionAndUpdate(event.targetX, event.targetY, event.targetZ);
                            entityPlayerMP.fallDistance = 0.0F;
                            player.attackEntityFrom(DamageSource.fall, event.attackDamage);
                        }
                    }
                }
            }
        }
    }

    /**
     * Teleport the entity to a random position.
     * @param entity
     * @param spawnParticle
     */
    public static void randomTeleport(Entity entity, boolean spawnParticle) {
        if(entity != null) {
            double d0 = entity.posX + (rand.nextDouble() - 0.5D) * 64.0D;
            double d1 = entity.posY + (double) (rand.nextInt(64) - 32);
            double d2 = entity.posZ + (rand.nextDouble() - 0.5D) * 64.0D;
            teleportEntity(entity, d0, d1, d2, spawnParticle);
        }
    }

    public static boolean canEntitySeeSky(Entity entity, World world) {
        int posX = (int) entity.posX;
        int posY = (int) entity.posY;
        int posZ = (int) entity.posZ;

        for (int y = posY; y < 150; y++) {
            Block block = world.getBlock(posX, y, posZ);
            if (block != Blocks.air) {
                return false;
            }
        }
        return true;
    }

    public static Entity getRandomEntityInRange(World world, double posX, double posY, double posZ, double range) {
        List<EntityLivingBase> entities = world.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(posX - range, posY - range, posZ - range, posX + range, posY + range, posZ + range));

        while(entities.size() > 0) {
            Entity e = entities.get(world.rand.nextInt(entities.size()));
            if (!(e instanceof EntityLivingBase)) {
                entities.remove(e);
                continue;
            }

            return e;
        }

        return null;
    }

    public static void moveEntityOneBlockOfSide(Entity entity, int side) {
        switch (side){
            case 0:
                entity.posY--;
                break;
            case 1:
                entity.posY++;
                break;
            case 2:
                entity.posZ--;
                break;
            case 3:
                entity.posZ++;
                break;
            case 4:
                entity.posX--;
                break;
            case 5:
                entity.posX++;
                break;
            default:
                break;
        }
    }

}
