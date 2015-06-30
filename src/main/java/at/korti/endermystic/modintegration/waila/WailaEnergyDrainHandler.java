package at.korti.endermystic.modintegration.waila;

import at.korti.endermystic.tileEntity.TileEntityEnergyDrain;
import mcp.mobius.waila.api.*;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Korti on 02.06.2015.
 */
public class WailaEnergyDrainHandler implements IWailaDataProvider{
    @Override
    public ItemStack getWailaStack(IWailaDataAccessor iWailaDataAccessor, IWailaConfigHandler iWailaConfigHandler) {
        return null;
    }

    @Override
    public ITaggedList.ITipList getWailaHead(ItemStack itemStack, ITaggedList.ITipList iTipList, IWailaDataAccessor iWailaDataAccessor, IWailaConfigHandler iWailaConfigHandler) {
        return iTipList;
    }

    @Override
    public ITaggedList.ITipList getWailaBody(ItemStack itemStack, ITaggedList.ITipList iTipList, IWailaDataAccessor iWailaDataAccessor, IWailaConfigHandler iWailaConfigHandler) {
        NBTTagCompound tagCompound = iWailaDataAccessor.getNBTData();
        iTipList.add("Can provide energy: " + tagCompound.getBoolean("CanProvide"));
        iTipList.add("Stored Energy: " + tagCompound.getInteger("Energy"));
        return iTipList;
    }

    @Override
    public ITaggedList.ITipList getWailaTail(ItemStack itemStack, ITaggedList.ITipList iTipList, IWailaDataAccessor iWailaDataAccessor, IWailaConfigHandler iWailaConfigHandler) {
        return iTipList;
    }

    @Override
    public NBTTagCompound getNBTData(TileEntity tileEntity, NBTTagCompound nbtTagCompound, IWailaDataAccessorServer iWailaDataAccessorServer) {
        if (tileEntity instanceof TileEntityEnergyDrain) {
            TileEntityEnergyDrain drain = (TileEntityEnergyDrain) tileEntity;
            nbtTagCompound.setBoolean("CanProvide", drain.canProvideEnergy());
            nbtTagCompound.setInteger("Energy", drain.getEnergyToProvide());
        }
        return nbtTagCompound;
    }
}
