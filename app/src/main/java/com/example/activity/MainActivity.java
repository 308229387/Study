package com.example.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    private String[] data = {"文字上色", "Listview", "startActivityForResult", "ListOne", "静态加载Fragment", "动态加载fragment", "fragment向Activity传输信息", "SharePreference", "Service", "网络请求", "动画", "eventBus", "广播", "bb", "cc", "dd"};//假数据

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.mListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        AdapterView.OnItemClickListener onClickListener = new onClickListener();
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(onClickListener);
    }

    private void goActivity(int i) {
        switch (i) {
            case 0:
                intent = new Intent(this, TextActivity.class);
                startActivity(intent);
                break;

            case 1:
                intent = new Intent(this, ListViewActivity.class);
                startActivity(intent);
                break;

            case 2:
                intent = new Intent(this, StartResultActivity.class);
                startActivity(intent);
                break;

            case 3:
                intent = new Intent(this, ListOneActivity.class);
                startActivity(intent);
                break;

            case 4:
                intent = new Intent(this, FragmentForActivity.class);
                startActivity(intent);
                break;

            case 5:
                intent = new Intent(this, DynamicFragmentActivity.class);
                startActivity(intent);
                break;

            case 6:
                intent = new Intent(this, SendMsgToActivity.class);
                startActivity(intent);
                break;

            case 7:
                intent = new Intent(this, SharePreferenceActivity.class);
                startActivity(intent);
                break;

            case 8:
                intent = new Intent(this, ServiceActivity.class);
                startActivity(intent);
                break;
        }

    }

    private class onClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
            goActivity(i);
        }
    }


}