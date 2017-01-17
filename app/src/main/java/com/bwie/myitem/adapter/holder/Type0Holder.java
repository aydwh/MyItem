package com.bwie.myitem.adapter.holder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bwie.myitem.R;
import com.bwie.myitem.bean.NewsBean;
import com.bwie.myitem.detail.act.RiBaoDetailActivity;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * Created by weihuanhuan on 2016/11/15.
 */

public class Type0Holder extends BaseViewHolder<NewsBean>{

    private final BGABanner banner;

    public Type0Holder(View itemView) {
        super(itemView);
        banner = (BGABanner) itemView.findViewById(R.id.banner_viewpager);
    }

    @Override
    public void setData(final Context context, final NewsBean newsBean) {
        List<String> imgs = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for (int i=0;i<newsBean.top_stories.size();i++){
            imgs.add(newsBean.top_stories.get(i).image);
            titles.add(newsBean.top_stories.get(i).title);
        }
        banner.setAdapter(new BGABanner.Adapter() {
            @Override
            public void fillBannerItem(BGABanner banner, View itemView, Object model, int position) {
                Glide.with(context).load(model)
                        .placeholder(R.drawable.holder)
                        .error(R.drawable.ic_launcher)
                        .into((ImageView) itemView);
//                GlideImagerLoader.glideUtils
//                        .display((ImageView) itemView,(String )model,R.drawable.holder,R.drawable.ic_launcher);
            }

        });
        banner.setData(imgs,titles);
        banner.setDelegate(new BGABanner.Delegate() {
            @Override
            public void onBannerItemClick(BGABanner banner, View itemView, Object model, int position) {
                context.startActivity(new Intent(context, RiBaoDetailActivity.class)
                        .putExtra("id",newsBean.top_stories.get(position).id));
            }
        });





    }

}
