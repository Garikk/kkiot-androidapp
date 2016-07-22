/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.base;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author blinov_is
 */
public abstract class PinData {

    public Set<String> featureID;
    public String dataDescription;
    
    public PinData()
    {
        featureID=new LinkedHashSet<>();
    }

}
