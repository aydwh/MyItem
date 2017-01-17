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
import com.bwie.myitem.bean.SpecialBean;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/4.
 */

public class ZhuanLanAdapter extends RecyclerView.Adapter<ZhuanLanAdapter.ViewHolder> {
    private Context context;
    private List<SpecialBean.DataBean> data;
    public ZhuanLanAdapter(Context context, List<SpecialBean.DataBean> data) {
        this.context=context;
        this.data=data;
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
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.zhuanlan_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.specil_description.setText(data.get(position).description);
        holder.specil_name.setText(data.get(position).name);
        Glide.with(context).load(data.get(position).thumbnail).into(holder.img);
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
        public ImageView img;
        public TextView specil_description;
        public TextView specil_name;

        public ViewHolder(View itemView) {
            super(itemView);
            img=(ImageView) itemView.findViewById(R.id.card_image);
            specil_description=(TextView) itemView.findViewById(R.id.specil_description);
            specil_name=(TextView) itemView.findViewById(R.id.specil_name);
        }
    }
}
