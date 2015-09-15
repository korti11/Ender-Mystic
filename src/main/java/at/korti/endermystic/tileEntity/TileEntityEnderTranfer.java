package at.korti.endermystic.tileEntity;

import at.korti.endermystic.ModInfo;
import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetworkHandler;
import at.korti.endermystic.api.mysticEnergyNetwork.IEnergyProvider;
import at.korti.endermystic.api.util.IActivation;
import at.korti.endermystic.blocks.EnderInjector;
import at.korti.endermystic.blocks.EnderPicker;
import at.korti.endermystic.items.WorldStorage;
import at.korti.endermystic.modintegration.carpentersblock.CarpentersBlockHelper;
import at.korti.endermystic.modintegration.ee3.EquivalentExchange;
import at.korti.endermystic.modintegration.forgemultipart.ForgeMultipartHelper;
import cpw.mods.fml.common.Loader;
import net.minecraft.block.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.FakePlayer;

/**
 * Created by Korti on 21.06.2015.
 */
public class TileEntityEnderTranfer extends TileEntity implements IInventory, IActivation{

    private ItemStack inventory;
    private final int range = 10;

    @Override
    public int getSizeInventory() {
        return 1;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return inventory;
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        if (inventory != null) {
            if (inventory.stackSize <= amount) {
                setInventorySlotContents(slot, null);
            } else {
                inventory = inventory.splitStack(amount);
            }
        }
        return inventory;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        return inventory;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        inventory = stack;
        if (stack != null && stack.stackSize > getInventoryStackLimit()) {
            stack.stackSize = getInventoryStackLimit();
        }
    }

    @Override
    public String getInventoryName() {
        return "EnderTransfer";
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
        return player.getDistanceSq(xCoord, yCoord, zCoord) <= 64;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        return stack.getItem() instanceof WorldStorage;
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);
        NBTTagCompound stackTag = new NBTTagCompound();
        if(inventory != null) {
            inventory.writeToNBT(stackTag);
        }
        tagCompound.setTag("Inventory", stackTag);
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);
        inventory = ItemStack.loadItemStackFromNBT(tagCompound.getCompoundTag("Inventory"));
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        this.writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        this.readFromNBT(pkt.func_148857_g());
    }

    public void copyWorld() {
        if (inventory != null && !worldObj.isRemote) {
            WorldStorage worldStorage = (WorldStorage) inventory.getItem();
            int storageSize = worldStorage.getStorageSize();
            ItemStack[][][] worldPart = new ItemStack[storageSize][storageSize][storageSize];
            for (int x = xCoord + 1; x < storageSize + 1 + xCoord; x++) {
                for (int y = yCoord; y < storageSize + yCoord; y++) {
                    for (int z = zCoord + 1; z < storageSize + 1 + zCoord; z++) {
                        if (!worldObj.isAirBlock(x, y, z)) {
                            Block block = worldObj.getBlock(x, y, z);
                            if (Item.getItemFromBlock(block) == null || Item.getItemFromBlock(block).getUnlocalizedName().contains("Carpenter")) {
                                ItemStack item = block.getDrops(worldObj, x, y, z, worldObj.getBlockMetadata(x, y, z), 0).get(0);
                                if (item.getUnlocalizedName().contains("Carpenter") && Loader.isModLoaded(ModInfo.CARPENTERSBLOCKS)) {
                                    ItemStack carpenter = item.copy();
                                    TileEntity carpenterTile = worldObj.getTileEntity(x, y, z);
                                    carpenter.stackTagCompound = CarpentersBlockHelper.getNBTTagOfTileEntity(carpenterTile);
                                    worldPart[x - (xCoord + 1)][y - yCoord][z - (zCoord + 1)] = carpenter;
                                }
                                else if (!item.getUnlocalizedName().contains("microblock")) {
                                    worldPart[x - (xCoord + 1)][y - yCoord][z - (zCoord + 1)] = findBlockWithMaxMeta(x, y, z, worldObj.getBlockMetadata(x, y, z), block, item.getItem(), true);
                                } else {
                                    ItemStack multiPart = item.copy();
                                    NBTTagCompound multiTile = new NBTTagCompound();
                                    worldObj.getTileEntity(x, y, z).writeToNBT(multiTile);
                                    multiPart.stackTagCompound.setTag("MultiTile", multiTile);
                                    worldPart[x - (xCoord + 1)][y - yCoord][z - (zCoord + 1)] = multiPart;
                                }
                            }
                            else {
                                worldPart[x - (xCoord + 1)][y - yCoord][z - (zCoord + 1)] = new ItemStack(block, 1, worldObj.getBlockMetadata(x, y, z));
                            }
                        }
                    }
                }
            }

            inventory.stackTagCompound = new NBTTagCompound();
            NBTTagList blockList = new NBTTagList();

            for (int x = 0; x < storageSize; x++) {
                for (int y = 0; y < storageSize; y++) {
                    for (int z = 0; z < storageSize; z++) {
                        if(worldPart[x][y][z] != null) {
                            NBTTagCompound block = new NBTTagCompound();
                            block.setInteger("XCoord", x);
                            block.setInteger("YCoord", y);
                            block.setInteger("ZCoord", z);
                            worldPart[x][y][z].writeToNBT(block);
                            blockList.appendTag(block);
                        }
                    }
                }
            }

            inventory.stackTagCompound.setTag("World", blockList);
        }
    }

    public void injectWorld() {
        if (inventory != null && !worldObj.isRemote) {
            WorldStorage worldStorage = (WorldStorage) inventory.getItem();
            int storageSize = worldStorage.getStorageSize();
            NBTTagList blockList = inventory.stackTagCompound.getTagList("World", 10);
            ItemStack[][][] worldPart = new ItemStack[storageSize][storageSize][storageSize];
            IEnergyProvider energyProvider = EnergyNetworkHandler.getProvider(worldObj, xCoord, yCoord, zCoord, 10);
            if(energyProvider != null) {
                for (int i = 0; i < blockList.tagCount(); i++) {
                    NBTTagCompound block = blockList.getCompoundTagAt(i);
                    int x = block.getInteger("XCoord");
                    int y = block.getInteger("YCoord");
                    int z = block.getInteger("ZCoord");
                    ItemStack stackBlock = ItemStack.loadItemStackFromNBT(block);
                    worldPart[x][y][z] = stackBlock;
                }

                for (int x = xCoord + 1; x < storageSize + xCoord + 1; x++) {
                    for (int y = yCoord; y < storageSize + yCoord; y++) {
                        for (int z = zCoord + 1; z < storageSize + zCoord + 1; z++) {
                            ItemStack stack = worldPart[x - (xCoord + 1)][y - yCoord][z - (zCoord + 1)];
                            if (stack != null) {
                                Block block = Block.getBlockFromItem(stack.getItem());
                                float energy = 0;
                                if (Loader.isModLoaded(ModInfo.EQUIVALENTEXCHANGE)) {
                                    energy = EquivalentExchange.getEMCValue(stack);
                                    if(energy != 0) {
                                        energyProvider = EnergyNetworkHandler.getProvider(worldObj, xCoord, yCoord, zCoord, 10, (int) energy);
                                        if (energyProvider == null) {
                                            continue;
                                        }
                                    }
                                }
                                if (block.equals(Blocks.air) || block.getUnlocalizedName().contains("Carpenter")) {
                                    Item item = stack.getItem();
                                    EntityPlayer fakePlayer = new FakePlayer(MinecraftServer.getServer().worldServers[0], MinecraftServer.getServer().func_152357_F()[0]);
                                    if (item.getUnlocalizedName().contains("microblock")) {
                                        if (Loader.isModLoaded(ModInfo.FORGEMULTIPART)) {
                                            ForgeMultipartHelper.addMultiBlockToWorld(worldObj, x, y, z, energyProvider, stack.stackTagCompound.getCompoundTag("MultiTile"));
                                        }
                                    } else if (item.getUnlocalizedName().contains("Carpenter") && Loader.isModLoaded(ModInfo.CARPENTERSBLOCKS)) {
                                        energy = energy == 0 ? 120 : energy;
                                        if (energyProvider.hasEnoughEnergy((int) energy)) {
                                            item.onItemUse(stack, fakePlayer, worldObj, x, y - 1, z, 1, 0F, 0F, 0F);
                                            TileEntity carpenter = worldObj.getTileEntity(x, y, z);
                                            CarpentersBlockHelper.setTileEntityData(carpenter, stack.stackTagCompound);
                                            energyProvider.decrEnergy((int) energy);
                                        }
                                    } else {
                                        energy = energy == 0 ? 150 : energy;
                                        if (energyProvider.hasEnoughEnergy((int) energy)) {
                                            fakePlayer.rotationYaw = (stack.getItemDamage() - 8) * 90;
                                            item.onItemUse(stack, fakePlayer, worldObj, x, y - 1, z, 1, 0F, 0F, 0F);
                                            energyProvider.decrEnergy((int) energy);
                                        }
                                    }
                                } else {
                                    int harvestLevel = block.getHarvestLevel(stack.getItemDamage());
                                    int defaulEnergy = 100;
                                    if(energy == 0) {
                                        energy = harvestLevel > 0 ? defaulEnergy * harvestLevel : defaulEnergy;
                                    }
                                    if(energyProvider.hasEnoughEnergy((int)energy)) {
                                        energyProvider.decrEnergy((int)energy);
                                        boolean isHelperBlockPlaced = false;
                                        if (block instanceof BlockLever) {
                                            if (worldObj.isAirBlock(x, y + 1, z)) {
                                                worldObj.setBlock(x, y + 1, z, Blocks.cobblestone);
                                                isHelperBlockPlaced = true;
                                            }
                                        }
                                        worldObj.setBlock(x, y, z, block);
                                        worldObj.setBlockMetadataWithNotify(x, y, z, stack.getItemDamage(), 2);
                                        if (block instanceof BlockLever) {
                                            if (!worldObj.isAirBlock(x, y + 1, z) && isHelperBlockPlaced) {
                                                worldObj.setBlockToAir(x, y + 1, z);
                                            }
                                        } else if (block instanceof BlockPistonBase) {
                                            block.onNeighborBlockChange(worldObj, x, y, z, null);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private ItemStack findBlockWithMaxMeta(int x, int y, int z, int foundMeta, Block mainBlock, Item item, boolean threeDSearch) {
        for (int posX = x - 1; posX <= x + 1; posX++) {
            for (int posZ = z - 1; posZ <= z + 1; posZ++) {
                if(threeDSearch) {
                    for (int posY = y - 1; posY <= y + 1; posY++) {
                        Block block = worldObj.getBlock(posX, posY, posZ);
                        if (block.getClass().equals(mainBlock.getClass()) && worldObj.getBlockMetadata(posX, posY, posZ) > foundMeta) {
                            return new ItemStack(item, 1, worldObj.getBlockMetadata(posX, posY, posZ));
                        }
                    }
                }
                else {
                    Block block = worldObj.getBlock(posX, y, posZ);
                    if (block.getClass().equals(mainBlock.getClass()) && worldObj.getBlockMetadata(posX, y, posZ) > foundMeta) {
                        return new ItemStack(item, 1, worldObj.getBlockMetadata(posX, y, posZ));
                    }
                }
            }
        }
        return new ItemStack(item, 1, foundMeta);
    }

    @Override
    public void activate(Object obj) {
        if (obj instanceof EnderPicker) {
            copyWorld();
        }
        else if (obj instanceof EnderInjector) {
            injectWorld();
        }
    }
}
