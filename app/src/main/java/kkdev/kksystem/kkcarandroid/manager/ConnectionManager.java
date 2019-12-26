package kkdev.kksystem.kkcarandroid.manager;

import java.util.Set;

import kkdev.kksystem.kkcarandroid.manager.exaconnector.BTConnector;
import kkdev.kksystem.kkcarandroid.manager.exaconnector.EXARequestProcessor;
import kkdev.kksystem.kkcarandroid.manager.wmhttp.WebManager;

/**
 * Created by sayma_000 on 30.01.2016.
 */
public class ConnectionManager {

    public static BTConnector BTC;
    public static WebManager WMG;


    public static void CheckConnect(boolean Renew) {
        if (BTC == null) {
            BTC = new BTConnector();
            BTC.InitConnector();
        } else if (Renew) {
            BTC.InitConnector();
        } else
        {
            BTC.checkConnection();
        }

        //
        if (WMG == null) {
            WMG = new WebManager();
        }


    }


    //DIAGINFO
    public static void DIAG_RequestDiagInfoCE() {

        if (BTC.ConnectionActive) {
            BTC.SendData(EXARequestProcessor.RequestDiag_ODB2_CE());
        }

    }
    public static void DIAG_RequestDiagInfo(Set<String> Parameters)
    {
        int[] ReqPID=new int[Parameters.size()];

        int i=0;
        for (String Param:Parameters)
        {
            ReqPID[i]=Integer.valueOf(Param);
            i++;
        }

        if (BTC.ConnectionActive) {
            BTC.SendData(EXARequestProcessor.RequestDiag_ODB2_Params(ReqPID));
        }

    }
    public static void DIAG_RequestDiagInfo_Stop()
    {
        if (BTC.ConnectionActive) {
            BTC.SendData(EXARequestProcessor.RequestDiag_ODB2_Params_Stop());
        }

    }
    //CONFINFO
    public static void CONFINFO_RequestConfigInfo()
    {


    }
    //DISPLAY
    public static void DISPLAY_SendControlCommands(String ControlID)
    {
        if (BTC.ConnectionActive) {
            BTC.SendData(EXARequestProcessor.Controls_ControlData(ControlID));
        }

    }

}
