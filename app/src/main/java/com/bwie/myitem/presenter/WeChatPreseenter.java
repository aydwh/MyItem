package com.bwie.myitem.presenter;

import com.bwie.library.mvp.BasePresenter;
import com.bwie.myitem.bean.WechatBean;
import com.bwie.myitem.model.WeChatModel;
import com.bwie.myitem.model.imodel.IWeChatModle;
import com.bwie.myitem.model.listener.OnGetWeChatListener;
import com.bwie.myitem.view.IWeChatView;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/5.
 */

public class WeChatPreseenter extends BasePresenter<IWeChatModle,IWeChatView> {
    private IWeChatView mIWeChatView;
    public WeChatPreseenter(IWeChatView iWeChatView) {
        super(iWeChatView);
        mIWeChatView=iWeChatView;
    }

    @Override
    protected IWeChatModle createModel() {
        return new WeChatModel();
    }
    public void initData(){
        mModel.getDate(new OnGetWeChatListener() {
            @Override
            public void OnSuccess(WechatBean wechatBean) {
                mView.OnSuccess(wechatBean);
            }

            @Override
            public void OnFial(String str) {
                mView.OnFile(str);
            }
        });
    }
}
