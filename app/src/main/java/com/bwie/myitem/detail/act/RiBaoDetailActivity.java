package com.bwie.myitem.detail.act;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.library.log.MyLog;
import com.bwie.library.mvp.MvpActivity;
import com.bwie.library.mvp.ibase.IBaseView;
import com.bwie.myitem.R;
import com.bwie.myitem.bean.RiBaoDetailBean;
import com.bwie.myitem.detail.presenter.RiBaoDetailPresenter;
import com.bwie.myitem.detail.view.IRiBaoDetailView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RiBaoDetailActivity extends MvpActivity<RiBaoDetailPresenter> implements IRiBaoDetailView {


    @Bind(R.id.detail_bar_image)
    ImageView detailBarImage;
    @Bind(R.id.detail_bar_copyright)
    TextView detailBarCopyright;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @Bind(R.id.app_bar)
    AppBarLayout appBar;
    @Bind(R.id.wv_detail_content)
    WebView wvDetailContent;
    @Bind(R.id.nsv_scroller)
    NestedScrollView nsvScroller;
    @Bind(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected RiBaoDetailPresenter createPresenter(IBaseView view) {
        return new RiBaoDetailPresenter(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_ri_bao_detail;
    }

    @Override
    public void initVariables() {

    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        mPresenter.initData(id);
    }


    @Override
    public void OnSuccess(RiBaoDetailBean riBaoDetailBean) {
        new MyLog().e("请求成功"+riBaoDetailBean.toString());
        toolbar.setTitle(riBaoDetailBean.title);
        toolbar.setLogo(R.drawable.ic_left);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Glide.with(this).load(riBaoDetailBean.image).into(detailBarImage);
        detailBarCopyright.setText(riBaoDetailBean.image_source);
        wvDetailContent.getSettings().setJavaScriptEnabled(true);
        wvDetailContent.setWebViewClient(new WebViewClient());
        wvDetailContent.loadUrl(riBaoDetailBean.share_url);
    }

    @Override
    public void OnFial(String str) {
new MyLog().e(str+"请求出错");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
