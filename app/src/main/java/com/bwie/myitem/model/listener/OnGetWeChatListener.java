package com.bwie.myitem.model.listener;

import com.bwie.myitem.bean.WechatBean;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/5.
 */
public interface OnGetWeChatListener {
    void OnSuccess(WechatBean wechatBean);
    void OnFial(String str);
}
