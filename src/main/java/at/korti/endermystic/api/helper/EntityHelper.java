package at.korti.endermystic.api.helper;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

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

        if (entity.worldObj.blockExists(i, j, k))
        {
            boolean flag1 = false;

            while (!flag1 && j > 0)
            {
                Block block = entity.worldObj.getBlock(i, j - 1, k);

                if (block.getMaterial().blocksMovement())
                {
                    flag1 = true;
                }
                else
                {
                    --entity.posY;
                    --j;
                }
            }

            if (flag1)
            {
                entity.setPosition(entity.posX, entity.posY, entity.posZ);

                if (entity.worldObj.getCollidingBoundingBoxes(entity, entity.boundingBox).isEmpty() && !entity.worldObj.isAnyLiquid(entity.boundingBox))
                {
                    flag = true;
                }
            }
        }

        if (!flag)
        {
            entity.setPosition(d3, d4, d5);
            return;
        }
        else if(spawnParticle)
        {
            short short1 = 128;

            for (int l = 0; l < short1; ++l)
            {
                double d6 = (double)l / ((double)short1 - 1.0D);
                float f = (rand.nextFloat() - 0.5F) * 0.2F;
                float f1 = (rand.nextFloat() - 0.5F) * 0.2F;
                float f2 = (rand.nextFloat() - 0.5F) * 0.2F;
                double d7 = d3 + (entity.posX - d3) * d6 + (rand.nextDouble() - 0.5D) * (double)entity.width * 2.0D;
                double d8 = d4 + (entity.posY - d4) * d6 + rand.nextDouble() * (double)entity.height;
                double d9 = d5 + (entity.posZ - d5) * d6 + (rand.nextDouble() - 0.5D) * (double)entity.width * 2.0D;
                entity.worldObj.spawnParticle("portal", d7, d8, d9, (double)f, (double)f1, (double)f2);
            }

            return;
        }
    }

    /**
     * Teleport the entity to a random position.
     * @param entity
     * @param spawnParticle
     */
    public static void randomTeleport(Entity entity, boolean spawnParticle) {
        double d0 = entity.posX + (rand.nextDouble() - 0.5D) * 64.0D;
        double d1 = entity.posY + (double)(rand.nextInt(64) - 32);
        double d2 = entity.posZ + (rand.nextDouble() - 0.5D) * 64.0D;
        teleportEntity(entity, d0, d1, d2, spawnParticle);
    }

}
