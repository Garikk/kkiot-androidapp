/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.base;


/**
 *
 * @author blinov_is
 */
public class PinBaseDataTaggedInt extends PinBaseData {

    public PinBaseDataTaggedInt()
    {
        this.dataType=BASE_DATA_TYPE.TAGGED_INT;
    }
    public String tag;
    public int value;
}
