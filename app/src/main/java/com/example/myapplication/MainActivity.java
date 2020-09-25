package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView)findViewById(R.id.text);

        String text = String.format(getResources().getString(R.string.baoxiang), 2,18,"银宝箱");
        int index[] = new int[3];
        index[0] = text.indexOf("2");
        index[1] = text.indexOf("18");
        index[2] = text.indexOf("银宝箱");

        SpannableStringBuilder style=new SpannableStringBuilder(text);
        style.setSpan(new ForegroundColorSpan(Color.RED),index[0],index[0]+1, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);//ContextCompat.getColor(getActivity(), R.color.main_theme_color)
        style.setSpan(new ForegroundColorSpan(Color.RED),index[1],index[1]+2,Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        style.setSpan(new BackgroundColorSpan(Color.RED),index[2],index[2]+3,Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        textView.setText(style);
    }
}