package com.bwie.myitem.presenter;


import com.bwie.library.mvp.BasePresenter;
import com.bwie.myitem.bean.NewsBean;
import com.bwie.myitem.model.imodel.IRiBaoModel;
import com.bwie.myitem.model.listener.OnGetDataListener;
import com.bwie.myitem.model.RiBaoModel;
import com.bwie.myitem.view.IView;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/3.
 */

public class RiBaoPresenter extends BasePresenter<IRiBaoModel,IView> {


    private IView mIView;
    public RiBaoPresenter(IView iView) {
        super(iView);
        mIView=iView;

    }

    @Override
    protected IRiBaoModel createModel() {

        return new RiBaoModel();
    }
    public void initDate(){
        mModel.getData(new OnGetDataListener() {
            @Override
            public void OnSuccess(NewsBean newsBean) {
                mIView.OnSuccess(newsBean);

            }

            @Override
            public void OnFial(String str) {
                mIView.OnFile(str);
            }
        });
    }

}
