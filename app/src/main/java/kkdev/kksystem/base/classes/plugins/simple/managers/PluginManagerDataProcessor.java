/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.plugins.simple.managers;

import java.util.LinkedHashSet;
import java.util.Set;
import kkdev.kksystem.base.classes.display.DisplayConstants;
import kkdev.kksystem.base.classes.display.PinDataLed;
import kkdev.kksystem.base.classes.display.pages.framesKeySet;
import static kkdev.kksystem.base.constants.PluginConsts.KK_PLUGIN_BASE_LED_COMMAND;
import static kkdev.kksystem.base.constants.PluginConsts.KK_PLUGIN_BASE_LED_DATA;

/**
 *
 * @author blinov_is
 */
public class PluginManagerDataProcessor extends PluginManagerBase {

    public void DISPLAY_ActivatePage(String FeatureID, String UIContextID, String PageName) {
        Set<String> Ftr = new LinkedHashSet<>();
        Ftr.add(FeatureID);
        DISPLAY_ActivatePage(Ftr, UIContextID, PageName);
    }

    public void DISPLAY_ActivatePage(Set<String> FeatureID, String UIContextID, String PageName) {
        DISPLAY_SendPluginMessageCommand(FeatureID, UIContextID, DisplayConstants.KK_DISPLAY_COMMAND.DISPLAY_KKSYS_PAGE_ACTIVATE, PageName, null, null, null);
    }

    public void _DISPLAY_ActivatePageDirect(String FeatureID, String UIContextID, String TargetID, String PageName) {
        Set<String> Ftr = new LinkedHashSet<>();
        Ftr.add(FeatureID);
        _DISPLAY_ActivatePageDirect(Ftr, UIContextID, TargetID, PageName);
    }

    public void _DISPLAY_ActivatePageDirect(Set<String> FeatureID, String UIContextID, String TargetID, String PageName) {
        _DISPLAY_SendPluginMessageCommandDirect(FeatureID, UIContextID, TargetID, DisplayConstants.KK_DISPLAY_COMMAND.DISPLAY_KKSYS_PAGE_ACTIVATE, PageName, null, null, null);
    }

    public void _DISPLAY_UpdateUIFramesDirect(String FeatureID, String UIContextID, String TargetID, String PageName, framesKeySet UIFrames) {
        Set<String> Ftr = new LinkedHashSet<>();
        Ftr.add(FeatureID);
        DISPLAY_UpdateUIFrames_Internal(Ftr, UIContextID, true, TargetID, PageName, UIFrames);
    }

    public void _DISPLAY_UpdateUIFramesDirect(Set<String> FeatureID, String UIContextID, String TargetID, String PageName, framesKeySet UIFrames) {
        
        DISPLAY_UpdateUIFrames_Internal(FeatureID, UIContextID, true, TargetID, PageName, UIFrames);
    }

    public void DISPLAY_UpdateUIFrames(String FeatureID, String UIContextID, String PageName, framesKeySet UIFrames) {
        Set<String> Ftr = new LinkedHashSet<>();
        Ftr.add(FeatureID);
        DISPLAY_UpdateUIFrames(Ftr, UIContextID, PageName, UIFrames);
    }

    public void DISPLAY_UpdateUIFrames(Set<String> FeatureID,String UIContextID, String PageName, framesKeySet UIFrames) {
        DISPLAY_UpdateUIFrames_Internal(FeatureID,UIContextID,false,  null, PageName, UIFrames);
    }

    private void DISPLAY_UpdateUIFrames_Internal(Set<String> FeatureID,String UIContextID,boolean Direct,  String TargetID, String PageName, framesKeySet UIFrames) {
        PinDataLed PLD = new PinDataLed();
        PLD.displayFrames = UIFrames;
        PLD.featureID = FeatureID;
        PLD.targetPage = PageName;
        PLD.ledDataType = DisplayConstants.KK_DISPLAY_DATA.DISPLAY_KKSYS_TEXT_UPDATE_FRAME;
       
        
        if (Direct) {
            _DISPLAY_SendPluginMessageDataDirect(FeatureID,UIContextID, TargetID, PLD);
        } else {
            DISPLAY_SendPluginMessageData(FeatureID,UIContextID, PLD);
        }
    }

    public void DISPLAY_SendPluginMessageCommand(Set<String> FeatureID,String UIContextID, DisplayConstants.KK_DISPLAY_COMMAND Command, String PageID, String[] DataStr, int[] DataInt, boolean[] DataBool) {
        DISPLAY_SendPluginMessageCommand_Internal(FeatureID,UIContextID,false, null,  Command, PageID, DataStr, DataInt, DataBool);
    }

    public void _DISPLAY_SendPluginMessageCommandDirect(Set<String> FeatureID,String UIContextID, String TargetID, DisplayConstants.KK_DISPLAY_COMMAND Command, String PageID, String[] DataStr, int[] DataInt, boolean[] DataBool) {
        DISPLAY_SendPluginMessageCommand_Internal(FeatureID,UIContextID,true, TargetID,  Command, PageID, DataStr, DataInt, DataBool);
    }

    private void DISPLAY_SendPluginMessageCommand_Internal(Set<String> FeatureID,String UIContextID,boolean Direct, String TargetID, DisplayConstants.KK_DISPLAY_COMMAND Command, String PageID, String[] DataStr, int[] DataInt, boolean[] DataBool) {
        PinDataLed PData = new PinDataLed();
        PData.command = Command;
        PData.dataBOOL = DataBool;
        PData.dataINT = DataInt;
        PData.dataSTRING = DataStr;
        PData.pageID = PageID;

        if (Direct) {
            this._BASE_SendPluginMessageDirect(FeatureID,UIContextID, TargetID, KK_PLUGIN_BASE_LED_COMMAND, PData);
        } else {
            this.BASE_SendPluginMessage(FeatureID,UIContextID, KK_PLUGIN_BASE_LED_COMMAND, PData);
        }
    }

    public void DISPLAY_SendPluginMessageData(Set<String> FeatureID,String UIContextID, PinDataLed PData) {

        //
        this.BASE_SendPluginMessage(FeatureID,UIContextID, KK_PLUGIN_BASE_LED_DATA, PData);
    }

    public void _DISPLAY_SendPluginMessageDataDirect(Set<String> FeatureID,String UIContextID, String PluginID, PinDataLed PData) {

        //
        this._BASE_SendPluginMessageDirect(FeatureID,UIContextID, PluginID, KK_PLUGIN_BASE_LED_DATA, PData);
    }



}
