package com.example.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;


/*静态加载Fragment
 *
 * 1、布局中增加两个fragment xml
 * 2、写两个单独的Fragment类 来实现fragment，xml中的fragment name会用到
 * 3、在父Activity中，可以直接按自己布局使用，不需要初始化里面的fragment而直接使用
 *
 * */

public class FragmentForActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_fragment);
        Button button = findViewById(R.id.button);

        final TextView textView = findViewById(R.id.right_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("静态加载Fragment,我在Activity里也能直接调用fragment的资源");
            }
        });

    }
}
