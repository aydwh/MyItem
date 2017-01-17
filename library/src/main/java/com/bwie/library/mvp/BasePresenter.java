package com.bwie.library.mvp;


import com.bwie.library.mvp.ibase.IBaseModel;
import com.bwie.library.mvp.ibase.IBasePresenter;
import com.bwie.library.mvp.ibase.IBaseView;

/**
 * 类描述：Presenter模块的基类，持有对应的View模块对象
 * 创建人：yekh
 * 创建时间：2016/7/6 10:21
 */
public abstract class BasePresenter<M extends IBaseModel, V extends IBaseView>
        implements IBasePresenter {

    protected V mView;

    protected M mModel;

    public BasePresenter(V v) {
        mView = v;
        mModel = createModel();
    }

    protected abstract M createModel();

    @Override
    public void onDestroy() {
        if(mModel!=null)
            mModel.onDestroy();
    }
}
