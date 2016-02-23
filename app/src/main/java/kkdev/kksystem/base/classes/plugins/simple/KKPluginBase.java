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
    public String GlobalConfID;
    
    public IPluginInfoRequest PluginInfo;
    IPluginBaseInterface Connector;
    
    public KKPluginBase(IPluginInfoRequest PluginInfoClass)
    {
       PluginInfo=PluginInfoClass;
    }
    
    @Override
    public PluginInfo GetPluginInfo() {
        return PluginInfo.GetPluginInfo();
    }

    @Override
    public PluginMessage ExecutePin(PluginMessage Pin) {
       //must be override!
        return null;
    }

    @Override
    public void SendPinMessage(PluginMessage Pin) {
        Pin.SenderUID=PluginInfo.GetPluginInfo().PluginUUID;
        Connector.ExecutePinCommand(Pin);
    }

    @Override
    public void PluginInit(IPluginBaseInterface BaseConnector,String GlobalConfUID) {
        Connector=BaseConnector;
        GlobalConfID=GlobalConfUID;
    }

    @Override
    public void PluginStart() {
       //Must be override
    }

    @Override
    public void PluginStop() {
       //Must be override
    }
    
}
