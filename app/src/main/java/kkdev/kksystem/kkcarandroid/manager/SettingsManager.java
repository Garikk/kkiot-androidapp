package kkdev.kksystem.kkcarandroid.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.ArraySet;

import java.util.HashSet;
import java.util.Set;

import kkdev.kksystem.base.classes.odb2.ODB2_SAE_J1979_PID_MODE_1;
import kkdev.kksystem.kkcarandroid.manager.types.AppSettings;

/**
 * Created by blinov_is on 11.03.2016.
 */
public class SettingsManager {
    final static String SETT_APP="MainKKAppSettings";
    final static String SETT_DIAG_PARAMS="DIAG_PARAMS";
    final static String SETT_CONN_BLUETOOTH_NAME="BT_EXADEV_NAME";
    final static String SETT_CONN_BLUETOOTH_DEVADDR="BT_EXADEV_ADDR";
    final static String SETT_CONN_BLUETOOTH_KEY="BT_EXADEV_KEY";
    final static String SETT_CONN_BLUETOOTH_ENABLED="BT_EXADEV";

    final static String SETT_CONN_DINGOCLOUD_ENABLED="CLOUD_DINGO";
    final static String SETT_CONN_DINGOCLOUD_HOST="CLOUD_DINGO_HOST";
    final static String SETT_CONN_DINGOCLOUD_LOGIN="CLOUD_DINGO_LOGIN";
    final static String SETT_CONN_DINGOCLOUD_HASH="CLOUD_DINGO_HASH";

    private static SharedPreferences mSettings;
    public static void initSettings(Context Ctx)
    {
        mSettings = Ctx.getSharedPreferences(SETT_APP, Context.MODE_PRIVATE);
        //
        AppSettings.DiagParameters=mSettings.getStringSet(SETT_DIAG_PARAMS,GetDefaultDiagParams());
        //
        AppSettings.KKBluetoothDevice_Name=mSettings.getString(SETT_CONN_BLUETOOTH_NAME,"");
        AppSettings.KKBluetoothDevice_Key=mSettings.getString(SETT_CONN_BLUETOOTH_KEY,"");
        AppSettings.KKBluetoothDevice_Enabled=mSettings.getBoolean(SETT_CONN_BLUETOOTH_ENABLED,false);
        AppSettings.KKBluetoothDevice_Addr=mSettings.getString(SETT_CONN_BLUETOOTH_DEVADDR,"");
        //
        AppSettings.DingoCloud_Addr=mSettings.getString(SETT_CONN_DINGOCLOUD_HOST,"");
        AppSettings.DingoCloud_Enabled=mSettings.getBoolean(SETT_CONN_DINGOCLOUD_ENABLED,false);
        AppSettings.DingoCloud_Login=mSettings.getString(SETT_CONN_DINGOCLOUD_LOGIN,"");
        AppSettings.DingoCloud_Hash=mSettings.getString(SETT_CONN_DINGOCLOUD_HASH,"");

    }
    public static void saveSettings(Context Ctx)
    {
        mSettings = Ctx.getSharedPreferences(SETT_APP, Context.MODE_PRIVATE);
        //
        SharedPreferences.Editor edit = mSettings.edit();
        //
        edit.putStringSet(SETT_DIAG_PARAMS,AppSettings.DiagParameters);
        //
        edit.putBoolean(SETT_CONN_BLUETOOTH_ENABLED,AppSettings.KKBluetoothDevice_Enabled);
        edit.putString(SETT_CONN_BLUETOOTH_KEY, AppSettings.KKBluetoothDevice_Key);
        edit.putString(SETT_CONN_BLUETOOTH_DEVADDR,AppSettings.KKBluetoothDevice_Addr);
        //
        edit.putBoolean(SETT_CONN_DINGOCLOUD_ENABLED,AppSettings.DingoCloud_Enabled);
        edit.putString(SETT_CONN_DINGOCLOUD_HOST, AppSettings.DingoCloud_Addr);
        edit.putString(SETT_CONN_DINGOCLOUD_LOGIN,AppSettings.DingoCloud_Login);
        edit.putString(SETT_CONN_DINGOCLOUD_HASH,AppSettings.DingoCloud_Hash);
        //
        edit.apply();
    }


    private static Set<String> GetDefaultDiagParams()
    {
        Set Ret;
        Ret=new HashSet();

        Ret.add(ODB2_SAE_J1979_PID_MODE_1.PID_0C_ENGINE_RPM);
        Ret.add(ODB2_SAE_J1979_PID_MODE_1.PID_0D_VEHICLE_SPEED);
        Ret.add(ODB2_SAE_J1979_PID_MODE_1.PID_42_CONTROL_MODULE_VOLTAGE);
        Ret.add(ODB2_SAE_J1979_PID_MODE_1.PID_05_COLIANT_TEMP);


        return Ret;

    }

}
