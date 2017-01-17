package com.bwie.myitem.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.myitem.R;
import com.bwie.myitem.bean.ZlDetailBean;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/7.
 */

public class ZlDetailAdapter extends RecyclerView.Adapter<ZlDetailAdapter.ViewHolder> {

    private Context context;
    private List<ZlDetailBean.StoriesBean> stories;
    private LayoutInflater mInflater;
    public ZlDetailAdapter(Context context, List<ZlDetailBean.StoriesBean> stories) {
        this.context=context;
        this.stories=stories;
        mInflater=LayoutInflater.from(context);
    }
    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
    }
    private Foot.OnItemClickLitener mOnItemClickLitener;
    public void setOnItemClickLitener(Foot.OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.zhuanlan_detail_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.tv_zl_item_title.setText(stories.get(position).title);
        Glide.with(context).load(stories.get(position).images.get(0)).into(holder.iv_zl_item_image);
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
        return stories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_zl_item_image;
        public TextView tv_zl_item_title;
        public ViewHolder(View itemView) {
            super(itemView);
            iv_zl_item_image=(ImageView) itemView.findViewById(R.id.iv_zl_item_image);
            tv_zl_item_title=(TextView) itemView.findViewById(R.id.tv_zl_item_title);
        }
    }
}
