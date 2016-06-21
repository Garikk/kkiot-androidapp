/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.display.pages;

/**
 *
 * @author blinov_is
 */
public class DisplayPage {
    public static final String DP_COUNT_PREFIX="[$COUNT]";
    public String pageName;         //ID
    public boolean dynamicElements; //want to exec anmimation by thread
    public boolean isDefaultPage;
    public boolean isMultifeaturePage;  //Page available in all features
    //
    public String[] features;
    //
    public String[] contexts;         //links to HWDisplays
    //
    public UIFramePack framesPack;
    //
    public  String[] frames;
    public  framesKeySet framesValues;
    
    public DisplayPage getInstance()
    {
        DisplayPage ret;
        ret=new DisplayPage();
        ret.features=this.features;
        ret.contexts=this.contexts;
        ret.framesPack=this.framesPack;
        ret.frames=this.frames;
        ret.framesValues=this.framesValues;
        ret.pageName=this.pageName;
        ret.dynamicElements=this.dynamicElements;
        ret.isDefaultPage=this.isDefaultPage;
        ret.isMultifeaturePage=this.isMultifeaturePage;
        
        return ret;
    }
   
     public void initUIFrames() {
        int i=0;
        frames = new String[framesPack.data.length];
        for (UIFrameData FrameData : framesPack.data) {
           frames[i]=FrameData.frameData;
           i++;
           
        }
    }
     
     public String[] getUIContexts()
     {
         return contexts;
     }
   
     public void initUIFrames(int RowCount)
     {
        DisplayPage.this.initUIFrames();
        String Template="";

        
         for (int i = 0; i < frames.length; i++) {
             if (!frames[i].contains(DP_COUNT_PREFIX))
                 continue;
             
             for (int ii = 0; ii < RowCount; ii++) {
                 if (ii == 0) {
                     Template = frames[i];
                     frames[i]=Template.replace(DP_COUNT_PREFIX, String.valueOf(ii));
                 }
                 else
                 {
                    frames[i] = frames[i] + Template.replace(DP_COUNT_PREFIX, String.valueOf(ii));
                 }
             }
         }
     }
    
 }

