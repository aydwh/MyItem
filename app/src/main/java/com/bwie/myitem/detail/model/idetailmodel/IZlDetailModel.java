package com.bwie.myitem.detail.model.idetailmodel;

import com.bwie.library.mvp.ibase.IBaseModel;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/7.
 */

public interface IZlDetailModel extends IBaseModel {
    void getData(OnZdetailListener listener,int id);
}
