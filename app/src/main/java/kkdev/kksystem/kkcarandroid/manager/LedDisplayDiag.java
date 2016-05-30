package kkdev.kksystem.kkcarandroid.manager;

import kkdev.kksystem.base.classes.plugins.PluginMessage;
import kkdev.kksystem.kkcarandroid.leddebug.LCDDisplayManager;
import kkdev.kksystem.kkcarandroid.manager.callback.ILedDebugUI;

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
        if (LDM==null)
            return;

            LDM.ReceivePin(PM.FeatureID,PM.PinName,PM.PinData);
    }
}
