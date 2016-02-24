/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.odb2;

/**
 *
 * @author sayma_000
 */
public class PinOdb2ConnectorInfo {
    public enum ODB_State{
        ODB_CONNECTOR_WAIT,
        ODB_CONNECTOR_ERROR,
        ODB_CONNECTOR_READY
    }
    
    public ODB_State OdbAdapterState;
    public String OdbAdapterDescripton;
}
