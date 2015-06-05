package at.korti.endermystic.api.mysticEnergyNetwork;

/**
 * Created by Korti on 14.04.2015.
 */
public interface IEnergyProvider extends IEnergy {

    int getEnergyToProvide();

    int decrEnergy(int energyUse);

    boolean canProvideEnergy();

    boolean hasEnoughEnergy(int toUse);

}
