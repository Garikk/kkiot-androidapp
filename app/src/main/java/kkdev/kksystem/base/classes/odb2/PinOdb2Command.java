/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.odb2;

import kkdev.kksystem.base.classes.base.PinBaseCommand;
import kkdev.kksystem.base.classes.odb2.ODBConstants.KK_ODB_COMMANDTYPE;
import kkdev.kksystem.base.classes.odb2.ODBConstants.KK_ODB_DATACOMMANDINFO;


/**
 *
 * @author blinov_is
 */
public class PinOdb2Command extends PinBaseCommand{
    public KK_ODB_COMMANDTYPE command;      //Type of command for ODB Plugin
    public KK_ODB_DATACOMMANDINFO commandData;   //Type of Data
    public int[] requestPIDs;               //pid numbers
    public int[] dynamicRequestInterval;    //0 - one request, other - seconds for dynamic requests
    public Object objectData;               //any raw data for plugin interconnection
}
