package com.zjh.mvpdemo.mvp1.login;

/**
 * 契约合同，
 * 降低耦合度
 */
public interface ILogin {
    public interface VP {
        void requestLogin(String name,String pwd);
        void requestLoginResult(boolean loginResult);
    }
    public interface M{
        void requestLogin(String name,String pwd) throws Exception;
    }
}
