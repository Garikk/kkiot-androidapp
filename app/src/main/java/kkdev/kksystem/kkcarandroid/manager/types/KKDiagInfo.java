package kkdev.kksystem.kkcarandroid.manager.types;

/**
 * Created by blinov_is on 01.12.2015.
 */
public class KKDiagInfo {
    public String MILString;
    public KKDTCCode[] CurrentDTC;


    public class KKDTCCode
    {
        public String paramid;
        public String timestamp;
        public String localdescript;
    }


    public void InitValues()
    {

        if (CurrentDTC!=null && CurrentDTC.length>0)
        {
            MILString="OK";
        }
        else
        {
            MILString="CHECK ENGINE";

        }
    }

}
