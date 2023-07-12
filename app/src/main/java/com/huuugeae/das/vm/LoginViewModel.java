package com.huuugeae.das.vm;

import android.app.Application;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import com.huuugeae.das.SmartApplication;
import com.huuugeae.das.net.BaseRequest;
import com.huuugeae.das.net.BaseResponse;
import com.huuugeae.das.net.req.ReqLogin;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import okhttp3.RequestBody;

public class LoginViewModel extends BaseViewModel {

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }


    public ObservableField<String> accountObserve = new ObservableField<>();
    public ObservableField<String> passwordObserve = new ObservableField<>();
    public BindingCommand jumpOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
        }
    });

    public BindingCommand<View> login = new BindingCommand<>(() -> {
        ReqLogin reqLogin = new ReqLogin();
        reqLogin.setPassword("123456");
        reqLogin.setUsername("demo1@qq.com");
        reqLogin.setProvider("admins");
        reqLogin.setClient_type("password_client");
        reqLogin.setGrant_type("password");


        BaseRequest.getInstance().getApiService().login(reqLogin)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<BaseResponse>() {

                    @Override
                    public void onNext(BaseResponse addressRes) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
//                        XLog.e("queryWeather onError->" + Log.getStackTraceString(e));
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    });

    public void switchLoginMode() {
//        vCodeMode.setValue(vCodeMode.getValue() == null || !vCodeMode.getValue());
    }


}
