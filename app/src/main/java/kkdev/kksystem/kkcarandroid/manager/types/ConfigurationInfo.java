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

    public String carinfo;
    public String confname;
    public String confversion;
    public String confversion_kkcl;


    public  String ConfName;
    public  String ConfDescription;
    public   String ConfDate;
    public   String ConfStamp;

    public  CarConnection CConnectionState;
    public  CarStatus CStatus;
    public  EngineStatus EState;

   /*
    "  kkcar_confinfo.id as paramid, "
            . "  kkcar_confinfo.carinfo as carinfo, "
            . "  configurations.name as confname, "
            . "  configurations.stamp as confversion_act, "
            . "  kkcar_confinfo.configversion as confversion_kkc, "
            . "  kkcar_confinfo.kkcontrollerversion as kkcversion,	"
            . "  kkcar_confinfo.osversion as osversion,	"
            . "  kkcar_confinfo.confstatus as kkcconfstatus,	"
            . "  kkcar_confinfo.carstatus as carstatus,	"
            . "  kkcar_confinfo.timestamp as timestamp	"
            . "  kkcar_confinfo.enginestatus as enginestatus	"
            */
            
}
