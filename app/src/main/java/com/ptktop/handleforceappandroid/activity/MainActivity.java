package com.ptktop.handleforceappandroid.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ptktop.handleforceappandroid.R;
import com.ptktop.handleforceappandroid.manager.MyExceptionHandler;

/*********************
 * Created by PTKTOP *
 *********************/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Set Handle Force */
        Thread.setDefaultUncaughtExceptionHandler(new MyExceptionHandler(this));
//        Thread.setDefaultUncaughtExceptionHandler(new MyExceptionHandler(this, SecondActivity.class));

        /* Receive after Crash */
        if (getIntent().getBooleanExtra("crash", false)) {
            Toast.makeText(this, "App restarted after crash.", Toast.LENGTH_LONG).show();
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setTitle("MainActivity");
        }
    }

    public void intentSecond(View v) {
        startActivity(new Intent(this, SecondActivity.class));
    }

    public void intentThird(View v) {
        startActivity(new Intent(this, ThirdActivity.class));
    }
}
