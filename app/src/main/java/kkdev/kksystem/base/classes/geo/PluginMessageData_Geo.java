/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.geo;

import kkdev.kksystem.base.classes.plugins.PluginMessage;

/**
 *
 * @author blinov_is
 */
public class PluginMessageData_Geo extends PluginMessage {

    public PluginMessageData_Geo(PinDataGeo newPinData) {
        super(newPinData);
    }


    public void setPinData(PinDataGeo PinData) {
        super.setPinData(PinData); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PinDataGeo getPinData() {
        return (PinDataGeo)super.getPinData(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
