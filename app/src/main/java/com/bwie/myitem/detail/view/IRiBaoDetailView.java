package com.bwie.myitem.detail.view;

import com.bwie.library.mvp.ibase.IBaseView;
import com.bwie.myitem.bean.RiBaoDetailBean;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/6.
 */

public interface IRiBaoDetailView extends IBaseView {
    void OnSuccess(RiBaoDetailBean riBaoDetailBean);
    void OnFial(String str);
}
