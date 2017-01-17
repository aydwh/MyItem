package com.bwie.myitem.model.listener;

import com.bwie.myitem.bean.SpecialBean;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/4.
 */
public interface OnZhuanLanListener {
    void OnSuccess(SpecialBean specialBean);
    void OnFial(String str);
}
