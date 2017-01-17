package com.bwie.myitem.model.listener;

import com.bwie.myitem.bean.NewsBean;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/3.
 */
public interface OnGetDataListener {
    void OnSuccess(NewsBean newsBean);
    void OnFial(String str);

}
