package com.bwie.myitem.detail.presenter;

import com.bwie.library.mvp.BasePresenter;
import com.bwie.myitem.bean.RiBaoDetailBean;
import com.bwie.myitem.detail.model.idetailmodel.IRiBaoDetailModel;
import com.bwie.myitem.detail.model.idetailmodel.OnGetRiListener;
import com.bwie.myitem.detail.model.RiBaoDetailRbModel;
import com.bwie.myitem.detail.view.IRiBaoDetailView;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/6.
 */

public class RiBaoDetailPresenter extends BasePresenter<IRiBaoDetailModel,IRiBaoDetailView> {
    private IRiBaoDetailView mIRiBaoDetailView;
    public RiBaoDetailPresenter(IRiBaoDetailView iRiBaoDetailView) {
        super(iRiBaoDetailView);
        mIRiBaoDetailView=iRiBaoDetailView;
    }

    @Override
    protected IRiBaoDetailModel createModel() {
        return new RiBaoDetailRbModel();
    }
    public void initData(int id){
        mModel.getData(new OnGetRiListener() {
            @Override
            public void OnSuccess(RiBaoDetailBean riBaoDetailBean) {
                mView.OnSuccess(riBaoDetailBean);
            }

            @Override
            public void OnFial(String str) {
                mView.OnFial(str);
            }
        },id);

    }
}
