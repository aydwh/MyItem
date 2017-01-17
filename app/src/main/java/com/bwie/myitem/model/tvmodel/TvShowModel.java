package com.bwie.myitem.model.tvmodel;

import com.bwie.library.net.ICallback;
import com.bwie.myitem.bean.tvbean.ShowTvBean;
import com.bwie.myitem.detail.model.mymodel.MyTvModel;
import com.bwie.myitem.model.imodel.ITvShowModel;
import com.bwie.myitem.model.listener.OnGetDataShow;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/12.
 */

public class TvShowModel extends MyTvModel implements ITvShowModel {

    @Override
    public void getDataShow(final OnGetDataShow dataShow, String uid) {
        deploy(getApi().getTvShow(uid), new ICallback<ShowTvBean>() {

            @Override
            public void onCompleted(ShowTvBean showTvBean) {
                dataShow.OnSuccess(showTvBean);
            }

            @Override
            public void onFailed(String errMsg) {
                dataShow.OnFial(errMsg);
            }
        });
    }
}
