package at.korti.endermystic.client.model;

import at.korti.endermystic.items.ModItems;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

/**
 * EnderSoulArmor - Korti
 * Created using Tabula 4.1.1
 */
public class EnderSoulArmorModel extends ModelBiped {
    public ModelRenderer PlateBodyBack;
    public ModelRenderer PlateBodyFront;
    public ModelRenderer PlateHandLeftUp;
    public ModelRenderer PlateHandLeftUp_1;
    public ModelRenderer PlateHandLeft;
    public ModelRenderer PlateHandLeft_1;
    public ModelRenderer PlateHandLeft_2;
    public ModelRenderer PlateHandLeft_3;
    public ModelRenderer PlateHandLeftFront;
    public ModelRenderer PlateHandLeftFront_1;
    public ModelRenderer PlateHandLeftFront_2;
    public ModelRenderer PlateHandLeftBack;
    public ModelRenderer PlateHandLeftBack_1;
    public ModelRenderer PlateHandLeftBack_2;
    public ModelRenderer PlateHandLeftDown;
    public ModelRenderer HandLeftLeatherHolderFront;
    public ModelRenderer HandLeftLeatherHolderFront_1;
    public ModelRenderer HandLeftLeatherHolderBack;
    public ModelRenderer PlateHandRightUp;
    public ModelRenderer PlateHandRightUp_1;
    public ModelRenderer PlateHandRight;
    public ModelRenderer PlateHandRight_1;
    public ModelRenderer PlateHandRight_2;
    public ModelRenderer PlateHandRight_3;
    public ModelRenderer PlateHandRightFront;
    public ModelRenderer PlateHandRightFront_1;
    public ModelRenderer PlateHandRightFront_2;
    public ModelRenderer PlateHandRightBack;
    public ModelRenderer PlateHandRightBack_1;
    public ModelRenderer PlateHandRightBack_2;
    public ModelRenderer PlateHandRightDown;
    public ModelRenderer HandRightLeatherHolderFront;
    public ModelRenderer HandRightLeatherHolderFront_1;
    public ModelRenderer HandRightLeatherHolderBack;
    public ModelRenderer BodySwordBlade;
    public ModelRenderer BodySwordShaft;
    public ModelRenderer BodySwordHolder;
    public ModelRenderer Belt;
    public ModelRenderer Belt_1;
    public ModelRenderer Belt_2;
    public ModelRenderer Belt_3;
    public ModelRenderer Belt_4;
    public ModelRenderer Belt_5;
    public ModelRenderer Belt_6;
    public ModelRenderer Belt_7;
    public ModelRenderer Buckle;
    public ModelRenderer Buckle_1;
    public ModelRenderer Buckle_2;
    public ModelRenderer Belt_8;
    public ModelRenderer Belt_9;
    public ModelRenderer Belt_10;
    public ModelRenderer PlateFeetRightFront;
    public ModelRenderer PlateFeetRightFront_1;
    public ModelRenderer PlateFeetRightFront_2;
    public ModelRenderer PlateFeetRightBack;
    public ModelRenderer PlateFeetRightBack_1;
    public ModelRenderer PlateFeetRightBack_2;
    public ModelRenderer PlateFeetLeft;
    public ModelRenderer PlateFeetLeft_1;
    public ModelRenderer PlateFeetLeft_2;
    public ModelRenderer PlateFeetRight;
    public ModelRenderer PlateFeetRight_1;
    public ModelRenderer PlateFeetRight_2;
    public ModelRenderer PlateFeetLeftFront;
    public ModelRenderer PlateFeetLeftFront_1;
    public ModelRenderer PlateFeetLeftFront_2;
    public ModelRenderer PlateFeetLeftBack;
    public ModelRenderer PlateFeetLeftBack_1;
    public ModelRenderer PlateFeetLeftBack_2;
    public ModelRenderer LegsSwordBlade;
    public ModelRenderer LegsSwordShaft;
    public ModelRenderer LegsSwordHolder;
    public ModelRenderer PlateHelmetTop;
    public ModelRenderer PlateHelmetLeft;
    public ModelRenderer PlateHelmetLeft_1;
    public ModelRenderer PlateHelmetRight;
    public ModelRenderer PlateHelmetRight_1;
    public ModelRenderer PlateHelmetBack;
    public ModelRenderer PlateHelmetBack_1;
    public ModelRenderer PlateHelmetBack_2;

    public EnderSoulArmorModel(int armorType) {
        super();
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.LegsSwordHolder = new ModelRenderer(this, 8, 34);
        this.LegsSwordHolder.setRotationPoint(0F, 0F, 0.0F);
        this.LegsSwordHolder.addBox(2.6F, 2.5F, -7.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(LegsSwordHolder, -0.4363323129985824F, 0.0F, -0.0F);
        this.PlateBodyFront = new ModelRenderer(this, 32, 0);
        this.PlateBodyFront.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.PlateBodyFront.addBox(-4.0F, 0.0F, -1.0F, 8, 12, 1, 0.0F);
        this.PlateHandRight = new ModelRenderer(this, 32, 25);
        this.PlateHandRight.setRotationPoint(0F, 0F, 0.0F);
        this.PlateHandRight.addBox(-4.3F, -1.35F, -3.0F, 1, 2, 6, 0.0F);
        this.setRotateAngle(PlateHandRight, 0.0F, 0.0F, 0.17453292519943295F);
        this.PlateFeetLeftFront_1 = new ModelRenderer(this, 62, 10);
        this.PlateFeetLeftFront_1.setRotationPoint(0F, 0F, 0.0F);
        this.PlateFeetLeftFront_1.addBox(-1.9F, 3.75F, -2.5F, 4, 3, 1, 0.0F);
        this.setRotateAngle(PlateFeetLeftFront_1, -0.2617993877991494F, 0.0F, 0.0F);
        this.Belt = new ModelRenderer(this, 0, 38);
        this.Belt.setRotationPoint(0.0F, 5.5F, -3.0F);
        this.Belt.addBox(-0.5F, -6.0F, -0.5F, 1, 13, 1, 0.0F);
        this.setRotateAngle(Belt, 0.0F, 0.0F, 0.5235987755982988F);
        this.HandRightLeatherHolderBack = new ModelRenderer(this, 55, 22);
        this.HandRightLeatherHolderBack.setRotationPoint(0F, 0F, 0.0F);
        this.HandRightLeatherHolderBack.addBox(-3.0F, 8.0F, 1.5F, 4, 1, 1, 0.0F);
        this.PlateHelmetLeft_1 = new ModelRenderer(this, 98, 0);
        this.PlateHelmetLeft_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.PlateHelmetLeft_1.addBox(-7.5F, -1.5F, -4.5F, 1, 4, 9, 0.0F);
        this.setRotateAngle(PlateHelmetLeft_1, 0.0F, 3.141592653589793F, -0.6981317007977318F);
        this.PlateFeetRightBack = new ModelRenderer(this, 62, 10);
        this.PlateFeetRightBack.setRotationPoint(0F, 0F, 0.0F);
        this.PlateFeetRightBack.addBox(-2.1F, 0.75F, 1.75F, 4, 3, 1, 0.0F);
        this.setRotateAngle(PlateFeetRightBack, 0.2617993877991494F, 0.0F, 0.0F);
        this.HandRightLeatherHolderFront_1 = new ModelRenderer(this, 55, 24);
        this.HandRightLeatherHolderFront_1.setRotationPoint(0F, 0F, 0.0F);
        this.HandRightLeatherHolderFront_1.addBox(-2.0F, 9.0F, -2.5F, 1, 1, 1, 0.0F);
        this.PlateFeetRightBack_1 = new ModelRenderer(this, 62, 10);
        this.PlateFeetRightBack_1.setRotationPoint(0F, 0F, 0.0F);
        this.PlateFeetRightBack_1.addBox(-2.1F, 3.75F, 1.5F, 4, 3, 1, 0.0F);
        this.setRotateAngle(PlateFeetRightBack_1, 0.2617993877991494F, 0.0F, 0.0F);
        this.PlateHandLeft_1 = new ModelRenderer(this, 32, 25);
        this.PlateHandLeft_1.setRotationPoint(0F, 0F, 0.0F);
        this.PlateHandLeft_1.addBox(2.95F, 0.65F, -3.0F, 1, 2, 6, 0.0F);
        this.setRotateAngle(PlateHandLeft_1, 0.0F, 0.0F, -0.17453292519943295F);
        this.Belt_4 = new ModelRenderer(this, 0, 38);
        this.Belt_4.setRotationPoint(0.0F, 5.5F, 3.0F);
        this.Belt_4.addBox(-0.5F, -6.0F, -0.5F, 1, 13, 1, 0.0F);
        this.setRotateAngle(Belt_4, 0.0F, 0.0F, 0.5235987755982988F);
        this.PlateHandLeftBack_2 = new ModelRenderer(this, 50, 13);
        this.PlateHandLeftBack_2.setRotationPoint(0F, 0F, 0.0F);
        this.PlateHandLeftBack_2.addBox(-1.0F, 2.5F, 1.7F, 5, 2, 1, 0.0F);
        this.setRotateAngle(PlateHandLeftBack_2, 0.17453292519943295F, 0.0F, 0.0F);
        this.Buckle_2 = new ModelRenderer(this, 21, 41);
        this.Buckle_2.setRotationPoint(1.0F, 10.0F, -3.0F);
        this.Buckle_2.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.PlateHandLeftFront_1 = new ModelRenderer(this, 50, 13);
        this.PlateHandLeftFront_1.setRotationPoint(0F, 0F, 0.0F);
        this.PlateHandLeftFront_1.addBox(-1.0F, 0.5F, -3.0F, 5, 2, 1, 0.0F);
        this.setRotateAngle(PlateHandLeftFront_1, -0.17453292519943295F, 0.0F, 0.0F);
        this.PlateHelmetRight = new ModelRenderer(this, 98, 0);
        this.PlateHelmetRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.PlateHelmetRight.addBox(-5.0F, -8.0F, -4.5F, 1, 3, 9, 0.0F);
        this.PlateHandRight_2 = new ModelRenderer(this, 32, 25);
        this.PlateHandRight_2.setRotationPoint(0F, 0F, 0.0F);
        this.PlateHandRight_2.addBox(-3.7F, 2.65F, -3.0F, 1, 2, 6, 0.0F);
        this.setRotateAngle(PlateHandRight_2, 0.0F, 0.0F, 0.17453292519943295F);
        this.PlateFeetRight = new ModelRenderer(this, 0, 0);
        this.PlateFeetRight.setRotationPoint(0F, 0F, 0.0F);
        this.PlateFeetRight.addBox(-2.25F, 0.5F, -2.5F, 1, 3, 5, 0.0F);
        this.setRotateAngle(PlateFeetRight, 0.0F, 0.0F, 0.2617993877991494F);
        this.BodySwordHolder = new ModelRenderer(this, 6, 20);
        this.BodySwordHolder.setRotationPoint(-2.75F, 0.08F, 3.0F);
        this.BodySwordHolder.addBox(-0.5F, -1.5F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(BodySwordHolder, 0.0F, 0.0F, -0.4363323129985824F);
        this.PlateHandRight_1 = new ModelRenderer(this, 32, 25);
        this.PlateHandRight_1.setRotationPoint(0F, 0F, 0.0F);
        this.PlateHandRight_1.addBox(-4.0F, 0.65F, -3.0F, 1, 2, 6, 0.0F);
        this.setRotateAngle(PlateHandRight_1, 0.0F, 0.0F, 0.17453292519943295F);
        this.Belt_5 = new ModelRenderer(this, 4, 42);
        this.Belt_5.setRotationPoint(3.2F, 0.0F, -3.0F);
        this.Belt_5.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 7, 0.0F);
        this.setRotateAngle(Belt_5, 0.0F, 0.0F, 0.5235987755982988F);
        this.PlateFeetRightFront_2 = new ModelRenderer(this, 62, 10);
        this.PlateFeetRightFront_2.setRotationPoint(0F, 0F, 0.0F);
        this.PlateFeetRightFront_2.addBox(-2.1F, 6.75F, -2.25F, 4, 3, 1, 0.0F);
        this.setRotateAngle(PlateFeetRightFront_2, -0.2617993877991494F, 0.0F, 0.0F);
        this.PlateHandRightUp = new ModelRenderer(this, 32, 18);
        this.PlateHandRightUp.setRotationPoint(0F, 0F, 0.0F);
        this.PlateHandRightUp.addBox(-3.75F, -2.8F, -3.0F, 5, 1, 6, 0.0F);
        this.setRotateAngle(PlateHandRightUp, 0.0F, 0.0F, -0.17453292519943295F);
        this.PlateHandRightFront = new ModelRenderer(this, 50, 13);
        this.PlateHandRightFront.setRotationPoint(0F, 0F, 0.0F);
        this.PlateHandRightFront.addBox(-4.0F, -1.5F, -3.3F, 5, 2, 1, 0.0F);
        this.setRotateAngle(PlateHandRightFront, -0.17453292519943295F, 0.0F, 0.0F);
        this.PlateHandRightBack = new ModelRenderer(this, 50, 13);
        this.PlateHandRightBack.setRotationPoint(0F, 0F, 0.0F);
        this.PlateHandRightBack.addBox(-4.0F, -1.5F, 2.3F, 5, 2, 1, 0.0F);
        this.setRotateAngle(PlateHandRightBack, 0.17453292519943295F, 0.0F, 0.0F);
        this.Belt_6 = new ModelRenderer(this, 15, 39);
        this.Belt_6.setRotationPoint(-2.5F, 11.0F, -3.0F);
        this.Belt_6.addBox(-1.5F, 0.0F, -0.5F, 3, 1, 1, 0.0F);
        this.PlateHelmetLeft = new ModelRenderer(this, 98, 0);
        this.PlateHelmetLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.PlateHelmetLeft.addBox(4.0F, -8.0F, -4.5F, 1, 3, 9, 0.0F);
        this.PlateBodyBack = new ModelRenderer(this, 32, 0);
        this.PlateBodyBack.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.PlateBodyBack.addBox(-4.0F, 0.0F, 0.0F, 8, 12, 1, 0.0F);
        this.HandRightLeatherHolderFront = new ModelRenderer(this, 55, 22);
        this.HandRightLeatherHolderFront.setRotationPoint(0F, 0F, 0.0F);
        this.HandRightLeatherHolderFront.addBox(-3.0F, 8.0F, -2.5F, 4, 1, 1, 0.0F);
        this.PlateHelmetTop = new ModelRenderer(this, 62, 0);
        this.PlateHelmetTop.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.PlateHelmetTop.addBox(-4.5F, -9.0F, -4.5F, 9, 1, 9, 0.0F);
        this.BodySwordBlade = new ModelRenderer(this, 0, 16);
        this.BodySwordBlade.setRotationPoint(0.0F, 6.0F, 3.0F);
        this.BodySwordBlade.addBox(-1.0F, -4.0F, 0.0F, 2, 12, 1, 0.0F);
        this.setRotateAngle(BodySwordBlade, 0.0F, 0.0F, -0.4363323129985824F);
        this.Belt_8 = new ModelRenderer(this, 15, 43);
        this.Belt_8.setRotationPoint(0.0F, 11.0F, 3.0F);
        this.Belt_8.addBox(-4.0F, 0.0F, -0.5F, 8, 1, 1, 0.0F);
        this.Belt_9 = new ModelRenderer(this, 15, 45);
        this.Belt_9.setRotationPoint(-4.0F, 11.0F, 0.0F);
        this.Belt_9.addBox(-0.5F, 0.0F, -3.5F, 1, 1, 7, 0.0F);
        this.LegsSwordShaft = new ModelRenderer(this, 0, 34);
        this.LegsSwordShaft.setRotationPoint(0F, 0F, 0.0F);
        this.LegsSwordShaft.addBox(1.6F, 1.5F, -4.0F, 3, 3, 1, 0.0F);
        this.setRotateAngle(LegsSwordShaft, -0.4363323129985824F, 0.0F, -0.0F);
        this.PlateFeetLeft_2 = new ModelRenderer(this, 0, 0);
        this.PlateFeetLeft_2.setRotationPoint(0F, 0F, 0.0F);
        this.PlateFeetLeft_2.addBox(0.25F, 6.5F, -2.5F, 1, 3, 5, 0.0F);
        this.setRotateAngle(PlateFeetLeft_2, 0.0F, 0.0F, -0.2617993877991494F);
        this.Belt_2 = new ModelRenderer(this, 4, 40);
        this.Belt_2.setRotationPoint(-1.5F, 4.75F, -3.0F);
        this.Belt_2.addBox(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Belt_2, 0.0F, 0.0F, 0.5235987755982988F);
        this.BodySwordShaft = new ModelRenderer(this, 6, 16);
        this.BodySwordShaft.setRotationPoint(-1.9F, 1.9F, 3.0F);
        this.BodySwordShaft.addBox(-1.5F, -0.5F, -1.5F, 3, 1, 3, 0.0F);
        this.setRotateAngle(BodySwordShaft, 0.0F, 0.0F, -0.4363323129985824F);
        this.PlateFeetLeft = new ModelRenderer(this, 0, 0);
        this.PlateFeetLeft.setRotationPoint(0F, 0F, 0.0F);
        this.PlateFeetLeft.addBox(1.25F, 0.5F, -2.5F, 1, 3, 5, 0.0F);
        this.setRotateAngle(PlateFeetLeft, 0.0F, 0.0F, -0.2617993877991494F);
        this.PlateHandRightBack_2 = new ModelRenderer(this, 50, 13);
        this.PlateHandRightBack_2.setRotationPoint(0F, 0F, 0.0F);
        this.PlateHandRightBack_2.addBox(-4.0F, 2.5F, 1.7F, 5, 2, 1, 0.0F);
        this.setRotateAngle(PlateHandRightBack_2, 0.17453292519943295F, 0.0F, 0.0F);
        this.PlateHandLeftUp_1 = new ModelRenderer(this, 32, 13);
        this.PlateHandLeftUp_1.setRotationPoint(0F, 0F, 0.0F);
        this.PlateHandLeftUp_1.addBox(-1.25F, -3.8F, -2.0F, 3, 1, 4, 0.0F);
        this.setRotateAngle(PlateHandLeftUp_1, 0.0F, 0.0F, 0.17453292519943295F);
        this.PlateHandRightBack_1 = new ModelRenderer(this, 50, 13);
        this.PlateHandRightBack_1.setRotationPoint(0F, 0F, 0.0F);
        this.PlateHandRightBack_1.addBox(-4.0F, 0.5F, 2.0F, 5, 2, 1, 0.0F);
        this.setRotateAngle(PlateHandRightBack_1, 0.17453292519943295F, 0.0F, 0.0F);
        this.PlateFeetRightFront = new ModelRenderer(this, 62, 10);
        this.PlateFeetRightFront.setRotationPoint(0F, 0F, 0.0F);
        this.PlateFeetRightFront.addBox(-2.1F, 0.75F, -2.75F, 4, 3, 1, 0.0F);
        this.setRotateAngle(PlateFeetRightFront, -0.2617993877991494F, 0.0F, 0.0F);
        this.PlateHandLeft_2 = new ModelRenderer(this, 32, 25);
        this.PlateHandLeft_2.setRotationPoint(0F, 0F, 0.0F);
        this.PlateHandLeft_2.addBox(2.6F, 2.65F, -3.0F, 1, 2, 6, 0.0F);
        this.setRotateAngle(PlateHandLeft_2, 0.0F, 0.0F, -0.17453292519943295F);
        this.PlateHandLeftBack_1 = new ModelRenderer(this, 50, 13);
        this.PlateHandLeftBack_1.setRotationPoint(0F, 0F, 0.0F);
        this.PlateHandLeftBack_1.addBox(-1.0F, 0.5F, 2.0F, 5, 2, 1, 0.0F);
        this.setRotateAngle(PlateHandLeftBack_1, 0.17453292519943295F, 0.0F, 0.0F);
        this.Belt_7 = new ModelRenderer(this, 15, 39);
        this.Belt_7.setRotationPoint(2.5F, 11.0F, -3.0F);
        this.Belt_7.addBox(-1.5F, 0.0F, -0.5F, 3, 1, 1, 0.0F);
        this.PlateHandRightFront_1 = new ModelRenderer(this, 50, 13);
        this.PlateHandRightFront_1.setRotationPoint(0F, 0F, -0.0F);
        this.PlateHandRightFront_1.addBox(-4.0F, 0.5F, -3.0F, 5, 2, 1, 0.0F);
        this.setRotateAngle(PlateHandRightFront_1, -0.17453292519943295F, 0.0F, 0.0F);
        this.PlateFeetLeftFront_2 = new ModelRenderer(this, 62, 10);
        this.PlateFeetLeftFront_2.setRotationPoint(0F, 0.0F, 0.0F);
        this.PlateFeetLeftFront_2.addBox(-1.9F, 6.75F, -2.25F, 4, 3, 1, 0.0F);
        this.setRotateAngle(PlateFeetLeftFront_2, -0.2617993877991494F, 0.0F, 0.0F);
        this.PlateFeetLeftBack = new ModelRenderer(this, 62, 10);
        this.PlateFeetLeftBack.setRotationPoint(0F, 0F, 0.0F);
        this.PlateFeetLeftBack.addBox(-1.9F, 0.75F, 1.75F, 4, 3, 1, 0.0F);
        this.setRotateAngle(PlateFeetLeftBack, 0.2617993877991494F, 0.0F, 0.0F);
        this.PlateHandLeftBack = new ModelRenderer(this, 50, 13);
        this.PlateHandLeftBack.setRotationPoint(0F, 0F, 0.0F);
        this.PlateHandLeftBack.addBox(-1.0F, -1.5F, 2.3F, 5, 2, 1, 0.0F);
        this.setRotateAngle(PlateHandLeftBack, 0.17453292519943295F, 0.0F, 0.0F);
        this.PlateFeetRight_1 = new ModelRenderer(this, 0, 0);
        this.PlateFeetRight_1.setRotationPoint(0F, 0F, 0.0F);
        this.PlateFeetRight_1.addBox(-1.75F, 3.5F, -2.5F, 1, 3, 5, 0.0F);
        this.setRotateAngle(PlateFeetRight_1, 0.0F, 0.0F, 0.2617993877991494F);
        this.PlateHelmetBack_2 = new ModelRenderer(this, 98, 13);
        this.PlateHelmetBack_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.PlateHelmetBack_2.addBox(-4.5F, -3.2F, 4.38F, 9, 2, 1, 0.0F);
        this.setRotateAngle(PlateHelmetBack_2, 0.17453292519943295F, 0.0F, 0.0F);
        this.LegsSwordBlade = new ModelRenderer(this, 0, 20);
        this.LegsSwordBlade.setRotationPoint(0F, 0F, 0.0F);
        this.LegsSwordBlade.addBox(2.6F, 2.0F, -3.0F, 1, 2, 12, 0.0F);
        this.setRotateAngle(LegsSwordBlade, -0.4363323129985824F, 0.0F, -0.0F);
        this.PlateFeetLeftBack_1 = new ModelRenderer(this, 62, 10);
        this.PlateFeetLeftBack_1.setRotationPoint(0F, 0.0F, 0.0F);
        this.PlateFeetLeftBack_1.addBox(-1.9F, 3.75F, 1.5F, 4, 3, 1, 0.0F);
        this.setRotateAngle(PlateFeetLeftBack_1, 0.2617993877991494F, 0.0F, 0.0F);
        this.PlateHelmetBack_1 = new ModelRenderer(this, 98, 13);
        this.PlateHelmetBack_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.PlateHelmetBack_1.addBox(-4.5F, -5.2F, 4.88F, 9, 2, 1, 0.0F);
        this.setRotateAngle(PlateHelmetBack_1, 0.17453292519943295F, 0.0F, 0.0F);
        this.PlateHandLeft_3 = new ModelRenderer(this, 50, 0);
        this.PlateHandLeft_3.setRotationPoint(0F, 0F, 0.0F);
        this.PlateHandLeft_3.addBox(3.0F, 3.5F, -2.5F, 1, 7, 5, 0.0F);
        this.PlateFeetLeftBack_2 = new ModelRenderer(this, 62, 10);
        this.PlateFeetLeftBack_2.setRotationPoint(0F, 0F, 0.0F);
        this.PlateFeetLeftBack_2.addBox(-1.9F, 6.75F, 1.25F, 4, 3, 1, 0.0F);
        this.setRotateAngle(PlateFeetLeftBack_2, 0.2617993877991494F, 0.0F, 0.0F);
        this.PlateHelmetBack = new ModelRenderer(this, 98, 13);
        this.PlateHelmetBack.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.PlateHelmetBack.addBox(-4.5F, -7.2F, 5.25F, 9, 2, 1, 0.0F);
        this.setRotateAngle(PlateHelmetBack, 0.17453292519943295F, 0.0F, 0.0F);
        this.PlateHandLeftDown = new ModelRenderer(this, 50, 16);
        this.PlateHandLeftDown.setRotationPoint(0F, 0F, 0.0F);
        this.PlateHandLeftDown.addBox(0.0F, 10.0F, -2.5F, 3, 1, 5, 0.0F);
        this.HandLeftLeatherHolderFront_1 = new ModelRenderer(this, 55, 24);
        this.HandLeftLeatherHolderFront_1.setRotationPoint(0F, 0F, 0.0F);
        this.HandLeftLeatherHolderFront_1.addBox(1.0F, 9.0F, -2.5F, 1, 1, 1, 0.0F);
        this.Belt_10 = new ModelRenderer(this, 15, 45);
        this.Belt_10.setRotationPoint(4.0F, 11.0F, -2.5F);
        this.Belt_10.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 7, 0.0F);
        this.PlateHandLeftFront_2 = new ModelRenderer(this, 50, 13);
        this.PlateHandLeftFront_2.setRotationPoint(0F, 0F, 0.0F);
        this.PlateHandLeftFront_2.addBox(-1.0F, 2.5F, -2.7F, 5, 2, 1, 0.0F);
        this.setRotateAngle(PlateHandLeftFront_2, -0.17453292519943295F, 0.0F, 0.0F);
        this.HandLeftLeatherHolderBack = new ModelRenderer(this, 55, 22);
        this.HandLeftLeatherHolderBack.setRotationPoint(0F, 0F, 0.0F);
        this.HandLeftLeatherHolderBack.addBox(-1.0F, 8.0F, 1.5F, 4, 1, 1, 0.0F);
        this.Belt_3 = new ModelRenderer(this, 4, 40);
        this.Belt_3.setRotationPoint(1.5F, 6.5F, -3.0F);
        this.Belt_3.addBox(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Belt_3, 0.0F, 0.0F, 0.5235987755982988F);
        this.PlateFeetRightBack_2 = new ModelRenderer(this, 62, 10);
        this.PlateFeetRightBack_2.setRotationPoint(0F, 0F, 0.0F);
        this.PlateFeetRightBack_2.addBox(-2.1F, 6.75F, 1.25F, 4, 3, 1, 0.0F);
        this.setRotateAngle(PlateFeetRightBack_2, 0.2617993877991494F, 0.0F, 0.0F);
        this.PlateHandLeftFront = new ModelRenderer(this, 50, 13);
        this.PlateHandLeftFront.setRotationPoint(0F, 0F, 0.0F);
        this.PlateHandLeftFront.addBox(-1.0F, -1.5F, -3.3F, 5, 2, 1, 0.0F);
        this.setRotateAngle(PlateHandLeftFront, -0.17453292519943295F, 0.0F, 0.0F);
        this.HandLeftLeatherHolderFront = new ModelRenderer(this, 55, 22);
        this.HandLeftLeatherHolderFront.setRotationPoint(0F, 0F, 0.0F);
        this.HandLeftLeatherHolderFront.addBox(-1.0F, 8.0F, -2.5F, 4, 1, 1, 0.0F);
        this.PlateFeetRight_2 = new ModelRenderer(this, 0, 0);
        this.PlateFeetRight_2.setRotationPoint(0F, 0F, 0.0F);
        this.PlateFeetRight_2.addBox(-1.25F, 6.5F, -2.5F, 1, 3, 5, 0.0F);
        this.setRotateAngle(PlateFeetRight_2, 0.0F, 0.0F, 0.2617993877991494F);
        this.PlateFeetLeftFront = new ModelRenderer(this, 62, 10);
        this.PlateFeetLeftFront.setRotationPoint(0F, 0F, 0.0F);
        this.PlateFeetLeftFront.addBox(-1.9F, 0.75F, -2.75F, 4, 3, 1, 0.0F);
        this.setRotateAngle(PlateFeetLeftFront, -0.2617993877991494F, 0.0F, 0.0F);
        this.PlateHandRightDown = new ModelRenderer(this, 50, 16);
        this.PlateHandRightDown.setRotationPoint(0F, 0F, 0.0F);
        this.PlateHandRightDown.addBox(-3.0F, 10.0F, -2.5F, 3, 1, 5, 0.0F);
        this.Buckle = new ModelRenderer(this, 15, 41);
        this.Buckle.setRotationPoint(-0.0F, 11.0F, -3.0F);
        this.Buckle.addBox(-1.0F, 0.0F, -0.5F, 2, 1, 1, 0.0F);
        this.PlateHelmetRight_1 = new ModelRenderer(this, 98, 0);
        this.PlateHelmetRight_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.PlateHelmetRight_1.addBox(-7.5F, -1.5F, -4.5F, 1, 4, 9, 0.0F);
        this.setRotateAngle(PlateHelmetRight_1, 0.0F, 0.0F, 0.6981317007977318F);
        this.PlateFeetRightFront_1 = new ModelRenderer(this, 62, 10);
        this.PlateFeetRightFront_1.setRotationPoint(0F, 0F, 0.0F);
        this.PlateFeetRightFront_1.addBox(-2.1F, 3.75F, -2.5F, 4, 3, 1, 0.0F);
        this.setRotateAngle(PlateFeetRightFront_1, -0.2617993877991494F, 0.0F, 0.0F);
        this.PlateHandRight_3 = new ModelRenderer(this, 50, 0);
        this.PlateHandRight_3.setRotationPoint(0F, 0F, 0.0F);
        this.PlateHandRight_3.addBox(-4.0F, 3.5F, -2.5F, 1, 7, 5, 0.0F);
        this.PlateHandLeft = new ModelRenderer(this, 32, 25);
        this.PlateHandLeft.setRotationPoint(0F, 0F, 0.0F);
        this.PlateHandLeft.addBox(3.3F, -1.35F, -3.0F, 1, 2, 6, 0.0F);
        this.setRotateAngle(PlateHandLeft, 0.0F, 0.0F, -0.17453292519943295F);
        this.PlateHandRightUp_1 = new ModelRenderer(this, 32, 13);
        this.PlateHandRightUp_1.setRotationPoint(0F, 0F, 0.0F);
        this.PlateHandRightUp_1.addBox(-1.75F, -3.8F, -2.0F, 3, 1, 4, 0.0F);
        this.setRotateAngle(PlateHandRightUp_1, 0.0F, 0.0F, -0.17453292519943295F);
        this.PlateHandLeftUp = new ModelRenderer(this, 32, 18);
        this.PlateHandLeftUp.setRotationPoint(0F, 0F, 0.0F);
        this.PlateHandLeftUp.addBox(-1.25F, -2.8F, -3.0F, 5, 1, 6, 0.0F);
        this.setRotateAngle(PlateHandLeftUp, 0.0F, 0.0F, 0.17453292519943295F);
        this.Belt_1 = new ModelRenderer(this, 4, 38);
        this.Belt_1.setRotationPoint(0.0F, 5.5F, -3.0F);
        this.Belt_1.addBox(-1.5F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(Belt_1, 0.0F, 0.0F, 0.5235987755982988F);
        this.Buckle_1 = new ModelRenderer(this, 21, 41);
        this.Buckle_1.setRotationPoint(-1.0F, 10.0F, -3.0F);
        this.Buckle_1.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.PlateFeetLeft_1 = new ModelRenderer(this, 0, 0);
        this.PlateFeetLeft_1.setRotationPoint(0F, 0F, 0.0F);
        this.PlateFeetLeft_1.addBox(0.75F, 3.5F, -2.5F, 1, 3, 5, 0.0F);
        this.setRotateAngle(PlateFeetLeft_1, 0.0F, 0.0F, -0.2617993877991494F);
        this.PlateHandRightFront_2 = new ModelRenderer(this, 50, 13);
        this.PlateHandRightFront_2.setRotationPoint(0F, 0F, 0.0F);
        this.PlateHandRightFront_2.addBox(-4.0F, 2.5F, -2.7F, 5, 2, 1, 0.0F);
        this.setRotateAngle(PlateHandRightFront_2, -0.17453292519943295F, 0.0F, 0.0F);

        if (armorType == 0) {
            addHelm();
        }
        else if (armorType == 1) {
            addBreastplate();
        }
        else if (armorType == 2) {
            addLegs();
        }
    }

    @Override
    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
        super.setRotationAngles(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);

        this.bipedHead.render(f5);
        this.bipedBody.render(f5);
        this.bipedLeftArm.render(f5);
        this.bipedRightArm.render(f5);
        this.bipedLeftLeg.render(f5);
        this.bipedRightLeg.render(f5);
    }

    public void addHelm() {
        this.bipedHead.cubeList.clear();
        this.bipedHead.addChild(PlateHelmetTop);
        this.bipedHead.addChild(PlateHelmetLeft);
        this.bipedHead.addChild(PlateHelmetLeft_1);
        this.bipedHead.addChild(PlateHelmetRight);
        this.bipedHead.addChild(PlateHelmetRight_1);
        this.bipedHead.addChild(PlateHelmetBack);
        this.bipedHead.addChild(PlateHelmetBack_1);
        this.bipedHead.addChild(PlateHelmetBack_2);
    }

    public void addBreastplate() {
        //Body
        this.bipedBody.cubeList.clear();
        this.bipedBody.addChild(Belt);
        this.bipedBody.addChild(Belt_1);
        this.bipedBody.addChild(Belt_2);
        this.bipedBody.addChild(Belt_3);
        this.bipedBody.addChild(Belt_4);
        this.bipedBody.addChild(Belt_5);
        this.bipedBody.addChild(Belt_6);
        this.bipedBody.addChild(Belt_7);
        this.bipedBody.addChild(Belt_8);
        this.bipedBody.addChild(Belt_9);
        this.bipedBody.addChild(Belt_10);
        this.bipedBody.addChild(Buckle);
        this.bipedBody.addChild(Buckle_1);
        this.bipedBody.addChild(Buckle_2);

        this.bipedBody.addChild(BodySwordBlade);
        this.bipedBody.addChild(BodySwordShaft);
        this.bipedBody.addChild(BodySwordHolder);

        this.bipedBody.addChild(PlateBodyFront);
        this.bipedBody.addChild(PlateBodyBack);

        //Left Arm
        this.bipedLeftArm.cubeList.clear();
        this.bipedLeftArm.addChild(HandLeftLeatherHolderFront);
        this.bipedLeftArm.addChild(HandLeftLeatherHolderFront_1);
        this.bipedLeftArm.addChild(HandLeftLeatherHolderBack);
        this.bipedLeftArm.addChild(PlateHandLeftDown);
        this.bipedLeftArm.addChild(PlateHandLeftUp);
        this.bipedLeftArm.addChild(PlateHandLeftUp_1);
        this.bipedLeftArm.addChild(PlateHandLeft);
        this.bipedLeftArm.addChild(PlateHandLeft_1);
        this.bipedLeftArm.addChild(PlateHandLeft_2);
        this.bipedLeftArm.addChild(PlateHandLeft_3);
        this.bipedLeftArm.addChild(PlateHandLeftFront);
        this.bipedLeftArm.addChild(PlateHandLeftFront_1);
        this.bipedLeftArm.addChild(PlateHandLeftFront_2);
        this.bipedLeftArm.addChild(PlateHandLeftBack);
        this.bipedLeftArm.addChild(PlateHandLeftBack_1);
        this.bipedLeftArm.addChild(PlateHandLeftBack_2);

        //Right Arm
        this.bipedRightArm.cubeList.clear();
        this.bipedRightArm.addChild(HandRightLeatherHolderFront);
        this.bipedRightArm.addChild(HandRightLeatherHolderFront_1);
        this.bipedRightArm.addChild(HandRightLeatherHolderBack);
        this.bipedRightArm.addChild(PlateHandRightDown);
        this.bipedRightArm.addChild(PlateHandRightUp);
        this.bipedRightArm.addChild(PlateHandRightUp_1);
        this.bipedRightArm.addChild(PlateHandRight);
        this.bipedRightArm.addChild(PlateHandRight_1);
        this.bipedRightArm.addChild(PlateHandRight_2);
        this.bipedRightArm.addChild(PlateHandRight_3);
        this.bipedRightArm.addChild(PlateHandRightFront);
        this.bipedRightArm.addChild(PlateHandRightFront_1);
        this.bipedRightArm.addChild(PlateHandRightFront_2);
        this.bipedRightArm.addChild(PlateHandRightBack);
        this.bipedRightArm.addChild(PlateHandRightBack_1);
        this.bipedRightArm.addChild(PlateHandRightBack_2);

    }

    public void addLegs() {
        //Left leg
        this.bipedLeftLeg.cubeList.clear();
        this.bipedLeftLeg.addChild(LegsSwordBlade);
        this.bipedLeftLeg.addChild(LegsSwordShaft);
        this.bipedLeftLeg.addChild(LegsSwordHolder);
        this.bipedLeftLeg.addChild(PlateFeetLeft);
        this.bipedLeftLeg.addChild(PlateFeetLeft_1);
        this.bipedLeftLeg.addChild(PlateFeetLeft_2);
        this.bipedLeftLeg.addChild(PlateFeetLeftFront);
        this.bipedLeftLeg.addChild(PlateFeetLeftFront_1);
        this.bipedLeftLeg.addChild(PlateFeetLeftFront_2);
        this.bipedLeftLeg.addChild(PlateFeetLeftBack);
        this.bipedLeftLeg.addChild(PlateFeetLeftBack_1);
        this.bipedLeftLeg.addChild(PlateFeetLeftBack_2);

        //Right leg
        this.bipedRightLeg.cubeList.clear();
        this.bipedRightLeg.addChild(PlateFeetRight);
        this.bipedRightLeg.addChild(PlateFeetRight_1);
        this.bipedRightLeg.addChild(PlateFeetRight_2);
        this.bipedRightLeg.addChild(PlateFeetRightFront);
        this.bipedRightLeg.addChild(PlateFeetRightFront_1);
        this.bipedRightLeg.addChild(PlateFeetRightFront_2);
        this.bipedRightLeg.addChild(PlateFeetRightBack);
        this.bipedRightLeg.addChild(PlateFeetRightBack_1);
        this.bipedRightLeg.addChild(PlateFeetRightBack_2);
    }
}
