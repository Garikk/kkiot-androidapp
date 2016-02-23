/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.controls;

import kkdev.kksystem.base.classes.base.PinBaseData;

/**
 *
 * @author blinov_is
 */
public class PinControlData extends PinBaseData {
    public final static String DEF_BTN_UP="BTN_UP";
    public final static String DEF_BTN_DOWN="BTN_DOWN";
    public final static String DEF_BTN_ENTER="BTN_ENTER";
    public final static String DEF_BTN_BACK="BTN_BACK";
    
    public enum KK_CONTROL_DATA{
        CONTROL_ACTIVATE,
        CONTROL_DEACTIVATE,
        CONTROL_CHANGEVALUE,
        CONTROL_TRIGGERED,
        CONTROL_LONGPRESS
    }
    
    
    public KK_CONTROL_DATA DataType;
    //
    public String ControlID;
    //
    public int ControlValue;
}
