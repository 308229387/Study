package com.example.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import fragment.SendMsgFragment;

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
