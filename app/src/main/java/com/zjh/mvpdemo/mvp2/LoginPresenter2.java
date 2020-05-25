package com.zjh.mvpdemo.mvp2;


import com.zjh.mvpdemo.base.BasePresenter;

public class LoginPresenter2 extends BasePresenter<LoginActivity2,LoginModel2, ILogin.VP> {


    @Override
    protected LoginModel2 getMoelInstance() {
        return new LoginModel2(this);
    }

    @Override
    public ILogin.VP getContract() {
        return new ILogin.VP() {
            @Override
            public void requestLogin(String name, String pwd) {

                try {
                    mModel.getContract().requestLogin(name,pwd);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void requestLoginResult(boolean loginResult) {
                mView.getContract().requestLoginResult(loginResult);

            }
        };
    }
}
