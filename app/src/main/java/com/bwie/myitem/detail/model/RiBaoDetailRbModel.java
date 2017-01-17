package com.bwie.myitem.detail.model;

import com.bwie.library.net.ICallback;
import com.bwie.myitem.bean.RiBaoDetailBean;
import com.bwie.myitem.detail.model.idetailmodel.IRiBaoDetailModel;
import com.bwie.myitem.detail.model.idetailmodel.OnGetRiListener;
import com.bwie.myitem.detail.model.mymodel.MyRbModel;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/6.
 */

public class RiBaoDetailRbModel extends MyRbModel implements IRiBaoDetailModel {

    @Override
    public void getData(final OnGetRiListener listener, int id) {
        deploy(getApi().getNewsDetail(id), new ICallback<RiBaoDetailBean>() {


            @Override
            public void onCompleted(RiBaoDetailBean riBaoDetailBean) {
                listener.OnSuccess(riBaoDetailBean);
            }

            @Override
            public void onFailed(String errMsg) {
                listener.OnFial(errMsg);
            }
        });
    }


}
