package at.korti.endermystic.items;

import at.korti.endermystic.EnderMystic;
import at.korti.endermystic.ModInfo;
import at.korti.endermystic.network.ChangeItemPacket;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

/**
 * Created by Korti on 27.10.2014.
 */
public class EnderSoulFill extends ModItem {

    public EnderSoulFill() {
        super("EnderSoulFill", 1);

        setCreativeTab(EnderMystic.tab);
        setNoRepair();
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    @SideOnly(Side.CLIENT)
    IIcon empty;
    @SideOnly(Side.CLIENT)
    IIcon filled;

    @Override
    public void registerIcons(IIconRegister register) {
        empty = register.registerIcon(ModInfo.MODID + ":EnderSoulFillEmpty");
        filled = register.registerIcon(ModInfo.MODID + ":EnderSoulFillFilled");
    }

    @Override
    public IIcon getIconFromDamage(int meta) {

        if(meta == 0){
            return empty;
        }
        else if(meta == 1){
            return filled;
        }

        return empty;

    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        switch (stack.getItemDamage()){
            case 0:
                return super.getUnlocalizedName() + "Empty";
            case 1:
                return super.getUnlocalizedName() + "Filled";
            default:
                return super.getUnlocalizedName();
        }
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase entity) {

        if(entity instanceof EntityEnderman) {

            ChangeItemPacket packet = new ChangeItemPacket();

            packet.setStack(new ItemStack(this, 1, 1));
            EnderMystic.pipeline.sendToServer(packet);

            entity.setDead();
        }

        return super.itemInteractionForEntity(stack, player, entity);
    }

    @Override
    public void getSubItems(net.minecraft.item.Item item, CreativeTabs tab, List list) {
        for(int i = 0; i < 2; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }
}
