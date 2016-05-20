/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.display.tools.infopage;

import kkdev.kksystem.base.classes.controls.PinControlData;
import kkdev.kksystem.base.classes.display.UIFramesKeySet;
import kkdev.kksystem.base.classes.plugins.simple.managers.PluginManagerDataProcessor;
import kkdev.kksystem.base.interfaces.IPluginKKConnector;

/**
 *
 * @author blinov_is
 */
public class PageMaker {
    String BackCommand;
    String CurrentFeature;
    String CurrentContext;
    MKPageView PViewer;
    PluginManagerDataProcessor PManager;
    IPageMakerExecCommand CallBack;

    public interface IPageMakerExecCommand {

        public void ExecCommand(String PageCMD);
        public void PageSelected(String PageName);
    }

    public PageMaker(String FeatureID,String UIContext, IPluginKKConnector PluginConnector, IPageMakerExecCommand PageExecCallback) {
        PManager = new PluginManagerDataProcessor();
        PManager.Connector = PluginConnector;
        CurrentFeature = FeatureID;
        CurrentContext=UIContext;
        CallBack = PageExecCallback;
    }

    public void AddPages(MKPageItem[] Page) {
        PViewer = new MKPageView(Page.length);

        for (int i = 0; i < Page.length; i++) {
            PViewer.SetPageData(i, Page[i]);
        }
    }

    public void ProcessControlCommand(String ControlID) {
        switch (ControlID) {
            case PinControlData.DEF_BTN_UP:
                SelectPrevPage();
                break;
            case PinControlData.DEF_BTN_DOWN:
                SelectNextPage();
                break;
            case PinControlData.DEF_BTN_ENTER:
                ExecCommand();
                break;
            case PinControlData.DEF_BTN_BACK:
                break;

        }

    }

    public void ShowInfoPage() {
        ShowPage(PViewer.GetPage());
    }

    public void SelectNextPage() {
        ShowPage(PViewer.MovePageNext());
    }

    public void SelectPrevPage() {
        ShowPage(PViewer.MovePagePrev());
    }

    public void ExecCommand() {
        CallBack.ExecCommand(PViewer.GetPage().PageCommand);
    }

    public void UpdatePageFrames(String PageName, UIFramesKeySet Frames) {
        PViewer.UpdateUIFrames(PageName, Frames);
        UpdateUIFrames(PageName);

    }

    private void UpdateUIFrames(String PageName) {
        MKPageItem Page = PViewer.GetPage();
        PManager.DISPLAY_UpdateUIFrames(CurrentFeature,CurrentContext, Page.PageName, Page.UIFrames);
    }

    private void ShowPage(MKPageItem Page) {
        PManager.DISPLAY_ActivatePage(CurrentFeature,CurrentContext, Page.PageName);
        PManager.DISPLAY_UpdateUIFrames(CurrentFeature,CurrentContext, Page.PageName, Page.UIFrames);
        //
        CallBack.PageSelected(Page.PageName);
    }

}
