package com.bwie.myitem.presenter.tvpresenter;

import com.bwie.library.mvp.BasePresenter;
import com.bwie.myitem.bean.tvbean.OtherBean;
import com.bwie.myitem.model.imodel.IOtherModel;
import com.bwie.myitem.model.listener.OnGetDataOther;
import com.bwie.myitem.model.tvmodel.OtherModel;
import com.bwie.myitem.view.tvview.IOtherView;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/9.
 */

public class OtherPresenter extends BasePresenter<IOtherModel,IOtherView> {
    private IOtherView mIOtherView;
    public OtherPresenter(IOtherView iOtherView) {
        super(iOtherView);
        mIOtherView=iOtherView;
    }

    @Override
    protected IOtherModel createModel() {
        return new OtherModel();
    }
    public void initData(String name){
        mModel.getDate1(new OnGetDataOther() {
            @Override
            public void OnSuccess(OtherBean otherBean) {
                mView.OnSuccess(otherBean);
            }

            @Override
            public void OnFial(String str) {
                mView.OnFial(str);
            }
        },name);
    }
}
