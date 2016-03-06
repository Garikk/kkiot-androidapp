package kkdev.kksystem.kkcarandroid.manager;

import kkdev.kksystem.kkcarandroid.manager.exaconnector.BTConnector;
import kkdev.kksystem.kkcarandroid.manager.exaconnector.EXARequestProcessor;
import kkdev.kksystem.kkcarandroid.manager.wmhttp.WebManager;

/**
 * Created by sayma_000 on 30.01.2016.
 */
public class ConnectionManager {

    public static BTConnector BTC;
    public static WebManager WMG;


    public static void CheckConnect()
    {
        if (BTC==null) {
            BTC = new BTConnector();
            BTC.InitConnector();
        }
        //
        if (WMG==null) {
            WMG = new WebManager();
        }

    }


    //DIAGINFO
    public static void DIAG_RequestDiagInfoCE()
    {

        if (BTC.ConnectionEnabled) {
            BTC.SendData(EXARequestProcessor.RequestDiag_ODB2Data());
        }

    }
    //CONFINFO
    public static void CONFINFO_RequestConfigInfo()
    {


    }
    //DISPLAY
    public static void DISPLAY_SendControlCommands(String ControlID)
    {
        if (BTC.ConnectionEnabled) {
            BTC.SendData(EXARequestProcessor.Controls_ControlData(ControlID));
        }

    }

}
