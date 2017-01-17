package com.bwie.myitem.model.imodel;

import com.bwie.library.mvp.ibase.IBaseModel;
import com.bwie.myitem.model.listener.OnGetDataFirst;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/9.
 */

public interface IFirstModel extends IBaseModel {
    void getDate1(OnGetDataFirst dateFirst);
}
