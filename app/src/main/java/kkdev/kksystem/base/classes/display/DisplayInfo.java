/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.display;

/**
 *
 * @author blinov_is
 */
public class DisplayInfo {
    public enum UIDisplayType
    {
        DISPLAY_TEXT,
        DISPLAY_GRAPHIC,
        DISPLAY_MIXED
    }
    public UIDisplayType displayType;
    public int textMode_Columns;
    public int textMode_Rows;
    public int gfxMode_Width;
    public int gfxMode_Height;
    public int maxBackLight;
    public int maxContrast;
    public String displayID;
}
