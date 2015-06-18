package at.korti.endermystic.potion;

import at.korti.endermystic.EnderMystic;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by Korti on 27.10.2014.
 */
public class PotionHelper {

    public static Potion enderHeartBleed;
    public static Potion waterBreathing;
    public static Potion enderScream;

    public static void preInit(){
        Potion[] potionTypes = null;

        for(Field f : net.minecraft.potion.Potion.class.getDeclaredFields()){
            f.setAccessible(true);

            try{
                if(f.getName().equals("potionTypes") || f.getName().equals("field_76425_a")){
                    Field modfield = Field.class.getDeclaredField("modifiers");
                    modfield.setAccessible(true);
                    modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);

                    potionTypes = (Potion[])f.get(null);
                    final Potion[] newPotionTypes  = new Potion[256];
                    System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
                    f.set(null, newPotionTypes);
                }
            } catch (Exception e){
                System.err.println("Severe error, please report to the mod author: ");
                System.err.println(e);
            }
        }

        MinecraftForge.EVENT_BUS.register(new PotionEventHandler());

    }

    public static void init(){
        enderHeartBleed = (new EnderHeartBleed(EnderMystic.config.get("Potion", "Ender Heart Bleed ID", 60).getInt(), false, 0)).setIconIndex(0,0).setPotionName("potion.enderHeartBleed");
        waterBreathing = (new WaterBreathing(EnderMystic.config.get("Potion", "Water Breathing ID", 61).getInt(), false, 0)).setIconIndex(0,0).setPotionName("potion.Breathing");
        enderScream = (new EnderScream(EnderMystic.config.get("Potion", "Ender Scream ID", 62).getInt(), false, 0)).setIconIndex(0, 0).setPotionName("potion.enderScream");
    }

}
