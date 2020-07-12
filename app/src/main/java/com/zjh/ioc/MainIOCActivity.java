package com.zjh.ioc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.zjh.mvpdemo.R;

@ContentView(R.layout.activity_main_ioc)
public class MainIOCActivity extends BaseActivity {

    @ViewInject(R.id.button)
    Button btn1;
    @ViewInject(R.id.button2)
    Button btn2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btn1.setText("了撒娇格拉斯哥");
        btn2.setText("哒哒哒哒哒哒多了撒娇格拉斯哥");
    }
}
