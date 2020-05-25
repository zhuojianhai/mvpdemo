package com.zjh.mvpdemo.base.baseactivity;

import com.zjh.mvpdemo.base.SuperBase;

/**
 * P 同时持有 V层和M层
 * @param <V>
 * @param <M>
 */
public abstract  class BasePresenter<V extends BaseActivity,M extends BaseModel> {
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
