/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.display;

/**
 *
 * @author blinov_is
 */
public final class DisplayConstants {
     public static enum KK_DISPLAY_COMMAND
    {
        DISPLAY_KKSYS_GETINFO,
        DISPLAY_KKSYS_POWER,
        DISPLAY_KKSYS_GETACTIVEPAGE,
        DISPLAY_KKSYS_PAGE_ACTIVATE,
        DISPLAY_RAW_EXEC_DISPLAY_COMMAND
    }
       public static enum KK_DISPLAY_DATA
    {
        DISPLAY_KKSYS_ACTIVE_PAGE,   
        DISPLAY_KKSYS_TEXT_SIMPLE_OUT,         //Simple text output
        DISPLAY_KKSYS_TEXT_UPDATE_DIRECT,      //Updated text with positions
        DISPLAY_KKSYS_TEXT_UPDATE_FRAME,       //Updated Frame constants
        DISPLAY_KKSYS_DISPLAY_STATE,
        DISPLAY_RAW_EXEC_DISPLAY_DATA
    }
       
      
}
