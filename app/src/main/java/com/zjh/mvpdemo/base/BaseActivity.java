package com.zjh.mvpdemo.base;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public abstract class BaseActivity<P extends BasePresenter,CONTRACT> extends AppCompatActivity implements View.OnClickListener{
    public abstract CONTRACT getContract();

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
