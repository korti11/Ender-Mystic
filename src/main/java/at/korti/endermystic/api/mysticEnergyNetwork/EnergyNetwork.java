package at.korti.endermystic.api.mysticEnergyNetwork;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldSavedData;

/**
 * Created by Korti on 17.10.2014.
 */
public class EnergyNetwork extends WorldSavedData {

    public int mysticEnergy;
    public int mysticCapacity;

    public EnergyNetwork(String p_i2141_1_) {
        super(p_i2141_1_);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        mysticEnergy = nbt.getInteger("em_mysticEnergy");
        mysticCapacity = nbt.getInteger("em_mysticCapacity");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        nbt.setInteger("em_mysticEnergy", mysticEnergy);
        nbt.setInteger("em_mysticCapacity", mysticCapacity);
    }
}
