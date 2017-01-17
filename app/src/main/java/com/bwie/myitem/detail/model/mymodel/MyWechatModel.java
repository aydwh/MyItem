package com.bwie.myitem.detail.model.mymodel;

import com.bwie.library.mvp.BaseModel;
import com.bwie.library.net.Retrofit2Helper;
import com.bwie.myitem.api.BaseApi;

import retrofit2.Retrofit;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/7.
 */

public class MyWechatModel extends BaseModel<BaseApi> {
    String url="http://api.tianapi.com/";

    public MyWechatModel() {
        Retrofit retrofit = Retrofit2Helper.getInstance().getRetrofit(url);
        BaseApi baseApi = retrofit.create(BaseApi.class);
        setApi(baseApi);
    }
}
