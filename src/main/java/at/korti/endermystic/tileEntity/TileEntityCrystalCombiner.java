package at.korti.endermystic.tileEntity;

import at.korti.endermystic.api.crafting.CraftingRegistry;
import at.korti.endermystic.api.crafting.CrystalCombinerRecipe;
import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetworkHandler;
import at.korti.endermystic.api.mysticEnergyNetwork.IEnergyProvider;
import at.korti.endermystic.api.util.IActivation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Korti on 11.04.2015.
 */
public class TileEntityCrystalCombiner extends TileEntityInventory implements IActivation{

    private int timeToCraft = 0;
    private CrystalCombinerRecipe recipe = null;
    private int checkRequirementCount = 0;
    private final int range = 10;

    public TileEntityCrystalCombiner() {
        super("CrystalCombiner", 5, 1, true);
    }

    @Override
    public void activate(Object obj) {
        if(!worldObj.isRemote) {
            if (recipe == null) {
                for (int i = 0; i < CraftingRegistry.getInstance().recipeCount(); i++) {
                    recipe = CraftingRegistry.getInstance().getCrystalCombinerRecipe(i);
                    checkRequirementCount = 0;

                    if (recipe != null) {
                        for (int j = 0; j < recipe.requirementsCount(); j++) {
                            for (int l = 0; l < getSizeInventory() - 1; l++) {
                                if (getStackInSlot(l) == null) {
                                    continue;
                                }

                                if (getStackInSlot(l).getItem() == recipe.getRequirement(j).getItem() && getStackInSlot(l).getItemDamage() == recipe.getRequirement(j).getItemDamage()) {
                                    checkRequirementCount++;
                                    break;
                                }
                            }
                        }

                        if (recipe.requirementsCount() == checkRequirementCount && countSlotsUsed() == recipe.requirementsCount()) {
                            break;
                        }
                    }
                }

                if (recipe != null && recipe.requirementsCount() == checkRequirementCount && getStackInSlot(4) == null) {
                    timeToCraft = recipe.getTimeToCraft();
                } else {
                    recipe = null;
                }
            } else {
                timeToCraft = 0;
                recipe = null;
            }
        }
    }

    @Override
    public void updateEntity() {
        if(isInventoryEmpty()){
            return;
        }

        IEnergyProvider provider = EnergyNetworkHandler.getProvider(worldObj, xCoord, yCoord, zCoord, range);

        if(!worldObj.isRemote && provider != null && provider.canProvideEnergy() && recipe != null) {
            isOperating = false;
            if (timeToCraft == 0 && checkRequirementCount == recipe.requirementsCount()) {
                clearRequirementsSlots();
                setInventorySlotContents(4, new ItemStack(recipe.getResult().getItem(), 1, recipe.getResult().getItemDamage()));
                recipe = null;
                markDirty();
            } else if (timeToCraft > 0 && provider.hasEnoughEnergy(recipe.getEnergyUsePerTick())) {
                timeToCraft--;
                provider.decrEnergy(recipe.getEnergyUsePerTick());
                isOperating = true;
            }
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        }
        else if (worldObj.isRemote && timeToCraft % 2 == 0 && isOperating) {
            for (int l = 0; l < 128; ++l) {
                float f = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
                float f1 = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
                float f2 = (worldObj.rand.nextFloat() - 0.5F) * 0.2F;
                this.worldObj.spawnParticle("portal", xCoord + 0.5, yCoord + 0.75, zCoord + 0.5, (double) f, (double) f1, (double) f2);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setShort("TimeToCraft", (short) timeToCraft);
        compound.setShort("CheckRequirementCount", (short) checkRequirementCount);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        timeToCraft = compound.getShort("TimeToCraft");
        checkRequirementCount = compound.getShort("CheckRequirementCount");
    }

    private boolean isInventoryEmpty() {
        for (ItemStack stack : super.getInventory()) {
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

    public boolean isConnected(){
        return EnergyNetworkHandler.getProvider(worldObj, xCoord, yCoord, zCoord, range) != null;
    }

    /**
     * Get the rest time to craft in seconds.
     * @return Rest time.
     */
    public float getRestTime(){
        return timeToCraft / 20;
    }

    public String getResultItemName() {
        if (recipe != null) {
            return recipe.getResult().getDisplayName();
        }
        return "";
    }
}
