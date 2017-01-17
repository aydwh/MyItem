package com.bwie.myitem.detail.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.bwie.library.mvp.MvpActivity;
import com.bwie.library.mvp.ibase.IBaseView;
import com.bwie.myitem.R;
import com.bwie.myitem.adapter.Foot;
import com.bwie.myitem.adapter.ZlDetailAdapter;
import com.bwie.myitem.bean.ZlDetailBean;
import com.bwie.myitem.detail.presenter.ZlDetailPresenter;
import com.bwie.myitem.detail.view.IZlDetailView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ZhuanLanDetail1Activity extends MvpActivity<ZlDetailPresenter> implements IZlDetailView {
    List<ZlDetailBean.StoriesBean> stories=new ArrayList<>();

    @Bind(R.id.pull_rlv)
    RecyclerView pullRlv;
    private ZlDetailAdapter adapter;

    @Override
    public int bindLayout() {
        return R.layout.activity_zhuan_lan_detail1;
    }

    @Override
    public void initVariables() {

    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        mPresenter.initData(id);
        pullRlv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ZlDetailAdapter(this,stories);
        pullRlv.setAdapter(adapter);

    }

    @Override
    public void OnSuccess(final ZlDetailBean zlDetailBean) {
        stories.addAll(zlDetailBean.stories);
        adapter.notifyDataSetChanged();
        adapter.setOnItemClickLitener(new Foot.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent=new Intent(ZhuanLanDetail1Activity.this,RiBaoDetailActivity.class);
                int index = zlDetailBean.stories.get(position).id;
                intent.putExtra("id", index);
                startActivity(intent);
            }
        });
    }

    @Override
    public void OnFial(String str) {
        Log.e("zl",str);
    }

    @Override
    protected ZlDetailPresenter createPresenter(IBaseView view) {
        return new ZlDetailPresenter(this);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

}
