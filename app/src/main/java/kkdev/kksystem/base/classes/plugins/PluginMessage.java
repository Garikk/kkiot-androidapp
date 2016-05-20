/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.plugins;

import kkdev.kksystem.base.classes.base.PinBaseCommand;

/**
 *
 * @author blinov_is
 */
public class PluginMessage {
    public String SenderUID;    //Sender plugin ID
    public String FeatureID;    //Feature ID
    public String PinName; 
    public Object PinData;
    
    public PluginMessage newInstance()
    {
        PluginMessage Ret;
        Ret=new PluginMessage();
        Ret.SenderUID=this.SenderUID;
        Ret.FeatureID=this.FeatureID;
        Ret.PinName=this.PinName;
        Ret.PinData=this.PinData;
        
        return Ret;
    }
}
