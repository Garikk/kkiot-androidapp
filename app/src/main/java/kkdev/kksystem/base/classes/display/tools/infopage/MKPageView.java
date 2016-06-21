/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.display.tools.infopage;

import java.util.HashMap;
import java.util.Map;
import kkdev.kksystem.base.classes.display.pages.framesKeySet;

/**
 *
 * @author blinov_is
 */
public class MKPageView {

    int pageSelector;
    MKPageItem[] currentPages;
    Map<String, Integer> pageIndex;

    public MKPageView(int CountPages) {
        currentPages = new MKPageItem[CountPages];
        pageIndex = new HashMap<>();
    }

    public MKPageItem movePageNext() {
        if (currentPages.length == 1) {
            return getPage();
        }

        if (pageSelector < currentPages.length - 1) {
            pageSelector++;
        } else {
            pageSelector = 0;
        }

        return getPage();
    }

    public MKPageItem movePagePrev() {
        if (currentPages.length == 1) {
            return getPage();
        }

        if (pageSelector > 0) {
            pageSelector--;
        } else {
            pageSelector = currentPages.length - 1;
        }

        return getPage();
    }

    public void setPageData(int Position, MKPageItem Page) {
        currentPages[Position] = Page;
        if (!pageIndex.containsKey(Page.pageName)) {
            pageIndex.put(Page.pageName, Position);
        }
    }

    public MKPageItem getPage() {
        return currentPages[pageSelector];
    }

    public void updateUIFrames(String PageName, framesKeySet Frames) {
        currentPages[pageIndex.get(PageName)].pageFrames = Frames;
    }
}
