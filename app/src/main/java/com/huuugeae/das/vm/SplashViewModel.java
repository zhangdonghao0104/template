package com.huuugeae.das.vm;

import android.app.Application;

import androidx.annotation.NonNull;

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
}
