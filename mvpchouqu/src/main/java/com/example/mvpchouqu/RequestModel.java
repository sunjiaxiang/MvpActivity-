package com.example.mvpchouqu;

import com.example.mvpchouqu.Base.BaseModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
//model 层
public class RequestModel extends BaseModel {
    public void getData(int page, final RexcRackCall rexcRackCall) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppService.murl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        AppService appservice = retrofit.create(AppService.class);
        appservice.bdear(page).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ReBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ReBean reBean) {
                        rexcRackCall.onSucess(reBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        rexcRackCall.onfile(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
