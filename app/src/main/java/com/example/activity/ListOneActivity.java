package com.example.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import adapter.SettingAdapter;
import bean.Setting;
import data.ConstantData;

public class ListOneActivity extends Activity implements AdapterView.OnItemClickListener {
    private ListOneActivity self = this;
    private ListView listView;
    private SettingAdapter adapter;
    private ArrayList<Setting> list;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    list.get(1).setSub("0M");
                    adapter.notifyDataSetChanged();
                    break;
                default:
                    break;
            }
        }
        ;
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        listView = (ListView) findViewById(R.id.list_one);
        list = ConstantData.SETTING_LIST_LOGIN;
        adapter = new SettingAdapter(list, self);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                Toast.makeText(self, position + "", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(self, position + "", Toast.LENGTH_SHORT).show();
                handler.sendEmptyMessageDelayed(1, 2000);
                break;
            case 2:
                Toast.makeText(self, position + "", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(self, position + "", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(self, position + "", Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(self, position + "", Toast.LENGTH_SHORT).show();
                break;
            case 6:
                Toast.makeText(self, position + "", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
