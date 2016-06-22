package kkdev.kksystem.kkcarandroid.manager.exaconnector;

/**
 * Created by blinov_is on 28.01.2016.
 */

 import java.io.BufferedReader;
 import java.io.BufferedWriter;
 import java.io.IOException;
 import java.io.InputStream;
 import java.io.InputStreamReader;
 import java.io.OutputStream;
 import java.io.OutputStreamWriter;
 import java.util.UUID;

 import android.bluetooth.BluetoothAdapter;
 import android.bluetooth.BluetoothDevice;
 import android.bluetooth.BluetoothSocket;
 import android.util.Log;

 import kkdev.kksystem.kkcarandroid.manager.types.AppSettings;

public class BTConnector  {
//
    //


    private BluetoothAdapter btAdapter = null;
    private BluetoothSocket btSocket = null;
    private OutputStream outStream = null;
    private InputStream inStream = null;
    private BufferedWriter bw;
    private boolean ConnectorState=false;
    public boolean ConnectionActive =false;


    public void InitConnector()
    {
        //
        if (!AppSettings.KKBluetoothDevice_Enabled)
            return;
        //
        btAdapter = BluetoothAdapter.getDefaultAdapter();
        //
        ConnectorState=checkBTState();
        //
    }
    public void checkConnection()
    {
        if (!AppSettings.KKBluetoothDevice_Enabled)
            return;

        //
        ConnectorState=checkBTState();
        //
        if (!ConnectionActive)
        {
            ConnectToEXADevice();
        }

    }

    public void SendData(String Data)
    {
        btSendData(Data);
    }

    private void ConnectToEXADevice()
    {
        if (ConnectorState==false)
            return;

        BluetoothDevice device = btAdapter.getRemoteDevice(AppSettings.KKBluetoothDevice_Addr);
        try {
             btSocket = device.createRfcommSocketToServiceRecord(UUID.fromString("09846431-0000-1000-8000-00805F9B34FB"));
        } catch (IOException e) {
            Log.d("BTEXA", "BT Socket create failed: " + e.getMessage() + ".");
        }
        //
        try {
            ConnectionActive =true;
            btSocket.connect();
            Log.d("BTEXA", "...Connect OK...");
        } catch (IOException e) {
            try {
                btSocket.close();
            } catch (IOException e2) {
                Log.d("BTEXA","Unable to close socket during connection failure" + e2.getMessage() + ".");
            }
        }
        try {
            outStream = btSocket.getOutputStream();
            inStream = btSocket.getInputStream();
            bw=new BufferedWriter(new OutputStreamWriter(outStream));
            DataReader.start();
        } catch (IOException e) {
            Log.d("BTEXA", "In onResume() and output stream creation failed:" + e.getMessage() + ".");
        }
    }
    private void btSendData(String message) {
       // byte[] msgBuffer = message.getBytes();

        Log.d("BTEXA", "...Send data: " + message + "...");

        try {
           // outStream.write(msgBuffer);
            bw.write(message);
            bw.newLine();
            bw.flush();
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

    Thread DataReader = new Thread(new Runnable() {
        private BufferedReader br;
        @Override
        public void run() {
            br= new BufferedReader(new InputStreamReader(inStream));
            Log.d("BTEXA", "BT Reader start");
            while (ConnectionActive)
            {
                try {
                    String RL=br.readLine();
                    EXARequestProcessor.DecodeAndProcessPin( RL);
                } catch (IOException e) {
                    e.printStackTrace();
                    ConnectionActive = false;
                } catch (NullPointerException e){
                 e.printStackTrace();
                ConnectionActive = false;

                }

            }
            Log.d("BTEXA", "BT Reader stop");
        }
    });
}