package kkdev.kksystem.kkcarandroid.manager.types;

/**
 * Created by blinov_is on 18.11.2015.
 */
public  class ConfigurationInfo {

    public  enum CarConnection
    {
        Inactive,
        Idle,
        Active

    }
    public  enum CarStatus
    {
        Inactive,
        Ok,
        MILError

    }
    public  enum EngineStatus
    {
        Inactive,
        Ready,
        Active

    }


    public  String ConfName;
    public  String ConfDescription;
    public   String ConfDate;
    public   String ConfStamp;

    public  CarConnection CConnectionState;
    public  CarStatus CStatus;
    public  EngineStatus EState;
            
}
