package kkdev.kksystem.kkcarandroid.manager.exaconnector;

/**
 * Created by blinov_is on 28.01.2016.
 */

 import java.io.IOException;
 import java.io.InputStream;
 import java.io.OutputStream;
 import java.util.UUID;

 import android.bluetooth.BluetoothAdapter;
 import android.bluetooth.BluetoothDevice;
 import android.bluetooth.BluetoothSocket;
 import android.content.Intent;
 import android.util.Log;

 import kkdev.kksystem.base.constants.PluginConsts;

 import static android.support.v4.app.ActivityCompat.invalidateOptionsMenu;
 import static android.support.v4.app.ActivityCompat.startActivityForResult;

public class BTConnector  {
//
    private String _____TEMPRORARY_DEV_ADDR="____";
    //


    private BluetoothAdapter btAdapter = null;
    private BluetoothSocket btSocket = null;
    private OutputStream outStream = null;
    private boolean ConnectorState=false;

    public void InitConnector()
    {
        btAdapter = BluetoothAdapter.getDefaultAdapter();
        //
        ConnectorState=checkBTState();
        //
        if (!ConnectorState)
            return;
        //
        ConnectToEXADevice();
    }

    private void ConnectToEXADevice()
    {
        BluetoothDevice device = btAdapter.getRemoteDevice(_____TEMPRORARY_DEV_ADDR);
        try {
            btSocket = device.createRfcommSocketToServiceRecord(UUID.fromString(PluginConsts.KK_PLUGIN_BASE_PLUGIN_BLUETOOTH_BTSERVICE_KKEXCONNECTION_UUID));
        } catch (IOException e) {
            Log.d("BTEXA", "BT Socket create failed: " + e.getMessage() + ".");
        }
        //
        try {
            btSocket.connect();
            Log.d("BTEXA", "...Соединение установлено и готово к передачи данных...");
        } catch (IOException e) {
            try {
                btSocket.close();
            } catch (IOException e2) {
                Log.d("BTEXA","Unable to close socket during connection failure" + e2.getMessage() + ".");
            }
        }
        try {
            outStream = btSocket.getOutputStream();
        } catch (IOException e) {
            Log.d("BTEXA", "In onResume() and output stream creation failed:" + e.getMessage() + ".");
        }
    }
    private void sendData(String message) {
        byte[] msgBuffer = message.getBytes();

        Log.d("BTEXA", "...Send data: " + message + "...");

        try {
            outStream.write(msgBuffer);
        } catch (IOException e) {
            Log.d("BTEXA", "Exception occurred during write: " + e.getMessage());
        }
    }

    private boolean checkBTState() {
        if(btAdapter==null) {
            Log.d("BTEXA", "Bluetooth not found");
            return false;
        } else {
            if (btAdapter.isEnabled()) {
                Log.d("BTEXA", "Bluetooth enabled");
                return true;
            } else {
                Log.d("BTEXA", "Bluetooth disabled");
                return false;
                //Prompt user to turn on Bluetooth
                //Intent enableBtIntent = new Intent(btAdapter.ACTION_REQUEST_ENABLE);
              //  startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            }
        }
    }
}