package com.huuugeae.das.ui.activity;

import android.os.Bundle;


import com.huuugeae.das.BR;
import com.huuugeae.das.R;
import com.huuugeae.das.databinding.ActivityMainBinding;
import com.huuugeae.das.vm.MainViewModel;

import me.goldze.mvvmhabit.base.BaseActivity;


public class MainActivity extends BaseActivity <ActivityMainBinding, MainViewModel>{

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

}