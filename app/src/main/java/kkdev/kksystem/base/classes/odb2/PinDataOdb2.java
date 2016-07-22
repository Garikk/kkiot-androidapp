/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.odb2;


import kkdev.kksystem.base.classes.base.PinData;
import kkdev.kksystem.base.classes.odb2.ODBConstants.KK_ODB_DATATYPE;

/**
 *
 * @author blinov_is
 */
public class PinDataOdb2 extends PinData {
    public KK_ODB_DATATYPE Odb2DataType;
    
        public ODBConstants.KK_ODB_COMMANDTYPE command;      //Type of command for ODB Plugin
    public ODBConstants.KK_ODB_DATACOMMANDINFO commandData;   //Type of Data
    public int[] requestPIDs;               //pid numbers
    public int[] dynamicRequestInterval;    //0 - one request, other - seconds for dynamic requests
    public Object objectData;               //any raw data for plugin interconnection

    public ODB2Data ODBData;
    public PinOdb2ConnectorInfo AdapterInfo;
}
