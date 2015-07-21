package at.korti.endermystic.modintegration.baubles.rings;

import at.korti.endermystic.ModInfo;
import at.korti.endermystic.items.EnergyItem;
import baubles.api.BaubleType;
import baubles.api.IBauble;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;

/**
 * Created by Korti on 17.06.2015.
 */
public abstract class Ring extends EnergyItem implements IBauble {

    private int crystalColor;

    @SideOnly(Side.CLIENT)
    private IIcon crystalIcon;
    @SideOnly(Side.CLIENT)
    private IIcon ringIcon;

    public Ring(String name, int crystalColor) {
        super(name);
        this.crystalColor = crystalColor;
    }

    @Override
    public boolean requiresMultipleRenderPasses() {
        return true;
    }

    @Override
    public int getColorFromItemStack(ItemStack stack, int pass) {
        if (pass == 0) {
            return 0xffff0b;
        }
        else if (pass == 1) {
            return crystalColor;
        }
        return super.getColorFromItemStack(stack, pass);
    }

    @Override
    public IIcon getIcon(ItemStack stack, int pass) {
        if (pass == 0) {
            return ringIcon;
        } else {
            return crystalIcon;
        }
    }

    @Override
    public void registerIcons(IIconRegister register) {
        this.ringIcon = register.registerIcon(ModInfo.MODID + ":Ring");
        this.crystalIcon = register.registerIcon(ModInfo.MODID + ":RingCrystal");
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return BaubleType.RING;
    }

    @Override
    public abstract void onWornTick(ItemStack itemStack, EntityLivingBase entityLivingBase);

    @Override
    public void onEquipped(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        if(itemStack.stackTagCompound == null){
            itemStack.stackTagCompound = new NBTTagCompound();
        }

        if(!itemStack.stackTagCompound.hasKey("em_owner")){
            ((EntityPlayer)entityLivingBase).addChatMessage(new ChatComponentText("The Ring has no owner"));
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
