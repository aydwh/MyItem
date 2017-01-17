package com.bwie.myitem.api;


import com.bwie.myitem.bean.tvbean.FirstBean;
import com.bwie.myitem.bean.tvbean.OtherBean;
import com.bwie.myitem.bean.tvbean.ShowTvBean;
import com.bwie.myitem.bean.tvbean.TabBean;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/8.
 */

public interface TvApi {
    @GET("json/app/index/category/info-android.json?v=2.2.4&os=1&ver=4")
    Observable<List<TabBean>> getTabList();
    @GET("json/app/index/recommend/list-android.json?11241742&v=2.2.4&os=1&ver=4")
    Observable<FirstBean> getFirstList();
    @GET("json%2Fcategories%2F{name}%2Flist.json?11211639&os=1&v=2.2.4&os=1&ver=4")
    Observable<OtherBean> getOtherList(@Path("name") String name);
    @GET("json/rooms/{uid}/info1.json?11241653&v=2.2.4&os=1&ver=4")
    Observable<ShowTvBean> getTvShow(@Path("uid") String uid);

}
