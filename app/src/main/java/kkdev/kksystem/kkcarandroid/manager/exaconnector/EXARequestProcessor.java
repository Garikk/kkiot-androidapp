package kkdev.kksystem.kkcarandroid.manager.exaconnector;

import android.util.ArraySet;
import android.widget.Button;

import com.google.gson.Gson;

import java.util.Set;
import java.util.TreeSet;

import kkdev.kksystem.base.classes.base.PinBaseCommand;
import kkdev.kksystem.base.classes.base.PinBaseData;
import kkdev.kksystem.base.classes.base.PinData;
import kkdev.kksystem.base.classes.base.PinDataTaggedString;
import kkdev.kksystem.base.classes.base.PluginMessageData;
import kkdev.kksystem.base.classes.controls.PinControlData;
import kkdev.kksystem.base.classes.controls.PinDataControl;
import kkdev.kksystem.base.classes.display.PinDataLed;
import kkdev.kksystem.base.classes.display.PinLedCommand;
import kkdev.kksystem.base.classes.display.PinLedData;
import kkdev.kksystem.base.classes.odb2.ODBConstants;
import kkdev.kksystem.base.classes.odb2.PinOdb2Data;
import kkdev.kksystem.base.classes.plugins.PluginMessage;
import kkdev.kksystem.base.classes.plugins.simple.managers.PluginManagerControls;
import kkdev.kksystem.base.constants.PluginConsts;
import kkdev.kksystem.base.constants.SystemConsts;
import kkdev.kksystem.kkcarandroid.manager.DiagOperations;
import kkdev.kksystem.kkcarandroid.manager.LedDisplayDiag;

import static kkdev.kksystem.base.classes.plugins.simple.managers.PluginManagerODB.ODB_SendPluginMessageCommand_PMData;


/**
 * Created by blinov_is on 28.01.2016.
 */
public class EXARequestProcessor {

    static Gson gson=new Gson();

    public static void DecodeAndProcessPin(String JSONPin)
    {
        Gson gson=new Gson();

        PluginMessage PM=gson.fromJson(JSONPin,PluginMessage.class);


        switch (PM.pinName)
        {
            case PluginConsts.KK_PLUGIN_BASE_ODB2_DATA:
                PinOdb2Data PD=(PinOdb2Data)gson.fromJson(((PinDataTaggedString)PM.getPinData()).value,PinOdb2Data.class);
                UpdateDiagInfo(PD);
                break;
            case PluginConsts.KK_PLUGIN_BASE_LED_COMMAND:
                PM.setPinData((PinDataLed)gson.fromJson(((PinDataTaggedString)PM.getPinData()).value,PinDataLed.class));
                ProcessLedInfo(PM);
                break;
            case PluginConsts.KK_PLUGIN_BASE_LED_DATA :
                PM.setPinData((PinDataLed)gson.fromJson(((PinDataTaggedString)PM.getPinData()).value,PinDataLed.class));
                ProcessLedInfo(PM);
                break;
            case PluginConsts.KK_PLUGIN_BASE_CONTROL_DATA:
                PinControlData PC=(PinControlData)gson.fromJson(((PinDataTaggedString)PM.getPinData()).value,PinControlData.class);
                ProcessControlCmd(PC);
                break;
            case PluginConsts.KK_PLUGIN_BASE_PIN_COMMAND:
                PM.setPinData((PinData)gson.fromJson(((PinDataTaggedString)PM.getPinData()).value,PinData.class));
                ProcessBaseCommand(PM,(PinBaseCommand)PM.getPinData());
                break;

        }
    }


    private static void UpdateDiagInfo(PinOdb2Data PD)
    {
        DiagOperations.ReceiveExtData(PD);

    }
    private static void ProcessBaseCommand(PluginMessage PM,PinBaseCommand BC)
    {
        if (BC.baseCommand.equals(PinBaseCommand.BASE_COMMAND_TYPE.CHANGE_FEATURE))
        {
            LedDisplayDiag.ReceiveExtData(PM);

        }
    }
    private static void ProcessControlCmd(PinControlData PC)
    {

    }

    private static void ProcessLedInfo(PluginMessage PM)
    {
        LedDisplayDiag.ReceiveExtData(PM);
    }


    public static String RequestDiag_ODB2_CE()
    {
        PinDataTaggedString PDTS=new PinDataTaggedString();
        PDTS.tag="EXA_TRANSFER";
        PDTS.value=gson.toJson(ODB_SendPluginMessageCommand_PMData(ODBConstants.KK_ODB_COMMANDTYPE.ODB_KKSYS_CAR_GETINFO, ODBConstants.KK_ODB_DATACOMMANDINFO.ODB_GETINFO_CE_ERRORS, null, null));
        PluginMessageData PM;
        PM=new PluginMessageData(PDTS);
        PM.pinName=PluginConsts.KK_PLUGIN_BASE_ODB2_COMMAND;
        PM.FeatureID=new TreeSet<>();
        PM.FeatureID.add(SystemConsts.KK_BASE_FEATURES_ODB_DIAG_ANDROIDAPP_UID);
        //
        return gson.toJson(PM);

    }
    public static String RequestDiag_ODB2_Params(int[] ReqPID)
    {

        PinDataTaggedString PDTS=new PinDataTaggedString();
        PDTS.tag="EXA_TRANSFER";
        PDTS.value=gson.toJson(ODB_SendPluginMessageCommand_PMData( ODBConstants.KK_ODB_COMMANDTYPE.ODB_KKSYS_CAR_GETINFO, ODBConstants.KK_ODB_DATACOMMANDINFO.ODB_GETINFO_PIDDATA, ReqPID, null));

        PluginMessageData PM;
        PM=new PluginMessageData(PDTS);
        PM.pinName=PluginConsts.KK_PLUGIN_BASE_ODB2_COMMAND;
        PM.FeatureID=new TreeSet<>();
        PM.FeatureID.add(SystemConsts.KK_BASE_FEATURES_ODB_DIAG_ANDROIDAPP_UID);
        //
        return gson.toJson(PM);

    }
    public static String RequestDiag_ODB2_Params_Stop()
    {

        PinDataTaggedString PDTS=new PinDataTaggedString();
        PDTS.tag="EXA_TRANSFER";
        PDTS.value=gson.toJson(ODB_SendPluginMessageCommand_PMData(ODBConstants.KK_ODB_COMMANDTYPE.ODB_KKSYS_CAR_GETINFO_STOP, ODBConstants.KK_ODB_DATACOMMANDINFO.ODB_GETINFO_PIDDATA, null, null));

        PluginMessageData PM;
        PM=new PluginMessageData(PDTS);
        PM.pinName=PluginConsts.KK_PLUGIN_BASE_ODB2_COMMAND;

        PM.FeatureID=new TreeSet<>();
        PM.FeatureID.add(SystemConsts.KK_BASE_FEATURES_ODB_DIAG_ANDROIDAPP_UID);
        //
        return gson.toJson(PM);

    }
    public static String  Request_LedDisplay()
    {
        PinDataTaggedString PDTS=new PinDataTaggedString();
        PDTS.tag="EXA_TRANSFER";
        PDTS.value=gson.toJson(ODB_SendPluginMessageCommand_PMData(ODBConstants.KK_ODB_COMMANDTYPE.ODB_KKSYS_CAR_GETINFO, ODBConstants.KK_ODB_DATACOMMANDINFO.ODB_GETINFO_CE_ERRORS, null, null));

        PluginMessageData PM;
        PM=new PluginMessageData(PDTS);
        PM.pinName=PluginConsts.KK_PLUGIN_BASE_ODB2_COMMAND;
        PM.FeatureID=new TreeSet<>();
        PM.FeatureID.add(SystemConsts.KK_BASE_FEATURES_ODB_DIAG_ANDROIDAPP_UID);
        //
        return gson.toJson(PM);

    }
    public static String  Controls_ControlData(String ButtonID)
    {
        Set<String> FTR=new TreeSet<>();
        FTR.add(SystemConsts.KK_BASE_FEATURES_ODB_DIAG_ANDROIDAPP_UID);

        Set<String> Btn=new TreeSet<>();
        Btn.add(ButtonID);

        PinDataTaggedString PDTS=new PinDataTaggedString();
        PDTS.tag="EXA_TRANSFER";
        PDTS.value=gson.toJson(PluginManagerControls.CONTROL_SendPluginMessageData_PData(FTR,SystemConsts.KK_BASE_UICONTEXT_DEFAULT,Btn, PinDataControl.KK_CONTROL_DATA.CONTROL_TRIGGERED,1));

        PluginMessageData PM;
        PM=new PluginMessageData(PDTS);
        PM.pinName=PluginConsts.KK_PLUGIN_BASE_CONTROL_DATA;

        PM.FeatureID=FTR;
        //
        return gson.toJson(PM);

    }
}
