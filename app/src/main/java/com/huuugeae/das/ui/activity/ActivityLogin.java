package com.huuugeae.das.ui.activity;

import android.os.Bundle;

import com.huuugeae.das.BR;
import com.huuugeae.das.R;
import com.huuugeae.das.databinding.ActivityLoginBinding;
import com.huuugeae.das.databinding.ActivitySplashBinding;
import com.huuugeae.das.vm.LoginViewModel;
import com.huuugeae.das.vm.SplashViewModel;

import me.goldze.mvvmhabit.base.BaseActivity;

public class ActivityLogin extends BaseActivity <ActivityLoginBinding, LoginViewModel>{
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_login;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }
}
