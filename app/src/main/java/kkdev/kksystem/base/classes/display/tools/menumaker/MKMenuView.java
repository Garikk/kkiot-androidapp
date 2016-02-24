/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.display.tools.menumaker;

import kkdev.kksystem.base.classes.display.UIFramesKeySet;

/**
 *
 * @author blinov_is
 */
public class MKMenuView {

    private int MenuRowCount;

    public MKMenuItem[] DisplayedMenu;
   // public HashMap TemplateKeys;

    public static final String DEF_MENU_ITEM_PFX = "SYSMENU_";
    public static final String DEF_MENU_SELECTOR_PFX = "SEL_";
    public static final String DEF_MENU_PAGE = "SYSMENU_1";

    private int CurrentViewPosition = 0;
    private int SelectorPosition = 0;

    private int ViewRowCount;

    public MKMenuView(int ViewRows, int MenuRows) {
        DisplayedMenu = new MKMenuItem[MenuRows];
        MenuRowCount = MenuRows;
        ViewRowCount = ViewRows;

    }

    public void ResetMenuView(int MenuRows) {
        CurrentViewPosition = 0;
        SelectorPosition = 0;
        MenuRowCount = MenuRows;
        DisplayedMenu = new MKMenuItem[MenuRows];
    }
    

    public void SetItemData(int Position, MKMenuItem MenuItem) {
        DisplayedMenu[Position] = MenuItem;

    }

    public UIFramesKeySet GetMenu() {
        return GetView();
    }

    public UIFramesKeySet MoveMenuUP() {
       if (MenuRowCount==1)
            return GetView();
       
        if (SelectorPosition > 0) {
            SelectorPosition--;
        } else {
            if (CurrentViewPosition == 0) {
                CurrentViewPosition = MenuRowCount - ViewRowCount;
                SelectorPosition = ViewRowCount-1;
            } else {
                CurrentViewPosition--;
            }
        }

        return GetView();
    }

    public UIFramesKeySet MoveMenuDown() {
         // System.out.println(SelectorPosition + " " +ViewRowCount + " "+ MenuRowCount);
        if (MenuRowCount==1)
            return GetView();
        
        
        if (SelectorPosition < ViewRowCount - 1) {
            SelectorPosition++;
        } else {
            if ((CurrentViewPosition + ViewRowCount) > MenuRowCount - 1) {
                CurrentViewPosition = 0;
                SelectorPosition = 0;
            } else {
                CurrentViewPosition++;
            }
        }

        return GetView();

    }

    public MKMenuItem GetCurrentMenuItem()
    {
        return DisplayedMenu[CurrentViewPosition+SelectorPosition];
    }

    public UIFramesKeySet GetView() {
        UIFramesKeySet Ret;
        Ret = new UIFramesKeySet(); 
        //
        for (int i = 0; i < ViewRowCount; i++) {
            if (MenuRowCount==1 & i==1)
                Ret.AddKeySet(DEF_MENU_ITEM_PFX + i, ""); //if only one item in menu, set empty position
            else
            {
                Ret.AddKeySet(DEF_MENU_ITEM_PFX + i, DisplayedMenu[CurrentViewPosition + i].DisplayName);
            }
            
            
            if (i == SelectorPosition) {
                Ret.AddKeySet(DEF_MENU_SELECTOR_PFX+i,"*");
            } else {
                Ret.AddKeySet(DEF_MENU_SELECTOR_PFX+i," ");
            }
        }
        return Ret;
    }
    
}
