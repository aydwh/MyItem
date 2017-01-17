package com.bwie.myitem.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.myitem.R;
import com.bwie.myitem.adapter.holder.ItemViewHolder;
import com.bwie.myitem.bean.NewsBean;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/6.
 */

public class Foot extends RecyclerView.Adapter<ItemViewHolder>{
    private Context context;
    NewsBean newsBean;

    public Foot(Context context, NewsBean newsBean) {
        this.context = context;
        this.newsBean = newsBean;
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
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.ribao_item,parent,false));
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        holder.setData(context,newsBean.stories.get(position));
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
        return newsBean.stories.size();
    }

}
