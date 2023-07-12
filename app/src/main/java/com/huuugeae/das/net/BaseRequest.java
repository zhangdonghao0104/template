package com.huuugeae.das.net;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseRequest {

    public static BaseRequest instance;
    public ApiService apiService;

    private BaseRequest() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor("EduApp");
        interceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
        interceptor.setColorLevel(Level.INFO);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(120, TimeUnit.SECONDS)//设置请求超时时间
                .readTimeout(120, TimeUnit.SECONDS)//设置读取数据超时时间
                .writeTimeout(120, TimeUnit.SECONDS)//设置写入数据超时时间
                .addInterceptor(interceptor)//绑定日志拦截器
                .build();

        Retrofit retrofit = new Retrofit.Builder().
                addConverterFactory(GsonConverterFactory.create())//设置Gson转换器,将返回的json数据转为实体
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//设置CallAdapter
                .baseUrl(Api.getBaseUrl())
                .client(client)//设置客户端okHttp相关参数
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public static BaseRequest getInstance() {
        if (instance == null) {
            synchronized (BaseRequest.class) {
                if (instance == null) {
                    instance = new BaseRequest();
                }
            }
        }
        return instance;
    }

    public ApiService getApiService() {
        return apiService;
    }
}