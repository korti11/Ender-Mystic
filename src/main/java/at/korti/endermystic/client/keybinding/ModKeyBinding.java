package at.korti.endermystic.client.keybinding;

import at.korti.endermystic.EnderMystic;
import at.korti.endermystic.ModInfo;
import at.korti.endermystic.api.mysticEnergyNetwork.EnergyNetworkHandler;
import at.korti.endermystic.blocks.EnderZar;
import at.korti.endermystic.items.orbs.EnderZarOrb;
import at.korti.endermystic.network.ChangeItemPacket;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.lwjgl.input.Keyboard;

/**
 * Created by Korti on 08.05.2015.
 */
public class ModKeyBinding {

    private KeyBinding enderZarIncrease = new KeyBinding("Ender Zar Increase", Keyboard.KEY_PERIOD, ModInfo.NAME);
    private KeyBinding enderZarDecrease = new KeyBinding("Ender Zar Decrease", Keyboard.KEY_COMMA, ModInfo.NAME);

    public ModKeyBinding() {
        ClientRegistry.registerKeyBinding(enderZarIncrease);
        ClientRegistry.registerKeyBinding(enderZarDecrease);
    }

    @SubscribeEvent
    public void KeyInputEvent(InputEvent.KeyInputEvent event) {

        if (enderZarIncrease.isPressed()) {
            increaseEnderZar();
        }
        else if (enderZarDecrease.isPressed()) {
            decreaseEnderZar();
        }

    }

    private void increaseEnderZar(){
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        ItemStack currentItem = player.getCurrentEquippedItem();

        if(currentItem.getItem() instanceof EnderZarOrb) {
            if (currentItem.getItemDamage() - 100 >= 1 && EnergyNetworkHandler.DecEnergy(100, currentItem.stackTagCompound.getString("em_owner"))) {
                currentItem.setItemDamage(currentItem.getItemDamage() - 100);
            }
            ChangeItemPacket packet = new ChangeItemPacket();
            packet.setStack(currentItem);
            EnderMystic.pipeline.sendToServer(packet);
        }
    }

    private void decreaseEnderZar(){
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        ItemStack currentItem = player.getCurrentEquippedItem();

        if(currentItem.getItem() instanceof EnderZarOrb) {
            if (currentItem.getItemDamage() + 100 <= 1001 && EnergyNetworkHandler.AddEnergy(100, currentItem.stackTagCompound.getString("em_owner"))) {
                currentItem.setItemDamage(currentItem.getItemDamage() + 100);
            }
            ChangeItemPacket packet = new ChangeItemPacket();
            packet.setStack(currentItem);
            EnderMystic.pipeline.sendToServer(packet);
        }
    }
}
