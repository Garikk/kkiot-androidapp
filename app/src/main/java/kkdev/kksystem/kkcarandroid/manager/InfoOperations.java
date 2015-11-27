package kkdev.kksystem.kkcarandroid.manager;

import kkdev.kksystem.kkcarandroid.manager.types.ConfigurationInfo;
import kkdev.kksystem.kkcarandroid.wmhttp.WebManager;

/**
 * Created by blinov_is on 18.11.2015.
 */
public class InfoOperations {

    public static ConfigurationInfo GetConfInfo()
    {
        ConfigurationInfo Ret;

        Ret=WebManager.GetMyConfInfo();

        return Ret;

    }


}
