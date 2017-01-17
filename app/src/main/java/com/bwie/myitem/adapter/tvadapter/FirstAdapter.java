package com.bwie.myitem.adapter.tvadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bwie.myitem.R;
import com.bwie.myitem.adapter.holder.BaseViewHolder;
import com.bwie.myitem.adapter.holder.TvFootHolder;
import com.bwie.myitem.adapter.holder.TvHeadHolder;
import com.bwie.myitem.bean.tvbean.FirstBean;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/10.
 */

public class FirstAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private Context context;
    private List<FirstBean.RoomBean> roomBeans;
    private static final int TYPE0 = 0;
    private static final int TYPE1 = 1;
    private LayoutInflater mInflater;
    public FirstAdapter(Context context, List<FirstBean.RoomBean> roomBeans) {
        this.context=context;
        this.roomBeans=roomBeans;
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
                return new TvHeadHolder(mInflater.inflate(R.layout.item_yzk_1,parent,false));
            case TYPE1:
                return new TvFootHolder(mInflater.inflate(R.layout.item_yzk_2,parent,false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.setData(context,roomBeans.get(position));
    }



    @Override
    public int getItemCount() {
        return roomBeans.size();
    }


}
