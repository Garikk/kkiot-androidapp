/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.display;

import kkdev.kksystem.base.classes.display.pages.framesKeySet;
import kkdev.kksystem.base.classes.base.PinBaseData;
import kkdev.kksystem.base.classes.display.DisplayConstants.KK_DISPLAY_DATA;

/**
 *
 * @author blinov_is
 */
public class PinLedData extends PinBaseData {

    public String contextID;
    
    public KK_DISPLAY_DATA ledDataType;
    //
    public String targetPage;           //Target page
    //
    public framesKeySet displayFrames;
    //
    public String[] directDisplayText;        //Text for display
    public String[] directDisplayTextUpdate;    //Updated text (using positions)
    public int[] directStartPositionCol;     //Position for update text
    public int[] directStartPositionRow;       //Position for update text
    //
    public DisplayInfo[] displayState;    //

    public void fillFrameValues(String[] Keys, String[] Values) {
        displayFrames = new framesKeySet();
        displayFrames.fillValues(Keys, Values);
    }
}
