package at.korti.endermystic.api.mysticEnergyNetwork;

/**
 * Created by Korti on 05.06.2015.
 */
public class EnergyStorage {

    private int maxStorage;
    private int maxTransferIn;
    private int maxTransferOut;
    private int currentEnergy;

    public EnergyStorage(int maxStorage, int maxTransferIn, int maxTransferOut) {
        this.maxStorage = maxStorage;
        this.maxTransferIn = maxTransferIn;
        this.maxTransferOut = maxTransferOut;
        this.currentEnergy = 0;
    }

    public int getMaxStorage() {
        return maxStorage;
    }

    public void setMaxStorage(int maxStorage) {
        this.maxStorage = maxStorage;
    }

    public int getMaxTransferIn() {
        return maxTransferIn;
    }

    public void setMaxTransferIn(int maxTransferIn) {
        this.maxTransferIn = maxTransferIn;
    }

    public int getMaxTransferOut() {
        return maxTransferOut;
    }

    public void setMaxTransferOut(int maxTransferOut) {
        this.maxTransferOut = maxTransferOut;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    public void setCurrentEnergy(int energy) {
        this.currentEnergy = energy;
    }

    public int transferEnergyIn(int energy) {
        return currentEnergy = Math.min(maxStorage, currentEnergy + energy);
    }

    public int transferEnergyOut(int energy) {
        int tempEnergy = currentEnergy;
        currentEnergy = Math.max(0, currentEnergy - energy);
        if (currentEnergy == 0) {
            return tempEnergy;
        } else {
            return energy;
        }
    }

}
