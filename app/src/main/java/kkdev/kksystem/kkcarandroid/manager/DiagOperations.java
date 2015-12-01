package kkdev.kksystem.kkcarandroid.manager;

import kkdev.kksystem.kkcarandroid.manager.types.KKDiagInfo;
import kkdev.kksystem.kkcarandroid.wmhttp.WebManager;

/**
 * Created by blinov_is on 18.11.2015.
 */
public abstract class DiagOperations {

    public static KKDiagInfo GetDiagErrInfo()
    {
        KKDiagInfo Ret;
        Ret= WebManager.GetDiagInfo();
        Ret.InitValues();
        return Ret;

    }
}
