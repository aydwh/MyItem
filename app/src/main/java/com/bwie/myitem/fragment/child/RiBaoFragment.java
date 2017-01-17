package com.bwie.myitem.fragment.child;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.library.mvp.MvpFragment;
import com.bwie.library.mvp.ibase.IBaseView;
import com.bwie.myitem.R;
import com.bwie.myitem.adapter.RibaoAdapter;
import com.bwie.myitem.bean.NewsBean;
import com.bwie.myitem.presenter.RiBaoPresenter;
import com.bwie.myitem.view.IView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/3.
 */

public class RiBaoFragment extends MvpFragment<RiBaoPresenter> implements IView {


    @Bind(R.id.rlv)
    RecyclerView rlv;
    private RibaoAdapter adapter;


    @Override
    protected RiBaoPresenter createPresenter(IBaseView view) {
        return new RiBaoPresenter(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.ribaofragment;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        getmPresenter().initDate();

    }

    @Override
    public void OnSuccess(final NewsBean newsBean) {

        rlv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        adapter = new RibaoAdapter(getActivity(),newsBean);

        rlv.setAdapter(adapter);
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
