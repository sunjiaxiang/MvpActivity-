package com.example.mvpchouqu.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity <V extends BaseMvpView,T extends BasePresenter> extends AppCompatActivity {
   protected T mpresnter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(getLayoutId());
        ButterKnife.bind(this);
        mpresnter=initpresnter();
        if (mpresnter!=null){
            mpresnter.acchere((V)this);
        }
        initView();
        LenIstersenter();
        initData();
    }

    protected  void LenIstersenter(){}

    protected  void initData(){}

    protected  void initView(){}

    protected abstract int getLayoutId();

    protected abstract T initpresnter();

}
