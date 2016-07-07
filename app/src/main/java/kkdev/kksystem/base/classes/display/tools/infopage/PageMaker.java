/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.display.tools.infopage;

import java.util.Set;
import kkdev.kksystem.base.classes.controls.PinDataControl;
import kkdev.kksystem.base.classes.display.pages.framesKeySet;
import kkdev.kksystem.base.classes.plugins.simple.managers.PluginManagerDataProcessor;
import kkdev.kksystem.base.interfaces.IPluginKKConnector;

/**
 *
 * @author blinov_is
 */
public class PageMaker {
    String commandBack;
    String currentFeature;
    String currentContext;
    MKPageView PViewer;
    PluginManagerDataProcessor PManager;
    IPageMakerExecCommand callback;

    public interface IPageMakerExecCommand {

        public void execCommand(String PageCMD);
        public void pageSelected(String PageName);
        public void pageStepFwd();
        public void pageStepBwd();
    }

    public PageMaker(String FeatureID,String UIContext, IPluginKKConnector PluginConnector, IPageMakerExecCommand PageExecCallback) {
        PManager = new PluginManagerDataProcessor();
        PManager.setPluginConnector(PluginConnector);
        currentFeature = FeatureID;
        currentContext=UIContext;
        callback = PageExecCallback;
    }

    public void addPages(MKPageItem[] Page) {
        PViewer = new MKPageView(Page.length);

        for (int i = 0; i < Page.length; i++) {
            PViewer.setPageData(i, Page[i]);
        }
    }

    public void processControlCommand(Set<String> ControlID) {
        for (String btnCtrl : ControlID) {
            switch (btnCtrl) {
                case PinDataControl.DEF_BTN_UP:
                    selectPrevPage();
                    break;
                case PinDataControl.DEF_BTN_DOWN:
                    selectNextPage();
                    break;
                case PinDataControl.DEF_BTN_ENTER:
                    execCommand();
                    break;
                case PinDataControl.DEF_BTN_BACK:
                    break;

            }
        }
    }

    public void showInfoPage() {
        showPage(PViewer.getPage());
    }

    public void selectNextPage() {
        showPage(PViewer.movePageNext());
        callback.pageStepFwd();
    }

    public void selectPrevPage() {
        showPage(PViewer.movePagePrev());
        callback.pageStepBwd();
    }

    public void execCommand() {
        callback.execCommand(PViewer.getPage().pageCommand);
    }

    public void updatePageFrames(String PageName, framesKeySet Frames) {
        PViewer.updateUIFrames(PageName, Frames);
        updateUIFrames(PageName);

    }

    private void updateUIFrames(String PageName) {
        MKPageItem Page = PViewer.getPage();
        PManager.DISPLAY_UpdateUIFrames(currentFeature, currentContext, Page.pageName, Page.pageFrames);
    }

    private void showPage(MKPageItem Page) {
        PManager.DISPLAY_ActivatePage(currentFeature,currentContext, Page.pageName);
        PManager.DISPLAY_UpdateUIFrames(currentFeature,currentContext, Page.pageName, Page.pageFrames);
        //
        callback.pageSelected(Page.pageName);
    }

}
