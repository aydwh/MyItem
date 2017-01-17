package com.bwie.myitem.adapter.tvadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.myitem.R;
import com.bwie.myitem.adapter.holder.TvShowItemViewHolder;
import com.bwie.myitem.bean.tvbean.FirstBean;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/12.
 */

public class TvFoot extends RecyclerView.Adapter<TvShowItemViewHolder> {
    private Context context;
    private List<FirstBean.RoomBean.ListBean> list;
    private LayoutInflater mLayoutInflater;
    public TvFoot(Context context, List<FirstBean.RoomBean.ListBean> list) {
        this.context=context;
        this.list=list;
        mLayoutInflater=LayoutInflater.from(context);
    }
    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
    }
    private OnItemClickLitener mOnItemClickLitener;
    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }
    @Override
    public TvShowItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=mLayoutInflater.inflate(R.layout.item_yzk2_item,parent,false);
        return new TvShowItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TvShowItemViewHolder holder, int position) {
        holder.setData(context,list.get(position));
        if(mOnItemClickLitener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos=holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView,pos);
                }
            });
       }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
