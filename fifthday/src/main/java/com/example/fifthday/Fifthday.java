package com.example.fifthday;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Fifthday extends AppCompatActivity {
    Button btn;
    int num;
    TextView mTextView;
    LinearLayout mLayout;
    LinearLayout.LayoutParams layoutParams;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView();
        initView();
        init();
    }

    private void init() {
        layoutParams= (LinearLayout.LayoutParams) btn.getLayoutParams();
    }

    private void initView() {
        btn= (Button) findViewById(R.id.btn_test1);
        mTextView= (TextView) findViewById(R.id.tv_display_measure);
        mLayout= (LinearLayout) findViewById(R.id.ll_test1);
    }

    private void setView() {
        setContentView(R.layout.activity_fifthday);
    }

    public void onClick(View view) {
        num++;
        mTextView.setText(num+"");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Toast.makeText(this,"屏幕切换",Toast.LENGTH_SHORT).show();
        if (getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){
            mLayout.setOrientation(LinearLayout.HORIZONTAL);
            layoutParams.width=200;
            layoutParams.height=150;
            btn.setLayoutParams(layoutParams);
        }else {
            mLayout.setOrientation(LinearLayout.VERTICAL);
            layoutParams.width=984;
            layoutParams.height=150;
            btn.setLayoutParams(layoutParams);
        }
    }
}
