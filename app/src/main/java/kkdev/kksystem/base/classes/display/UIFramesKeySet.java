/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.display;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author blinov_is
 */
public class UIFramesKeySet {
    public Map<String,String> FrameValues;
    
    public UIFramesKeySet()
    {
        FrameValues= new HashMap<>();
    }
    
    public String[] Keys()
    {
        return (String[])FrameValues.keySet().toArray();
    }
    public String[] Values()
    {
        return (String[])FrameValues.values().toArray();
    }
    
    public void AddKeySet(String Key, String Value)
    {
       FrameValues.put(Key, Value);
    
    }
    
    public void FillValues(String[] Keys, String[] Values)
    {
        for (int i=0;i<Keys.length;i++)
        {
            FrameValues.put(Keys[i], Values[i]);
        }
    
    }
}
