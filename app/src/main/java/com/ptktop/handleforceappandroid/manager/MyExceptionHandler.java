package com.ptktop.handleforceappandroid.manager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.ptktop.handleforceappandroid.MyApplication;
import com.ptktop.handleforceappandroid.activity.MainActivity;

/*********************
 * Created by PTKTOP *
 *********************/

@SuppressWarnings("unused")
public class MyExceptionHandler implements Thread.UncaughtExceptionHandler {

    private Activity activity;
    private Class toClass;

    public MyExceptionHandler(Activity activity) {
        this.activity = activity;
    }

    public MyExceptionHandler(Activity activity, Class toClass) {
        this.activity = activity;
        this.toClass = toClass;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        // Start Main Page
        Intent intent;
        if (toClass != null) {
            intent = new Intent(activity, toClass);
        } else {
            intent = new Intent(activity, MainActivity.class);
        }
        intent.putExtra("crash", true);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_CLEAR_TASK
                | Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(MyApplication.getInstance().getBaseContext(), 0, intent, PendingIntent.FLAG_ONE_SHOT);
        AlarmManager mgr = (AlarmManager) MyApplication.getInstance().getBaseContext().getSystemService(Context.ALARM_SERVICE);
        mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 100, pendingIntent);
        activity.finish();
        System.exit(2);
    }
}
