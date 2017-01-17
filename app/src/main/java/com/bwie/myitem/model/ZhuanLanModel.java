package com.bwie.myitem.model;

import com.bwie.library.net.ICallback;
import com.bwie.myitem.bean.SpecialBean;
import com.bwie.myitem.detail.model.mymodel.MyRbModel;
import com.bwie.myitem.model.imodel.IZhuanLanModel;
import com.bwie.myitem.model.listener.OnZhuanLanListener;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/4.
 */

public class ZhuanLanModel extends MyRbModel implements IZhuanLanModel {

    @Override
    public void onDestroy() {

    }

    @Override
    public void getData(final OnZhuanLanListener listener) {
        deploy(getApi().getSpecilData(), new ICallback<SpecialBean>() {
            @Override
            public void onCompleted(SpecialBean specialBean) {
                listener.OnSuccess(specialBean);
            }

            @Override
            public void onFailed(String errMsg) {
                listener.OnFial(errMsg);
            }
        });
    }
}