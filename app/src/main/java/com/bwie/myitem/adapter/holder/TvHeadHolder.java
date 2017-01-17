package com.bwie.myitem.adapter.holder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bwie.library.log.MyLog;
import com.bwie.myitem.R;
import com.bwie.myitem.act.TvShowActivity;
import com.bwie.myitem.bean.tvbean.FirstBean;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/10.
 */

public class TvHeadHolder extends BaseViewHolder<FirstBean.RoomBean>{

    private final BGABanner banner;

    public TvHeadHolder(View itemView) {
        super(itemView);
        banner = (BGABanner) itemView.findViewById(R.id.banner_yzk);
    }

    @Override
    public void setData(final Context context, final FirstBean.RoomBean roomBean) {
        List<String> imgs=new ArrayList<>();
        List<String> titles=new ArrayList<>();
        final List<FirstBean.RoomBean.ListBean> list = roomBean.list;
new MyLog().e("tv集合长度"+list.size());

        for (int i=0;i< list.size();i++){
            imgs.add( list.get(i).thumb);
            titles.add( list.get(i).title);
        }
        banner.setAdapter(new BGABanner.Adapter() {
            @Override
            public void fillBannerItem(BGABanner banner, View itemView, Object model, int position) {
                Glide.with(context).load(model)
                        .placeholder(R.drawable.holder)
                        .error(R.drawable.ic_launcher)
                        .into((ImageView) itemView);
            }
        });
        banner.setData(imgs,titles);
        banner.setDelegate(new BGABanner.Delegate() {
            @Override
            public void onBannerItemClick(BGABanner banner, View itemView, Object model, int position) {
                context.startActivity(new Intent(context, TvShowActivity.class).putExtra("uid",list.get(position).uid+""));
            }
        });
    }


}

