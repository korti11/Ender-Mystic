package at.korti.endermystic.tileEntity;

import at.korti.endermystic.api.crafting.CraftingRegistry;
import at.korti.endermystic.api.crafting.OrbInfuserRecipe;
import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetworkHandler;
import at.korti.endermystic.api.mysticEnergyNetwork.IEnergyProvider;
import at.korti.endermystic.items.CrystalItem;
import at.korti.endermystic.items.OrbCoreItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Korti on 13.05.2015.
 */
public class TileEntityOrbInfuser extends TileEntity implements IInventory{

    private ItemStack[] inventory = new ItemStack[9];
    private int timeStartToCraft = 0;
    private int timeToCraft = 0;
    private OrbInfuserRecipe recipe = null;
    private final int range = 10;
    private int checkRequirementCount = 0;
    private List<Integer> usedSlots = new ArrayList<Integer>();

    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        ItemStack stack = getStackInSlot(slot);

        if(stack != null) {
            if (stack.stackSize <= amount) {
                setInventorySlotContents(slot, null);
            }
            else {
                stack = stack.splitStack(amount);
            }
        }
        markDirty();
        return stack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        inventory[slot] = stack;
        if (stack != null && stack.stackSize > getInventoryStackLimit()) {
            stack.stackSize = getInventoryStackLimit();
        }
        markDirty();
        timeStartToCraft = 80;
    }

    @Override
    public String getInventoryName() {
        return "OrbInfuser";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 1;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) <= 64;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        if (slot == 8) {
            return stack.getItem() instanceof ItemEnderPearl;
        }
        return stack.getItem() instanceof CrystalItem;
    }

    @Override
    public void updateEntity() {
        if(isInventoryEmpty()){
            return;
        }

        IEnergyProvider provider = EnergyNetworkHandler.getProvider(worldObj, xCoord, yCoord, zCoord, range);

        if(provider != null && provider.canProvideEnergy()) {
            if (timeToCraft == 0 && recipe == null && timeStartToCraft == 0) {
                for (int i = 0; i < CraftingRegistry.getInstance().recipeCount(); i++) {
                    recipe = CraftingRegistry.getInstance().getOrbInfuserRecipe(i);
                    usedSlots.clear();
                    checkRequirementCount = 0;

                    if(recipe != null) {
                        for (int j = 0; j < recipe.requirementsCount(); j++) {
                            for (int l = 0; l < getSizeInventory(); l++) {
                                if (getStackInSlot(l) == null) {
                                    continue;
                                }

                                if (getStackInSlot(l).getItem() == recipe.getRequirements(j).getItem() && getStackInSlot(l).getItemDamage() == recipe.getRequirements(j).getItemDamage() && !usedSlots.contains(l)) {
                                    checkRequirementCount++;
                                    usedSlots.add(l);
                                    break;
                                }
                            }
                        }

                        if (recipe.requirementsCount() == checkRequirementCount && countSlotsUsed() == recipe.requirementsCount()) {
                            break;
                        }
                    }
                }

                if (recipe != null && recipe.requirementsCount() == checkRequirementCount && !(getStackInSlot(8).getItem() instanceof OrbCoreItem)) {
                    timeToCraft = recipe.getTimeToCraft();
                    for (int l = 0; l < 128; ++l) {
                        float f = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
                        float f1 = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
                        float f2 = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
                        this.worldObj.spawnParticle("portal", xCoord + 0.5, yCoord + 0.75, zCoord + 0.5, (double) f, (double) f1, (double) f2);
                    }
                } else {
                    recipe = null;
                }
            }

            if (timeToCraft == 0 && recipe != null && checkRequirementCount == recipe.requirementsCount() && timeStartToCraft == 0) {
                clearRequirementsSlots();
                setInventorySlotContents(8, new ItemStack(recipe.getResult().getItem(), 1, recipe.getResult().getItemDamage()));
                recipe = null;
                usedSlots.clear();
                markDirty();
            } else if (timeToCraft > 0 && timeStartToCraft == 0 && recipe != null && provider.hasEnoughEnergy(recipe.getEnergyUsePerTick())) {
                timeToCraft--;
                provider.decrEnergy(recipe.getEnergyUsePerTick());
                if (timeToCraft % 2 == 0) {
                    for (int l = 0; l < 128; ++l) {
                        float f = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
                        float f1 = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
                        float f2 = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
                        this.worldObj.spawnParticle("portal", xCoord + 0.5, yCoord + 0.75, zCoord + 0.5, (double) f, (double) f1, (double) f2);
                    }
                }
            } else if (timeStartToCraft > 0) {
                timeStartToCraft--;
                timeToCraft = 0;
                recipe = null;
                usedSlots.clear();
            }
        }

        if(worldObj.isRemote){
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        }

    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setShort("TimeToCraft", (short) timeToCraft);
        compound.setShort("CheckRequirementCount", (short) checkRequirementCount);
        NBTTagList tagList = new NBTTagList();

        for(int i = 0; i < getSizeInventory(); i++){
            if(getStackInSlot(i) != null){
                NBTTagCompound temp = new NBTTagCompound();
                temp.setByte("Slot", (byte) i);
                getStackInSlot(i).writeToNBT(temp);
                tagList.appendTag(temp);
            }
        }
        compound.setTag("Items", tagList);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        NBTTagList tagList = compound.getTagList("Items", 10);

        for(int i = 0; i < tagList.tagCount(); i++){
            NBTTagCompound temp = tagList.getCompoundTagAt(i);
            byte slot = temp.getByte("Slot");

            if(slot >= 0 && slot < getSizeInventory()){
                setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(temp));
            }
        }

        timeToCraft = compound.getShort("TimeToCraft");
        checkRequirementCount = compound.getShort("CheckRequirementCount");
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        this.writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        readFromNBT(pkt.func_148857_g());
    }

    private boolean isInventoryEmpty() {
        for (ItemStack stack : inventory) {
            if(stack != null){
                return false;
            }
        }

        return true;
    }

    private void clearRequirementsSlots(){
        for(int i = 0; i < getSizeInventory() - 1; i++){
            setInventorySlotContents(i, null);
        }
    }

    private int countSlotsUsed(){
        int count = 0;
        for(int i = 0; i < getSizeInventory(); i++){
            if(getStackInSlot(i) != null){
                count++;
            }
        }
        return count;
    }
}
