/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.plugins;

import java.util.LinkedHashSet;
import java.util.Set;
import kkdev.kksystem.base.classes.base.PinData;

/**
 *
 * @author blinov_is
 */
public abstract class PluginMessage {
    public String SenderUID;    //Sender plugin ID
    public Set<String> FeatureID;    //Feature ID
    public String UIContextID;
    public String pinName; 
    private PinData pinData;
    
    public PluginMessage(PinData newPinData)
    {
        pinData=newPinData;
        FeatureID=new LinkedHashSet<>();
    }
    
    public PluginMessage cloneMessage()
    {
        return this;
    }
    
    public Object getPinData()
    {
        return pinData;
    }
    
    public void setPinData(PinData PinData)
    {
        pinData=PinData;
    }
}
