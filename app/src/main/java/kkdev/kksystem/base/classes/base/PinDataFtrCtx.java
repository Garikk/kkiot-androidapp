/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.base;

import java.util.Map;

/**
 *
 * @author blinov_is
 */
public class PinDataFtrCtx extends PinData {
   
    public enum FCManagementCommand
    {
        ChangeFeature,
        CurrentFeature
    }
    
    public FCManagementCommand managementCommand;
    public String manageUIContextID;
    public String manageFeatureID;
}
