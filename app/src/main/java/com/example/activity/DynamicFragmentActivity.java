package com.example.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import fragment.AFragment;
import fragment.BFragment;
import fragment.CFragment;

/*动态加载Fragment
 *
 * Fragment单独一个类，单独一个布局，在父布局中先实例化一个对象，再获取管理器，启动add进来，然后提交。
 *
 * Fragment向Activity传值：Fragment向Activity传值
 *
 * 发送方要做4件事，创建接口、创建全局变量、创建设置监听的函数、设置触发
 * Fragment里创建一个接口，里面写个点击的方法，里面传值
 * 再创建一个全局接口变量
 * 再设置一个set监听接口的方法，带参数
 * 设置触发事件，类似setOnclick，点击就回调的方法
 *
 *
 * 接收信息方需要做两件事，设置设置监听与实现接口，复写函数
 * set接口
 * Activity实现接口
 *
 * */

public class DynamicFragmentActivity extends FragmentActivity implements CFragment.SendActivityMessageListener {
    private Button fragment1Button;
    private Button fragment2Button;
    private Button fragment3Button;
    private Button sendMessageButton;
    private Button sendDynamicMessageButton;
    private int i;
    private AFragment aFragment;
    private BFragment bFragment;
    private CFragment cFragment;
    private Bundle bundle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initDate();
    }

    private void initView() {
        setContentView(R.layout.activity_dynamic_fragment);
        fragment1Button = findViewById(R.id.show_fragment1);
        fragment2Button = findViewById(R.id.show_fragment2);
        fragment3Button = findViewById(R.id.show_fragment3);
        sendMessageButton = findViewById(R.id.send_message_button);
        sendDynamicMessageButton = findViewById(R.id.send_dynamic_message_button);

        aFragment = new AFragment();
        bFragment = new BFragment();
        cFragment = new CFragment();
        cFragment.setListener(this);

        bundle = new Bundle();
    }

    private void initDate() {
        fragment1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.show_fragment_layout, aFragment).commit();
            }
        });

        fragment2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.show_fragment_layout, bFragment).commit();
            }
        });

        fragment3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.show_fragment_layout, cFragment).commit();
            }
        });

        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });


        sendDynamicMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
            }
        });

    }

    //静态向Fragment传值
    private void sendMessage() {
        bundle.putString("data", "我是初始化时传的值");
        cFragment.setArguments(bundle);
    }

    //接收Fragment传过来的值
    @Override
    public void send(String s) {
        sendDynamicMessageButton.setText(s);
    }
}
