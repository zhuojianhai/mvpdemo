package com.zjh.mvpdemo.mvp1.login;

import com.zjh.mvpdemo.base.baseactivity.BasePresenter;

public class LoginPresenter extends BasePresenter<LoginActivity,LoginModel> implements ILogin.VP {
    @Override
    protected LoginModel getMoelInstance() {
        return new LoginModel(this);
    }

    @Override
    public void requestLogin(String name, String pwd) {
        try {
            //校验数据，然后请求
            mModel.requestLogin(name,pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void requestLoginResult(boolean loginResult) {
        mView.requestLoginResult(loginResult);

    }
}
