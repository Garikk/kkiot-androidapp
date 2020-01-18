package kkdev.kksystem.kkcarandroid.constants;

import java.util.ArrayList;
import java.util.List;

    //PRF_ODB_DATAVIEW,
    //PRF_MEDIACENTER,
    //PRF_BLUETOOTH_RPI,
    //PRF_BLUETOOTH_ANDROID,
    //PRF_ANDROID_EXT_CONNECTOR,
    //PRF_ANDROID_HOST,
    //PRF_UNKNOWN;
public class SysConstants {
    public static List<String> SystemProfiles()
    {
        List<String> Ret;
        Ret = new ArrayList();
        Ret.add("PRF_ANDROID_HOST");
        Ret.add("PRF_BLUETOOTH_ANDROID");
        Ret.add("PRF_ODB_DATAVIEW");
        Ret.add("PRF_MEDIACENTER");
        return Ret;
    }
}
