package com.bwie.myitem.view.tvview;

import com.bwie.library.mvp.ibase.IBaseView;
import com.bwie.myitem.bean.tvbean.FirstBean;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/9.
 */

public interface IFirstView extends IBaseView {
    void OnSuccess(FirstBean firstBean);
    void OnFial(String str);
}
