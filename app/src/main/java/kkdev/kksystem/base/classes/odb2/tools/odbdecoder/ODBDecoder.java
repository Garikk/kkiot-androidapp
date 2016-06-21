/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.odb2.tools.odbdecoder;

/**
 *
 * @author blinov_is
 */
public class ODBDecoder {
    public ODBSimpleData simpleData;
    
    public ODBDecoder()
    {
        simpleData=new ODBSimpleData();
    }
    public String getTroubleCodePrefix(Integer PfxDigit)
    {
        String Ret;
        Ret= PfxDigit.toString();
        
        if (PfxDigit>=0 & PfxDigit<=3) {
            Ret= "P" + PfxDigit.toString();
        }
        else if (PfxDigit>=4 & PfxDigit<=7) {
            Ret= "C" + PfxDigit.toString();
        }
        else if (PfxDigit>=8 & PfxDigit<=0xB) {
            Ret= "B" + PfxDigit.toString();
        }
        else if (PfxDigit>=0xC & PfxDigit<=0xF) {
            Ret= "U" + PfxDigit.toString();
        }
        return Ret;
    }
}
