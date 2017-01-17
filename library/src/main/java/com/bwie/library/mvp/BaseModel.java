package com.bwie.library.mvp;


import com.bwie.library.mvp.ibase.IBaseModel;
import com.bwie.library.net.ICallback;
import com.bwie.library.net.ResponseBean;

import java.net.SocketTimeoutException;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2016/7/11 13:29
 */
public abstract class BaseModel<E> implements IBaseModel {
    private E api;

    public E getApi() {
        return api;
    }

    public void setApi(E api) {
        this.api = api;
    }

    private Subscription mSubscription;

    protected Observable threadControl(Observable observable){
        return observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    protected Subscription subscribe(Observable observable,
                                     final ICallback callback){
        return observable
                .subscribe(new Subscriber<ResponseBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(callback!=null){
                            if(e instanceof SocketTimeoutException)
                                callback.onFailed("服务器异常");
                            else
                                callback.onFailed(e.getMessage());
                        }

                    }
                    @Override
                    public void onNext(ResponseBean response) {
                        if(callback!=null) {
                                callback.onCompleted(response);
                        }
                    }
                });
    }
    protected Subscription subscribe1(Observable observable,
                                     final ICallback callback){
        return observable
                .subscribe(new Subscriber<List<ResponseBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if(callback!=null){
                            if(e instanceof SocketTimeoutException)
                                callback.onFailed("服务器异常");
                            else
                                callback.onFailed(e.getMessage());

                    }
                    }

                    @Override
                    public void onNext(List<ResponseBean> responseBeen) {
                        if(callback!=null) {
                            callback.onCompleted(responseBeen);
                        }
                    }
    });
    }

    protected Subscription deploy(Observable observable, final ICallback callback){
        mSubscription = subscribe(threadControl(observable),callback);
        return mSubscription;
    }

    protected Subscription deploy1(Observable observable, final ICallback callback){
        mSubscription = subscribe1(threadControl(observable),callback);
        return mSubscription;
    }

    @Override
    public void onDestroy() {
        if (null != mSubscription && mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }
}
