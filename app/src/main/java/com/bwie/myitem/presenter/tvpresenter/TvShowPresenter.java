package com.bwie.myitem.presenter.tvpresenter;

import com.bwie.library.mvp.BasePresenter;
import com.bwie.myitem.bean.tvbean.ShowTvBean;
import com.bwie.myitem.model.imodel.ITvShowModel;
import com.bwie.myitem.model.listener.OnGetDataShow;
import com.bwie.myitem.model.tvmodel.TvShowModel;
import com.bwie.myitem.view.tvview.ITvShowView;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/12.
 */

public class TvShowPresenter extends BasePresenter<ITvShowModel,ITvShowView> {
    private ITvShowView mITvShowView;
    public TvShowPresenter(ITvShowView iTvShowView) {
        super(iTvShowView);
        mITvShowView=iTvShowView;
    }

    @Override
    protected ITvShowModel createModel() {
        return new TvShowModel();
    }
    public void initDataShow(String uid){
        mModel.getDataShow(new OnGetDataShow() {
            @Override
            public void OnSuccess(ShowTvBean showTvBean) {
                mView.OnSuccess(showTvBean);
            }

            @Override
            public void OnFial(String str) {
                mView.OnFial(str);
            }
        },uid);
    }
}
