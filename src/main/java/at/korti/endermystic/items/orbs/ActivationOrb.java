package at.korti.endermystic.items.orbs;

import at.korti.endermystic.api.util.IActivation;
import at.korti.endermystic.tileEntity.TileEntityEnderTranfer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Korti on 11.09.2015.
 */
public class ActivationOrb extends Orb {

    public ActivationOrb() {
        super("ActivationOrb", 0xBCFFDE);
    }

    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {

        TileEntity tileEntity = world.getTileEntity(x, y, z);

        if (tileEntity instanceof IActivation) {
            IActivation activation = (IActivation) tileEntity;
            if (tileEntity instanceof TileEntityEnderTranfer) {
                activation.activate(world.getBlock(x, y, z));
            }
            else {
                activation.activate(null);
            }
        }

        return super.onItemUseFirst(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
    }
}
