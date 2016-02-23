/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.interfaces;

import kkdev.kksystem.base.classes.plugins.PluginInfo;
import kkdev.kksystem.base.classes.plugins.PluginMessage;

/**
 *
 * @author blinov_is
 */
public interface IPluginKKConnector {
    public PluginInfo GetPluginInfo();
    
    public PluginMessage ExecutePin(PluginMessage Pin);
    public void SendPinMessage(PluginMessage Pin);
    
    public void PluginInit(IPluginBaseInterface BaseConnector, String GlobalConfUID);
    public void PluginStart();
    public void PluginStop();
}
