package kkdev.kksystem.kkcarandroid.leddebug;

/**
 * Created by sayma_000 on 06.03.2016.
 */
    public class DisplayHW  {
        public static enum HWHostTypes
        {
            Android
        }
        public static enum HWDisplayTypes
        {
            LCDDebugDisplay
        }

        public String HWDisplayName;
        public HWHostTypes HWBoard;
        public HWDisplayTypes HWDisplay;
        public int[] HWBoardPins;



    }

