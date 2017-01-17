package com.bwie.myitem.model.tvmodel;

import com.bwie.library.net.ICallback;
import com.bwie.myitem.bean.tvbean.OtherBean;
import com.bwie.myitem.detail.model.mymodel.MyTvModel;
import com.bwie.myitem.model.imodel.IOtherModel;
import com.bwie.myitem.model.listener.OnGetDataOther;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/9.
 */

public class OtherModel extends MyTvModel implements IOtherModel {

    @Override
    public void getDate1(final OnGetDataOther dataOther,String name) {
        deploy(getApi().getOtherList(name), new ICallback<OtherBean>() {

            @Override
            public void onCompleted(OtherBean otherBean) {
                dataOther.OnSuccess(otherBean);
            }

            @Override
            public void onFailed(String errMsg) {
                dataOther.OnFial(errMsg);
            }
        });
    }
}
