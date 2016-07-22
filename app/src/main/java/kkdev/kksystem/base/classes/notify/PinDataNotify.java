/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.notify;

import kkdev.kksystem.base.classes.base.PinData;
import kkdev.kksystem.base.classes.notify.NotifyConsts.NOTIFY_METHOD;
import kkdev.kksystem.base.classes.notify.NotifyConsts.NOTIFY_TYPE;

/**
 *
 * @author blinov_is
 */
public class PinDataNotify extends PinData{
    public NOTIFY_TYPE notifyType;
    public NOTIFY_METHOD[] notifyMethod;
    
    public String notifyText;
}
