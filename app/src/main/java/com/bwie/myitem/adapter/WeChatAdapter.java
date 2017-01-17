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
import com.bwie.myitem.bean.WechatBean;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/5.
 */

public class WeChatAdapter extends RecyclerView.Adapter<WeChatAdapter.ViewHolder> {
    private Context context;
    private List<WechatBean.NewslistBean> newslist;
    private LayoutInflater mInflater;
    public WeChatAdapter(Context context, List<WechatBean.NewslistBean> newslist) {
        this.context=context;
        this.newslist=newslist;
        mInflater=LayoutInflater.from(context);
    }
    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
    }
    private WeChatAdapter.OnItemClickLitener mOnItemClickLitener;
    public void setOnItemClickLitener(WeChatAdapter.OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.wechat_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.wechat_ctime.setText(newslist.get(position).ctime);
        holder.wechat_description.setText(newslist.get(position).description);
        holder.wechat_title.setText(newslist.get(position).title);
        Glide.with(context).load(newslist.get(position).picUrl).into(holder.wechat_image);
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
        return newslist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView wechat_image;
        public TextView wechat_ctime;
        public TextView wechat_description;
        public TextView wechat_title;

        public ViewHolder(View itemView) {
            super(itemView);
            wechat_image=(ImageView) itemView.findViewById(R.id.wechat_image);
            wechat_ctime=(TextView) itemView.findViewById(R.id.wechat_ctime);
            wechat_description=(TextView) itemView.findViewById(R.id.wechat_description);
            wechat_title=(TextView) itemView.findViewById(R.id.wechat_title);

        }
    }
}
