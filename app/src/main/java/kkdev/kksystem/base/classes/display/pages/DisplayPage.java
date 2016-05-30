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
    public final String DP_COUNT_PREFIX="[$COUNT]";
    public String PageName;         //ID
    public boolean DynamicElements; //want to exec anmimation by thread
    public boolean IsDefaultPage;
    public boolean IsMultifeaturePage;  //Page available in all features
    //
    public String[] Features;
    //
    public String[] UIContexts;         //links to HWDisplays
    //
    public UIFramePack UIFramesPack;
    //
    public  String[] UIFrames;
    public  UIFramesKeySet UIFramesValues;
    
    public DisplayPage GetInstance()
    {
        DisplayPage Ret;
        Ret=new DisplayPage();
        Ret.Features=this.Features;
        Ret.UIContexts=this.UIContexts;
        Ret.UIFramesPack=this.UIFramesPack;
        Ret.UIFrames=this.UIFrames;
        Ret.UIFramesValues=this.UIFramesValues;
        Ret.PageName=this.PageName;
        Ret.DynamicElements=this.DynamicElements;
        Ret.IsDefaultPage=this.IsDefaultPage;
        Ret.IsMultifeaturePage=this.IsMultifeaturePage;
        
        return Ret;
    }
   
     public void InitUIFrames() {
        int i=0;
        UIFrames = new String[UIFramesPack.Data.length];
        for (UIFrameData FrameData : UIFramesPack.Data) {
           UIFrames[i]=FrameData.FrameData;
           i++;
           
        }
    }
     
     public String[] GetUIContexts()
     {
         return UIContexts;
     }
   
     public void InitUIFrames(int RowCount)
     {
        InitUIFrames();
        String Template="";

        
         for (int i = 0; i < UIFrames.length; i++) {
             if (!UIFrames[i].contains(DP_COUNT_PREFIX))
                 continue;
             
             for (int ii = 0; ii < RowCount; ii++) {
                 if (ii == 0) {
                     Template = UIFrames[i];
                     UIFrames[i]=Template.replace(DP_COUNT_PREFIX, String.valueOf(ii));
                 }
                 else
                 {
                    UIFrames[i] = UIFrames[i] + Template.replace(DP_COUNT_PREFIX, String.valueOf(ii));
                 }
             }
         }
     }
    
 }

