package com.example.mvpchouqu.Base;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePresenter <V extends BaseMvpView>{

    protected V mview;
  protected List<BaseModel> baseModels=new ArrayList<>();
    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    public  <T extends BasePresenter> void acchere(V v){
       mview= v;
    }
}
