package kkdev.kksystem.kkcarandroid.leddebug;

import android.telecom.Call;

import kkdev.kksystem.base.classes.display.DisplayInfo;
import kkdev.kksystem.kkcarandroid.manager.callback.ILedDebugUI;

/**
 * Created by sayma_000 on 06.03.2016.
 */
public class AndroidLEDDebugDisplay implements IDisplayConnectorHW{
        final int LCD_ROWS = 2;
        final int LCD_ROW_1 = 0;
        final int LCD_ROW_2 = 1;
        final int LCD_COLUMNS = 16;
        final int LCD_BITS = 4;

        boolean CmdStopDisplay=false;
        ILedDebugUI UILink;
        public AndroidLEDDebugDisplay(ILedDebugUI Callback)
        {
            UILink= Callback;
            InitDisplayHW(UILink);
        }

        @Override
        public void SetContrast(int Contrast) {
          //  System.out.println("[LCDDisplay][DEBUG] Set Contrast " + Contrast);
        }

        @Override
        public void SetLight(int Light) {
            //System.out.println("[LCDDisplay][DEBUG] Set Light " + Light);
        }

        @Override
        public void SetPower(boolean Power) {
         //   System.out.println("[LCDDisplay][DEBUG] Set Light " + Power);
        }

        @Override
        public void ShutDown() {
            CmdStopDisplay=true;
        }

        @Override
        public void DisplayText(String Text) {
         //   System.out.println("[LCDDisplay][DEBUG] " + Text);
        }

        @Override
        public void DisplayTextUpdate(String Text, int Column, int Line) {
         //   System.out.println("[LCDDisplay][DEBUG] ["+Column+"][" +Line +"]" + Text);
        }

        @Override
        public DisplayInfo GetDisplayInfo() {
            return GetMyInfo();
        }

        private DisplayInfo GetMyInfo() {
            DisplayInfo Ret = new DisplayInfo();
            Ret.displayType = DisplayInfo.UIDisplayType.DISPLAY_TEXT;
            Ret.maxBackLight = 255;
            Ret.maxContrast = 255;
            Ret.textMode_Columns = LCD_COLUMNS;
            Ret.textMode_Rows = LCD_ROWS;
            Ret.gfxMode_Height = 0;
            Ret.gfxMode_Width = 0;

            return Ret;
        }

        @Override
        public void InitDisplayHW(ILedDebugUI Link) {
            UILink=Link;


        }

        @Override
        public void ClearDisplay() {

        }

        @Override
        public void DisplayTextSetUIFrames(String[] Frames, int Offset) {
            String[] ShowFrame=Frames[Offset].split("\r\n");
            int i=0;
            for (String L:ShowFrame)
            {
                UILink.SetRowText(i,L);
                i++;
            }
        }


    }

