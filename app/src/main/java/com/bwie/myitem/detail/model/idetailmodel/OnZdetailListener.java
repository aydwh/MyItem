package com.bwie.myitem.detail.model.idetailmodel;

import com.bwie.myitem.bean.ZlDetailBean;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/7.
 */
public interface OnZdetailListener {
    void OnSuccess(ZlDetailBean zlDetailBean);
    void OnFial(String str);
}
