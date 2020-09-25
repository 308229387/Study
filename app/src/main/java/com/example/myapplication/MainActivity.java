package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private String data[] = {"aa", "bb", "cc", "dd", "aa", "bb", "cc", "dd", "aa", "bb", "cc", "dd", "aa", "bb", "cc", "dd"};//假数据
    Intent intent;

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

    private class onClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

            goActivity(i);


            switch (i) {
                case 0:

                    Toast.makeText(MainActivity.this, "你点击了" + i + "按钮", Toast.LENGTH_SHORT).show();
                    break;//当我们点击某一项就能吐司我们点了哪一项

                case 1:
                    Toast.makeText(MainActivity.this, "你点击了" + i + "按钮", Toast.LENGTH_SHORT).show();
                    break;

                case 2:
                    Toast.makeText(MainActivity.this, "你点击了" + i + "按钮", Toast.LENGTH_SHORT).show();
                    break;

                case 3:
                    Toast.makeText(MainActivity.this, "你点击了" + i + "按钮", Toast.LENGTH_SHORT).show();
                    break;

                case 4:
                    Toast.makeText(MainActivity.this, "你点击了" + i + "按钮", Toast.LENGTH_SHORT).show();
                    break;
            }

        }
    }

    private void goActivity(int i) {
        switch (i) {
            case 0:
                intent = new Intent(this, TextActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "你点击了" + i + "按钮", Toast.LENGTH_SHORT).show();
                break;//当我们点击某一项就能吐司我们点了哪一项

            case 1:
                Toast.makeText(MainActivity.this, "你点击了" + i + "按钮", Toast.LENGTH_SHORT).show();
                break;

            case 2:
                Toast.makeText(MainActivity.this, "你点击了" + i + "按钮", Toast.LENGTH_SHORT).show();
                break;

            case 3:
                Toast.makeText(MainActivity.this, "你点击了" + i + "按钮", Toast.LENGTH_SHORT).show();
                break;

            case 4:
                Toast.makeText(MainActivity.this, "你点击了" + i + "按钮", Toast.LENGTH_SHORT).show();
                break;
        }

    }


}