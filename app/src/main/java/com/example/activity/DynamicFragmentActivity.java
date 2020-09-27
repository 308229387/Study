package com.example.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import fragment.AFragment;
import fragment.BFragment;
import fragment.CFragment;

/*动态加载Fragment
 *
 * Fragment单独一个类，单独一个布局，在父布局中先实例化一个对象
 *
 *
 * */

public class DynamicFragmentActivity extends FragmentActivity {
    private Button fragment1Button;
    private Button fragment2Button;
    private Button fragment3Button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);
        fragment1Button = findViewById(R.id.show_fragment1);
        fragment2Button = findViewById(R.id.show_fragment2);
        fragment3Button = findViewById(R.id.show_fragment3);

        final Fragment aFragment = new AFragment();
        final Fragment bFragment = new BFragment();
        final Fragment cFragment = new CFragment();

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

    }
}
