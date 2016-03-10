package kkdev.kksystem.kkcarandroid.leddebug;

import android.graphics.pdf.PdfDocument;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kkdev.kksystem.base.classes.base.PinBaseCommand;
import kkdev.kksystem.base.classes.display.DisplayConstants;
import kkdev.kksystem.base.classes.display.DisplayInfo;
import kkdev.kksystem.base.classes.display.PinLedCommand;
import kkdev.kksystem.base.classes.display.PinLedData;
import kkdev.kksystem.base.classes.display.UIFramesKeySet;
import kkdev.kksystem.base.constants.PluginConsts;
import kkdev.kksystem.kkcarandroid.manager.callback.ILedDebugUI;

/**
 * Created by sayma_000 on 06.03.2016.
 */
public class LCDDisplayManager {

    static String CurrentFeature;
    static String DefaultDisplay;
    static Map<String, DisplayView> Displays;
    static Map<String, String> CurrentPage;              //Feature => PageName
    static Map<String, DisplayPage> DPages;
    static Map<String, Map<String, List<DisplayView>>> DViews;

    public void Init(ILedDebugUI Callback) {
        //Connector = Conn;

//            PluginSettings.InitConfig(Conn.GlobalConfID,Conn.PluginInfo.GetPluginInfo().PluginUUID);
        Settings.InitConfig();
        //
                  //CurrentFeature = ;'//PluginSettings.MainConfiguration.DefaultFeature;
        //
        ConfigAndHWInit(Callback);
    }

    private void ConfigAndHWInit(ILedDebugUI Callback) {
        DViews = new HashMap<>();
        DPages = new HashMap<>();
        Displays = new HashMap<>();
        CurrentPage = new HashMap<>();

        //Add HWDisplays and init
        for (DisplayHW DH : Settings.MainConfiguration.HWDisplays) {
            if (DH.HWBoard == DisplayHW.HWHostTypes.Android) {
                if (DH.HWDisplay == DisplayHW.HWDisplayTypes.LCDDebugDisplay) {
                    Displays.put(DH.HWDisplayName, new DisplayView(new AndroidLEDDebugDisplay(Callback)));
                } else {
                    System.out.println("[LCDDisplay][CONFLOADER] Unknown display type in config!! + " + DH.HWBoard);
                }
            } else {
                System.out.println("[LCDDisplay][CONFLOADER] Unknown HW board in config!! + " + DH.HWBoard);
            }
        }

        //Add SPages
        for (DisplayPage DP : Settings.MainConfiguration.DisplayPages) {
            DP.InitUIFrames();
            DPages.put(DP.PageName, DP);
            List<DisplayView> LS = new ArrayList<>();
            for (String DV : DP.HWDisplays) {
                LS.add(Displays.get(DV));
            }

            //
            for (String F : DP.Features) {
                if (!DViews.containsKey(F)) {
                    DViews.put(F, new HashMap<String, List<DisplayView>>());
                }
                DViews.get(F).put(DP.PageName, LS);
                //
                if (DP.IsDefaultPage)
                    if (!CurrentPage.containsKey(F))
                        CurrentPage.put(F, DP.PageName);
            }
            //
        }
    }


    public void ReceivePin(String FeatureID, String PinName, Object PinData) {

        switch (PinName) {
            case PluginConsts.KK_PLUGIN_BASE_LED_COMMAND:
                PinLedCommand CMD;
                CMD = (PinLedCommand) PinData;
                ProcessCommand(FeatureID, CMD);
                break;
            case PluginConsts.KK_PLUGIN_BASE_LED_DATA:
                PinLedData DAT;
                DAT = (PinLedData) PinData;
                ProcessData(DAT);
                break;
            case PluginConsts.KK_PLUGIN_BASE_PIN_COMMAND:
                PinBaseCommand BaseCMD;
                BaseCMD = (PinBaseCommand) PinData;
                ProcessBaseCommand(BaseCMD);
        }
    }

    ///////////////////
    ///////////////////
    private void ProcessCommand(String FeatureID, PinLedCommand Command) {

        switch (Command.Command) {
            case DISPLAY_KKSYS_PAGE_ACTIVATE:
                System.out.println("[LCDDisplay][MANAGER] Acti " + FeatureID + " " + Command.PageID);
                SetPageToActive(FeatureID, Command.PageID);
                break;
            case DISPLAY_KKSYS_GETINFO:
                AnswerDisplayInfo();
                break;

        }
    }

    private void ProcessData(PinLedData Data) {

        switch (Data.LedDataType) {
            case DISPLAY_KKSYS_TEXT_SIMPLE_OUT:
                SendTextToPage(Data.FeatureID, Data.TargetPage, Data.Direct_DisplayText);
                break;
            case DISPLAY_KKSYS_TEXT_UPDATE_DIRECT:

                break;
            case DISPLAY_KKSYS_TEXT_UPDATE_FRAME:
                UpdatePageUIFrames(Data.FeatureID, Data.TargetPage, false, Data.UIFrames);
                break;
        }
    }

    private void ProcessBaseCommand(PinBaseCommand Command) {
        switch (Command.BaseCommand) {
            case CHANGE_FEATURE:
                ChangeFeature(Command.ChangeFeatureID);
                break;
            case PLUGIN:
                break;
        }
    }

    //////////////////
    ///////////////////

    private void AnswerDisplayInfo() {
        PinLedData Ret;
        DisplayInfo[] DI = new DisplayInfo[Displays.values().size()];
        //
        int cnt = 0;
        //
        for (DisplayView DV : Displays.values()) {
            DI[cnt] = DV.Connector.GetDisplayInfo();
            cnt++;
        }
        //
        Ret = new PinLedData();
        Ret.DisplayState = DI;
        Ret.LedDataType = DisplayConstants.KK_DISPLAY_DATA.DISPLAY_KKSYS_DISPLAY_STATE;
        //
        // DISPLAY_SendPluginMessageData(CurrentFeature, Ret);
        //
    }

    //////////////////
    ///////////////////

    private void SendTextToPage(String FeatureID, String PageID, String[] Text) {
        for (String TL : Text) {
            SendTextToPage(FeatureID, PageID, TL);
        }
    }

    private void SendTextToPage(String FeatureID, String PageID, String Text) {
        //
        for (DisplayView DV : DViews.get(FeatureID).get(PageID)) {
            DV.SendText(Text);
        }
    }

    private void UpdateTextOnPage(String FeatureID, String PageID, String[] Text, int[] PositionsCol, int[] PositionRow) {

        for (DisplayView DV : DViews.get(FeatureID).get(PageID)) {
            for (int i = 0; i <= Text.length; i++) {
                DV.UpdateText(Text[i], PositionsCol[i], PositionRow[i]);
            }
        }

    }

    private void UpdatePageUIFrames(String FeatureID, String PageID, boolean SetUIFrames, UIFramesKeySet UIFrames) {

        DisplayPage DP = DPages.get(PageID);

        if (UIFrames != null) {
            DP.UIFramesValues = UIFrames;
        }
        //
        if (CurrentFeature==null)
            return;

        if (!CurrentFeature.equals(FeatureID))
            return;
        //

        for (DisplayView DV : DViews.get(FeatureID).get(PageID)) {
            //When change page, set new uiframes
            if (SetUIFrames) {
                DV.SetUIFrames(DP.UIFrames, DP.HaveDynamicElements);
            }
            //Update values
            DV.UpdateFrameVariables(DP.UIFramesValues);
        }

    }

    private void SetPageToActive(String FeatureID, String PageID) {
        DisplayPage DP = DPages.get(PageID);
        //
        CurrentPage.put(FeatureID, PageID);
        //
        if (CurrentFeature==null)
            return;
        //
        if (!CurrentFeature.equals(FeatureID))
            return;
        //
        UpdatePageUIFrames(FeatureID, PageID, true, null);
    }

    private void SetPageToInactive(String FeatureID, String PageID) {
        if (CurrentFeature==null)
            return;

        if (!FeatureID.equals(CurrentFeature)) {
            return;
        }

        // DViews.get(FeatureID).get(PageID).stream().forEach((DV) -> {
        //     DV.ClearDisplay();
        //});
        int max = DViews.get(FeatureID).get(PageID).size();
        for (int i = 0; i < max; i++) {
            DViews.get(FeatureID).get(PageID).get(i).ClearDisplay();
        }
    }

    private void ChangeFeature(String FeatureID) {
        if (CurrentFeature!=null) {
            if (CurrentFeature.equals(FeatureID)) {
                return;
            }
        }
        // Set Current page of feature to Active
        SetPageToInactive(CurrentFeature, CurrentPage.get(CurrentFeature));
        CurrentFeature = FeatureID;
        SetPageToActive(FeatureID, CurrentPage.get(FeatureID));

        //

    }
}


