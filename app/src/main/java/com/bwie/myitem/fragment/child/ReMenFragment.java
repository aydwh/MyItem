package com.bwie.myitem.fragment.child;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.library.mvp.MvpFragment;
import com.bwie.library.mvp.ibase.IBaseView;
import com.bwie.myitem.R;
import com.bwie.myitem.adapter.ReMenAdapter;
import com.bwie.myitem.bean.HotBean;
import com.bwie.myitem.presenter.ReMenPresenter;
import com.bwie.myitem.view.IReMenView;
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

public class ReMenFragment extends MvpFragment<ReMenPresenter> implements IReMenView {

    List<HotBean.RecentBean> recent=new ArrayList<>();
    @Bind(R.id.hot_rlv)
    PullLoadMoreRecyclerView hotRlv;
    private ReMenAdapter adapter;

    @Override
    protected ReMenPresenter createPresenter(IBaseView view) {
        return new ReMenPresenter(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.remenfragment;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        getmPresenter().initData();
        hotRlv.setLinearLayout();
        adapter = new ReMenAdapter(getActivity(),recent);
        hotRlv.setAdapter(adapter);
    }

    @Override
    public void OnSuccess(HotBean hotBean) {
        recent.addAll(hotBean.recent);
        adapter.notifyDataSetChanged();
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
