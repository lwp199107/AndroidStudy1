package com.example.firstday;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class zhaiDisplay extends AppCompatActivity{
    Button bt_login;
    Button bt_register;
    TextView tv_forget_password;
    List<String> userList;
    EditText userName;
    EditText password;
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setView();
        initView();
        setListen();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void init() {
        userList=new ArrayList<>();
    }

    /**
     * 设置监听
     */
    private void setListen() {
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp=userName.getText().toString();
                if (v.getId()==R.id.button1&&temp.length()!=0) {
                    userList.add(temp);
                    SharedPreferences mSharedPre = getSharedPreferences("user", MODE_PRIVATE);
                    SharedPreferences.Editor editor = mSharedPre.edit();
                    editor.putString(userName.getText().toString(), password.getText().toString());
                    editor.apply();
                    finish();
                }
            }
        });
        userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (userName.getText()!=null){
                   //
               }
            }
        });
        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (v.getId()==R.id.button2) {
////                    Toast t = Toast.makeText(zhaiDisplay.this,"注册被单击了",Toast.LENGTH_LONG);
////                    t.setGravity(Gravity.CENTER,0,0);
////                    t.show();
//                    Intent intent=new Intent(zhaiDisplay.this,UserRegister.class);
//                    startActivity(intent);
//                }
                SharedPreferences mSharedPre=getSharedPreferences("user",MODE_PRIVATE);
                password.setText(mSharedPre.getString(userName.getText().toString(),""));
            }
        });
        tv_forget_password.setMovementMethod(LinkMovementMethod.getInstance());
    }


    private void initView() {
        bt_login=(Button)findViewById(R.id.button1);
        bt_register=(Button)findViewById(R.id.button2);
        tv_forget_password=(TextView)findViewById(R.id.forget_password);
        userName= (EditText) findViewById(R.id.editText1);
        password= (EditText) findViewById(R.id.editText2);
        checkBox= (CheckBox) findViewById(R.id.checkBox);
    }

    private void setView() {
        setContentView(R.layout.activity_zhai_display);
    }

    public void choiceClick(View view) {

    }

}
