package com.bwie.myitem.view;

import com.bwie.library.mvp.ibase.IBaseView;
import com.bwie.myitem.bean.NewsBean;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/3.
 */

public interface IView extends IBaseView {
    void OnSuccess(NewsBean newsBean);
    void OnFile(String str);
}
