package com.ptktop.handleforceappandroid;

import android.app.Application;
import android.content.Context;

/*********************
 * Created by PTKTOP *
 *********************/

public class MyApplication extends Application {

    public static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    public static MyApplication getInstance() {
        return instance;
    }

}
