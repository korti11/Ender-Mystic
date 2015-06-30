package at.korti.endermystic.modintegration.waila;

import at.korti.endermystic.tileEntity.TileEntityCrystalCombiner;
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
public class WailaCrystalCombinerHandler implements IWailaDataProvider {

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
        iTipList.add("Has network enough energy: " + tagCompound.getBoolean("Connected"));
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
        if (tileEntity instanceof TileEntityCrystalCombiner) {
            TileEntityCrystalCombiner combiner = (TileEntityCrystalCombiner) tileEntity;
            nbtTagCompound.setBoolean("Connected", combiner.isConnected());
            nbtTagCompound.setFloat("TimeToCraft", combiner.getRestTime());
            nbtTagCompound.setString("ResultItem", combiner.getResultItemName());
        }
        return nbtTagCompound;
    }
}
