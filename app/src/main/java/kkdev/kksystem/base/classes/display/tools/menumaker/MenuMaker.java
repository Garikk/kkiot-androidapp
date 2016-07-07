/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.display.tools.menumaker;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;
import kkdev.kksystem.base.classes.controls.PinDataControl;
import kkdev.kksystem.base.classes.display.pages.PageConsts;
import kkdev.kksystem.base.classes.notify.NotifyConsts;
import kkdev.kksystem.base.classes.plugins.simple.managers.PluginManagerDataProcessor;
import kkdev.kksystem.base.constants.PluginConsts;
import kkdev.kksystem.base.interfaces.IKKControllerUtils;
import kkdev.kksystem.base.interfaces.IPluginBaseInterface;
import kkdev.kksystem.base.interfaces.IPluginKKConnector;

/**
 *
 * @author blinov_is
 */
public class MenuMaker {

    public static final String KK_MENUMAKER_SPECIALCMD_SUBMENU = "KK_SUBMENU";

    PluginManagerDataProcessor PManager;
    boolean inSystemMode = false;
    String menuFeatureID;
    String menuContextID;
    MKMenuItem[] menuItems;
    Deque<MKMenuItem[]> menuTree;
    IMenuMakerItemSelected callback;
    MKMenuView MViewer;
    String systemLCD;
    String targetPage;
    String activePage;
    String currentBackCMD;
    String specialPluginUUID;
    boolean sendNotifications;
    private IKKControllerUtils utils;
    //
    public String getActivePage()
    {
        return activePage;
    }
    public interface IMenuMakerItemSelected {

        public void selectedItem(String ItemCMD);
        public void stepBack(String BackCMD);
        public void activeMenuElement(String ItemText,String ItemCMD);
    }
    public void setPluginUUID(String UUID)
    {
        specialPluginUUID=UUID;
    }

    public MenuMaker(IKKControllerUtils KKUtils, String FeatureID,String UIContextID, String MenuTargetPage, IPluginBaseInterface BaseConnector, IMenuMakerItemSelected MenuCallback, String SystemLCD_ID, boolean SendNarratorNotifications) {
      
        if (MenuTargetPage == null) {
            targetPage = PageConsts.KK_DISPLAY_PAGES_SIMPLEMENU_TXT_C1RX_PREFIX;
        } else {
            targetPage = MenuTargetPage;
        }
        utils=KKUtils;
        sendNotifications=SendNarratorNotifications;
        callback = MenuCallback;
        PManager = new PluginManagerDataProcessor();
        PManager.setBaseConnector(BaseConnector);
        inSystemMode = true;
        systemLCD = SystemLCD_ID;
        menuFeatureID = FeatureID;
        menuContextID=UIContextID;
        

    }

    public MenuMaker(IKKControllerUtils KKUtils, String FeatureID, String UIContextID, String MenuTargetPage, IPluginKKConnector PluginConnector, IMenuMakerItemSelected MenuCallback, boolean SendNarratorNotifications) {
        if (MenuTargetPage == null | "".equals(MenuTargetPage)) {
            targetPage = PageConsts.KK_DISPLAY_PAGES_SIMPLEMENU_TXT_C1RX_PREFIX ;
        } else {
            targetPage = MenuTargetPage;
        }
        //        
        utils=KKUtils;
          sendNotifications=SendNarratorNotifications;
        callback = MenuCallback;
        PManager = new PluginManagerDataProcessor();
        PManager.setPluginConnector(PluginConnector);
        inSystemMode = false;
        menuFeatureID = FeatureID;
        menuContextID = UIContextID;
    }

    public void addMenuItems(MKMenuItem[] Items)
    {
       addMenuItems(utils.UICONTEXT_GetUIContextInfo(menuContextID).UIDisplay.textMode_Rows,Items);
    }
    public void addMenuItems(int PageRows,MKMenuItem[] Items) {
        menuTree = new ArrayDeque<>();
        menuItems = Items;
        MViewer = new MKMenuView(PageRows, Items.length);

        for (int i = 0; i < Items.length; i++) {
            MViewer.setItemData(i, Items[i]);
        }
    }

    public void updateMenuItems(MKMenuItem[] Items,String BackCMD, boolean IsBackCommand) {
        if (!IsBackCommand) {
            menuTree.push(menuItems);
        }

        menuItems = Items;
        MViewer.resetMenuView(Items.length);
        for (int i = 0; i < Items.length; i++) {
            if (Items[i].itemBackFromSubItemCommand==null || Items[i].itemBackFromSubItemCommand.equals(""))
                Items[i].itemBackFromSubItemCommand=BackCMD;
            //
            MViewer.setItemData(i, Items[i]);
        }
        menuRefreshDisplay();
    }

    public void showMenu() {

        if (inSystemMode) {
            activePage=targetPage;
            PManager._DISPLAY_ActivatePageDirect(menuFeatureID,menuContextID,systemLCD, targetPage);
            PManager._DISPLAY_UpdateUIFramesDirect(menuFeatureID,menuContextID, systemLCD, targetPage, MViewer.getMenu());
            
        } else {
            activePage=targetPage;
            PManager.DISPLAY_ActivatePage(menuFeatureID,menuContextID, targetPage);
            PManager.DISPLAY_UpdateUIFrames(menuFeatureID,menuContextID, targetPage, MViewer.getMenu());

        }
    }

    public void menuRefreshDisplay() {
        if (inSystemMode) {
            PManager._DISPLAY_UpdateUIFramesDirect(menuFeatureID,menuContextID, systemLCD, targetPage, MViewer.getMenu());
        } else {
            PManager.DISPLAY_UpdateUIFrames(menuFeatureID,menuContextID, targetPage, MViewer.getMenu());
        }
    }

    public void menuSelectUp() {

        if (inSystemMode) {
            PManager._DISPLAY_UpdateUIFramesDirect(menuFeatureID,menuContextID, systemLCD, targetPage, MViewer.moveMenuUP());
        } else {
            PManager.DISPLAY_UpdateUIFrames(menuFeatureID,menuContextID, targetPage, MViewer.moveMenuUP());
        }
    }

    public void menuSelectDown() {
        if (inSystemMode) {
            PManager._DISPLAY_UpdateUIFramesDirect(menuFeatureID,menuContextID, systemLCD, targetPage, MViewer.moveMenuDown());
        } else {
            PManager.DISPLAY_UpdateUIFrames(menuFeatureID,menuContextID, targetPage, MViewer.moveMenuDown());
        }
    }

    public void menuSelectBack() {
        if (menuTree.size() > 0) {
            MKMenuItem[] MI;
            callback.stepBack(currentBackCMD);
            MI=menuTree.pop();
            currentBackCMD=MI[0].itemBackFromSubItemCommand;
            updateMenuItems(MI,currentBackCMD, true);
            
        }
        else
        {
            callback.selectedItem("LEAVE");
        }

    }

    public void menuExec() {
        String CMD=execSpecialCommand(getCurrentSelection());
        if (!CMD.equals("")) {
            callback.selectedItem(CMD);
        }

    }

    private String execSpecialCommand(MKMenuItem Item) {
        if (Item.itemCommand==null)
            return "";
        
        String CMD;
        String RetCMD;
               
                
        
        if (Item.itemCommand.contains(" "))
        {
            CMD=Item.itemCommand.split(" ")[0];
            RetCMD=Item.itemCommand.substring(CMD.length()+1);
        }
        else 
        {
            CMD=Item.itemCommand;
            RetCMD="";
        }
        
        switch (CMD) {
            case KK_MENUMAKER_SPECIALCMD_SUBMENU:
                currentBackCMD=Item.itemBackFromSubItemCommand;
                updateMenuItems(Item.subItems,currentBackCMD, false);
                return RetCMD;
        }

        return Item.itemCommand;
    }

    public MKMenuItem getCurrentSelection() {
        return MViewer.getCurrentMenuItem();
    }

    public void processControlCommand(Set<String> ControlID) {
        for (String btnCtrl : ControlID) {
            switch (btnCtrl) {
                case PinDataControl.DEF_BTN_UP:
                    menuSelectUp();
                    sendNarratorNotification(getCurrentSelection().displayName);
                    callback.activeMenuElement(getCurrentSelection().displayName, getCurrentSelection().itemCommand);
                    break;
                case PinDataControl.DEF_BTN_DOWN:
                    menuSelectDown();
                    sendNarratorNotification(getCurrentSelection().displayName);
                    callback.activeMenuElement(getCurrentSelection().displayName, getCurrentSelection().itemCommand);
                    break;
                case PinDataControl.DEF_BTN_ENTER:
                    menuExec();
                    break;
                case PinDataControl.DEF_BTN_BACK:
                    menuSelectBack();
                    //SendNarratorNotification(getCurrentSelection().displayName);
                    //CallBack.activeMenuElement(getCurrentSelection().displayName, getCurrentSelection().itemCommand);
                    break;
            }
        }
    }

    private void sendNarratorNotification(String Text) {
        if (!sendNotifications) {
            return;
        }
        NotifyConsts.NOTIFY_METHOD[] NM = new NotifyConsts.NOTIFY_METHOD[1];
        NM[0] = NotifyConsts.NOTIFY_METHOD.VOICE;
        if (inSystemMode) {
            PManager._NOTIFY_SendNotifyMessage(PluginConsts.KK_PLUGIN_BASE_PLUGIN_UUID, menuFeatureID, NotifyConsts.NOTIFY_TYPE.SYSTEM_INFO, NM, Text);
        } else {
            PManager.NOTIFY_SendNotifyMessage(menuFeatureID, NotifyConsts.NOTIFY_TYPE.SYSTEM_INFO, NM, Text);
        }

    }
}
