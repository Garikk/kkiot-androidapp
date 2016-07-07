/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.interfaces;

import kkdev.kksystem.base.classes.plugins.PluginMessage;

/**
 *
 * @author blinov_is
 */
public interface IPluginBaseInterface {
    public  void executePinCommand(PluginMessage PP);
    public  void _executePinCommandDirect(String PluginUUID,PluginMessage PP);
    public IKKControllerUtils systemUtilities();
}
