package at.korti.endermystic.modintegration.waila;

import at.korti.endermystic.tileEntity.TileEntityEnergyCrystalStorage;
import mcp.mobius.waila.api.*;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Korti on 03.06.2015.
 */
public class WailaEnergyCrystalStorageHandler implements IWailaDataProvider {
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
        iTipList.add("Energy " + tagCompound.getInteger("CurrentEnergy") + "/" + tagCompound.getInteger("MaxEnergy"));
        return iTipList;
    }

    @Override
    public ITaggedList.ITipList getWailaTail(ItemStack itemStack, ITaggedList.ITipList iTipList, IWailaDataAccessor iWailaDataAccessor, IWailaConfigHandler iWailaConfigHandler) {
        return iTipList;
    }

    @Override
    public NBTTagCompound getNBTData(TileEntity tileEntity, NBTTagCompound nbtTagCompound, IWailaDataAccessorServer iWailaDataAccessorServer) {
        if (tileEntity instanceof TileEntityEnergyCrystalStorage) {
            TileEntityEnergyCrystalStorage storage = (TileEntityEnergyCrystalStorage) tileEntity;
            nbtTagCompound.setInteger("CurrentEnergy", storage.getEnergyToProvide());
            nbtTagCompound.setInteger("MaxEnergy", storage.getMaxStorage());
        }
        return nbtTagCompound;
    }
}
