package at.korti.endermystic.client.keybinding;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.EventBus;

/**
 * Created by Korti on 08.05.2015.
 */
public class KeyHandler {

    public static void init(){
        EventBus eventBus = FMLCommonHandler.instance().bus();
        eventBus.register(new ModKeyBinding());
        eventBus.register(new KeyHandler());
    }

}
