package com.example.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

public class DynamicFragmentActivity extends FragmentActivity {
    private Button fragment1Button;
    private Button fragment2Button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);
        fragment1Button = findViewById(R.id.show_fragment1);
        fragment2Button = findViewById(R.id.show_fragment2);
        fragment1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DynamicFragmentActivity.this, "1", Toast.LENGTH_SHORT).show();
            }
        });
        fragment2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DynamicFragmentActivity.this, "2", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
