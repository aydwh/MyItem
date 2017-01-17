package com.bwie.myitem.adapter.tvadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.myitem.R;
import com.bwie.myitem.bean.tvbean.OtherBean;

import java.util.List;


/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/9.
 */

public class OtherAdapter extends RecyclerView.Adapter<OtherAdapter.ViewHolder> {
    private Context context;
    private List<OtherBean.DataBean> data;
    private LayoutInflater mInflater;
    public OtherAdapter(Context context, List<OtherBean.DataBean> data) {
        this.context=context;
        this.data=data;
        mInflater=LayoutInflater.from(context);
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
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.item_tv_other,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Glide.with(context).load(data.get(position).thumb).into(holder.thumnails);
        holder.tv_viewnum.setText(data.get(position).view);
        Glide.with(context).load(data.get(position).avatar).into(holder.ic_head);
        holder.nickName.setText(data.get(position).nick);
        holder.title.setText(data.get(position).title);
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
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumnails;
        public TextView tv_viewnum;
        public ImageView ic_head;
        public TextView nickName;
        public TextView title;
        public ViewHolder(View itemView) {
            super(itemView);
            thumnails=(ImageView) itemView.findViewById(R.id.thumnails);
            tv_viewnum=(TextView) itemView.findViewById(R.id.tv_viewnum);
            ic_head=(ImageView) itemView.findViewById(R.id.ic_head);
            nickName=(TextView) itemView.findViewById(R.id.nickName);
            title=(TextView) itemView.findViewById(R.id.title);
        }
    }
}
