package kkdev.kksystem.kkcarandroid.manager.exaconnector;

import android.widget.Switch;

import com.google.gson.Gson;

import kkdev.kksystem.base.classes.plugins.PluginMessage;
import kkdev.kksystem.base.constants.PluginConsts;

/**
 * Created by blinov_is on 28.01.2016.
 */
public class EXARequestProcessor {


    public static void DecodeAndProcessPin(String JSONPin)
    {
        Gson gson=new Gson();

        PluginMessage PM=gson.fromJson(JSONPin,PluginMessage.class);

        switch (PM.PinName)
        {
            case PluginConsts.KK_PLUGIN_BASE_ODB2_DATA:
                UpdateDiagInfo(PM);
                break;
            case PluginConsts.KK_PLUGIN_BASE_LED_DATA:
                ProcessLedInfo(PM);
                break;
            case PluginConsts.KK_PLUGIN_BASE_CONTROL_DATA:
                ProcessControlCmd(PM);
                break;

        }
    }


    private static void UpdateDiagInfo(PluginMessage PM)
    {


    }

    private static void ProcessControlCmd(PluginMessage PM)
    {

    }

    private static void ProcessLedInfo(PluginMessage PM)
    {

    }
}
