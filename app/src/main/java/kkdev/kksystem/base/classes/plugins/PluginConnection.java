/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.plugins;

/**
 *
 * @author blinov_is
 */
public class PluginConnection{
   public String ConnectionName;      //Connection name
   public String SourcePluginName;    //source plugin name for info
   public String TargetPluginName;    //target plugin name for info
   public String SourcePluginUID;     //UUID srource plugin
   public String TargetPluginUID;     //UUID target plugin
   public String PinName[];             //Pin Name
   boolean Enabled;
    
}