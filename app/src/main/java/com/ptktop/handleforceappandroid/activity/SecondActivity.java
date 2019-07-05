package com.ptktop.handleforceappandroid.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.ptktop.handleforceappandroid.R;
import com.ptktop.handleforceappandroid.manager.MyExceptionHandler;

/*********************
 * Created by PTKTOP *
 *********************/

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        /* Receive after Crash when you intent this class*/
        if (getIntent().getBooleanExtra("crash", false)) {
            Thread.setDefaultUncaughtExceptionHandler(new MyExceptionHandler(this));
            Toast.makeText(this, "App restarted after crash.", Toast.LENGTH_LONG).show();
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setTitle("SecondActivity");
        }
    }

    public void intentThird(View v) {
        startActivity(new Intent(this, ThirdActivity.class));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            exitFromActivity();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        exitFromActivity();
    }

    private void exitFromActivity() {
        finish();
    }
}
