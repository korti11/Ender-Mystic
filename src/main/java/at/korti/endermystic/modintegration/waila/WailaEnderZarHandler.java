package at.korti.endermystic.modintegration.waila;

import at.korti.endermystic.tileEntity.TileEntityEnderZar;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Korti on 02.06.2015.
 */
public class WailaEnderZarHandler implements IWailaDataProvider {
    @Override
    public ItemStack getWailaStack(IWailaDataAccessor iWailaDataAccessor, IWailaConfigHandler iWailaConfigHandler) {
        return null;
    }

    @Override
    public List<String> getWailaHead(ItemStack itemStack, List<String> list, IWailaDataAccessor iWailaDataAccessor, IWailaConfigHandler iWailaConfigHandler) {
        return list;
    }

    @Override
    public List<String> getWailaBody(ItemStack itemStack, List<String> list, IWailaDataAccessor iWailaDataAccessor, IWailaConfigHandler iWailaConfigHandler) {
        NBTTagCompound tagCompound = iWailaDataAccessor.getNBTData();
        list.add("Stored Energy: " + tagCompound.getInteger("StoredEnergy"));
        list.add("Timer: " + tagCompound.getInteger("Timer"));
        return list;
    }

    @Override
    public List<String> getWailaTail(ItemStack itemStack, List<String> list, IWailaDataAccessor iWailaDataAccessor, IWailaConfigHandler iWailaConfigHandler) {
        return list;
    }

    @Override
    public NBTTagCompound getNBTData(EntityPlayerMP entityPlayerMP, TileEntity tileEntity, NBTTagCompound nbtTagCompound, World world, int i, int i1, int i2) {
        if (tileEntity instanceof TileEntityEnderZar) {
            TileEntityEnderZar enderZar = (TileEntityEnderZar) tileEntity;
            nbtTagCompound.setInteger("StoredEnergy", enderZar.getStoredEnergy());
            nbtTagCompound.setInteger("Timer", enderZar.getTimer());
        }
        return nbtTagCompound;
    }
}
