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
public class FeatureConfiguration {
    public String FeatureName;
    public String FeatureUUID;
    public boolean IsSystemFeature;
    public PluginConnection[] Connections;
    public int MinVersion;
    public String[] RequiredConfigurations;
    //
}
