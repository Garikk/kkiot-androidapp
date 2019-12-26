package kkdev.kksystem.kkcarandroid.leddebug;

import kkdev.kksystem.base.classes.display.UIFrameData;
import kkdev.kksystem.base.classes.display.UIFramePack;
import kkdev.kksystem.base.classes.display.UIFramesKeySet;

/**
 * Created by sayma_000 on 06.03.2016.
 */
public class DisplayPage {
    public String PageName;             //ID
    public boolean HaveDynamicElements; //want to exec anmimation by thread
    public boolean IsDefaultPage;
    //
    public String[] Features;
    //
    public String[] HWDisplays;         //links to HWDisplays
    //
    public UIFramePack UIFramesPack;
    //
    public  String[] UIFrames;
    public UIFramesKeySet UIFramesValues;

    public void InitUIFrames() {
        int i=0;
        UIFrames = new String[UIFramesPack.Data.length];
        for (UIFrameData FrameData : UIFramesPack.Data) {
            UIFrames[i]=FrameData.FrameData;
            i++;
        }

    }
}
