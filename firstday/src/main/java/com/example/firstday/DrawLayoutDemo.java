package com.example.firstday;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Aslan on 2016/9/6.
 */
public class DrawLayoutDemo extends AppCompatActivity {
    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView();
        initView();
        setAdapter();
    }

    private void setAdapter() {
        mListView.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                new String[]{"111","222","333"}
        ));
    }

    private void initView() {
    mListView= (ListView) findViewById(R.id.drawLayout_lv);
    }

    private void setView() {
        setContentView(R.layout.drawlayout);
    }
}
