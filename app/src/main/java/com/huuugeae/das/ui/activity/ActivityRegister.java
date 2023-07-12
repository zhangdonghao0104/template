package com.huuugeae.das.ui.activity;

import android.os.Bundle;

import com.huuugeae.das.BR;
import com.huuugeae.das.R;

import me.goldze.mvvmhabit.base.BaseActivity;

public class ActivityRegister extends BaseActivity {
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_register;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }
}
