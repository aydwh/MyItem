package com.bwie.myitem.detail.model.mymodel;

import com.bwie.library.mvp.BaseModel;
import com.bwie.library.net.Retrofit2Helper;
import com.bwie.myitem.api.TvApi;

import retrofit2.Retrofit;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/7.
 */

public class MyTvModel extends BaseModel<TvApi> {
    String url="http://www.quanmin.tv/";
    public MyTvModel() {
        Retrofit retrofit = Retrofit2Helper.getInstance().getRetrofit(url);
        TvApi tvApi = retrofit.create(TvApi.class);
        setApi(tvApi);

    }
}
