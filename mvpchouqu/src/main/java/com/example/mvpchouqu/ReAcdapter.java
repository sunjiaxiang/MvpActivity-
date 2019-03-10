package com.example.mvpchouqu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ReAcdapter extends RecyclerView.Adapter {
    private Context context;
 List<ReBean.ResultsBean> reBeans=new ArrayList<>();
//适配器
    public ReAcdapter(Context context, List<ReBean.ResultsBean> reBeans) {
        this.context = context;
        this.reBeans = reBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layhow, null);
        return new ViewOne(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewOne viewOne= (ViewOne) viewHolder;
        viewOne.te_on.setText(reBeans.get(i).getUrl());
        Glide.with(context).load(reBeans.get(i).getUrl()).into(viewOne.age);
    }

    @Override
    public int getItemCount() {
        return reBeans.size();
    }
    public  void getData(List<ReBean.ResultsBean> reBean){
        reBeans.addAll(reBean);
        notifyDataSetChanged();
    }
     class  ViewOne extends RecyclerView.ViewHolder {

         private final ImageView age;
         private final TextView te_on;

         public ViewOne(View itemView) {
                 super(itemView);
             age = itemView.findViewById(R.id.age);
             te_on = itemView.findViewById(R.id.te_on);
             }
         }

}
