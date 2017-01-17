package com.bwie.myitem.model.listener;

import com.bwie.myitem.bean.tvbean.FirstBean;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/9.
 */
public interface OnGetDataFirst {
    void OnSuccess(FirstBean firstBean);
    void OnFial(String str);
}
