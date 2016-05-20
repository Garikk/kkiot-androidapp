/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.plugins.simple.managers;

import kkdev.kksystem.base.classes.display.DisplayConstants;
import kkdev.kksystem.base.classes.display.PinLedCommand;
import kkdev.kksystem.base.classes.display.PinLedData;
import kkdev.kksystem.base.classes.display.UIFramesKeySet;
import static kkdev.kksystem.base.constants.PluginConsts.KK_PLUGIN_BASE_LED_COMMAND;
import static kkdev.kksystem.base.constants.PluginConsts.KK_PLUGIN_BASE_LED_DATA;

/**
 *
 * @author blinov_is
 */
public class PluginManagerDataProcessor extends PluginManagerBase {

    public void DISPLAY_ActivatePage(String FeatureID,String UIContextID, String PageName) {
        DISPLAY_SendPluginMessageCommand(FeatureID,UIContextID, DisplayConstants.KK_DISPLAY_COMMAND.DISPLAY_KKSYS_PAGE_ACTIVATE, PageName, null, null, null);
    }

    public void _DISPLAY_ActivatePageDirect(String FeatureID,String UIContextID, String TargetID, String PageName) {
        _DISPLAY_SendPluginMessageCommandDirect(FeatureID,UIContextID, TargetID, DisplayConstants.KK_DISPLAY_COMMAND.DISPLAY_KKSYS_PAGE_ACTIVATE, PageName, null, null, null);
    }

    public void _DISPLAY_UpdateUIFramesDirect(String FeatureID,String UIContextID, String TargetID, String PageName, UIFramesKeySet UIFrames) {
        DISPLAY_UpdateUIFrames_Internal(FeatureID,UIContextID,true, TargetID, PageName, UIFrames);
    }

    public void DISPLAY_UpdateUIFrames(String FeatureID,String UIContextID, String PageName, UIFramesKeySet UIFrames) {
        DISPLAY_UpdateUIFrames_Internal(FeatureID,UIContextID,false,  null, PageName, UIFrames);
    }

    private void DISPLAY_UpdateUIFrames_Internal(String FeatureID,String UIContextID,boolean Direct,  String TargetID, String PageName, UIFramesKeySet UIFrames) {
        PinLedData PLD = new PinLedData();
        PLD.UIFrames = UIFrames;
        PLD.FeatureID = FeatureID;
        PLD.TargetPage = PageName;
        PLD.LedDataType = DisplayConstants.KK_DISPLAY_DATA.DISPLAY_KKSYS_TEXT_UPDATE_FRAME;
        PLD.UIContextID=UIContextID;

        
        
        if (Direct) {
            _DISPLAY_SendPluginMessageDataDirect(FeatureID, TargetID, PLD);
        } else {
            DISPLAY_SendPluginMessageData(FeatureID, PLD);
        }
    }

    public void DISPLAY_SendPluginMessageCommand(String FeatureID,String UIContextID, DisplayConstants.KK_DISPLAY_COMMAND Command, String PageID, String[] DataStr, int[] DataInt, boolean[] DataBool) {
        DISPLAY_SendPluginMessageCommand_Internal(FeatureID,UIContextID,false, null,  Command, PageID, DataStr, DataInt, DataBool);
    }

    public void _DISPLAY_SendPluginMessageCommandDirect(String FeatureID,String UIContextID, String TargetID, DisplayConstants.KK_DISPLAY_COMMAND Command, String PageID, String[] DataStr, int[] DataInt, boolean[] DataBool) {
        DISPLAY_SendPluginMessageCommand_Internal(FeatureID,UIContextID,true, TargetID,  Command, PageID, DataStr, DataInt, DataBool);
    }

    private void DISPLAY_SendPluginMessageCommand_Internal(String FeatureID,String UIContextID,boolean Direct, String TargetID, DisplayConstants.KK_DISPLAY_COMMAND Command, String PageID, String[] DataStr, int[] DataInt, boolean[] DataBool) {
        PinLedCommand PData = new PinLedCommand();
        PData.Command = Command;
        PData.BOOL = DataBool;
        PData.INT = DataInt;
        PData.STRING = DataStr;
        PData.PageID = PageID;
        PData.ChangeFeatureID=FeatureID;
        PData.ChangeUIContextID=UIContextID;

        if (Direct) {
            this._BASE_SendPluginMessageDirect(FeatureID, TargetID, KK_PLUGIN_BASE_LED_COMMAND, PData);
        } else {
            this.BASE_SendPluginMessage(FeatureID, KK_PLUGIN_BASE_LED_COMMAND, PData);
        }
    }

    public void DISPLAY_SendPluginMessageData(String FeatureID, PinLedData PData) {

        //
        this.BASE_SendPluginMessage(FeatureID, KK_PLUGIN_BASE_LED_DATA, PData);
    }

    public void _DISPLAY_SendPluginMessageDataDirect(String FeatureID, String PluginID, PinLedData PData) {

        //
        this._BASE_SendPluginMessageDirect(FeatureID, PluginID, KK_PLUGIN_BASE_LED_DATA, PData);
    }



}
