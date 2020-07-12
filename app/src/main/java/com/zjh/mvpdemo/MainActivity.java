package com.zjh.mvpdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zjh.ioc.MainIOCActivity;
import com.zjh.mvpdemo.mvp1.login.LoginActivity;
import com.zjh.mvpdemo.mvp2.LoginActivity2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt1 = findViewById(R.id.bt_mvp1);
        Button bt2 = findViewById(R.id.bt_mvp2);
        Button bt3 = findViewById(R.id.bt_mvp_ioc);


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity2.class);
                startActivity(intent);

            }
        });
        bt3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MainIOCActivity.class);
                startActivity(intent);
            }
        });
    }
}
