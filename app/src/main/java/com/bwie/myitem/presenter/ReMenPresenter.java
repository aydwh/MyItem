package com.bwie.myitem.presenter;

import com.bwie.library.mvp.BasePresenter;
import com.bwie.myitem.bean.HotBean;
import com.bwie.myitem.model.ReMenModel;
import com.bwie.myitem.model.imodel.IReMenModel;
import com.bwie.myitem.model.listener.OnGetHotListener;
import com.bwie.myitem.view.IReMenView;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/5.
 */

public class ReMenPresenter extends BasePresenter<IReMenModel,IReMenView> {
    private IReMenView mIReMenView;
    public ReMenPresenter(IReMenView iReMenView) {
        super(iReMenView);
        mIReMenView=iReMenView;
    }

    @Override
    protected IReMenModel createModel() {
        return new ReMenModel();
    }
    public void initData(){
        mModel.getData(new OnGetHotListener() {
            @Override
            public void OnSuccess(HotBean hotBean) {
                mView.OnSuccess(hotBean);
            }

            @Override
            public void OnFial(String str) {
                mView.OnFile(str);
            }
        });
    }
}
