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
public class PinBaseDataTaggedObj extends PinBaseData {
    
    public PinBaseDataTaggedObj()
    {
        this.dataType=BASE_DATA_TYPE.TAGGED_OBJ;
    }
    public String tag;
    public Object value;
}
