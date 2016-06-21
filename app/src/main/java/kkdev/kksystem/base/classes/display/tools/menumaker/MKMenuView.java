/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.display.tools.menumaker;

import static kkdev.kksystem.base.classes.display.pages.PageConsts.KK_DISPLAY_PAGES_SIMPLEMENU_TXT_C1RX_PREFIX;
import kkdev.kksystem.base.classes.display.pages.framesKeySet;

/**
 *
 * @author blinov_is
 */
public class MKMenuView {

    private int menuRowCount;

    public MKMenuItem[] displayedMenu;
   // public HashMap TemplateKeys;

    public static final String DEF_MENU_ITEM_PFX = "SYSMENU_";
    public static final String DEF_MENU_SELECTOR_PFX = "SEL_";
   
    private int currentViewPosition = 0;
    private int selectorPosition = 0;

    private int viewRowCount;

    public MKMenuView(int ViewRows, int MenuRows) {
        displayedMenu = new MKMenuItem[MenuRows];
        menuRowCount = MenuRows;
        viewRowCount = ViewRows;

    }

    public void resetMenuView(int MenuRows) {
        currentViewPosition = 0;
        selectorPosition = 0;
        menuRowCount = MenuRows;
        displayedMenu = new MKMenuItem[MenuRows];
    }
    

    public void setItemData(int Position, MKMenuItem MenuItem) {
        displayedMenu[Position] = MenuItem;

    }

    public framesKeySet getMenu() {
        return getView();
    }

    public framesKeySet moveMenuUP() {
       if (menuRowCount==1)
            return getView();
       
        if (selectorPosition > 0) {
            selectorPosition--;
        } else {
            if (currentViewPosition == 0) {
                if (menuRowCount>viewRowCount)
                {
                    currentViewPosition = menuRowCount - viewRowCount;
                    selectorPosition = viewRowCount-1;
                }
                else
                {
                    selectorPosition = menuRowCount-1;
                }
            } else {
                currentViewPosition--;
            }
        }
        return getView();
    }

    public framesKeySet moveMenuDown() {
        if (menuRowCount==1)
            return getView();
        
        
        if ((selectorPosition < viewRowCount - 1) & (selectorPosition<menuRowCount)) {
            selectorPosition++;
        } else {
            if (((currentViewPosition + viewRowCount) > menuRowCount - 1) | (selectorPosition==menuRowCount-1)) {
                currentViewPosition = 0;
                selectorPosition = 0;
            } else {
                currentViewPosition++;
            }
        }
        
        return getView();

    }

    public MKMenuItem getCurrentMenuItem()
    {
        return displayedMenu[currentViewPosition+selectorPosition];
    }

    public framesKeySet getView() {
        framesKeySet Ret;
        Ret = new framesKeySet(); 
        //
        for (int i = 0; i < viewRowCount; i++) {
            if ((i>=menuRowCount))
            {
                Ret.addKeySet(DEF_MENU_ITEM_PFX + i, ""); //if only one item in menu, set empty position
            }
            else
            {
               
                Ret.addKeySet(DEF_MENU_ITEM_PFX + i, displayedMenu[currentViewPosition + i].displayName);
            }
            
            
            if (i == selectorPosition) {
                Ret.addKeySet(DEF_MENU_SELECTOR_PFX+i,"*");
            } else {
                Ret.addKeySet(DEF_MENU_SELECTOR_PFX+i," ");
            }
        }
        return Ret;
    }
    
}
