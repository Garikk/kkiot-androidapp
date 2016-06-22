package kkdev.kksystem.kkcarandroid;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Set;

import kkdev.kksystem.kkcarandroid.manager.SettingsManager;
import kkdev.kksystem.kkcarandroid.manager.types.AppSettings;

public class act_bluetoothconnect extends AppCompatActivity {

    private final static int REQUEST_ENABLE_BT = 1;
    final int KK_ACTIVITY_REQUEST_RESULT_OK=1;
    final int KK_ACTIVITY_REQUEST_RESULT_CANCEL=5;

    BluetoothAdapter bluetooth;
    ArrayAdapter DevicesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetoothconnect);

        bluetooth= BluetoothAdapter.getDefaultAdapter();
        DevicesList=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1);
        ListView lstBTDevices;
        lstBTDevices = (ListView)findViewById(R.id.lstBTDevices);
        lstBTDevices.setAdapter(DevicesList);
        lstBTDevices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setResult(KK_ACTIVITY_REQUEST_RESULT_OK);
                AppSettings.KKBluetoothDevice_Name=((TextView) view.findViewById(android.R.id.text1)).getText().toString();
                AppSettings.KKBluetoothDevice_Addr=((TextView) view.findViewById(android.R.id.text2)).getText().toString();
                SettingsManager.saveSettings(getApplicationContext());
                finish();
            }
        });

        Button btnRefresh = (Button)findViewById(R.id.btnRefresh);
        Button btnBack = (Button)findViewById(R.id.btn_BT_Back);


         btnRefresh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fillBTDevices();
                }
            });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(KK_ACTIVITY_REQUEST_RESULT_CANCEL);
                finish();
            }
        });

        if(bluetooth==null)
        {
            return;
        }
        if (bluetooth.isEnabled()) {
            // Bluetooth включен. Работаем.
        }
        else
        {
            // Bluetooth выключен. Предложим пользователю включить его.
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }
        //
        fillBTDevices();

    }
    private final BroadcastReceiver mReceiver=new BroadcastReceiver(){
        public void onReceive(Context context, Intent intent){
            String action= intent.getAction();
            if(BluetoothDevice.ACTION_FOUND.equals(action)){
                BluetoothDevice device= intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                DevicesList.add(device.getName()+"\n"+ device.getAddress());
            }
        }
    };

    @Override
    protected void onDestroy() {
        unregisterReceiver(mReceiver);
        super.onDestroy();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == REQUEST_ENABLE_BT) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                fillBTDevices();
            }
        }
    }

    private void fillBTDevices()
    {
        DevicesList.clear();
        Set<BluetoothDevice> pairedDevices= bluetooth.getBondedDevices();
        //
        for(BluetoothDevice device: pairedDevices) {
            DevicesList.add(device.getName()+"\n"+ device.getAddress());
        }

        IntentFilter filter=new IntentFilter(BluetoothDevice.ACTION_FOUND);
        unregisterReceiver(mReceiver);
        registerReceiver(mReceiver, filter);


    }
}
