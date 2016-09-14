package com.example.fifthday;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Aslan on 2016/9/14.
 */
public class Test2 extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView();
    }
    private void setView() {
        setContentView(R.layout.activity_test2);
    }

    public void next(View view) {
        Intent intent=new Intent(this,Test21.class);
        startActivity(intent);
        //第一种:开启新的activity时,将本activity给销毁掉finish(),那么在最后一个activity按下back键时,自动退出应用
        // 第二种方法:构造一个ActivityList类,其拥有List<Activity>属性,addActivity方法和finishAll()方法;
            // 每当开启一个新的Activity时,调用addActivity()方法将其放入List中;
            // 改写最后一个Activity的onBackPress方法,调用finishAll()方法,将所有的Activity全部finish;
        //第三种在AndroidMainfest中将activity的nohistory置为true;
        //第四种:在倒数第二个activity中Intent最后一个activity时,将此前的用于存放activity的栈进行清空处理,只开辟新栈用于存放新生成的最后一个activity;
        // intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);

    }
}
