/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.plugins;

import kkdev.kksystem.base.classes.display.tools.menumaker.MKMenuItem;

/**
 *
 * @author blinov_is
 */
public class ControllerConfiguration {
    public String ConfigurationUID;
    public String ConfigurationStamp;
    public FeatureConfiguration[] Features;
    //
    public String SystemDisplay_UID;
    public String SystemHID_UID;
    //
    public String DefaultFeature;
    public MKMenuItem[] SystemMenuItems;
    
    //
}
