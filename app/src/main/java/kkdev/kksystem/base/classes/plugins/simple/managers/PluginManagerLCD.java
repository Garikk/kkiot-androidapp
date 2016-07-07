/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.plugins.simple.managers;

import java.util.Set;
import kkdev.kksystem.base.classes.display.DisplayConstants;
import kkdev.kksystem.base.classes.display.PinDataLed;
import static kkdev.kksystem.base.constants.PluginConsts.KK_PLUGIN_BASE_LED_COMMAND;
import static kkdev.kksystem.base.constants.PluginConsts.KK_PLUGIN_BASE_LED_DATA;

/**
 *
 * @author blinov_is
 */
public class PluginManagerLCD extends PluginManagerBase {
    
    
      public void DISPLAY_SendPluginMessageCommand(String UIContextID,Set<String> FeatureID,DisplayConstants.KK_DISPLAY_COMMAND Command,String PageID, String[] DataStr, int[] DataInt, boolean[] DataBool) {
        //
        PinDataLed PData = new PinDataLed();
        PData.command = Command;
        PData.dataBOOL = DataBool;
        PData.dataINT = DataInt;
        PData.dataSTRING = DataStr;
        PData.pageID=PageID;
        //
        //
        this.BASE_SendPluginMessage(FeatureID,UIContextID,KK_PLUGIN_BASE_LED_COMMAND, PData);
    }

    public void DISPLAY_SendPluginMessageData(Set<String> FeatureID,String UIContextID, PinDataLed PData) {
        this.BASE_SendPluginMessage(FeatureID,UIContextID,KK_PLUGIN_BASE_LED_DATA, PData);
    }
    
     public void _DISPLAY_SendPluginMessageDataDirect(Set<String> FeatureID,String UIContextID,String TargetUUID, PinDataLed PData) {
        //PData.FeatureUID=FeatureID;
        //
        this._BASE_SendPluginMessageDirect(FeatureID,UIContextID,TargetUUID,KK_PLUGIN_BASE_LED_DATA, PData);
    }
       public void _DISPLAY_SendPluginMessageCommandDirect(String UIContextID,String TargetUUID,Set<String> FeatureID,DisplayConstants.KK_DISPLAY_COMMAND Command,String PageID, String[] DataStr, int[] DataInt, boolean[] DataBool) {
        
        PinDataLed PData = new PinDataLed();
        PData.command = Command;
        PData.dataBOOL = DataBool;
        PData.dataINT = DataInt;
        PData.dataSTRING = DataStr;
        PData.pageID=PageID;


        //
        this._BASE_SendPluginMessageDirect(FeatureID,UIContextID,TargetUUID,KK_PLUGIN_BASE_LED_COMMAND, PData);
    }
}
