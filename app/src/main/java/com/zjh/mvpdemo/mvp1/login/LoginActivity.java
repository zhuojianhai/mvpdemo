package com.zjh.mvpdemo.mvp1.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zjh.mvpdemo.R;
import com.zjh.mvpdemo.base.baseactivity.BaseActivity;

public class LoginActivity extends BaseActivity<LoginPresenter> implements ILogin.VP{

    EditText name;
    EditText pwd;
    Button login;

    @Override
    public LoginPresenter getmPresenterInstance() {
        return new LoginPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initViews() {
        name = findViewById(R.id.et_name);
        pwd = findViewById(R.id.et_pwd);
        login = findViewById(R.id.bt_login);

    }

    @Override
    public void initListener() {
        login.setOnClickListener(this);

    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    public <ERROR> void responseError(ERROR error, Throwable throwable) {
        Toast.makeText(this," 错误了 ",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestory() {

    }

    @Override
    public void onClick(View v) {
        if(v==login){
         String names =    name.getText().toString();
         String pwds =  pwd.getText().toString();

            requestLogin(names,pwds);
        }

    }

    @Override
    public void requestLogin(String name, String pwd) {
        mPresenter.requestLogin(name,pwd);
    }

    @Override
    public void requestLoginResult(boolean loginResult) {
        Toast.makeText(this,"request result is "+loginResult,Toast.LENGTH_LONG).show();

    }
}
