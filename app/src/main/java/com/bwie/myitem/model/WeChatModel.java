package com.bwie.myitem.model;

import com.bwie.library.net.ICallback;
import com.bwie.myitem.bean.WechatBean;
import com.bwie.myitem.detail.model.mymodel.MyWechatModel;
import com.bwie.myitem.model.imodel.IWeChatModle;
import com.bwie.myitem.model.listener.OnGetWeChatListener;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/5.
 */

public class WeChatModel extends MyWechatModel implements IWeChatModle {
    int page=1;

    @Override
    public void getDate(final OnGetWeChatListener listener) {
        deploy(getApi().getWChat("09691a96d0c41d30215a888632e1b96e", 10, page), new ICallback<WechatBean>() {
            @Override
            public void onCompleted(WechatBean wechatBean) {
                listener.OnSuccess(wechatBean);
            }

            @Override
            public void onFailed(String errMsg) {
                listener.OnFial(errMsg);
            }
        });
    }

    @Override
    public void getRefreshData(final OnGetWeChatListener listener) {
        int page=1;
        deploy(getApi().getWChat("09691a96d0c41d30215a888632e1b96e", 10, page), new ICallback<WechatBean>() {
            @Override
            public void onCompleted(WechatBean wechatBean) {
                listener.OnSuccess(wechatBean);
            }

            @Override
            public void onFailed(String errMsg) {
                listener.OnFial(errMsg);
            }
        });
    }

    @Override
    public void getLoadMoreData(final OnGetWeChatListener listener) {
        page++;
        deploy(getApi().getWChat("09691a96d0c41d30215a888632e1b96e", 10, page), new ICallback<WechatBean>() {
            @Override
            public void onCompleted(WechatBean wechatBean) {
                listener.OnSuccess(wechatBean);
            }

            @Override
            public void onFailed(String errMsg) {
                listener.OnFial(errMsg);
            }
        });
    }

    @Override
    public void onDestroy() {

    }

}
