package com.bwie.myitem.view.tvview;

import com.bwie.library.mvp.ibase.IBaseView;
import com.bwie.myitem.bean.tvbean.ShowTvBean;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/12.
 */

public interface ITvShowView extends IBaseView{
    void OnSuccess(ShowTvBean showTvBean);
    void OnFial(String str);
}
