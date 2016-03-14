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
    final String SETT_APP="MainKKAppSettings";
    final String SETT_DIAG_PARAMS="DIAG_PARAMS";
    final String SETT_CONN_BLUETOOTH="BT_EXADEV";


    private SharedPreferences mSettings;
    public void InitSettings(Context Ctx)
    {
        mSettings = Ctx.getSharedPreferences(SETT_APP, Context.MODE_PRIVATE);
        //
        AppSettings.DiagParameters=mSettings.getStringSet(SETT_DIAG_PARAMS,GetDefaultDiagParams());
        AppSettings.KKBluetoothDevice=mSettings.getString(SETT_CONN_BLUETOOTH,"00:15:83:3D:0A:57");
    }


    private Set<String> GetDefaultDiagParams()
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
