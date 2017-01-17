package com.bwie.myitem.act;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.bwie.library.mvp.MvpActivity;
import com.bwie.library.mvp.ibase.IBaseView;
import com.bwie.library.utils.StatusBarUtil;
import com.bwie.myitem.R;
import com.bwie.myitem.bean.tvbean.TabBean;
import com.bwie.myitem.fragment.FragmentAdapter;
import com.bwie.myitem.fragment.tvfragment.FirstFragment;
import com.bwie.myitem.fragment.tvfragment.OtherFragment;
import com.bwie.myitem.presenter.tvpresenter.TvMainPresenter;
import com.bwie.myitem.view.tvview.ITvMainView;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TvMainActivity extends MvpActivity<TvMainPresenter> implements ITvMainView {

    List<Fragment> fragments = new ArrayList<>();
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabs)
    TabLayout tabs;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
//    String[] path =
//            {"lol",
//            "beauty",
//            "overwatch",
//            "huwai",
//            "heartstone",
//            "mobilegame",
//            "webgame",
//            "tvgame",
//            "wangzhe",
//             "",
//            "dota2",
//            "cfpc",
//            "dnf",
//            "qqfeiche",
//            "war3",
//            "nba2k",
//            "minecraft",
//            "fifa",
//            "blizzard",
//            "qiuqiu",
//            "erciyuan",
//            "cfpc",
//            "jianling",
//            "qqfeiche",
//            "limingshaji",
//            "nba2k",
//            "msg",
//            "fifa",
//            "fs",
//            "war3",
//            "zhuangjiafengbao",
//            "wangzhe",
//            "street"};
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected TvMainPresenter createPresenter(IBaseView view) {
        return new TvMainPresenter(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_tv_main;
    }

    @Override
    public void initVariables() {

    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        StatusBarUtil.setTransparent(this);
        mPresenter.initDate();
        toolbar.setTitle("全民TV");
    }

    @Override
    public void OnSuccess(List<TabBean> tabBeans) {
        for (int i = 0; i < tabBeans.size(); i++) {
            tabs.addTab(tabs.newTab().setText(tabBeans.get(i).name));
            switch (i) {
                case 0:
                    fragments.add(new FirstFragment());
                    break;
                default:
                    OtherFragment otherFragment = new OtherFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name",tabBeans.get(i).slug);
                    otherFragment.setArguments(bundle);
                    fragments.add(otherFragment);
                     break;
            }
        }
        int position=0;
        viewpager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), fragments));
        viewpager.setCurrentItem(position);//要设置到viewpager.setAdapter后才起作用
        tabs.setupWithViewPager(viewpager);
        tabs.setVerticalScrollbarPosition(position);

        for (int i = 0; i < tabBeans.size(); i++) {
            tabs.getTabAt(i).setText(tabBeans.get(i).name);
        }

    }

    @Override
    public void OnFial(String str) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("TvMain Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
