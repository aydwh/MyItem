package com.bwie.myitem.view.tvview;

import com.bwie.library.mvp.ibase.IBaseView;
import com.bwie.myitem.bean.tvbean.TabBean;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/8.
 */

public interface ITvMainView extends IBaseView {
    void OnSuccess(List<TabBean> tabBeans);
    void OnFial(String str);
}
