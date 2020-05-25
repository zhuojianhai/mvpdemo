package com.zjh.mvpdemo.mvp1.login;

import com.zjh.mvpdemo.base.baseactivity.BaseModel;

public class LoginModel extends BaseModel<LoginPresenter> implements ILogin.M{
    public LoginModel(LoginPresenter mPresenter) {
        super(mPresenter);
    }

    /**
     * 真正的网络数据请求
     * @param name
     * @param pwd
     * @throws Exception
     */
    @Override
    public void requestLogin(String name, String pwd) throws Exception {

        //请求服务器登录接口，拿到接口数据，返回json数据

        if(name.equals("abc") && pwd.equals("123")){

            mPresenter.requestLoginResult(true);
        }else{
            mPresenter.requestLoginResult(false);
        }

    }
}
