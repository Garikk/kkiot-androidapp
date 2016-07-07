/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.plugins.simple.managers;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kkdev.kksystem.base.classes.base.PinData;
import kkdev.kksystem.base.classes.base.PluginMessageData;
import kkdev.kksystem.base.classes.notify.NotifyConsts;
import kkdev.kksystem.base.classes.notify.PinDataNotify;
import kkdev.kksystem.base.classes.notify.PluginMessageData_Notify;
import kkdev.kksystem.base.classes.plugins.PluginMessage;
import kkdev.kksystem.base.constants.PluginConsts;
import kkdev.kksystem.base.interfaces.IPluginBaseInterface;
import kkdev.kksystem.base.interfaces.IPluginKKConnector;

/**
 *
 * @author blinov_is
 */
public class PluginManagerBase {

    public Map<String, String> currentFeature; // UIContext => Feature
    private IPluginKKConnector connector;
    private IPluginBaseInterface baseConnector;

    public PluginManagerBase() {
        currentFeature = new HashMap<>();
    }

    public PluginManagerBase(IPluginKKConnector PluginConnector) {
        currentFeature = new HashMap<>();
        connector = PluginConnector;
    }

    public PluginManagerBase(IPluginBaseInterface BaseConnector) {
        currentFeature = new HashMap<>();
        baseConnector = BaseConnector;
    }

    public void setBaseConnector(IPluginBaseInterface BaseConnector) {
        baseConnector = BaseConnector;
    }

    public void setPluginConnector(IPluginKKConnector PluginConnector) {
        connector = PluginConnector;
    }

    public IPluginKKConnector getPluginConnector() {
        return connector;
    }

    public synchronized void BASE_SendPluginMessage(String FeatureID, String UIContextID, String PinName, PinData PinData) {
        LinkedHashSet<String> Ftr;
        Ftr = new LinkedHashSet<>();
        Ftr.add(FeatureID);

        BASE_SendPluginMessage(Ftr, UIContextID, PinName, PinData);
    }
    public synchronized void BASE_SendPluginMessage(Set<String> FeatureID, String UIContextID, String PinName, PinData PinData) {
        PluginMessage Msg = new PluginMessageData(PinData);
        Msg.pinName = PinName;
        Msg.FeatureID = FeatureID;
        Msg.UIContextID = UIContextID;

       connector.sendPinMessage(Msg);
    }

    public synchronized void _BASE_SendPluginMessageDirect(Set<String> FeatureID, String UIContextID, String PluginUUID, String PinName, PinData PinData) {
        PluginMessage Msg = new PluginMessageData(PinData);
        Msg.pinName = PinName;
        Msg.FeatureID = FeatureID;
        Msg.UIContextID = UIContextID;

        baseConnector._executePinCommandDirect(PluginUUID, Msg);

    }

    public synchronized void NOTIFY_SendNotifyMessage(String FeatureID, NotifyConsts.NOTIFY_TYPE NotifyType, NotifyConsts.NOTIFY_METHOD[] NotifyMethod, String NotifyText) {
        LinkedHashSet<String> Ftr = new LinkedHashSet();
        Ftr.add(FeatureID);
        NOTIFY_SendNotifyMessage(Ftr, NotifyType, NotifyMethod, NotifyText);
    }

    public synchronized void NOTIFY_SendNotifyMessage(Set<String> FeatureID, NotifyConsts.NOTIFY_TYPE NotifyType, NotifyConsts.NOTIFY_METHOD[] NotifyMethod, String NotifyText) {
        _NOTIFY_SendNotifyMessage(null, FeatureID, NotifyType, NotifyMethod, NotifyText);
    }

    public synchronized void _NOTIFY_SendNotifyMessage(String SenderPluginUUID, String FeatureID, NotifyConsts.NOTIFY_TYPE NotifyType, NotifyConsts.NOTIFY_METHOD[] NotifyMethod, String NotifyText) {
        LinkedHashSet<String> Ftr = new LinkedHashSet();
        Ftr.add(FeatureID);
        _NOTIFY_SendNotifyMessage(SenderPluginUUID, Ftr, NotifyType, NotifyMethod, NotifyText);
    }

    public synchronized void _NOTIFY_SendNotifyMessage(String SenderPluginUUID, Set<String> FeatureID, NotifyConsts.NOTIFY_TYPE NotifyType, NotifyConsts.NOTIFY_METHOD[] NotifyMethod, String NotifyText) {
        PinDataNotify PD;
        PD = new PinDataNotify();
        PD.notifyText = NotifyText;
        PD.notifyMethod = NotifyMethod;
        PD.notifyType = NotifyType;

        PluginMessage Msg = new PluginMessageData_Notify(PD);
        Msg.pinName = PluginConsts.KK_PLUGIN_BASE_NOTIFY_DATA;
        Msg.FeatureID = FeatureID;
        if (SenderPluginUUID != null) {
            Msg.SenderUID = SenderPluginUUID;
        }

        if (connector == null) {
            baseConnector.executePinCommand(Msg);
        } else {
            connector.sendPinMessage(Msg);
        }
    }
}
