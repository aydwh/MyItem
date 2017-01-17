package com.bwie.myitem.fragment.child;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bwie.library.mvp.MvpFragment;
import com.bwie.library.mvp.ibase.IBaseView;
import com.bwie.myitem.R;
import com.bwie.myitem.adapter.WeChatAdapter;
import com.bwie.myitem.bean.WechatBean;
import com.bwie.myitem.presenter.WeChatPreseenter;
import com.bwie.myitem.view.IWeChatView;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/3.
 */

public class WeChatFragment extends MvpFragment<WeChatPreseenter> implements IWeChatView {

    List<WechatBean.NewslistBean> newslist=new ArrayList<>();
    @Bind(R.id.wechat_rlv)
    PullLoadMoreRecyclerView wechatRlv;
    private WeChatAdapter adapter;



    @Override
    public int bindLayout() {
        return R.layout.wechatfragment;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        getmPresenter().initData();

        wechatRlv.setLinearLayout();
        adapter = new WeChatAdapter(getActivity(),newslist);
        wechatRlv.setAdapter(adapter);
    }
    @Override
    protected WeChatPreseenter createPresenter(IBaseView view) {
        return new WeChatPreseenter(this);
    }
    @Override
    public void OnSuccess(final WechatBean wechatBean) {
        newslist.addAll(wechatBean.newslist);
       adapter.notifyDataSetChanged();
        adapter.setOnItemClickLitener(new WeChatAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                WebView webView = new WebView(getActivity());
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl(newslist.get(position).url);
                webView.setWebViewClient(new WebViewClient());
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                AlertDialog dialog = builder.create();
                dialog.setView(webView);
                dialog.show();
        }
        });

    }

    @Override
    public void OnFile(String str) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
