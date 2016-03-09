package kkdev.kksystem.kkcarandroid.manager;

import kkdev.kksystem.base.classes.display.DisplayConstants;
import kkdev.kksystem.base.classes.display.PinLedCommand;
import kkdev.kksystem.base.classes.display.PinLedData;
import kkdev.kksystem.base.classes.odb2.ODBConstants;
import kkdev.kksystem.base.classes.odb2.PinOdb2Data;
import kkdev.kksystem.base.classes.plugins.PluginMessage;
import kkdev.kksystem.kkcarandroid.leddebug.LCDDisplayManager;
import kkdev.kksystem.kkcarandroid.manager.callback.IDiagUI;
import kkdev.kksystem.kkcarandroid.manager.callback.ILedDebugUI;
import kkdev.kksystem.kkcarandroid.manager.types.KKDiagInfo;

/**
 * Created by blinov_is on 02.03.2016.
 */
public class LedDisplayDiag {
    static ILedDebugUI  CurrentUI;
    static LCDDisplayManager LDM;


    public static void RegisterCallback(ILedDebugUI Callback) {
        if (LDM==null)
           LDM= new LCDDisplayManager();
        //
        LDM.Init(Callback);
        //
        ConnectionManager.CheckConnect();
        CurrentUI = Callback;

    }

    public static void ProcessControlButton(String ControlID)
    {
        ConnectionManager.DISPLAY_SendControlCommands(ControlID);

    }
    public static void ReceiveExtData(PluginMessage PM) {
            LDM.ReceivePin(PM.FeatureID,PM.PinName,PM.PinData);

    }
}
