/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.display.pages;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author blinov_is
 */
public class framesKeySet {
    public  Map<String,String> frameValues;
    
    public framesKeySet()
    {
        frameValues= new HashMap<>();
    }
    
    public String[] keys()
    {
        return (String[])frameValues.keySet().toArray();
    }
    public String[] values()
    {
        return (String[])frameValues.values().toArray();
    }
    
    public void addKeySet(String Key, String Value)
    {
       frameValues.put(Key, Value);
    
    }
    
    public void fillValues(String[] Keys, String[] Values)
    {
        for (int i=0;i<Keys.length;i++)
        {
            frameValues.put(Keys[i], Values[i]);
        }
    }
    public void setValue(String Key,String Value)
    {
            frameValues.put(Key, Value);
    }
}
