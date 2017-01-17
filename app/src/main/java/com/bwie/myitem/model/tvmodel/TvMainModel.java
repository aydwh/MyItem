package com.bwie.myitem.model.tvmodel;

import com.bwie.library.net.ICallback;
import com.bwie.myitem.bean.tvbean.TabBean;
import com.bwie.myitem.detail.model.mymodel.MyTvModel;
import com.bwie.myitem.model.imodel.ITvMainModel;
import com.bwie.myitem.model.listener.OnGettvMainListener;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/8.
 */

public class TvMainModel extends MyTvModel implements ITvMainModel {


    @Override
    public void getDate(final OnGettvMainListener listener) {
        deploy1(getApi().getTabList(), new ICallback<List<TabBean>>() {

            @Override
            public void onCompleted(List<TabBean> tabBeens) {
                listener.OnSuccess(tabBeens);
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
