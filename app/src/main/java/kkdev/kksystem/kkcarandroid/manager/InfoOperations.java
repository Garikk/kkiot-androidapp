package kkdev.kksystem.kkcarandroid.manager;

import kkdev.kksystem.kkcarandroid.manager.types.ConfigurationInfo;

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

        Ret.CStatus= ConfigurationInfo.CarStatus.Ok;
        Ret.CConnectionState= ConfigurationInfo.CarConnection.Idle;
        Ret.EState= ConfigurationInfo.EngineStatus.Active;

        return Ret;

    }


}
