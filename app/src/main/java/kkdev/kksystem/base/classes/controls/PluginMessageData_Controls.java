/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.controls;

import kkdev.kksystem.base.classes.plugins.PluginMessage;

/**
 *
 * @author blinov_is
 */
public class PluginMessageData_Controls extends PluginMessage {

    public PluginMessageData_Controls(PinDataControl newPinData) {
        super(newPinData);
    }


    public void setPinData(PinDataControl PinData) {
        super.setPinData(PinData); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PinDataControl getPinData() {
        return (PinDataControl)super.getPinData(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
