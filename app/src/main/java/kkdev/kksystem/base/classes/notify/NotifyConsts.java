/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.notify;

/**
 *
 * @author blinov_is
 */
public class NotifyConsts {
    public enum NOTIFY_TYPE
    {
        SYSTEM_INFO,
        SYSTEM_WARN,
        CAR_INFO,
        CAR_WARN,
        CAR_ALERT,
        ROAD_INFO,
        ROAD_WARN,
        ROAD_ALERT
    }
    public enum NOTIFY_METHOD
    {
        LOG,
        DISPLAY,
        VOICE,
        SIGNAL,
        INFO
    }
            
}
