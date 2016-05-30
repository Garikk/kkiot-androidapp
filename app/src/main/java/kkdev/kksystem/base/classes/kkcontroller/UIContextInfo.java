/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.kkcontroller;

import kkdev.kksystem.base.classes.display.DisplayInfo;

/**
 *
 * @author blinov_is
 */
    public class UIContextInfo {
        public String UIContextID;
        public DisplayInfo UIDisplay;
        //public ControlsInfo[] UIControls;
        public UIContextInfo(String ContextID)
        {
            this.UIContextID=ContextID;
        }
    }
