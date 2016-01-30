package at.korti.endermystic.items.gadgets;

import at.korti.endermystic.api.helper.EntityHelper;
import at.korti.endermystic.api.helper.WorldHelper;
import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetworkHandler;
import at.korti.endermystic.items.EnergyItem;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Created by Korti on 01.10.2015.
 */
public class TeleportWand extends EnergyItem {

    private final int range = 20;

    public TeleportWand() {
        super("TeleportWand");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {

        String owner = EnergyNetworkHandler.getOwner(stack);

        if(!owner.isEmpty() && EnergyNetworkHandler.isEnoughEnergy(350, owner) && !world.isRemote) {
            MovingObjectPosition objectPosition = WorldHelper.raytraceFromEntity(world, player, false, range);
            if (objectPosition != null) {
                EntityHelper.teleportPlayer(player, objectPosition.blockX + 0.5F, objectPosition.blockY, objectPosition.blockZ + 0.5F, objectPosition.sideHit, true);
            } else {
                world.spawnEntityInWorld(new EntityEnderPearl(world, player));
            }
            EnergyNetworkHandler.decEnergy(350, owner);
        }
        return super.onItemRightClick(stack, world, player);
    }
}
