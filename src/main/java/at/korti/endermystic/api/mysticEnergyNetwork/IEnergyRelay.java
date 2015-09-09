package at.korti.endermystic.api.mysticEnergyNetwork;

/**
 * Created by Korti on 14.04.2015.
 */
public interface IEnergyRelay extends IEnergy {

    int getConnectionsToProvider();

    IEnergyProvider getConnectionToProvider();

    IEnergyRelay getLastReleay();

    void findNewConnection(int energy);

}
