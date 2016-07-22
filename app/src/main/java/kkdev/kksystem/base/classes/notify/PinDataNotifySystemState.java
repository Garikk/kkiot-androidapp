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
public class PinDataNotifySystemState  extends PinDataNotify{
    public enum SystemStateInfo
    {
        INERNET_ACTIVE,
        INERNET_INACTIVE
    }
    
    public SystemStateInfo systemState;
}
