package com.example.mvpchouqu;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AppService {
//    https://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1
    String murl="https://gank.io/api/data/";
    @GET("%E7%A6%8F%E5%88%A9/10/{page}")
    Observable<ReBean> bdear(@Path("page")int page);
}
