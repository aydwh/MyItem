package com.bwie.myitem.act;

import android.content.Intent;
import android.os.Bundle;

import com.bwie.library.mvp.BaseActivity;
import com.bwie.library.utils.StatusBarUtil;
import com.bwie.myitem.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class FlashActivity extends BaseActivity {


    @Override
    public int bindLayout() {
        StatusBarUtil.setTranslucent(this);
        return R.layout.activity_flash;
    }

    @Override
    public void initVariables() {

    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        Observable.timer(2000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        if (!isFinishing())
                            startActivity(new Intent(FlashActivity.this,MainActivity.class));
                    }
                })
                .isUnsubscribed();
    }




    @Override
    public void loadData() {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        finish();
    }
}
