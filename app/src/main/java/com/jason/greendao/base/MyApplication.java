package com.jason.greendao.base;

import android.app.Application;

/**
 * Created by JiaBo on 2017/9/20.
 */

public class MyApplication extends Application {

    private static MyApplication appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        this.appContext = this;
    }

    public static MyApplication getAppContext() {
        return appContext;
    }
}
