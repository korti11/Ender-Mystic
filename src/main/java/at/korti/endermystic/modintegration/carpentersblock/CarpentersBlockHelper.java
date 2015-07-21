package at.korti.endermystic.modintegration.carpentersblock;

import com.carpentersblocks.tileentity.TEBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Korti on 29.06.2015.
 */
public class CarpentersBlockHelper {

    public static NBTTagCompound getNBTTagOfTileEntity(TileEntity tile){
        TEBase teBase = (TEBase) tile;
        NBTTagCompound  nbtTile = new NBTTagCompound();
        NBTTagList sideAttributes = new NBTTagList();
        NBTTagList chiselDesign = new NBTTagList();
        nbtTile.setInteger("SlopeID", teBase.getData());
        nbtTile.setString("Design", teBase.getDesign());
        for (int i = 0; i < TEBase.ATTR_COVER.length; i++) {
            byte attrId = TEBase.ATTR_COVER[i];
            if (teBase.hasAttribute(attrId)) {
                NBTTagCompound side = new NBTTagCompound();
                side.setByte("Side", attrId);
                teBase.getAttribute(attrId).writeToNBT(side);
                sideAttributes.appendTag(side);
            }
        }
        nbtTile.setTag("SideAttri", sideAttributes);
        for (int i = 0; i < 7; i++) {
            NBTTagCompound design = new NBTTagCompound();
            design.setInteger("Side", i);
            design.setString("ChiselDesign", teBase.getChiselDesign(i));
            chiselDesign.appendTag(design);
        }
        nbtTile.setTag("ChiselDesigns", chiselDesign);
        return nbtTile;
    }

    public static void setTileEntityData(TileEntity tile, NBTTagCompound tagCompound) {
        TEBase teBase = (TEBase) tile;
        int slopeID = tagCompound.getInteger("SlopeID");
        String designName = tagCompound.getString("Design");
        NBTTagList sideAttributes = tagCompound.getTagList("SideAttri", 10);
        NBTTagList chiselDesign = tagCompound.getTagList("ChiselDesigns", 10);
        teBase.setData(slopeID);
        teBase.setDesign(designName);
        for (int i = 0; i < sideAttributes.tagCount(); i++) {
            NBTTagCompound side = sideAttributes.getCompoundTagAt(i);
            byte attrId = side.getByte("Side");
            ItemStack stack = ItemStack.loadItemStackFromNBT(side);
            teBase.addAttribute(attrId, stack);
        }
        for (int i = 0; i < chiselDesign.tagCount(); i++) {
            NBTTagCompound design = chiselDesign.getCompoundTagAt(i);
            int side = design.getInteger("Side");
            String chisel = design.getString("ChiselDesign");
            teBase.setChiselDesign(side, chisel);
        }
    }

}
