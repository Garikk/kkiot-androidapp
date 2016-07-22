/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.geo;

import kkdev.kksystem.base.classes.base.PinData;
import static kkdev.kksystem.base.classes.geo.NMEA0183.*;

/**
 *
 * @author blinov_is
 */
public class PinDataGeo extends PinData{
    public static enum GEO_DATA_TYPE
    {
        GEO_GPRMC,
        ERRDATA
    }
    public double Lat;
    public boolean IsNorthLat;
    
    public double Long;
    public boolean IsEastLong;
    
    public double Speed;
    public double Vector;
    public boolean Status;
    public int SatTimeUnix;
    public String SatDate;
    public String SatTime;
    
    public GEO_DATA_TYPE DataType;
    
    
    
    public void FillNMEAData(String Data)
    {
        String[] NMEA = Data.split(",");
        
        if ("$GPRMC".equals(NMEA[NMEA_0183_HEADER]))
        {
            DataType=GEO_DATA_TYPE.GEO_GPRMC;
            SatTime=NMEA[NMEA_0183_RMC_TIME];
            Status=(NMEA[NMEA_0183_RMC_STATUS].equals("A"));
            Lat=Double.parseDouble(NMEA[NMEA_0183_RMC_LAT]);
            IsNorthLat=(NMEA[4].equals(NMEA_0183_RMC_NORTH_SOUTH));
            Long=Double.parseDouble(NMEA[NMEA_0183_RMC_LONG]);
            IsEastLong=(NMEA[6].equals(NMEA_0183_RMC_EAST_WEST));
            Speed=Double.parseDouble(NMEA[NMEA_0183_RMC_SPEED]);
            Vector=Double.parseDouble(NMEA[NMEA_0183_RMC_VECTOR]);
            SatDate=NMEA[NMEA_0183_RMC_DATE];
        }
        else
        {
            DataType=GEO_DATA_TYPE.ERRDATA;
        }
    }
}
