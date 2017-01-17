package com.bwie.myitem.act;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.bwie.library.mvp.MvpActivity;
import com.bwie.library.mvp.ibase.IBaseView;
import com.bwie.myitem.R;
import com.bwie.myitem.bean.tvbean.ShowTvBean;
import com.bwie.myitem.presenter.tvpresenter.TvShowPresenter;
import com.bwie.myitem.view.tvview.ITvShowView;
import com.pili.pldroid.player.widget.PLVideoView;
import com.zhy.autolayout.AutoRelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TvShowActivity extends MvpActivity<TvShowPresenter> implements ITvShowView {

    @Bind(R.id.videoView)
    PLVideoView videoView;

    @Bind(R.id.btn)
    Button btn;
    @Bind(R.id.linear_view)
    AutoRelativeLayout linearView;


    @Override
    protected TvShowPresenter createPresenter(IBaseView view) {
        return new TvShowPresenter(this);
    }


    @Override
    public int bindLayout() {
        return R.layout.activity_tv_show;
    }

    @Override
    public void initVariables() {

    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String uid = intent.getStringExtra("uid");
        mPresenter.initDataShow(uid);
    }

    public void OnClick(View view) {
        //判断手机屏幕的方向
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int heigh = dm.heightPixels;
        if (width >heigh) {

            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //竖屏
            videoView.setDisplayAspectRatio(PLVideoView.ACCESSIBILITY_LIVE_REGION_ASSERTIVE);
        }
        else {

            videoView.setDisplayAspectRatio(PLVideoView.ACCESSIBILITY_LIVE_REGION_ASSERTIVE);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//横屏

        }
        videoView.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        videoView.pause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        videoView.start();

    }

    @Override
    public void OnSuccess(ShowTvBean showTvBean) {
        String src = showTvBean.live.ws.hls.wu.src;
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        Log.e("src", src);
        videoView.setVideoPath(src);
        videoView.start();

    }

    @Override
    public void OnFial(String str) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


}
