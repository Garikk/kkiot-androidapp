package kkdev.kksystem.kkcarandroid.manager.types;

/**
 * Created by blinov_is on 28.01.2016.
 */
public class KKDTCCode
{
    public String paramid;
    public String timestamp;
    public String value;
    public String localdesc;

    public KKDTCCode() {}
    public KKDTCCode(String Param,String Val,String TStamp)
    {
        paramid=Param;
        value=Val;
        timestamp=TStamp;
    }
}