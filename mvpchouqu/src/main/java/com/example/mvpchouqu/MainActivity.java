package com.example.mvpchouqu;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mvpchouqu.Base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

//                     继承Base基类
public class MainActivity extends BaseActivity<RequestView,RequestPrenseter> implements RequestView {
    int page=1;
    @BindView(R.id.rede)
    RecyclerView mRede;
    private ReAcdapter reAcdapter;

    @Override
    protected void initView() {
        super.initView();
        //绑定适配器和布局管理器
        List<ReBean.ResultsBean> reBeans=new ArrayList<>();
        reAcdapter = new ReAcdapter(this,reBeans);
       mRede.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
       mRede.setAdapter(reAcdapter);
    }

    @Override
    protected void initData() {
        super.initData();
        mpresnter.getData(page);
    }

    @Override
    protected int getLayoutId() {
        return  R.layout.activity_main;
    }

    @Override
    protected RequestPrenseter initpresnter() {
        return new RequestPrenseter();
    }

    @Override
    public void geData(ReBean reBean) {
        //添加数据
reAcdapter.getData(reBean.getResults());
    }

    @Override
    public void showtact(String message) {

    }
}
