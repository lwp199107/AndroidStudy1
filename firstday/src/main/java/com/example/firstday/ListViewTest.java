package com.example.firstday;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
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
 * Created by Aslan on 2016/9/6.
 */
public class ListViewTest extends AppCompatActivity implements AdapterView.OnItemLongClickListener{
    EditText editText;
    ListView mListView;
    MyAdapter mMyAdapter;
    List<String> listCountry;
    int mPosition;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView();
        initView();
        init();
        itemListener();
    }
    private void itemListener() {
        mListView.setOnItemLongClickListener(this);
    }
    /**
     * ListView针对项提供了项单击,项长按,项选中三个时间
     *
     * 选中需要物理键盘支持
     * 长按时间触发的同时也会触发单击
     */

    private void init() {
        listCountry=new ArrayList<>();
        mMyAdapter=new MyAdapter();
    }

    private void setView() {
        setContentView(R.layout.listview_test);
    }

    private void initView() {
        editText= (EditText) findViewById(R.id.entryCountry);
        mListView= (ListView) findViewById(R.id.countryList);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.main,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_delete:
                listCountry.remove(mPosition);
                mMyAdapter.notifyDataSetChanged();
                break;
            case R.id.menu_update:
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setTitle("修改对话框");
                final EditText editText=new EditText(this);
                editText.setHint("请输入修改后的内容");
                builder.setView(editText);
                builder.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String temp=editText.getText().toString();
                        if (temp.length()==0)
                            return;
                        listCountry.set(mPosition,temp);
                        mMyAdapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                //通过builder构建对话框
                AlertDialog dialog=builder.create();
                //通过show()方法显示
                dialog.show();
                break;
            default:
                break;
        }
        return true;
    }

    public void onClick(View view) {
        String temp=editText.getText().toString();
        if (TextUtils.isEmpty(temp)){
            Toast.makeText(this,"输入不可为空",Toast.LENGTH_SHORT).show();
            return;
        }
        listCountry.add(temp);
        mMyAdapter.notifyDataSetChanged();
        mListView.setAdapter(mMyAdapter);
        editText.setText("");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        mPosition=position;
        return false;
    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return listCountry.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        /**
         *
         * @param position
         * @param convertView
         * @param parent
         * @return
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View conver=convertView;
            if (conver==null){
                LayoutInflater lf= (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                conver=lf.inflate(android.R.layout.simple_list_item_1,null);
                registerForContextMenu(conver);//给每项注册上下文菜单
            }
            TextView textView= (TextView) conver.findViewById(android.R.id.text1);
            //textView.setTextSize(40);
            textView.setText(listCountry.get(position));
            return conver;
        }
    }
}
