package com.example.userlogin;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class UserLogin extends AppCompatActivity {
    boolean isClick;
    Button btn_choice;
    Button btn_login;
    List<String> mList;
    AutoCompleteTextView mAutoCompleteTextView;
    ArrayAdapter<String> mArrayAdapter;
    ListView listView;
    View view;
    //MyAdapter mMyAdapter;
   // RelativeLayout mRelativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setView();
        initView();
        setListener();
       // itemListener();
    }

    private void setListener() {
        btn_choice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId()==R.id.btn_user_name_choice&&!isClick){

                }else if (v.getId()==R.id.btn_user_name_choice&&isClick){

                }
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId()==R.id.btn_login){
                    String temp=mAutoCompleteTextView.getText().toString();
                    if (temp.length()==0){
                        Toast.makeText(UserLogin.this,"用户名不能为空",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (!mList.contains(temp)){
                        mList.add(temp);
                        mAutoCompleteTextView.setText("");
                    };
                }
            }
        });
    }
//    private void itemListener() {
//        mListView.setOnItemClickListener(this);
//    }

    private void init() {
        mList=new ArrayList<>();
        mList.add("123123");
        mList.add("adasdadqw");
        mArrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mList);
        //mMyAdapter=new MyAdapter();
    }

    private void initView() {
        btn_login= (Button) findViewById(R.id.btn_login);
        btn_choice= (Button) findViewById(R.id.btn_user_name_choice);
        mAutoCompleteTextView= (AutoCompleteTextView) findViewById(R.id.actv_choice);
        mAutoCompleteTextView.setAdapter(mArrayAdapter);
        view= (View) LayoutInflater.from(this).inflate(R.layout.user_list,null);
        listView= (ListView) view.findViewById(R.id.user_list);
    }
    private void setView() {
        setContentView(R.layout.user_login);
    }
    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View conver=convertView;
            if (conver==null){
                conver=getLayoutInflater().inflate(android.R.layout.simple_list_item_1,null);
            }
            TextView tv= (TextView) conver.findViewById(android.R.id.text1);
            tv.setText(mList.get(position));
            //registerForContextMenu(convertView);
            return conver;
        }
    }
}
