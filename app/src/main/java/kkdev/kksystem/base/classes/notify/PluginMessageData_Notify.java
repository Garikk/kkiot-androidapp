/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.notify;

import kkdev.kksystem.base.classes.base.PinData;
import kkdev.kksystem.base.classes.plugins.PluginMessage;

/**
 *
 * @author blinov_is
 */
public class PluginMessageData_Notify extends PluginMessage {

    public PluginMessageData_Notify(PinDataNotify newPinData) {
        super(newPinData);
    }


    public void setPinData(PinDataNotify PinData) {
        super.setPinData(PinData); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public PinDataNotify getPinData() {
        return (PinDataNotify)super.getPinData(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
