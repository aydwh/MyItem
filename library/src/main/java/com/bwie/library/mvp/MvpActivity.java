package com.bwie.library.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.bwie.library.mvp.ibase.IBasePresenter;
import com.bwie.library.mvp.ibase.IBaseView;


/**
 * 类描述：MVP架构下的Activity基类
 * 创建人：yekh
 * 创建时间：2016/7/6 10:27
 */
public abstract class MvpActivity<P extends IBasePresenter> extends BaseActivity {


    protected P mPresenter;

    protected abstract P createPresenter(IBaseView view);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter = createPresenter(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        //避免Presenter持有该对象，先销毁Presenter
        if (null != mPresenter) {
            mPresenter.onDestroy();
        }
        super.onDestroy();
    }
}