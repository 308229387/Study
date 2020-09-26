package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListViewActivity extends Activity {
    private static ArrayList<String> EMPTY = new ArrayList<String>();
    private ArrayList<String> CHEESES = new ArrayList<String>();
    private CheeseAdapter mAdapter;
    private ListView mListView;
    private ViewStub inflate_stub;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty_list);

        for (int i = 0; i < 20; i++) {
            CHEESES.add(i + "");
        }

        inflate_stub = (ViewStub) findViewById(R.id.inflate_stub);
        inflate_stub.inflate();
        inflate_stub.setVisibility(View.GONE);

        mListView = (ListView) findViewById(R.id.listView);
        mListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        mAdapter = new CheeseAdapter(CHEESES);
        mListView.setAdapter(mAdapter);
        //		mListView.setSelection(0);
//		mListView.setItemChecked(0, true);
    }

    public void onSetEmpty(View v) {
        mAdapter.changeData(EMPTY);
    }

    public void onSetData(View v) {
        mAdapter.changeData(CHEESES);
    }

    private class CheeseAdapter extends BaseAdapter {

        private ArrayList<String> mData;

        public CheeseAdapter(ArrayList<String> data) {
            mData = data;
        }

        public void changeData(ArrayList<String> data) {
            mData = data;
            if (mData.size() > 0) {
                inflate_stub.setVisibility(View.GONE);
            } else {
                inflate_stub.setVisibility(View.VISIBLE);
            }
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public String getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.listpopwindow_item,
                        parent, false);
            }

//			TextView textView = (TextView) convertView.findViewById(R.id.mytxtview);;
//			textView.setText(getItem(position));

            return convertView;
        }
    }
}
