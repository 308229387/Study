package com.example.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SharePreferenceActivity extends Activity {
    TextView spText;
    Button writeButton;
    Button readButton;
    Context context;
    int i;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sp_layout);
        context = this;
        spText = findViewById(R.id.sp_text);
        writeButton = findViewById(R.id.sp_write_button);
        readButton = findViewById(R.id.sp_read_button);

        final SharedPreferences sharedPreferences = context.getSharedPreferences("sptest", MODE_PRIVATE);
        String temp = sharedPreferences.getString("name", "默认值");
        if (!temp.equals("默认值")) {
            spText.setText(temp);
        } else {
            i++;
        }

        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", "名字" + i);
                editor.commit();

                spText.setText("第" + i + "次输入");
                i++;
            }
        });

        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = sharedPreferences.getString("name", "默认值");
                spText.setText("存入的内容是:" + name);
            }
        });

    }
}
