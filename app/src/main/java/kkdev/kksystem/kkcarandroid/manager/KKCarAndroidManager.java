package kkdev.kksystem.kkcarandroid.manager;

import kkdev.kksystem.kkcarandroid.manager.exaconnector.BTConnector;
import kkdev.kksystem.kkcarandroid.manager.types.KKDiagInfo;
import kkdev.kksystem.kkcarandroid.manager.wmhttp.WebManager;

/**
 * Created by blinov_is on 18.11.2015.
 */
public class KKCarAndroidManager {

    public static boolean MainConnectionState=false;
    private static WebManager WM;
    private static BTConnector BT;

    public static void InitConnection()
    {


    }

    public static KKDiagInfo GetODB2Errors()
    {
        return  DiagOperations.GetDiagErrInfo();

    }


}
