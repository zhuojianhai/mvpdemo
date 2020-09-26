package com.zjh.mvpdemo.base;

/**
 * 所有base接口的父类
 * @param <CONTRACT>
 */
public abstract class SuperBase<CONTRACT> {
    public abstract CONTRACT getContract();
}
