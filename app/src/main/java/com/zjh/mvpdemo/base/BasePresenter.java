package com.zjh.mvpdemo.base;


/**
 * P 同时持有 V层和M层
 * 面向接口编程，父类要求你传入指定接口，然后子类去具体实现
 * @param <V>
 * @param <M>
 */
public abstract  class BasePresenter<V extends BaseActivity,M extends BaseModel,CONTRACT> extends SuperBase<CONTRACT> {
    public V mView;
    public M mModel;
    
    public BasePresenter(){
        this.mModel = getMoelInstance();
    }

    protected abstract M getMoelInstance();

    public void bindView(V mView){
        this.mView = mView;
    }

    public void unBindview(){
        mView = null;
    }
}
