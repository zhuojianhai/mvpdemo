package com.zjh.mvpdemo.base;


/**
 * M 要把数据回传给P层，所以持有p层
 * @param <P>
 */
public abstract  class BaseModel<P extends  BasePresenter,CONTRACT> extends SuperBase<CONTRACT>{
    public P mPresenter;

    public BaseModel(P mPresenter){
        this.mPresenter = mPresenter;
    }



}
