package com.bwie.myitem.detail.model.idetailmodel;

import com.bwie.library.mvp.ibase.IBaseModel;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/6.
 */

public interface IRiBaoDetailModel extends IBaseModel{
    void getData(OnGetRiListener listener, int id);
}
