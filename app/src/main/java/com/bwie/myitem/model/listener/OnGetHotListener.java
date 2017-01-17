package com.bwie.myitem.model.listener;

import com.bwie.myitem.bean.HotBean;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/5.
 */
public interface OnGetHotListener {
    void OnSuccess(HotBean hotBean);
    void OnFial(String str);
}
