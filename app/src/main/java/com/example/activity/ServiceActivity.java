package com.example.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import service.NormalService;

/*
 *
 * 1、在Manifest里初始化Service
 * 2、实现Service类
 * 3、startService
 *
 * bindService
 * 1. 在Service的onBind方法中返回IBinder类型的实例。
 * 2. onBind方法返回的IBinder的实例需要能够返回Service实例本身或者通过binder暴露出Service公共方法
 *
 *
 * */

public class ServiceActivity extends Activity {

    private NormalService mIBinder;
    private TextView serviceText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_layout);
        serviceText = findViewById(R.id.service_text);
        findViewById(R.id.service_start_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });

        findViewById(R.id.service_bind_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bind();
            }
        });

        findViewById(R.id.service_unbind_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbind();
            }
        });
        findViewById(R.id.service_stop_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
            }
        });


    }

    public void start() {
        startService(new Intent(this, NormalService.class));
        Log.d("service", "on-click-startService");
    }

    public void stop() {
        stopService(new Intent(this, NormalService.class));
        Log.d("service", "on-click-stopService");
    }

    public void bind() {
        bindService(new Intent(this, NormalService.class), mConnection, Context.BIND_AUTO_CREATE);
        Log.d("service", "on-click-bindService");
    }

    public void unbind() {
        unbindService(mConnection);
        Log.d("service", "on-click-unbindService");
    }

    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("service", "onServiceConnected");
            mIBinder = ((NormalService.MyBinder) service).getService();
            serviceText.setText(mIBinder.getMsg());
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("service", "onServiceDisconnected");
        }
    };
}
