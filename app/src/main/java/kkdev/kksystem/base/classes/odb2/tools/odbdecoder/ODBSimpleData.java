/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.odb2.tools.odbdecoder;

import java.util.HashMap;
import java.util.Map;
import kkdev.kksystem.base.classes.odb2.ODB2Data;
import kkdev.kksystem.base.classes.odb2.ODB2_SAE_J1979_PID_MODE_1;
import static kkdev.kksystem.base.classes.odb2.ODB2_SAE_J1979_PID_MODE_1.*;

/**
 *
 * @author blinov_is
 */
public class ODBSimpleData {
    Map<Integer,Double> ODBData;

    public ODBSimpleData()
    {
        ODBData=new HashMap<>();
    }
    public static int[] GetSimpleDiagRequest()
    {
        int[] Ret=new int[2];
        Ret[0]=ODB2_SAE_J1979_PID_MODE_1.PID_05_COLIANT_TEMP;
        Ret[1]=ODB2_SAE_J1979_PID_MODE_1.PID_0D_VEHICLE_SPEED;
        return Ret;
    }
      public static int[] GetExtendedDiagRequest()
    {
        int[] Ret=new int[4];
        Ret[0]=ODB2_SAE_J1979_PID_MODE_1.PID_05_COLIANT_TEMP;
        Ret[1]=ODB2_SAE_J1979_PID_MODE_1.PID_42_CONTROL_MODULE_VOLTAGE;
        Ret[2]=ODB2_SAE_J1979_PID_MODE_1.PID_0D_VEHICLE_SPEED;
        Ret[3]=ODB2_SAE_J1979_PID_MODE_1.PID_0C_ENGINE_RPM;
        return Ret;
    }
     
    public void SetODBData(ODB2Data Data)
    {
        for (int Key:Data.GetHT().keySet())
        {
            ODBData.put(Key, Data.GetHT().get(Key));
        }
    }
    
    
    public Double DIAG_GetCarSpeed()
    {
        Double Ret;
        
        if (ODBData == null) {
            return 0.0;
        }

        Ret = ODBData.get(PID_0D_VEHICLE_SPEED);
        if (Ret == null) {
            Ret = 0.0;
        }

        return Ret;
    }

    public Double DIAG_GetCarEngineRPM() {
        Double Ret;

        if (ODBData == null) {
            return 0.0;
        }

        Ret = ODBData.get(PID_0C_ENGINE_RPM);

        if (Ret == null) {
            Ret = 0.0;
        }
        return Ret;
    }

    public Double DIAG_GetCarEngineCooliantTemp() {
        Double Ret;
        if (ODBData == null) {
            return 0.0;
        }

        Ret = ODBData.get(PID_05_COLIANT_TEMP);
        if (Ret == null)
            Ret=0.0;
        
        return Ret;
    }
     public Double DIAG_GetCarBattVoltage()
    {
        Double Ret;
        
        if (ODBData==null)
            return 0.0;
        
        Ret=ODBData.get(PID_42_CONTROL_MODULE_VOLTAGE);
        if (Ret==null)
            Ret=0.0;
        
        return Ret;
    }
}
