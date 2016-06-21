/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.odb2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author blinov_is
 */
public class ODB2Data {
    Map<Integer,Double> PIDValues;
    Map<Integer,List<Byte>> CE_Errors;

    public ODB2Data()
    {
        PIDValues=new HashMap<>();
        CE_Errors=new HashMap<>();
    }
    public Map<Integer,Double> getHT()
    {
        return PIDValues;

    }
     public Map<Integer,List<Byte>> getCEError()
    {
        return CE_Errors;

    }
    
    public void addPID(Integer PID, Double Value)
    {
        PIDValues.put(PID, Value);
    }
    public void addError(int Prefix, Byte Value)
    {
        
        if (!CE_Errors.containsKey(Prefix))
        {
            List<Byte> Val=new ArrayList<>();
            Val.add(Value);
            CE_Errors.put(Prefix, Val);
        }
        
        CE_Errors.get(Prefix).add(Value);
    }
}
