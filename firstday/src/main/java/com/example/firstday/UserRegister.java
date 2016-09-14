package com.example.firstday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Aslan on 2016/9/4.
 */
public class UserRegister extends AppCompatActivity{
    UserInfo user;
    public UserRegister() {
        user = new UserInfo();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_register);
        Button btn_register=(Button)findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (registerName()&password()&checkPassword())
                    finish();
            }
        });
    }
    public boolean registerName(){
        boolean isName=false;
        if(((EditText)findViewById(R.id.the_user_name)).getText().toString().equals("")){
            ((TextView) findViewById(R.id.user_name_prompt)).setText("用户名不能为空");
        }else {
            ((TextView) findViewById(R.id.user_name_prompt)).setText(" ");
            isName=true;
        }
        return isName;
    }
    public boolean password(){
        boolean isPassword=false;
       if(((EditText)findViewById(R.id.the_user_password)).getText().toString().equals("")){
            ((TextView) findViewById(R.id.password_prompt)).setText("密码不能为空");
        }else if (((EditText)findViewById(R.id.the_user_password)).getText().toString().length()<6){
            ((TextView) findViewById(R.id.password_prompt)).setText("密码长度不能小于6位");
        }else if (!judgeNumberAndLetter(((EditText)findViewById(R.id.the_user_password)).getText().toString())){
            ((TextView) findViewById(R.id.password_prompt)).setText("密码只能为数字/字母");
        }else {
            ((TextView) findViewById(R.id.password_prompt)).setText(" ");
           isPassword=true;
        }
        return isPassword;
    }
    public boolean checkPassword(){
        boolean isCheckPassword=false;
        if (((EditText) findViewById(R.id.the_user_check_password)).getText().toString().equals("")){
            ((TextView) findViewById(R.id.check_password_prompt)).setText("请再次输入密码");
        } else if (((EditText) findViewById(R.id.the_user_password)).getText().toString().equals(((EditText) findViewById(R.id.the_user_check_password)).getText().toString())) {
            ((TextView) findViewById(R.id.check_password_prompt)).setText(" ");
            isCheckPassword=true;
        }else {
            ((TextView) findViewById(R.id.check_password_prompt)).setText("密码输入不一致");
        }
        return isCheckPassword;
    }
    public boolean judgeNumberAndLetter(String str){
        boolean isCorrect=true;
        for (int i=0;i<str.length();i++){
            int temp=str.charAt(i);
            if (temp<48||temp>57&&temp<65||temp>90&&temp<97||temp>122)
                isCorrect=false;
        }
        return isCorrect;
    }
}
class UserInfo{
    private String name;
    private String password;
    private String checkPassword;
    private String male;
    private String birthDay;

    public UserInfo(String name, String password, String checkPassword, String male, String birthDay) {
        this.name = name;
        this.password = password;
        this.checkPassword = checkPassword;
        this.male = male;
        this.birthDay = birthDay;
    }

    public UserInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCheckPassword() {
        return checkPassword;
    }

    public void setCheckPassword(String checkPassword) {
        this.checkPassword = checkPassword;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
}
