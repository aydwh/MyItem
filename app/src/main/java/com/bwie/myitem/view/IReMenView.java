package com.bwie.myitem.view;

import com.bwie.library.mvp.ibase.IBaseView;
import com.bwie.myitem.bean.HotBean;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/5.
 */

public interface IReMenView extends IBaseView {
    void OnSuccess(HotBean hotBean);
    void OnFile(String str);
}
