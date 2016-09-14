package com.example.firstday;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aslan on 2016/9/7.
 */
public class ListViewDemo extends AppCompatActivity implements AdapterView.OnItemLongClickListener{
    EditText mEditText;
    ListView mListview;
    int mPosition;
    List<String> mListCountry;
    MyAdapter mMyAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setView();
        initView();
        itemListener();
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_delete:
                mListCountry.remove(mPosition);
                mMyAdapter.notifyDataSetChanged();
                break;
            case R.id.menu_update:
                AlertDialog.Builder dialog=new AlertDialog.Builder(this);
                dialog.setTitle("修改对话框");
               final EditText editText=new EditText(this);
                editText.setHint("请输入修改后的内容");
                dialog.setView(editText);
                dialog.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String temp =editText.getText().toString();
                        if (temp.length()==0)
                            return;
                        mListCountry.set(mPosition,temp);
                        mMyAdapter.notifyDataSetChanged();
                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                AlertDialog dialog1=dialog.create();
                dialog1.show();
                break;
            default:
                break;
        }
        return true;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.main,menu);
    }

    private void itemListener() {
        mListview.setOnItemLongClickListener(this);
    }

    //初始化变量
    private void init() {
        mListCountry=new ArrayList<>();
        mMyAdapter=new MyAdapter();
    }

    private void initView() {
        mEditText= (EditText) findViewById(R.id.entryCountry);
        mListview= (ListView) findViewById(R.id.countryList);
    }
    //设置布局
    private void setView() {
        setContentView(R.layout.listview_test);
    }

    public void onClick(View view) {
        String temp=mEditText.getText().toString();
        if (temp.length()==0){
            Toast.makeText(this,"国家输入不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        mListCountry.add(temp);
        mMyAdapter.notifyDataSetChanged();
        mListview.setAdapter(mMyAdapter);
        mEditText.setText("");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        mPosition=position;
        return false;
    }

    class MyAdapter extends BaseAdapter {
        /**
         * 获得显示项数
         * @return
         */
        @Override
        public int getCount() {
            return mListCountry.size();
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
                LayoutInflater lf= (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                conver=lf.inflate(android.R.layout.simple_list_item_1,null);
            }
            TextView textView= (TextView) conver.findViewById(android.R.id.text1);
            textView.setText(mListCountry.get(position));
            registerForContextMenu(conver);
            return conver;
        }
    }
}
