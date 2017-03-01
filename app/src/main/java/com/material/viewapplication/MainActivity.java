package com.material.viewapplication;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Application mApplication;
    private ThreadLocal<String> mThreadLocal = new ThreadLocal<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
