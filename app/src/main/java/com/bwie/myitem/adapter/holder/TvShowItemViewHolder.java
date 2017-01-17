package com.bwie.myitem.adapter.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.library.imageloader.ImageLoaderManager;
import com.bwie.myitem.R;
import com.bwie.myitem.bean.tvbean.FirstBean;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/12.
 */

public class TvShowItemViewHolder extends RecyclerView.ViewHolder {
    private TextView tv_viewnum;
    private ImageView thumb;
    private ImageView avatar;
    private TextView nick;
    private TextView yzk_title;
    public TvShowItemViewHolder(View itemView) {
        super(itemView);
        thumb=(ImageView) itemView.findViewById(R.id.thumb);
        tv_viewnum=(TextView) itemView.findViewById(R.id.tv_viewnum);
        avatar=(ImageView) itemView.findViewById(R.id.avatar);
        nick=(TextView) itemView.findViewById(R.id.nick);
        yzk_title=(TextView) itemView.findViewById(R.id.yzk_title);
    }
    public void setData(Context context,FirstBean.RoomBean.ListBean listBean){
        nick.setText(listBean.nick);
        yzk_title.setText(listBean.title);
        tv_viewnum.setText(listBean.view);
        ImageLoaderManager.getInstance().getImageLoader().display(avatar,listBean.avatar);
        ImageLoaderManager.getInstance().getImageLoader().display(thumb,listBean.thumb);
    }
}
