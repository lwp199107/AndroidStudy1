package com.example.fifthday;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Aslan on 2016/9/14.
 */
public class Test31 extends AppCompatActivity {
    List<PhoneNumber> phoneNumberList;






    class MyAdapter extends BaseAdapter{
        private Context context;

        public MyAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return phoneNumberList.size();
        }

        @Override
        public Object getItem(int position) {
            return phoneNumberList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view=convertView;
            ViewHolder viewHolder=null;
            if (view==null){
               view=LayoutInflater.from(context).inflate(R.layout.test311,parent,false);
                viewHolder=new ViewHolder(view);
                view.setTag(viewHolder);
            }else {
                viewHolder= (ViewHolder) view.getTag();
            }
            PhoneNumber phoneNumber=phoneNumberList.get(position);
            return null;
        }
        class ViewHolder{
            ImageView imageView;
            TextView textView;

            public ViewHolder(View view) {
                imageView= (ImageView) view.findViewById(R.id.img_phoneItem);
                textView= (TextView) view.findViewById(R.id.tv_phone_number);
            }
        }
    }
}
