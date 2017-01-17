package com.bwie.myitem.presenter.tvpresenter;

import com.bwie.library.mvp.BasePresenter;
import com.bwie.myitem.bean.tvbean.FirstBean;
import com.bwie.myitem.model.imodel.IFirstModel;
import com.bwie.myitem.model.listener.OnGetDataFirst;
import com.bwie.myitem.model.tvmodel.FirstModel;
import com.bwie.myitem.view.tvview.IFirstView;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/9.
 */

public class FirstPresenter extends BasePresenter<IFirstModel,IFirstView> {
    private IFirstView mIFirstView;
    public FirstPresenter(IFirstView iFirstView) {
        super(iFirstView);
        mIFirstView =iFirstView;
    }

    @Override
    protected IFirstModel createModel() {
        return new FirstModel();
    }
    public void initFirstDate(){
        mModel.getDate1(new OnGetDataFirst() {
            @Override
            public void OnSuccess(FirstBean firstBean) {
                mView.OnSuccess(firstBean);
            }

            @Override
            public void OnFial(String str) {
                mView.OnFial(str);
            }
        });
    }
}
