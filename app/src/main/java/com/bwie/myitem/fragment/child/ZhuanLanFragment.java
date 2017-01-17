package com.bwie.myitem.fragment.child;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.library.mvp.MvpFragment;
import com.bwie.library.mvp.ibase.IBaseView;
import com.bwie.myitem.R;
import com.bwie.myitem.adapter.ZhuanLanAdapter;
import com.bwie.myitem.bean.SpecialBean;
import com.bwie.myitem.detail.act.ZhuanLanDetail1Activity;
import com.bwie.myitem.presenter.ZhuanLanPresenter;
import com.bwie.myitem.view.IZhuanLanView;
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

public class ZhuanLanFragment extends MvpFragment<ZhuanLanPresenter> implements IZhuanLanView {
    List<SpecialBean.DataBean> data=new ArrayList<>();

    @Bind(R.id.pull_rlv)
    PullLoadMoreRecyclerView pullRlv;
    private ZhuanLanAdapter adapter;

    @Override
    public int bindLayout() {
        return R.layout.zhuanlanfragment;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        getmPresenter().initData();
        pullRlv.setGridLayout(2);
        adapter = new ZhuanLanAdapter(getActivity(),data);
        pullRlv.setPullLoadMoreCompleted();
        pullRlv.setAdapter(adapter);


    }

    @Override
    protected ZhuanLanPresenter createPresenter(IBaseView view) {
        return new ZhuanLanPresenter(this);
    }

    @Override
    public void OnSuccess(final SpecialBean specialBean) {
        data.addAll(specialBean.data);
        adapter.notifyDataSetChanged();
        adapter.setOnItemClickLitener(new ZhuanLanAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent=new Intent(getActivity(), ZhuanLanDetail1Activity.class);
                int index = specialBean.data.get(position).id;
                intent.putExtra("id",index);
                startActivity(intent);
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
