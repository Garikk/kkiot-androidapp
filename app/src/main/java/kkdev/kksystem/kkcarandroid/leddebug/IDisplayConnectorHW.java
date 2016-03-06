package kkdev.kksystem.kkcarandroid.leddebug;

import kkdev.kksystem.base.classes.display.DisplayInfo;
import kkdev.kksystem.kkcarandroid.manager.callback.ILedDebugUI;

/**
 * Created by sayma_000 on 06.03.2016.
 */
public interface IDisplayConnectorHW {
    void SetContrast(int Contrast);
    void SetLight(int Light);
    void SetPower(boolean Power);
    //
    void DisplayText(String Text);
    void DisplayTextUpdate(String Text, int Column, int Line);
    void DisplayTextSetUIFrames(String[] Frames, int Offset);
    //
    void InitDisplayHW(ILedDebugUI Callback);
    void ShutDown();
    //
    void ClearDisplay();
    //

    DisplayInfo GetDisplayInfo();

}