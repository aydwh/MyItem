package com.bwie.myitem.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bwie.myitem.R;
import com.bwie.myitem.adapter.holder.BaseViewHolder;
import com.bwie.myitem.adapter.holder.Type0Holder;
import com.bwie.myitem.adapter.holder.Type1Holder;
import com.bwie.myitem.bean.NewsBean;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/3.
 */

public class RibaoAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private Context context;
    private NewsBean newsBean;
    private static final int TYPE0 = 0;
    private static final int TYPE1 = 1;
    private LayoutInflater mInflater;
    public RibaoAdapter(Context context, NewsBean newsBean) {
        this.context = context;
        this.newsBean = newsBean;
        mInflater = LayoutInflater.from(context);

    }



    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 0:
                return TYPE0;
            case 1:
                return TYPE1;
        }
        return TYPE1;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE0:
                return new Type0Holder(mInflater.inflate(
                        R.layout.ribao_head_item,parent,false));
            case TYPE1:
                return new Type1Holder(mInflater.inflate(
                        R.layout.ribao_b_item,parent,false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final BaseViewHolder holder, int position) {
        holder.setData(context,newsBean);
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
