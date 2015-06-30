package at.korti.endermystic.modintegration.baubles.belts;

import at.korti.endermystic.items.EnergyItem;
import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;

/**
 * Created by Korti on 17.06.2015.
 */
public abstract class Belt extends EnergyItem implements IBauble {

    private int crystalColor;

    public Belt(String name, int crystalColor) {
        super(name);

        this.crystalColor = crystalColor;
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return BaubleType.BELT;
    }


    @Override
    public int getColorFromItemStack(ItemStack stack, int pass) {
        if(pass == 0){
            return 0x45200f;
        }
        else if (pass == 1) {
            return crystalColor;
        }
        return super.getColorFromItemStack(stack, pass);
    }

    @Override
    public abstract void onWornTick(ItemStack itemStack, EntityLivingBase entityLivingBase);

    @Override
    public void onEquipped(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        if(itemStack.getTagCompound() == null){
            itemStack.setTagCompound(new NBTTagCompound());
        }

        if(!itemStack.getTagCompound().hasKey("em_owner")){
            ((EntityPlayer)entityLivingBase).addChatMessage(new ChatComponentText("The Belt has no owner"));
        }
    }

    @Override
    public void onUnequipped(ItemStack itemStack, EntityLivingBase entityLivingBase) {

    }

    @Override
    public boolean canEquip(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        return true;
    }

    @Override
    public boolean canUnequip(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        return true;
    }
}
