package com.bwie.myitem.adapter.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.myitem.R;
import com.bwie.myitem.bean.NewsBean;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/6.
 */

public class ItemViewHolder extends RecyclerView.ViewHolder {
    public TextView tv_daily_item_title;
    public ImageView iv_daily_item_image;

    public ItemViewHolder(View itemView) {
        super(itemView);
        tv_daily_item_title = (TextView) itemView.findViewById(R.id.tv_daily_item_title);
        iv_daily_item_image = (ImageView) itemView.findViewById(R.id.iv_daily_item_image);
    }

    public void setData(Context context, NewsBean.StoriesBean storiesBean) {
        tv_daily_item_title.setText(storiesBean.title);
        Glide.with(context).load(storiesBean.images.get(0)).into(iv_daily_item_image);

    }
}
