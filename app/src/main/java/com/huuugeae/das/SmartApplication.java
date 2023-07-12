package com.huuugeae.das;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;


import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.LogLevel;
import com.appsflyer.AppsFlyerLib;

import java.io.File;

import me.goldze.mvvmhabit.base.BaseApplication;

public class SmartApplication extends BaseApplication {

    private static SmartApplication instance = null;

    public static SmartApplication getInstance() {
        if (instance == null) {
            return new SmartApplication();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
//        在进行测试时，请确保将 environment (环境) 设置为 AdjustConfig.ENVIRONMENT_SANDBOX 。
//        请在向 App Store 提交应用程序前，将环境设置变为 AdjustConfig.ENVIRONMENT_PRODUCTION。
        String appToken = "{mmoiymxyvvnk}";
        String environment = AdjustConfig.ENVIRONMENT_SANDBOX;
        AdjustConfig config = new AdjustConfig(this, appToken, environment);
        config.setLogLevel(LogLevel.WARN);
        Adjust.onCreate(config);


    }


    public String getImagePath() {

        return Environment.getExternalStorageDirectory() + "/Android/data/com.smart.recyclable/image";
    }

    public File getHostFile() {
        File host = SmartApplication.getInstance().getExternalFilesDir("host");
        if (!host.exists()) {
            host.mkdirs();
        }
        return host;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

    }


    private static final class AdjustLifecycleCallbacks implements ActivityLifecycleCallbacks{

        @Override
        public void onActivityCreated(Activity activity, Bundle bundle) {

        }

        @Override
        public void onActivityStarted(Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {
            Adjust.onResume();
        }

        @Override
        public void onActivityPaused(Activity activity) {
            Adjust.onPause();
        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {

        }
    }
}
