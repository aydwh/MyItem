package com.bwie.myitem.view.tvview;

import com.bwie.library.mvp.ibase.IBaseView;
import com.bwie.myitem.bean.tvbean.OtherBean;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/9.
 */

public interface IOtherView extends IBaseView {
    void OnSuccess(OtherBean otherBean);
    void OnFial(String str);
}
