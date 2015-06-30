package at.korti.endermystic.modintegration.waila;

import at.korti.endermystic.tileEntity.TileEntityOrbInfuser;
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
public class WailaOrbInfuserHandler implements IWailaDataProvider {
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
        iTipList.add("Connected to network: " + tagCompound.getBoolean("Connected"));
        iTipList.add("Rest time to craft: " + tagCompound.getFloat("TimeToCraft") + "s");
        iTipList.add("Result Item: " + tagCompound.getString("ResultItem"));
        return iTipList;
    }

    @Override
    public ITaggedList.ITipList getWailaTail(ItemStack itemStack, ITaggedList.ITipList iTipList, IWailaDataAccessor iWailaDataAccessor, IWailaConfigHandler iWailaConfigHandler) {
        return iTipList;
    }

    @Override
    public NBTTagCompound getNBTData(TileEntity tileEntity, NBTTagCompound nbtTagCompound, IWailaDataAccessorServer iWailaDataAccessorServer) {
        if (tileEntity instanceof TileEntityOrbInfuser) {
            TileEntityOrbInfuser infuser = (TileEntityOrbInfuser) tileEntity;
            nbtTagCompound.setBoolean("Connected", infuser.isConnected());
            nbtTagCompound.setFloat("TimeToCraft", infuser.getRestTime());
            nbtTagCompound.setString("ResultItem", infuser.getResultItemName());
        }
        return nbtTagCompound;
    }
}
