package com.zjh.mvpdemo.base.baseactivity;

/**
 * M 要把数据回传给P层，所以持有p层
 * @param <P>
 */
public class BaseModel<P extends  BasePresenter> {
    public P mPresenter;

    public BaseModel(P mPresenter){
        this.mPresenter = mPresenter;
    }



}
