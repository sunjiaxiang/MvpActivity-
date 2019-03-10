package com.example.mvpchouqu;

import com.example.mvpchouqu.Base.BaseMvpView;

public interface RequestView extends BaseMvpView {
    void geData(ReBean reBean);

    void showtact(String message);
}
