package com.example.thirdday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdDay extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_view);
        final MyView myView= (MyView) findViewById(R.id.myView);
        myView.setOnClickListener(new MyView.OnClickListener() {
            @Override
            public void OnClick(View view) {
                Toast.makeText(ThirdDay.this,"哈哈",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
