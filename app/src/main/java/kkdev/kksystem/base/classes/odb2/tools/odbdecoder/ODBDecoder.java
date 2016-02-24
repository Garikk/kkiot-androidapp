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
    public ODBSimpleData SimpleData;
    
    public ODBDecoder()
    {
        SimpleData=new ODBSimpleData();
    }
    public String GetTroubleCodePrefix(Integer PfxDigit)
    {
        if (PfxDigit>=0 & PfxDigit<=3)
            return "P"+PfxDigit.toString();
        if (PfxDigit>=4 & PfxDigit<=7)
            return "C"+PfxDigit.toString();
        if (PfxDigit>=8 & PfxDigit<=0xB)
            return "B"+PfxDigit.toString();
        if (PfxDigit>=0xC & PfxDigit<=0xF)
            return "U"+PfxDigit.toString();
        
        return PfxDigit.toString();
    }
}
