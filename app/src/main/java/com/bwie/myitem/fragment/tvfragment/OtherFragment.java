package com.bwie.myitem.fragment.tvfragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.library.mvp.MvpFragment;
import com.bwie.library.mvp.ibase.IBaseView;
import com.bwie.myitem.R;
import com.bwie.myitem.act.TvShowActivity;
import com.bwie.myitem.adapter.tvadapter.OtherAdapter;
import com.bwie.myitem.bean.tvbean.OtherBean;
import com.bwie.myitem.presenter.tvpresenter.OtherPresenter;
import com.bwie.myitem.view.tvview.IOtherView;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/9.
 */

public class OtherFragment extends MvpFragment<OtherPresenter> implements IOtherView {

    List<OtherBean.DataBean> data=new ArrayList<>();
    @Bind(R.id.other_rv)
    PullLoadMoreRecyclerView otherRv;
    private OtherAdapter adapter;

    @Override
    protected OtherPresenter createPresenter(IBaseView view) {
        return new OtherPresenter(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.otherfragment;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        String name = bundle.getString("name");
        getmPresenter().initData(name);
        adapter = new OtherAdapter(getActivity(), data);
        otherRv.setGridLayout(2);
        otherRv.setAdapter(adapter);

    }

    @Override
    public void OnSuccess(final OtherBean otherBean) {
         data.addAll(otherBean.data);
        adapter.notifyDataSetChanged();
        adapter.setOnItemClickLitener(new OtherAdapter.OnItemClickLitener() {
                                          @Override
                                          public void onItemClick(View view, int position) {
                                              Intent intent=new Intent(getActivity(), TvShowActivity.class);
                                              intent.putExtra("uid",data.get(position).uid);
                                              startActivity(intent);

                                          }
                                      });
    }

    @Override
    public void OnFial(String str) {

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
