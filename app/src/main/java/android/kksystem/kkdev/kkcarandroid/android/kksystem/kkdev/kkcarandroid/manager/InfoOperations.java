package android.kksystem.kkdev.kkcarandroid.android.kksystem.kkdev.kkcarandroid.manager;

import android.kksystem.kkdev.kkcarandroid.android.kksystem.kkdev.kkcarandroid.manager.types.ConfigurationInfo;

/**
 * Created by blinov_is on 18.11.2015.
 */
public class InfoOperations {

    public static ConfigurationInfo GetConfInfo()
    {
        ConfigurationInfo Ret;

        Ret=new ConfigurationInfo();
        Ret.ConfName="test";
        Ret.ConfDescription="test desc";

        Ret.CarStatus= ConfigurationInfo.CarStatus.Ok;
        Ret.CarConnectionState= ConfigurationInfo.CarConnection.Idle;
        Ret.EngineState= ConfigurationInfo.EngineStatus.Active;

        return Ret;

    }


}
