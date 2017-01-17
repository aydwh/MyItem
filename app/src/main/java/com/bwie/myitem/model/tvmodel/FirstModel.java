package com.bwie.myitem.model.tvmodel;

import com.bwie.library.net.ICallback;
import com.bwie.myitem.bean.tvbean.FirstBean;
import com.bwie.myitem.detail.model.mymodel.MyTvModel;
import com.bwie.myitem.model.imodel.IFirstModel;
import com.bwie.myitem.model.listener.OnGetDataFirst;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/9.
 */

public class FirstModel extends MyTvModel implements IFirstModel {
    @Override
    public void getDate1(final OnGetDataFirst dateFirst) {
        deploy(getApi().getFirstList(), new ICallback<FirstBean>() {

            @Override
            public void onCompleted(FirstBean firstBean) {
                dateFirst.OnSuccess(firstBean);
            }

            @Override
            public void onFailed(String errMsg) {
                dateFirst.OnFial(errMsg);
            }
        });
    }
}
