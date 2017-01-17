package com.bwie.myitem.view;

import com.bwie.library.mvp.ibase.IBaseView;
import com.bwie.myitem.bean.WechatBean;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/5.
 */

public interface IWeChatView extends IBaseView {
    void OnSuccess(WechatBean wechatBean);
    void OnFile(String str);
}
