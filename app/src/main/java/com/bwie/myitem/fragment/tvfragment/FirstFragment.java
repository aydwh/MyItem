package com.bwie.myitem.fragment.tvfragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bwie.library.log.MyLog;
import com.bwie.library.mvp.MvpFragment;
import com.bwie.library.mvp.ibase.IBaseView;
import com.bwie.myitem.R;
import com.bwie.myitem.adapter.tvadapter.FirstAdapter;
import com.bwie.myitem.bean.tvbean.FirstBean;
import com.bwie.myitem.presenter.tvpresenter.FirstPresenter;
import com.bwie.myitem.view.tvview.IFirstView;

import butterknife.Bind;


/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/9.
 */

public class FirstFragment extends MvpFragment<FirstPresenter> implements IFirstView {
    @Bind(R.id.first_rv)
    RecyclerView firstRv;
    private FirstAdapter adapter ;

    @Override
    protected FirstPresenter createPresenter(IBaseView view) {
        return new FirstPresenter(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.firstfragment;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        getmPresenter().initFirstDate();
    }

    @Override
    public void OnSuccess(FirstBean firstBean) {
        new MyLog().e("FirstFragment请求成功"+firstBean);
        firstRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter=new FirstAdapter(getActivity(),firstBean.room);
        firstRv.setAdapter(adapter);


    }

    @Override
    public void OnFial(String str) {
        new MyLog().e("FirstFragment请失败求"+str);
    }


}
