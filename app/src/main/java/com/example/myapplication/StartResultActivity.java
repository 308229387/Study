package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class StartResultActivity extends Activity {
    private TextView text;
    private Button buttonA;
    private Button buttonB;
    private Intent mIntent;
    private int requestCode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.star_result_layout);

        text = (TextView) findViewById(R.id.text);
        buttonA = (Button) findViewById(R.id.button_a);
        buttonB = (Button) findViewById(R.id.button_b);

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent();
                mIntent.setClass(StartResultActivity.this, ResultActivity.class);
                requestCode = 1;
                startActivityForResult(mIntent, requestCode);
            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent();
                mIntent.setClass(StartResultActivity.this, ResultActivity.class);
                requestCode = 2;
                startActivityForResult(mIntent, requestCode);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String changeA = data.getStringExtra("changeA");
        String changeB = data.getStringExtra("changeB");

        switch (requestCode) {
            case 1:
                text.setText(changeA);
                text.setTextColor(getResources().getColor(R.color.water));
                break;
            case 2:
                text.setText(changeB);
                text.setTextColor(getResources().getColor(R.color.fire));
                break;
            default:
                break;
        }
    }
}
