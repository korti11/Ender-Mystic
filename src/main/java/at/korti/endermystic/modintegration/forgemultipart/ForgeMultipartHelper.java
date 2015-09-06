package at.korti.endermystic.modintegration.forgemultipart;

import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetworkHandler;
import at.korti.endermystic.api.mysticEnergyNetwork.IEnergyProvider;
import codechicken.lib.vec.BlockCoord;
import codechicken.multipart.TileMultipart;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

/**
 * Created by Korti on 27.06.2015.
 */
public class ForgeMultipartHelper {

    public static void addMultiBlockToWorld(World world, int x, int y, int z, NBTTagCompound tagCompound) {
        TileMultipart multiTile = TileMultipart.createFromNBT(tagCompound);
        for (int i = 0; i < multiTile.partList().size(); i++) {
            TileMultipart.addPart(world, new BlockCoord(x, y, z), multiTile.partList().apply(i));
        }
    }

    public static void addMultiBlockToWorld(World world, int x, int y, int z, IEnergyProvider provider, NBTTagCompound tagCompound) {
        TileMultipart multipart = TileMultipart.createFromNBT(tagCompound);
        int energyUse = multipart.partList().size() * 25;
        if (provider.hasEnoughEnergy(energyUse)) {
            provider.decrEnergy(energyUse);
            addMultiBlockToWorld(world, x, y, z, tagCompound);
        }
    }

}
