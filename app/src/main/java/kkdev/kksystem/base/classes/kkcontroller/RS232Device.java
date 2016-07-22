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
 public class RS232Device {

    public static enum RS232DevType {
        Dev3GModem,
        DevELM327,
        DevSmarthead,
        Other,
        Error;
    }
    

        public String PortName;
        public RS232DevType PortType;
        public RS232Device(String PName) {
            PortName = PName;
        }
    }