/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.constants;

/**
 *
 * @author blinov_is
 */
public final class PluginConsts {
    public static enum KK_PLUGIN_MESSAGES
    {
        BASE_MESSAGE_INFO
    }
    
    //
    //
    // Default system PINS
    public final static String KK_PLUGIN_BASE_PIN_ANY="PIN_KK_ANYPIN";
    
    public final static String KK_PLUGIN_BASE_PIN_COMMAND="PIN_KK_COMMAND";
    //
    public final static String KK_PLUGIN_BASE_BASIC_TAGGEDINT_DATA="PIN_KK_BASIC_TAGGED_INT";
    public final static String KK_PLUGIN_BASE_BASIC_TAGGEDOBJ_DATA="PIN_KK_BASIC_TAGGED_OBJ";
    //
    // Default KKController
    public final static String KK_KKCONTROLLER_UTIL="PIN_KKTRLR_UTILITY";
    
    // Default ODB2 Pins
    public final static String KK_PLUGIN_BASE_ODB2_COMMAND="PIN_KK_ODB2_COMMAND";
    public final static String KK_PLUGIN_BASE_ODB2_DATA="PIN_KK_ODB2_DATA";
    public final static String KK_PLUGIN_BASE_ODB2_RAW="PIN_KK_ODB2_RAW";
    
 // Default Display Pins
    public final static String KK_PLUGIN_BASE_LED_COMMAND="PIN_KK_LED_COMMAND";
    public final static String KK_PLUGIN_BASE_LED_DATA="PIN_KK_LED_DATA";
    public final static String KK_PLUGIN_BASE_LED_RAW="PIN_KK_LED_RAW";
     
    // Default Controls Pins
    public final static String KK_PLUGIN_BASE_CONTROL_COMMAND="PIN_KK_CTRL_COMMAND";
    public final static String KK_PLUGIN_BASE_CONTROL_DATA="PIN_KK_CTRL_DATA";
    public final static String KK_PLUGIN_BASE_CONTROL_RAW="PIN_KK_CTRL_RAW";
    //

    //
    public static String KK_PLUGIN_BASE_PLUGIN = "KKController";
    public static String KK_PLUGIN_BASE_PLUGIN_UUID = "10000000-0000-0000-0000-000000000000";

    
    public static String KK_PLUGIN_BASE_PLUGIN_ODB2 = "KKODB2Reader";
    public static String KK_PLUGIN_BASE_PLUGIN_ODB2_UUID = "44b5dab1-f596-458a-b09b-d9565b91464e";

    public static String KK_PLUGIN_BASE_PLUGIN_LEDDISPLAY = "KKLEDDisplay";
    public static String KK_PLUGIN_BASE_PLUGIN_LEDDISPLAY_UUID = "7fbac0f7-6939-4380-bcb0-0ef8b1580fbf";
    
    public static String KK_PLUGIN_BASE_PLUGIN_DATADISPLAY = "KKDataDisplay";
    public static String KK_PLUGIN_BASE_PLUGIN_DATADISPLAY_UUID = "b5b50412-c02a-4674-a112-ddc5805ea4e5";
    
    public static String KK_PLUGIN_BASE_PLUGIN_HID = "KKControls";
    public static String KK_PLUGIN_BASE_PLUGIN_HID_UUID = "62d1026f-5297-4951-890d-61d75ae67d02";

    public static String KK_PLUGIN_BASE_PLUGIN_HWADAPTER = "HWAdapter";
    public static String KK_PLUGIN_BASE_PLUGIN_HWADAPTER_UUID = "4d0b0982-6219-11e5-9d70-feff819cdc9f";

    public static String KK_PLUGIN_BASE_PLUGIN_EXTCONNECTOR = "KKEXAdapter";
    public static String KK_PLUGIN_BASE_PLUGIN_EXTCONNECTOR_UUID = "51534a41-4200-40f6-adac-1a915678cde9";
    public static String KK_PLUGIN_BASE_PLUGIN_EXTCONNECTOR_BTSERVICE_UUID = "64dee184-022e-4fcd-b544-6d478fc631cc";

    public static String KK_PLUGIN_BASE_PLUGIN_BLUETOOTH = "KKBTConnection";
    public static String KK_PLUGIN_BASE_PLUGIN_BLUETOOTH_UUID = "f0ab876b-5403-40d8-86a2-309f337757a9";
    public static long KK_PLUGIN_BASE_PLUGIN_BLUETOOTH_BTSERVICE_RFCOMM_UUID = 0x0003;
    public static String KK_PLUGIN_BASE_PLUGIN_BLUETOOTH_BTSERVICE_RFCOMM_S_UUID = "0000000000001000800000805F9B34FB";
    public static String KK_PLUGIN_BASE_PLUGIN_BLUETOOTH_BTSERVICE_KKEXCONNECTION_UUID = "9846431";
 
    //
    

    
}
