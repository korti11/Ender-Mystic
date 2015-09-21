package at.korti.endermystic.blocks;

import at.korti.endermystic.EnderMystic;
import at.korti.endermystic.ModInfo;
import at.korti.endermystic.api.crafting.IItemBookCrafting;
import at.korti.endermystic.api.helper.InventoryHelper;
import at.korti.endermystic.api.helper.WorldHelper;
import at.korti.endermystic.tileEntity.TileEntityOrbInfuser;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by Korti on 13.05.2015.
 */
public class OrbInfuser extends ModelBlock implements IItemBookCrafting {

    public OrbInfuser() {
        super(Material.rock, TileEntityOrbInfuser.class);

        setCreativeTab(EnderMystic.tab);
        setBlockBounds(0.05F, 0.0F, 0.05F, 0.95F, 0.75F, 0.95F);
        setBlockName(ModInfo.MODID + ".OrbInfuser");
        setStepSound(soundTypeStone);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        System.out.println("HitX: " + hitX + ", HitY: " + hitY + ", HitZ: " + hitZ + ", Side: " + side);

        TileEntityOrbInfuser infuser = (TileEntityOrbInfuser) world.getTileEntity(x, y, z);

        if(InventoryHelper.isBetween(0.40F, 0.60F, hitX) && InventoryHelper.isBetween(0.74F, 0.94F, hitZ)){      //Slot 1
            InventoryHelper.setStackInSlot(0, player, infuser);
        }
        else if(InventoryHelper.isBetween(0.09F, 0.29F, hitX) && InventoryHelper.isBetween(0.71F, 0.91F, hitZ)){      //Slot 2
            InventoryHelper.setStackInSlot(1, player, infuser);
        }
        else if(InventoryHelper.isBetween(0.06F, 0.26F, hitX) && InventoryHelper.isBetween(0.40F, 0.60F, hitZ)){      //Slot 3
            InventoryHelper.setStackInSlot(2, player, infuser);
        }
        else if(InventoryHelper.isBetween(0.09F, 0.29F, hitX) && InventoryHelper.isBetween(0.09F, 0.29F, hitZ)){      //Slot 4
            InventoryHelper.setStackInSlot(3, player, infuser);
        }
        else if(InventoryHelper.isBetween(0.40F, 0.60F, hitX) && InventoryHelper.isBetween(0.06F, 0.26F, hitZ)){      //Slot 5
            InventoryHelper.setStackInSlot(4, player, infuser);
        }
        else if(InventoryHelper.isBetween(0.71F, 0.91F, hitX) && InventoryHelper.isBetween(0.09F, 0.29F, hitZ)){      //Slot 6
            InventoryHelper.setStackInSlot(5, player, infuser);
        }
        else if(InventoryHelper.isBetween(0.74F, 0.94F, hitX) && InventoryHelper.isBetween(0.40F, 0.60F, hitZ)){      //Slot 7
            InventoryHelper.setStackInSlot(6, player, infuser);
        }
        else if(InventoryHelper.isBetween(0.71F, 0.91F, hitX) && InventoryHelper.isBetween(0.71F, 0.91F, hitZ)){      //Slot 8
            InventoryHelper.setStackInSlot(7, player, infuser);
        }
        else if(InventoryHelper.isBetween(0.37F, 0.62F, hitX) && InventoryHelper.isBetween(0.37F, 0.62F, hitZ)){      //Slot 9
            if(player.inventory.getCurrentItem() == null && infuser.getStackInSlot(8) != null){
                player.inventory.addItemStackToInventory(infuser.getStackInSlot(8));
                infuser.setInventorySlotContents(8, null);
            }
            else {
                InventoryHelper.setStackInSlot(8, player, infuser);
            }
        }

        return true;
    }
}
