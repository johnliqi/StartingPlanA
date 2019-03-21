package com.liqi.wawwa.Application;

import android.app.Application;

import com.liqi.wawwa.BuildConfig;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
   //     CrashManager.getInstance().init(this, BuildConfig.DEBUG);
    }
}
