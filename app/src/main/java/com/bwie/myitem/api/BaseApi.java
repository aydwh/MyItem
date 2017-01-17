package com.bwie.myitem.api;

import com.bwie.myitem.bean.HotBean;
import com.bwie.myitem.bean.NewsBean;
import com.bwie.myitem.bean.RiBaoDetailBean;
import com.bwie.myitem.bean.SpecialBean;
import com.bwie.myitem.bean.WechatBean;
import com.bwie.myitem.bean.ZlDetailBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/3.
 */

public interface BaseApi {
    /**
     * 最新日报
     */
    @GET("news/latest")
    Observable<NewsBean> getNewsData();

    /**
     * 专栏日报
     */
    @GET("sections")
    Observable<SpecialBean> getSpecilData();
    /**
     * 专栏详情1
     */
    @GET("section/{id}")
    Observable<ZlDetailBean> getZlDetaillData(@Path("id") int id);

    /**
     * 微信精选列表
     */
    @GET("wxnew")
    Observable<WechatBean> getWChat(@Query("key") String key, @Query("num") int num, @Query("page") int page);
    /**
     * 热门
     */
    @GET("news/hot")
    Observable<HotBean> getHotData();
    /**
     * 日报详情
     */
    @GET("news/{id}")
    Observable<RiBaoDetailBean> getNewsDetail(@Path("id") int id);
}
