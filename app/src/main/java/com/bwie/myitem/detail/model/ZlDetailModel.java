package com.bwie.myitem.detail.model;

import com.bwie.library.net.ICallback;
import com.bwie.myitem.bean.ZlDetailBean;
import com.bwie.myitem.detail.model.idetailmodel.IZlDetailModel;
import com.bwie.myitem.detail.model.idetailmodel.OnZdetailListener;
import com.bwie.myitem.detail.model.mymodel.MyRbModel;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/7.
 */

public class ZlDetailModel extends MyRbModel implements IZlDetailModel {

    @Override
    public void getData(final OnZdetailListener listener, int id) {
        deploy(getApi().getZlDetaillData(id), new ICallback<ZlDetailBean>() {

            @Override
            public void onCompleted(ZlDetailBean zlDetailBean) {
                listener.OnSuccess(zlDetailBean);
            }

            @Override
            public void onFailed(String errMsg) {
                listener.OnFial(errMsg);
            }
        });
    }
}
