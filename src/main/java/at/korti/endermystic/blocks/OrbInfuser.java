package at.korti.endermystic.blocks;

import at.korti.endermystic.EnderMystic;
import at.korti.endermystic.ModInfo;
import at.korti.endermystic.api.util.AbilityHelper;
import at.korti.endermystic.tileEntity.TileEntityOrbInfuser;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Korti on 13.05.2015.
 */
public class OrbInfuser extends BlockContainer {

    public OrbInfuser() {
        super(Material.rock);

        setCreativeTab(EnderMystic.tab);
        setBlockBounds(0.05F, 0.0F, 0.05F, 0.95F, 0.75F, 0.95F);
        setBlockName(ModInfo.MODID + ".OrbInfuser");
        setStepSound(soundTypeStone);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityOrbInfuser();
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        System.out.println("HitX: " + hitX + ", HitY: " + hitY + ", HitZ: " + hitZ + ", Side: " + side);

        TileEntityOrbInfuser infuser = (TileEntityOrbInfuser) world.getTileEntity(x, y, z);

        //TODO: Optimize hit box

        if(AbilityHelper.isBetween(0.47F, 0.51F,hitX) && AbilityHelper.isBetween(0.85F, 0.91F, hitZ)){      //Slot 1
            AbilityHelper.setStackInSlot(0, player, infuser);
        }
        else if(AbilityHelper.isBetween(0.15F, 0.22F,hitX) && AbilityHelper.isBetween(0.76F, 0.85F, hitZ)){      //Slot 2
            AbilityHelper.setStackInSlot(1, player, infuser);
        }
        else if(AbilityHelper.isBetween(0.11F, 0.16F,hitX) && AbilityHelper.isBetween(0.47F, 0.52F, hitZ)){      //Slot 3
            AbilityHelper.setStackInSlot(2, player, infuser);
        }
        else if(AbilityHelper.isBetween(0.15F, 0.22F,hitX) && AbilityHelper.isBetween(0.15F, 0.22F, hitZ)){      //Slot 4
            AbilityHelper.setStackInSlot(3, player, infuser);
        }
        else if(AbilityHelper.isBetween(0.47F, 0.51F,hitX) && AbilityHelper.isBetween(0.11F, 0.16F, hitZ)){      //Slot 5
            AbilityHelper.setStackInSlot(4, player, infuser);
        }
        else if(AbilityHelper.isBetween(0.77F, 0.86F,hitX) && AbilityHelper.isBetween(0.15F, 0.22F, hitZ)){      //Slot 6
            AbilityHelper.setStackInSlot(5, player, infuser);
        }
        else if(AbilityHelper.isBetween(0.82F, 0.88F,hitX) && AbilityHelper.isBetween(0.47F, 0.52F, hitZ)){      //Slot 7
            AbilityHelper.setStackInSlot(6, player, infuser);
        }
        else if(AbilityHelper.isBetween(0.77F, 0.86F,hitX) && AbilityHelper.isBetween(0.76F, 0.85F, hitZ)){      //Slot 8
            AbilityHelper.setStackInSlot(7, player, infuser);
        }
        else if(AbilityHelper.isBetween(0.37F, 0.62F,hitX) && AbilityHelper.isBetween(0.37F, 0.62F, hitZ)){      //Slot 9
            if(player.inventory.getCurrentItem() == null && infuser.getStackInSlot(8) != null){
                player.inventory.addItemStackToInventory(infuser.getStackInSlot(8));
                infuser.setInventorySlotContents(8, null);
            }
            else {
                AbilityHelper.setStackInSlot(8, player, infuser);
            }
        }

        return true;
    }
}
