package com.example.joshuaton.mvp.presenter;

import com.example.joshuaton.mvp.view.ILoginView;

/**
 * Created by joshuaton on 16/5/7.
 */
public class LoginPresenterCompl implements ILoginPresenter{
    ILoginView mLoginView;

    public LoginPresenterCompl(ILoginView iLoginView){
        this.mLoginView = iLoginView;
    }

    @Override
    public void clear() {
        mLoginView.onClearText();
    }

    @Override
    public void doLogin(String name, String passwd) {
        Boolean isLoginSuccess = true;
        int code = 0;

        if("admin".equals(name) && "admin".equals(passwd)){
        }else{
            isLoginSuccess = false;
            code = -1;
        }
        mLoginView.onLoginResult(isLoginSuccess, code);

    }

    @Override
    public void setProgressBarVisibility(int visibility) {
        mLoginView.onSetProgressBarVisibility(visibility);
    }
}
