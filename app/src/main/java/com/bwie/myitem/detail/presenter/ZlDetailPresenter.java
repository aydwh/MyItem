package com.bwie.myitem.detail.presenter;

import com.bwie.library.mvp.BasePresenter;
import com.bwie.myitem.bean.ZlDetailBean;
import com.bwie.myitem.detail.model.ZlDetailModel;
import com.bwie.myitem.detail.model.idetailmodel.IZlDetailModel;
import com.bwie.myitem.detail.model.idetailmodel.OnZdetailListener;
import com.bwie.myitem.detail.view.IZlDetailView;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/7.
 */

public class ZlDetailPresenter extends BasePresenter<IZlDetailModel,IZlDetailView> {
    private IZlDetailView mIZlDetailView;
    public ZlDetailPresenter(IZlDetailView iZlDetailView) {
        super(iZlDetailView);
        mIZlDetailView=iZlDetailView;
    }

    @Override
    protected IZlDetailModel createModel() {
        return new ZlDetailModel();
    }
    public void initData(int id){
        mModel.getData(new OnZdetailListener() {
            @Override
            public void OnSuccess(ZlDetailBean zlDetailBean) {
                mView.OnSuccess(zlDetailBean);
            }

            @Override
            public void OnFial(String str) {
                mView.OnFial(str);
            }
        },id);

    }
}
