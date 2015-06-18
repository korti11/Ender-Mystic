package at.korti.endermystic.world;

import at.korti.endermystic.blocks.ModBlocks;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

/**
 * Created by Korti on 26.05.2015.
 */
public class OreGeneration implements IWorldGenerator{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        generate(world, random, chunkX, chunkZ);
    }

    public void generate(World world, Random random, int x, int z) {
        generateOre(ModBlocks.crystalOre, 0, world, random, x, z, 9);
        generateOre(ModBlocks.crystalOre, 1, world, random, x, z, 9);
        generateOre(ModBlocks.crystalOre, 2, world, random, x, z, 9);
        generateOre(ModBlocks.crystalOre, 3, world, random, x, z, 9);
    }

    public void generateOre(Block ore, int meta, World world, Random random, int blockXPos, int blockZPos, int maxVeinSize){

        int seaLevel = world.provider.getAverageGroundLevel() + 1;

        if (seaLevel < 20) {
            int x = (blockXPos << 4) + 8;
            int z = (blockZPos << 4) + 8;
            seaLevel = world.getHeightValue(x, z);
        }

        if (ore == null) {
            return;
        }

        double oreDepthMultiplier = maxVeinSize * seaLevel / 64;
        int scale = (int) Math.round(random.nextGaussian() * Math.sqrt(oreDepthMultiplier) + oreDepthMultiplier);

        for (int x = 0; x < (random.nextBoolean() ? 2 : scale) / 2; ++x) {
            WorldGenMinable blockOre = new WorldGenMinable(ore, meta, maxVeinSize, Blocks.stone);
            int cx = blockXPos * 16 + random.nextInt(22);
            int cy = random.nextInt(40 * seaLevel / 64) + random.nextInt(22 * seaLevel / 64) + 12 * seaLevel / 64;
            int cz = blockZPos * 16 + random.nextInt(22);
            blockOre.generate(world, random, cx, cy, cz);
        }

    }
}
