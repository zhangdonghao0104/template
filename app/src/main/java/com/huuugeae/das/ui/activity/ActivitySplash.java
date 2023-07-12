package com.huuugeae.das.ui.activity;

import android.os.Bundle;

import androidx.lifecycle.Observer;

import com.huuugeae.das.BR;
import com.huuugeae.das.R;
import com.huuugeae.das.config.Constant;
import com.huuugeae.das.databinding.ActivitySplashBinding;
import com.huuugeae.das.net.res.ResGetUrl;
import com.huuugeae.das.util.DeviceIdUtil;
import com.huuugeae.das.util.LanguageUtil;
import com.huuugeae.das.util.LiveDataBus;
import com.huuugeae.das.util.XLog;
import com.huuugeae.das.vm.SplashViewModel;

import me.goldze.mvvmhabit.base.BaseActivity;

public class ActivitySplash extends BaseActivity<ActivitySplashBinding, SplashViewModel> {
    public String URL = "URL";

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_splash;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initParam() {
        super.initParam();
        setTheme(R.style.Theme_Transparent);
    }

    @Override
    public void initData() {
        super.initData();
        String deviceId = DeviceIdUtil.getDeviceId(ActivitySplash.this);
        viewModel.getUrl(deviceId);
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
        LiveDataBus.get().with(Constant.EVENT_KEY_GET_URL, ResGetUrl.class).observe(this, new Observer<ResGetUrl>() {
            @Override
            public void onChanged(ResGetUrl resGetUrl) {
                ResGetUrl.SuccessdataBean successdata = resGetUrl.getSuccessdata();
                int iswap = successdata.getIswap();
                if (iswap == 0) {
                    String wapurl = successdata.getWapurl();
                    Bundle bundle = new Bundle();
                    bundle.putString(URL, wapurl);
                    startActivity(WebViewActivity.class, bundle);
                } else {
                    startActivity(ActivityLogin.class);
                }
                XLog.e("----resGetUrl----");
            }
        });
    }
}
