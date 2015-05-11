package at.korti.endermystic.client.containers;

import at.korti.endermystic.client.slots.BaubleSlot;
import at.korti.endermystic.tileEntity.TileEntityBaublesBackpack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

/**
 * Created by Korti on 05.12.2014.
 */
public class BaublesBackpackContainer extends Container {

    private TileEntityBaublesBackpack backpack;

    public BaublesBackpackContainer(InventoryPlayer inventoryPlayer, TileEntityBaublesBackpack backpack){
        this.backpack = backpack;

        for(int x = 0; x < 9; x++) {
            addSlotToContainer(new Slot(inventoryPlayer, x, 8 + 18 * x, 194));
        }

        for(int y = 0; y < 3; y++){
            for(int x = 0; x < 9; x++) {
                addSlotToContainer(new Slot(inventoryPlayer, x + y * 9 + 9, 8 + 18 * x, 136 + y * 18));
            }
        }

        int cnt = 1;

        for(int y = 0; y < 4; y++){
            for(int x = 0; x < 9; x++) {
                addSlotToContainer(new BaubleSlot(backpack, cnt, 8 + 18 * x, 75 + y * 18));
            }
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return backpack.isUseableByPlayer(player);
    }
}
