package com.bwie.myitem.model;

import com.bwie.library.net.ICallback;
import com.bwie.myitem.bean.NewsBean;
import com.bwie.myitem.detail.model.mymodel.MyRbModel;
import com.bwie.myitem.model.imodel.IRiBaoModel;
import com.bwie.myitem.model.listener.OnGetDataListener;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/3.
 */

public class RiBaoModel extends MyRbModel implements IRiBaoModel {

    @Override
    public void onDestroy() {

    }

    @Override
    public void getData(final OnGetDataListener listener) {
        deploy(getApi().getNewsData(), new ICallback<NewsBean>() {
            @Override
            public void onCompleted(NewsBean newsBean) {
                listener.OnSuccess(newsBean);
            }

            @Override
            public void onFailed(String errMsg) {
                listener.OnFial(errMsg);
            }
        });
    }
}
