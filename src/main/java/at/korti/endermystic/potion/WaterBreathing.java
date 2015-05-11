package at.korti.endermystic.potion;

import net.minecraft.potion.Potion;

/**
 * Created by Korti on 27.10.2014.
 */
public class WaterBreathing extends Potion {

    public WaterBreathing(int p_i1573_1_, boolean p_i1573_2_, int p_i1573_3_) {
        super(p_i1573_1_, p_i1573_2_, p_i1573_3_);
    }

    @Override
    protected Potion setIconIndex(int p_76399_1_, int p_76399_2_) {
        super.setIconIndex(p_76399_1_, p_76399_2_);
        return this;
    }
}
