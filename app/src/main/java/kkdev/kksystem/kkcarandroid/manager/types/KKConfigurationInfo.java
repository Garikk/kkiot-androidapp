package kkdev.kksystem.kkcarandroid.manager.types;

/**
 * Created by blinov_is on 18.11.2015.
 */
public  class KKConfigurationInfo {

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

    public String paramid;
    public String carinfo;
    public String confname;
    public String confversion_act;
    public String confversion_kkc;
    public String kkcversion;
    public String osversion;
    public String kkcconfstatus;
    public String carstatus;
    public String timestamp;
    public String enginestatus;


    public  String ConfName;
    public  String ConfDescription;
    public  String ConfStamp;
    public  String SyncState;
    public  String Platf;

    public  CarConnection CConnectionState;
    public  CarStatus CStatus;
    public  EngineStatus EState;


    public KKConfigurationInfo()
    {
        carinfo="unknown";
        confname="unknown";
        confversion_act="unknown";
        confversion_kkc="unknown";
        kkcversion="unknown";
        osversion="unknown";
        kkcconfstatus="unknown";
        carstatus="unknown";
        timestamp="unknown";
        enginestatus="unknown";

    }

    public void InitParams() {
        ConfName = confname;
        ConfDescription = carinfo;
        ConfStamp = timestamp;
        Platf=osversion;

        if (enginestatus == "0")
            EState = EngineStatus.Inactive;
        else if (enginestatus == "1")
            EState = EngineStatus.Active;
        else if (enginestatus == "2")
            EState = EngineStatus.Ready;

        if (carstatus.equals("0"))
            CStatus=CarStatus.Inactive;
        else if (carstatus.equals("1"))
            CStatus=CarStatus.Ok;
        else if (carstatus.equals("2"))
            CStatus=CarStatus.MILError;

        if (!confversion_kkc.equals(confversion_act))
            SyncState="!!NO SYNC!!";
        else
            SyncState="Ok";


    }
            
}
