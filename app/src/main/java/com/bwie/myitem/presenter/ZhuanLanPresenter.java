package com.bwie.myitem.presenter;

import com.bwie.library.mvp.BasePresenter;
import com.bwie.myitem.bean.SpecialBean;
import com.bwie.myitem.model.imodel.IZhuanLanModel;
import com.bwie.myitem.model.listener.OnZhuanLanListener;
import com.bwie.myitem.model.ZhuanLanModel;
import com.bwie.myitem.view.IZhuanLanView;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/4.
 */

public class ZhuanLanPresenter extends BasePresenter<IZhuanLanModel,IZhuanLanView> {
        private IZhuanLanView mIZhuanLanView;
    public ZhuanLanPresenter(IZhuanLanView iZhuanLanView) {
        super(iZhuanLanView);
       mIZhuanLanView=iZhuanLanView;

    }

    @Override
    protected IZhuanLanModel createModel() {
        return new ZhuanLanModel();
    }
    public void initData(){
        mModel.getData(new OnZhuanLanListener() {
            @Override
            public void OnSuccess(SpecialBean specialBean) {
                mIZhuanLanView.OnSuccess(specialBean);
            }

            @Override
            public void OnFial(String str) {
                mIZhuanLanView.OnFile(str);
            }
        });
    }
}
