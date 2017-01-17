package com.bwie.myitem.model.imodel;

import com.bwie.library.mvp.ibase.IBaseModel;
import com.bwie.myitem.model.listener.OnGetWeChatListener;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/5.
 */

public interface IWeChatModle extends IBaseModel {
    void getDate(OnGetWeChatListener listener );
    void getRefreshData(OnGetWeChatListener listener );
    void getLoadMoreData(OnGetWeChatListener listener);
}
