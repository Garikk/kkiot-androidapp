/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.display.tools.infopage;

import java.util.HashMap;
import java.util.Map;
import kkdev.kksystem.base.classes.display.UIFramesKeySet;

/**
 *
 * @author blinov_is
 */
public class MKPageView {

    int PageSelector;
    MKPageItem[] CurrentPages;
    Map<String, Integer> PageIndex;

    public MKPageView(int CountPages) {
        CurrentPages = new MKPageItem[CountPages];
        PageIndex = new HashMap<>();
    }

    public MKPageItem MovePageNext() {
        if (CurrentPages.length == 1) {
            return GetPage();
        }

        if (PageSelector < CurrentPages.length - 1) {
            PageSelector++;
        } else {
            PageSelector = 0;
        }

        return GetPage();
    }

    public MKPageItem MovePagePrev() {
        if (CurrentPages.length == 1) {
            return GetPage();
        }

        if (PageSelector > 0) {
            PageSelector--;
        } else {
            PageSelector = CurrentPages.length - 1;
        }

        return GetPage();
    }

    public void SetPageData(int Position, MKPageItem Page) {
        CurrentPages[Position] = Page;
        if (!PageIndex.containsKey(Page.PageName)) {
            PageIndex.put(Page.PageName, Position);
        }
    }

    public MKPageItem GetPage() {
        return CurrentPages[PageSelector];
    }

    public void UpdateUIFrames(String PageName, UIFramesKeySet Frames) {
        CurrentPages[PageIndex.get(PageName)].UIFrames = Frames;
    }
}
