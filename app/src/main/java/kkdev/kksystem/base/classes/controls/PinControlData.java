/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.controls;

import java.util.Set;
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
    
    public final static String DEF_BTN_PLAY="BTN_PLAY";
    public final static String DEF_BTN_STOP="BTN_STOP";
    public final static String DEF_BTN_PAUSE="BTN_PAUSE";
    public final static String DEF_BTN_NEXT_TRACK="BTN_NEXT_TRACK";
    public final static String DEF_BTN_PREV_TRACK="BTN_PREV_TRACK";
    public final static String DEF_BTN_NEXT_PLIST="BTN_NEXT_PLIST";
    public final static String DEF_BTN_PREV_PLIST="BTN_PREV_PLIST";
    public final static String DEF_BTN_SEEK_FF="BTN_SEEK_FWD";
    public final static String DEF_BTN_SEEK_RW="BTN_SEEK_RW";
    public final static String DEF_BTN_VOL_INC="BTN_VOL_INC";
    public final static String DEF_BTN_VOL_DEC="BTN_VOL_DEC";
    public final static String DEF_BTN_VOL_MUTE="BTN_VOL_MUTE";
    public final static String DEF_BTN_VOL_UNMUTE="BTN_VOL_UNMUTE";
     
    
    
    public enum KK_CONTROL_DATA{
        CONTROL_ACTIVATE,
        CONTROL_DEACTIVATE,
        CONTROL_CHANGEVALUE,
        CONTROL_TRIGGERED,
        CONTROL_LONGPRESS
    }
    
    public String UIContextID;
    
    public KK_CONTROL_DATA controlDataType;
    //
    public Set<String> controlID;
    //
    public int controlValue;
}
