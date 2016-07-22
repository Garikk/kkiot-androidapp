/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.odb2;

import kkdev.kksystem.base.classes.plugins.PluginMessage;

/**
 *
 * @author blinov_is
 */
public class PluginMessageData_Odb2 extends PluginMessage {

    public PluginMessageData_Odb2(PinDataOdb2 newPinData) {
        super(newPinData);
    }


    public void setPinData(PinDataOdb2 PinData) {
        super.setPinData(PinData); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PinDataOdb2 getPinData() {
        return (PinDataOdb2)super.getPinData(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
