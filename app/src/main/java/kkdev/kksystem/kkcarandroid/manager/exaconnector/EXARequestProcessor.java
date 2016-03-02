package kkdev.kksystem.kkcarandroid.manager.exaconnector;

import android.widget.Switch;

import com.google.gson.Gson;

import kkdev.kksystem.base.classes.odb2.ODBConstants;
import kkdev.kksystem.base.classes.odb2.PinOdb2Data;
import kkdev.kksystem.base.classes.plugins.PluginMessage;
import kkdev.kksystem.base.constants.PluginConsts;
import kkdev.kksystem.base.constants.SystemConsts;
import kkdev.kksystem.kkcarandroid.manager.DiagOperations;

import static kkdev.kksystem.base.classes.plugins.simple.managers.PluginManagerDataProcessor.ODB_SendPluginMessageCommand_PMData;

/**
 * Created by blinov_is on 28.01.2016.
 */
public class EXARequestProcessor {

    static Gson gson=new Gson();

    public static void DecodeAndProcessPin(String JSONPin)
    {
        Gson gson=new Gson();

        PluginMessage PM=gson.fromJson(JSONPin,PluginMessage.class);
        PinOdb2Data PD=(PinOdb2Data)gson.fromJson((String)PM.PinData,PinOdb2Data.class);

        switch (PM.PinName)
        {
            case PluginConsts.KK_PLUGIN_BASE_ODB2_DATA:
                UpdateDiagInfo(PD);
                break;
            case PluginConsts.KK_PLUGIN_BASE_LED_DATA:
                ProcessLedInfo(PM);
                break;
            case PluginConsts.KK_PLUGIN_BASE_CONTROL_DATA:
                ProcessControlCmd(PM);
                break;

        }
    }


    private static void UpdateDiagInfo(PinOdb2Data PD)
    {
        DiagOperations.ReceiveExtData(PD);

    }

    private static void ProcessControlCmd(PluginMessage PM)
    {

    }

    private static void ProcessLedInfo(PluginMessage PM)
    {

    }


    public static String  RequestDiag_ODB2Data()
    {
        PluginMessage PM;
        PM=new PluginMessage();
        PM.PinName=PluginConsts.KK_PLUGIN_BASE_ODB2_COMMAND;
        PM.PinData=gson.toJson(ODB_SendPluginMessageCommand_PMData(SystemConsts.KK_BASE_FEATURES_ODB_DIAG_ANDROIDAPP_UID, ODBConstants.KK_ODB_COMMANDTYPE.ODB_KKSYS_CAR_GETINFO, ODBConstants.KK_ODB_DATACOMMANDINFO.ODB_GETINFO_CE_ERRORS, null, null));
        PM.FeatureID=SystemConsts.KK_BASE_FEATURES_ODB_DIAG_ANDROIDAPP_UID;
        //
        return gson.toJson(PM);

    }
}
