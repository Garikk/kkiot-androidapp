/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.interfaces;

import kkdev.kksystem.base.classes.base.PluginMessageData;
import kkdev.kksystem.base.classes.plugins.PluginInfo;
import kkdev.kksystem.base.classes.plugins.PluginMessage;

/**
 *
 * @author blinov_is
 */
public interface IPluginKKConnector {
    public PluginInfo getPluginInfo();
    
    public void executePin(PluginMessage Pin);
    public void sendPinMessage(PluginMessage Pin);
    
    public void pluginInit(IPluginBaseInterface BaseConnector, String GlobalConfUID);
    public void pluginStart();
    public void pluginStop();
}
