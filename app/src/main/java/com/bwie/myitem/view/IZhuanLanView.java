package com.bwie.myitem.view;

import com.bwie.library.mvp.ibase.IBaseView;
import com.bwie.myitem.bean.SpecialBean;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/4.
 */

public interface IZhuanLanView extends IBaseView {
    void OnSuccess(SpecialBean specialBean);
    void OnFile(String str);
}
