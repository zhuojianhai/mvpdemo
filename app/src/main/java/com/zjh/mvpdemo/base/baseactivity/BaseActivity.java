package com.zjh.mvpdemo.base.baseactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.zjh.mvpdemo.R;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements View.OnClickListener{

    public P mPresenter;
    public abstract  P getmPresenterInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());

        initViews();
        initListener();
        initData();

        mPresenter = getmPresenterInstance();
        mPresenter.bindView(this);
    }

    protected abstract void initData();


    public abstract  void initViews();
    public abstract  void initListener();
    public abstract  int getContentViewId();

    public abstract <ERROR extends Object> void responseError(ERROR error,Throwable throwable);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onDestory();
    }
    public abstract  void onDestory();
}
