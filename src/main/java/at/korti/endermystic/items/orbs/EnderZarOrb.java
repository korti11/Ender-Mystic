package at.korti.endermystic.items.orbs;

import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetworkHandler;
import at.korti.endermystic.api.util.AbilityHelper;
import at.korti.endermystic.blocks.ModBlocks;
import at.korti.endermystic.tileEntity.TileEntityEnderZar;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Korti on 07.05.2015.
 */
public class EnderZarOrb extends Orb {

    public EnderZarOrb() {
        super("EnderZarOrb", 0x4e447f);

        setNoRepair();
        setMaxDamage(1002);
    }

    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        super.onItemRightClick(stack, world, player);

        if (stack.getItemDamage() < 1001) {
            AbilityHelper.SetBlock(x, y, z, side, ModBlocks.enderZar, world);
            TileEntityEnderZar enderZar = (TileEntityEnderZar) AbilityHelper.getTileEntityFromSide(x, y, z, side, world);
            enderZar.setStoredEnergy((stack.getMaxDamage() - 1) - stack.getItemDamage());
            if(!world.isRemote) {
                if (EnergyNetworkHandler.getEnergy(stack.stackTagCompound.getString("em_owner")) >= (stack.getMaxDamage() - 1) - stack.getItemDamage()) {
                    EnergyNetworkHandler.decEnergy((stack.getMaxDamage()) - 1 - stack.getItemDamage(), stack.stackTagCompound.getString("em_owner"));
                } else {
                    int energyCanUse =  (EnergyNetworkHandler.getEnergy(stack.stackTagCompound.getString("em_owner")) / 100) * 100;
                    EnergyNetworkHandler.decEnergy(energyCanUse, stack.stackTagCompound.getString("em_owner"));
                    stack.setItemDamage((stack.getMaxDamage() - energyCanUse) - 1);
                }
            }
        }

        return super.onItemUseFirst(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        list.add(new ItemStack(item, 1, 1001));
        //list.add(new ItemStack(item, 1, 1));
    }
}
