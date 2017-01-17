package com.bwie.myitem.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.myitem.R;
import com.bwie.myitem.bean.HotBean;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/5.
 */

public class ReMenAdapter extends RecyclerView.Adapter<ReMenAdapter.ViewHolder> {
    private Context context;
    private List<HotBean.RecentBean> recent;
    private LayoutInflater mInflater;
    public ReMenAdapter(Context context, List<HotBean.RecentBean> recent) {
        this.context=context;
        this.recent=recent;
        mInflater=LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.remen_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.hotText.setText(recent.get(position).url);

    }

    @Override
    public int getItemCount() {
        return recent.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView hotImg;
        public ImageView hotRT;
        public TextView hotName;
        public TextView hotText;
        public TextView hotDate;

        public ViewHolder(View itemView) {
            super(itemView);
            hotImg=(ImageView) itemView.findViewById(R.id.hotImg);
            hotRT=(ImageView) itemView.findViewById(R.id.hotRT);
            hotName=(TextView) itemView.findViewById(R.id.hotName);
            hotText=(TextView) itemView.findViewById(R.id.hotText);
            hotDate=(TextView) itemView.findViewById(R.id.hotDate);
        }
    }
}
