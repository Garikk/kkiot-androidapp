package kkdev.kksystem.kkcarandroid.manager.callback;

/**
 * Created by blinov_is on 22.06.2016.
 */
public interface IConnectionState {
    public enum ConnectionStates
    {
        CONNECTION_ACTIVE,
        CONNECTION_INACTIVE,
        CONNECTION_ERROR,
        CONNECTION_DISABLED

    }
    public enum ConnectorType
    {
        BluetoothEXA,
        DingoCloud

    }

    public void connectionStateInfo(ConnectionStates ConnectionState,ConnectorType Connector);
}
