package kkdev.kksystem.kkcarandroid.manager;

import kkdev.kksystem.kkcarandroid.manager.types.KKConfigurationInfo;
import kkdev.kksystem.kkcarandroid.manager.wmhttp.WebManager;

/**
 * Created by blinov_is on 18.11.2015.
 */
public class InfoOperations {

    public static KKConfigurationInfo GetConfInfo()
    {
        KKConfigurationInfo Ret;

        Ret=WebManager.GetMyConfInfo();
        Ret.InitParams();
        return Ret;

    }


}
