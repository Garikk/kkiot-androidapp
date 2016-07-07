/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.plugins.simple;

import kkdev.kksystem.base.classes.plugins.PluginInfo;
import kkdev.kksystem.base.classes.plugins.PluginMessage;
import kkdev.kksystem.base.interfaces.IPluginBaseInterface;
import kkdev.kksystem.base.interfaces.IPluginKKConnector;

/**
 *
 * @author blinov_is
 */
public class KKPluginBase implements IPluginKKConnector{
    public String globalConfID;
    
    public IPluginInfoRequest pluginInfo;
    IPluginBaseInterface connector;
    
    public KKPluginBase(IPluginInfoRequest PluginInfoClass)
    {
       pluginInfo=PluginInfoClass;
    }
    
    @Override
    public PluginInfo getPluginInfo() {
        return pluginInfo.getPluginInfo();
    }

    @Override
    public void executePin(PluginMessage Pin) {
       //must be override!
        return;
    }

    @Override
    public void sendPinMessage(PluginMessage Pin) {
        Pin.SenderUID=pluginInfo.getPluginInfo().PluginUUID;
        connector.executePinCommand(Pin);
    }

    @Override
    public void pluginInit(IPluginBaseInterface BaseConnector,String GlobalConfUID) {
        connector=BaseConnector;
        globalConfID=GlobalConfUID;
    }

    @Override
    public void pluginStart() {
       //Must be override
    }

    @Override
    public void pluginStop() {
       //Must be override
    }
    
}
