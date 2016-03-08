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
import kkdev.kksystem.base.classes.odb2.ODBConstants;
import kkdev.kksystem.base.classes.odb2.PinOdb2Command;
import static kkdev.kksystem.base.constants.PluginConsts.KK_PLUGIN_BASE_LED_COMMAND;
import static kkdev.kksystem.base.constants.PluginConsts.KK_PLUGIN_BASE_LED_DATA;
import static kkdev.kksystem.base.constants.PluginConsts.KK_PLUGIN_BASE_ODB2_COMMAND;

/**
 *
 * @author blinov_is
 */
public class PluginManagerDataProcessor extends PluginManagerBase {

    public void ODB_SendPluginMessageCommand(String FeatureID, ODBConstants.KK_ODB_COMMANDTYPE Command, ODBConstants.KK_ODB_DATACOMMANDINFO Request, int[] DataInt, int[] ReadInterval) {

        PinOdb2Command PData =ODB_SendPluginMessageCommand_PMData(FeatureID,  Command,  Request, DataInt, ReadInterval);

        this.BASE_SendPluginMessage(FeatureID, KK_PLUGIN_BASE_ODB2_COMMAND, PData);
    }

    public void DISPLAY_ActivatePage(String FeatureID, String PageName) {
        DISPLAY_SendPluginMessageCommand(FeatureID, DisplayConstants.KK_DISPLAY_COMMAND.DISPLAY_KKSYS_PAGE_ACTIVATE, PageName, null, null, null);
    }

    public void _DISPLAY_ActivatePageDirect(String FeatureID, String TargetID, String PageName) {
        _DISPLAY_SendPluginMessageCommandDirect(FeatureID, TargetID, DisplayConstants.KK_DISPLAY_COMMAND.DISPLAY_KKSYS_PAGE_ACTIVATE, PageName, null, null, null);
    }

    public void _DISPLAY_UpdateUIFramesDirect(String FeatureID, String TargetID, String PageName, UIFramesKeySet UIFrames) {
        DISPLAY_UpdateUIFrames_Internal(true, FeatureID, TargetID, PageName, UIFrames);
    }

    public void DISPLAY_UpdateUIFrames(String FeatureID, String PageName, UIFramesKeySet UIFrames) {
        DISPLAY_UpdateUIFrames_Internal(false, FeatureID, null, PageName, UIFrames);
    }

    private void DISPLAY_UpdateUIFrames_Internal(boolean Direct, String FeatureID, String TargetID, String PageName, UIFramesKeySet UIFrames) {
        PinLedData PLD = new PinLedData();
        PLD.UIFrames = UIFrames;
        PLD.FeatureID = FeatureID;
        PLD.TargetPage = PageName;
        PLD.LedDataType = DisplayConstants.KK_DISPLAY_DATA.DISPLAY_KKSYS_TEXT_UPDATE_FRAME;

        if (Direct) {
            _DISPLAY_SendPluginMessageDataDirect(FeatureID, TargetID, PLD);
        } else {
            DISPLAY_SendPluginMessageData(FeatureID, PLD);
        }
    }

    public void DISPLAY_SendPluginMessageCommand(String FeatureID, DisplayConstants.KK_DISPLAY_COMMAND Command, String PageID, String[] DataStr, int[] DataInt, boolean[] DataBool) {
        DISPLAY_SendPluginMessageCommand_Internal(false, null, FeatureID, Command, PageID, DataStr, DataInt, DataBool);
    }

    public void _DISPLAY_SendPluginMessageCommandDirect(String FeatureID, String TargetID, DisplayConstants.KK_DISPLAY_COMMAND Command, String PageID, String[] DataStr, int[] DataInt, boolean[] DataBool) {
        DISPLAY_SendPluginMessageCommand_Internal(true, TargetID, FeatureID, Command, PageID, DataStr, DataInt, DataBool);
    }

    private void DISPLAY_SendPluginMessageCommand_Internal(boolean Direct, String TargetID, String FeatureID, DisplayConstants.KK_DISPLAY_COMMAND Command, String PageID, String[] DataStr, int[] DataInt, boolean[] DataBool) {
        PinLedCommand PData = new PinLedCommand();
        PData.Command = Command;
        PData.BOOL = DataBool;
        PData.INT = DataInt;
        PData.STRING = DataStr;
        PData.PageID = PageID;

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

    public static PinOdb2Command ODB_SendPluginMessageCommand_PMData(String FeatureID, ODBConstants.KK_ODB_COMMANDTYPE Command, ODBConstants.KK_ODB_DATACOMMANDINFO Request, int[] DataInt, int[] ReadInterval) {
        PinOdb2Command PData = new PinOdb2Command();
        PData.Command = Command;
        PData.CommandData = Request;
        //
        PData.RequestPIDs = DataInt;
        PData.DynamicRequestInterval = ReadInterval;
        //
        return PData;
    }

}
