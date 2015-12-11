package kkdev.kksystem.kkcarandroid.manager.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        public String value;
        public String localdesc;
    }


    public ArrayList<HashMap<String, String>>  GetDTCErrArray()
    {
        ArrayList<HashMap<String, String>> myArrList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> Item;
        for (KKDTCCode KK:CurrentDTC)
        {
            Item= new HashMap<String, String>();
            Item.put("DTC_ID",KK.value);
            Item.put("Description",KK.localdesc);
            myArrList.add(Item);
        }
        return myArrList;

    }

    public void InitValues()
    {

        if (CurrentDTC!=null && CurrentDTC.length==0)
        {
            MILString="OK";
        }
        else
        {
            MILString="CHECK ENGINE";

        }
    }

}
