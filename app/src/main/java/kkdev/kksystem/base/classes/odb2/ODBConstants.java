/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.odb2;

/**
 *
 * @author blinov_is
 */
public final class ODBConstants {
       public static enum KK_ODB_DATACOMMANDINFO
    {
        ODB_GETINFO_PIDDATA,
        ODB_GETINFO_RAWINFO,
        ODB_GETINFO_CE_ERRORS,
        ODB_CMD_CLEAR_CE_DATA,
        ODB_CMD_OTHERCMD
       }
    public static enum KK_ODB_DATATYPE
    {
        ODB_BASE_CONNECTOR,
        ODB_DIAG_DATA,
        ODB_DIAG_CE_ERRORS,
        ODB_DIAG_RAWDATA
    }
    
    public static enum KK_ODB_COMMANDTYPE
    {
        ODB_KKSYS_ADAPTER_CONNECT,
        ODB_KKSYS_ADAPTER_DISCONNECT,
        ODB_KKSYS_CAR_GETINFO,
        ODB_KKSYS_CAR_GETINFO_STOP,
        ODB_KKSYS_CAR_EXEC_COMMAND,
        ODB_RAW_EXEC_ODB_COMMAND
        
       }
}

