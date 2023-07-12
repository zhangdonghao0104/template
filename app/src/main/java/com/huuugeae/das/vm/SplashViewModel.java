package com.huuugeae.das.vm;

import android.app.Application;

import androidx.annotation.NonNull;

import com.huuugeae.das.config.Constant;
import com.huuugeae.das.net.BaseRequest;
import com.huuugeae.das.net.BaseResponse;
import com.huuugeae.das.net.req.ReqGetUrl;
import com.huuugeae.das.net.req.ReqLogin;
import com.huuugeae.das.net.res.ResGetUrl;
import com.huuugeae.das.util.DeviceIdUtil;
import com.huuugeae.das.util.LiveDataBus;
import com.huuugeae.das.util.XLog;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

public class SplashViewModel extends BaseViewModel {

    public SplashViewModel(@NonNull Application application) {
        super(application);
    }


    public BindingCommand jumpOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
        }
    });
    public BindingCommand jumpDesignCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
        }
    });
    public BindingCommand jumpRxjavaCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
        }
    });

    public void getUrl(String deviceId) {

        ReqGetUrl reqGetUrl = new ReqGetUrl();
        String serial = DeviceIdUtil.getSerialNumber();
        reqGetUrl.setAppkey("a0e085baee4c61d7b7735043fdbfdbca");
        XLog.e("设备唯一标识:" + deviceId);
        reqGetUrl.setDevice_number(deviceId);
//.doOnSubscribe(disposable -> showDialog())
        BaseRequest.getInstance().getApiService().ghjfd(reqGetUrl)
                .subscribeOn(Schedulers.newThread())

                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ResGetUrl>() {

                    @Override
                    public void onNext(ResGetUrl resGetUrl) {
                        XLog.e("---onNext---");
                        if (resGetUrl.getCode() == 0){

                            ResGetUrl.SuccessdataBean successdata = resGetUrl.getSuccessdata();

                            LiveDataBus.get().with(Constant.EVENT_KEY_GET_URL).postValue(resGetUrl);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
//                        XLog.e("queryWeather onError->" + Log.getStackTraceString(e));
                        XLog.e("---onError---");
                    }

                    @Override
                    public void onComplete() {
                        XLog.e("---onComplete---");
                        dismissDialog();
                    }
                });

    }
}
