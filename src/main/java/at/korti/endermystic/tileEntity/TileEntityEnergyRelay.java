package at.korti.endermystic.tileEntity;

import at.korti.endermystic.api.mysticEnergyNetwork.IEnergy;
import at.korti.endermystic.api.mysticEnergyNetwork.IEnergyProvider;
import at.korti.endermystic.api.mysticEnergyNetwork.IEnergyRelay;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Korti on 14.04.2015.
 */
public class TileEntityEnergyRelay extends TileEntity implements IEnergyRelay{

    private IEnergy connection;
    private final int range = 20;
    private int connectionsToProvider;

    public TileEntityEnergyRelay() {
        connectionsToProvider = Integer.MAX_VALUE;
    }

    @Override
    public void updateEntity() {
        if(!isConnected()) {
            for (int x = xCoord - (range / 2); x < xCoord + (range / 2); x++) {
                for (int y = Math.max(0, yCoord - (range / 2)); y < yCoord + (range / 2); y++) {
                    for (int z = zCoord - (range / 2); z < zCoord + (range / 2); z++) {
                        TileEntity tileEntity = worldObj.getTileEntity(x, y, z);
                        if (tileEntity instanceof IEnergy && tileEntity != this) {
                            if (tileEntity instanceof IEnergyRelay) {
                                IEnergyRelay relay = (IEnergyRelay) tileEntity;
                                connectionsToProvider = connectionsToProvider > relay.getConnectionsToProvider() ? relay.getConnectionsToProvider() + 1 : connectionsToProvider;
                                if (connectionsToProvider == relay.getConnectionsToProvider()) {
                                    connectionsToProvider = Integer.MAX_VALUE;
                                    continue;
                                }
                                connection = (IEnergy) tileEntity;
                            } else if (tileEntity instanceof IEnergyProvider && connectionsToProvider > 0) {
                                connectionsToProvider = 0;
                                connection = (IEnergy) tileEntity;
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean isConnected(){
        if(connection != null) {
            TileEntity tileEntity = (TileEntity) connection;
            return worldObj.getTileEntity(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord) instanceof IEnergy;
        }
        return false;
    }

    @Override
    public int getConnectionsToProvider() {
        return connectionsToProvider;
    }

    @Override
    public IEnergyProvider getConnectionToProvider(){
        if(connection instanceof IEnergyRelay){
            return ((IEnergyRelay)connection).getConnectionToProvider();
        }
        else if(connection instanceof IEnergyProvider){
            return (IEnergyProvider) connection;
        }

        return null;
    }
}
