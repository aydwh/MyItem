package com.bwie.myitem.detail.view;

import com.bwie.library.mvp.ibase.IBaseView;
import com.bwie.myitem.bean.ZlDetailBean;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/7.
 */

public interface IZlDetailView extends IBaseView {
    void OnSuccess(ZlDetailBean zlDetailBean);
    void OnFial(String str);
}
