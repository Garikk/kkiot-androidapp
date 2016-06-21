/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.interfaces;

import java.util.List;
import kkdev.kksystem.base.classes.display.DisplayInfo;
import kkdev.kksystem.base.classes.display.pages.DisplayPage;
import kkdev.kksystem.base.classes.kkcontroller.KKController_Utils.RS232Device;
import kkdev.kksystem.base.classes.kkcontroller.UIContextInfo;
import kkdev.kksystem.base.classes.plugins.PluginInfo;

/**
 *
 * @author blinov_is
 */
public interface IKKControllerUtils {
    //HWDevices
    public List<RS232Device> HWDEVICES_GetRS232Devices();
    // Plugin information
    public List<PluginInfo> PLUGINS_GetLoadedPlugins();
    // Display pages
    public List<DisplayPage> DISPLAY_GetUIDisplayPages();
    public DisplayPage DISPLAY_GetUIDisplayPage(String Page);
    public void DISPLAY_AddUIDisplayPage(DisplayPage Page);
    // UIContexts
    public void UICONTEXT_AddUIContext(String UIContextID);
    public UIContextInfo UICONTEXT_GetUIContextInfo(String ContextID);
    public void UICONTEXT_UpdateDisplayInUIContext(String ContextID,DisplayInfo DI);
     
}
