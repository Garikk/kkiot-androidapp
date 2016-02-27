package kkdev.kksystem.kkcarandroid.manager;

import android.telecom.Call;

import kkdev.kksystem.base.classes.odb2.ODB2Data;
import kkdev.kksystem.base.classes.odb2.ODBConstants;
import kkdev.kksystem.base.classes.odb2.PinOdb2Data;
import kkdev.kksystem.kkcarandroid.manager.callback.IDiagUI;
import kkdev.kksystem.kkcarandroid.manager.exaconnector.BTConnector;
import kkdev.kksystem.kkcarandroid.manager.types.KKDiagInfo;
import kkdev.kksystem.kkcarandroid.manager.wmhttp.WebManager;

/**
 * Created by blinov_is on 18.11.2015.
 */
public class DiagOperations {

    static KKDiagInfo CachedInfoCE;
    static KKDiagInfo CachedInfoInf;
    static IDiagUI CurrentDiagUI;

    public static void RegisterCallback(IDiagUI Callback) {
        ConnectionManager.CheckConnect();
        CurrentDiagUI = Callback;

    }

    public static void UnRegisterCallback() {
        CurrentDiagUI = null;

    }

    public static void ReceiveExtData(PinOdb2Data Dat) {
        if (Dat.DataType == ODBConstants.KK_ODB_DATATYPE.ODB_DIAG_CE_ERRORS) {
            UpdateDiagInfoCE(KKDiagInfo.FillFromPinODB2(Dat));
        } else if (Dat.DataType == ODBConstants.KK_ODB_DATATYPE.ODB_DIAG_DATA) {
            UpdateDiagInfoInf(KKDiagInfo.FillFromPinODB2(Dat));

        }

    }

    private static void UpdateDiagInfoCE(KKDiagInfo Info) {
        if (Info.Timestamp > CachedInfoCE.Timestamp)
            CachedInfoCE = Info;

        CurrentDiagUI.UpdateErrorsList(Info);
    }

    private static void UpdateDiagInfoInf(KKDiagInfo Info) {

        if (Info.Timestamp > CachedInfoInf.Timestamp)
            CachedInfoInf = Info;

        CurrentDiagUI.UpdateErrorsList(Info);
    }

    public static KKDiagInfo GetDiagErrInfo() {
        //ConnectionManager.DIAG_RequestDiagInfo();


        KKDiagInfo Ret;
        Ret = CachedInfoCE;
        Ret.InitValues();
        return Ret;
    }


}
