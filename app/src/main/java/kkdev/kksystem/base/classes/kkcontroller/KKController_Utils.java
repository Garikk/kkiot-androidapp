/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.kkcontroller;

/**
 *
 * @author blinov_is
 */
public abstract class KKController_Utils
{
 public static class RS232Device {

        public String PortName;
        public RS232DevType PortType;
        public RS232Device(String PName) {
            PortName = PName;
        }
    }

    public static enum RS232DevType {
        Dev3GModem,
        DevELM327,
        Other,
        Error;
    }
    
    public static final String KKController_Util_Act_RS232Devices="1";
}