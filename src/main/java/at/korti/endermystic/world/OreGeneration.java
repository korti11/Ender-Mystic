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
        switch (world.provider.dimensionId) {
            case 0:
                generateOverworld(world, random, chunkX * 16, chunkZ * 16);
        }
    }

    public void generateOverworld(World world, Random random, int x, int z) {
        addOreSpawn(ModBlocks.crystalOre, 0, world, random, x, z, 16, 16, 3, 15, 10, 50);
        addOreSpawn(ModBlocks.crystalOre, 1, world, random, x, z, 16, 16, 3, 15, 10, 50);
        addOreSpawn(ModBlocks.crystalOre, 2, world, random, x, z, 16, 16, 3, 15, 10, 50);
        addOreSpawn(ModBlocks.crystalOre, 3, world, random, x, z, 16, 16, 3, 15, 10, 50);
    }

    public void addOreSpawn(Block ore, int meta, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY){

        int diff = maxY - minY;

        for(int i = 0; i < chancesToSpawn; i++){
            int posX = blockXPos + random.nextInt(maxX);
            int posY = minY + random.nextInt(diff);
            int posZ = blockZPos + random.nextInt(maxZ);
            (new WorldGenMinable(ore, meta, maxVeinSize, Blocks.stone)).generate(world, random, posX, posY, posZ);
        }

    }
}
