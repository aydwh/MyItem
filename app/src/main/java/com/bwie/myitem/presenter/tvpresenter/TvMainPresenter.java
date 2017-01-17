package com.bwie.myitem.presenter.tvpresenter;

import com.bwie.library.mvp.BasePresenter;
import com.bwie.myitem.bean.tvbean.TabBean;
import com.bwie.myitem.model.tvmodel.TvMainModel;
import com.bwie.myitem.model.imodel.ITvMainModel;
import com.bwie.myitem.model.listener.OnGettvMainListener;
import com.bwie.myitem.view.tvview.ITvMainView;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/8.
 */

public class TvMainPresenter extends BasePresenter<ITvMainModel,ITvMainView> {
    private ITvMainView mITvMainView;
    public TvMainPresenter(ITvMainView iTvMainView) {
        super(iTvMainView);
        mITvMainView=iTvMainView;
    }

    @Override
    protected ITvMainModel createModel() {
        return new TvMainModel();
    }
    public void initDate(){
        mModel.getDate(new OnGettvMainListener() {
            @Override
            public void OnSuccess(List<TabBean> tabBeans) {
                mView.OnSuccess(tabBeans);
            }

            @Override
            public void OnFial(String str) {
                mView.OnFial(str);
            }
        });
    }
}
