package com.huuugeae.das.net;

import com.huuugeae.das.net.req.ReqGetUrl;
import com.huuugeae.das.net.req.ReqLogin;
import com.huuugeae.das.net.res.ResGetUrl;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {



    @POST("/api/app0/api/login")
    Observable<BaseResponse> login(@Body ReqLogin map);

    @POST("/api/v8/apple/*")
    Observable<ResGetUrl> ghjfd(@Body ReqGetUrl map);





}
