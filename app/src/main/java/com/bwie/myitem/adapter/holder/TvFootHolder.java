package com.bwie.myitem.adapter.holder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bwie.library.log.MyLog;
import com.bwie.myitem.R;
import com.bwie.myitem.act.TvShowActivity;
import com.bwie.myitem.adapter.tvadapter.TvFoot;
import com.bwie.myitem.bean.tvbean.FirstBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/10.
 */

public class TvFootHolder extends BaseViewHolder<FirstBean.RoomBean>{
    private TextView tv;
    private RecyclerView rv;
    List<FirstBean.RoomBean.ListBean> list =new ArrayList<>();
    public TvFootHolder(View itemView) {
        super(itemView);
        tv=(TextView) itemView.findViewById(R.id.textview_yzk_item);
        rv=(RecyclerView) itemView.findViewById(R.id.recycleview_yzk_item);
    }

    @Override
    public void setData(final Context context, FirstBean.RoomBean roomBean) {
        tv.setText(roomBean.name);
        list.addAll(roomBean.list);
        rv.setLayoutManager(new GridLayoutManager(context,2));
        TvFoot tvFoot=new TvFoot(context,list);
        rv.setAdapter(tvFoot);
        tvFoot.setOnItemClickLitener(new TvFoot.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent=new Intent(context, TvShowActivity.class);
                int uid = list.get(position).uid;
                intent.putExtra("uid",uid+"");

                new MyLog().e("uid"+list.get(position).uid);
                context.startActivity(intent);
            }
        });

    }


}
