package com.bwie.myitem.detail.model.idetailmodel;

import com.bwie.myitem.bean.RiBaoDetailBean;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/6.
 */
public interface OnGetRiListener {
    void OnSuccess(RiBaoDetailBean riBaoDetailBean);
    void OnFial(String str);
}
