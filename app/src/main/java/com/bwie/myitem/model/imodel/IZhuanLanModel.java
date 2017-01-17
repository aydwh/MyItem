package com.bwie.myitem.model.imodel;

import com.bwie.library.mvp.ibase.IBaseModel;
import com.bwie.myitem.model.listener.OnZhuanLanListener;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/4.
 */

public interface IZhuanLanModel extends IBaseModel{
    void getData(OnZhuanLanListener listener);
}
