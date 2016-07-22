/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.base;

import kkdev.kksystem.base.classes.plugins.PluginMessage;

/**
 *
 * @author blinov_is
 */
public class PluginMessageData extends PluginMessage {

    public PluginMessageData(PinData newPinData) {
        super(newPinData);
    }

    @Override
    public void setPinData(PinData PinData) {
        super.setPinData(PinData); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PinData getPinData() {
        return (PinData)super.getPinData(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PluginMessage cloneMessage() {
        return super.cloneMessage(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
