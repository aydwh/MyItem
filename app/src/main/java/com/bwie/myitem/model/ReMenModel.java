package com.bwie.myitem.model;

import com.bwie.library.net.Retrofit2Helper;
import com.bwie.myitem.api.BaseApi;
import com.bwie.myitem.bean.HotBean;
import com.bwie.myitem.model.imodel.IReMenModel;
import com.bwie.myitem.model.listener.OnGetHotListener;

import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/5.
 */

public class ReMenModel implements IReMenModel {
    String url="http://news-at.zhihu.com/api/3/";
    @Override
    public void getData(final OnGetHotListener listener) {
        Retrofit retrofit = Retrofit2Helper.getInstance().getRetrofit(url);
        BaseApi baseApi = retrofit.create(BaseApi.class);
        baseApi.getHotData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotBean>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("");
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.OnFial(e.toString());
                    }

                    @Override
                    public void onNext(HotBean hotBean) {
                        listener.OnSuccess(hotBean);
                    }
                });

    }

    @Override
    public void onDestroy() {

    }
}
