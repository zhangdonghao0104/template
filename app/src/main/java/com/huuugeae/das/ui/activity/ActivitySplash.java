package com.huuugeae.das.ui.activity;

import android.os.Bundle;

import com.huuugeae.das.BR;
import com.huuugeae.das.R;
import com.huuugeae.das.databinding.ActivitySplashBinding;
import com.huuugeae.das.util.LanguageUtil;
import com.huuugeae.das.vm.SplashViewModel;

import me.goldze.mvvmhabit.base.BaseActivity;

public class ActivitySplash extends BaseActivity <ActivitySplashBinding, SplashViewModel>{
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_splash;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
        showSaveLanguage("en");
    }

    /**
     * 保存设置的语言
     */
    private void showSaveLanguage(String language){
        //设置的语言、重启的类一般为应用主入口（微信也是到首页）
        LanguageUtil.changeAppLanguage(this, language, MainActivity.class);
        //保存设置的语言
//        SpUserUtils.putString(this, "language", language);
    }

}
