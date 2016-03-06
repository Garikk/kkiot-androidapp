/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.plugins.simple.managers;

import kkdev.kksystem.base.classes.odb2.ODB2Data;
import kkdev.kksystem.base.classes.odb2.ODBConstants;
import kkdev.kksystem.base.classes.odb2.PinOdb2Command;
import kkdev.kksystem.base.classes.odb2.PinOdb2ConnectorInfo;
import kkdev.kksystem.base.classes.odb2.PinOdb2ConnectorInfo.ODB_State;
import kkdev.kksystem.base.classes.odb2.PinOdb2Data;
import static kkdev.kksystem.base.constants.PluginConsts.KK_PLUGIN_BASE_ODB2_COMMAND;
import static kkdev.kksystem.base.constants.PluginConsts.KK_PLUGIN_BASE_ODB2_DATA;

/**
 *
 * @author blinov_is
 */
public class PluginManagerODB extends PluginManagerBase {
    
    public void ODB_SendPluginMessageCommand(String FeatureID,ODBConstants.KK_ODB_COMMANDTYPE Command, ODBConstants.KK_ODB_DATACOMMANDINFO Request, int[] DataInt, int[] ReadInterval) {
        PinOdb2Command PData = new PinOdb2Command();
        PData.Command = Command;
        PData.CommandData = Request;
        //
        PData.RequestPIDs = DataInt;
        PData.DynamicRequestInterval = ReadInterval;
        //
        this.BASE_SendPluginMessage(FeatureID,KK_PLUGIN_BASE_ODB2_COMMAND, PData);
    }
    public void ODB_SendConnectionState(String FeatureID,PinOdb2ConnectorInfo ConnInfo) {
        //
        PinOdb2Data PData = new PinOdb2Data();
        PData.Odb2DataType=ODBConstants.KK_ODB_DATATYPE.ODB_BASE_CONNECTOR;
        PData.AdapterInfo=ConnInfo;
        PData.FeatureID=FeatureID;
        //
       this.BASE_SendPluginMessage(FeatureID,KK_PLUGIN_BASE_ODB2_DATA, PData);
    }
     public void ODB_SendODBInfo(String FeatureID,PinOdb2ConnectorInfo ConnInfo, ODB2Data Data) {
        //
        PinOdb2Data PData = new PinOdb2Data();
        PData.Odb2DataType=ODBConstants.KK_ODB_DATATYPE.ODB_DIAG_DATA;
        PData.ODBData=Data;
        PData.AdapterInfo=ConnInfo;
        PData.FeatureID=FeatureID;
        //
       this.BASE_SendPluginMessage(FeatureID,KK_PLUGIN_BASE_ODB2_DATA, PData);
    }
      public void ODB_SendODBErrors(String FeatureID,PinOdb2ConnectorInfo ConnInfo, ODB2Data Data) {
        //
        PinOdb2Data PData = new PinOdb2Data();
        PData.Odb2DataType=ODBConstants.KK_ODB_DATATYPE.ODB_DIAG_CE_ERRORS;
        PData.ODBData=Data;
        PData.AdapterInfo=ConnInfo;
        PData.FeatureID=FeatureID;
        //
       this.BASE_SendPluginMessage(FeatureID,KK_PLUGIN_BASE_ODB2_DATA, PData);
    }
}
