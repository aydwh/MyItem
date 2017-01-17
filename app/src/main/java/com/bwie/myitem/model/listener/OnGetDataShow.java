package com.bwie.myitem.model.listener;

import com.bwie.myitem.bean.tvbean.ShowTvBean;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/12.
 */
public interface OnGetDataShow {
    void OnSuccess(ShowTvBean showTvBean);
    void OnFial(String str);
}
