package com.example.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ThreadActivity extends Activity implements View.OnClickListener, Runnable {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;

    private ProgressDialog progress;
    public static final int STOP = 1;

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            Log.d("test", "3");
            if (msg.what == STOP) {
                progress.dismiss();
            }
            return false;
        }
    });

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thread_layout);
        init();
        setOnClick();
    }

    private void init() {
        btn1 = findViewById(R.id.thread_one_button);
        btn2 = findViewById(R.id.thread_two_button);
        btn3 = findViewById(R.id.thread_three_button);
        btn4 = findViewById(R.id.thread_four_button);
        Log.d("test", "1");
    }

    private void setOnClick() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.thread_one_button:
                try {
                    Thread.sleep(10000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.thread_two_button:
                progress = showDialog();
                LoadingThread thread1 = new LoadingThread();
                thread1.start();

                break;
            case R.id.thread_three_button:
                progress = showDialog();
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        afterClick();
                    }
                });
                thread.start();
                break;
            case R.id.thread_four_button:
                progress = showDialog();
                Thread thread2 = new Thread(ThreadActivity.this);
                thread2.start();
                break;

            default:
                break;

        }
    }

    private ProgressDialog showDialog() {
        return ProgressDialog.show(ThreadActivity.this, "提示", "进程加载中", false);
    }

    @Override
    public void run() {
        afterClick();
    }

    private void afterClick() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Message msg = new Message();
        msg.what = STOP;
        Log.d("test", "2");
        handler.sendMessage(msg);
    }

    private class LoadingThread extends Thread {
        @Override
        public void run() {
            afterClick();
        }
    }
}
