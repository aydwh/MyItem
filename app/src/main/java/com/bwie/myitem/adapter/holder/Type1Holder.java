package com.bwie.myitem.adapter.holder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bwie.myitem.R;
import com.bwie.myitem.adapter.Foot;
import com.bwie.myitem.bean.NewsBean;
import com.bwie.myitem.detail.act.RiBaoDetailActivity;

/**
 * Created by weihuanhuan on 2016/11/15.
 */

public class Type1Holder extends BaseViewHolder<NewsBean>{


    private final RecyclerView item1_rv;

    public Type1Holder(View itemView) {
        super(itemView);
        item1_rv = (RecyclerView) itemView.findViewById(R.id.item1_rv);
    }

    @Override
    public void setData(final Context context, final NewsBean newsBean) {

        item1_rv.setLayoutManager(new LinearLayoutManager(context));
        Foot foot=new Foot(context,newsBean);
        item1_rv.setAdapter(foot);
        foot.setOnItemClickLitener(new Foot.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(context,"cccccccc",Toast.LENGTH_SHORT).show();
               Intent intent=new Intent(context, RiBaoDetailActivity.class);
                int index = newsBean.stories.get(position).id;
                intent.putExtra("id",index);
                context.startActivity(intent);
            }
        });
    }

}
