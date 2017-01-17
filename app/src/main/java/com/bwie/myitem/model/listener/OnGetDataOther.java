package com.bwie.myitem.model.listener;

import com.bwie.myitem.bean.tvbean.OtherBean;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/9.
 */
public interface OnGetDataOther {
    void OnSuccess(OtherBean otherBean);
    void OnFial(String str);
}
