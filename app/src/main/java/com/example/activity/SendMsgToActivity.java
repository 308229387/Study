package com.example.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import fragment.SendMsgFragment;

/*
*
* Fragment向Activity传值

发送方要做4件事，创建接口、创建全局变量、创建设置监听的函数、设置触发
Fragment里创建一个接口，里面写个点击的方法，里面传值
再创建一个全局接口变量
再设置一个set监听接口的方法，带参数
设置触发事件，类似setOnclick，点击就回调的方法


接收信息方需要做两件事，设置设置监听与实现接口，复写函数
set接口
Activity实现接口
*
*
* */

public class SendMsgToActivity extends FragmentActivity implements SendMsgFragment.SendMsgToActivityListener {

    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_msg_to_activity_layout);

        textView = findViewById(R.id.send_msg_to_activity_button);


        SendMsgFragment fragment = new SendMsgFragment();

        fragment.setListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.show_send_msg_layout, fragment).commit();


    }


    @Override
    public void send(String s) {
        textView.setText(s);
    }
}
