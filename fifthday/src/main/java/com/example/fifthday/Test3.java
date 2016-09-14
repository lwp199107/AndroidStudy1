package com.example.fifthday;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Aslan on 2016/9/14.
 */
public class Test3 extends AppCompatActivity implements View.OnClickListener {
    EditText phone;
    EditText message;
    Button btn_phone;
    Button btn_message;
    Button btn_send;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView();
        initView();
    }

    private void initView() {
        phone= (EditText) findViewById(R.id.et_phone_number);
        message= (EditText) findViewById(R.id.et_message);
        btn_phone= (Button) findViewById(R.id.btn_choose_phone);
        btn_message= (Button) findViewById(R.id.btn_choose_message);
        btn_send= (Button) findViewById(R.id.btn_send);
    }

    private void setView() {
        setContentView(R.layout.test3);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_choose_phone:
                Intent intent1=new Intent(this,Test31.class);
                startActivityForResult(intent1,1);//跳转至毫毛选择界面
                break;
            case R.id.btn_choose_message:
                Intent intent2=new Intent(this,Test32.class);
                startActivityForResult(intent2,2);//跳转至毫毛选择界面
                break;
            case R.id.btn_send:
                break;
            default:
                break;
        }
    }
}
