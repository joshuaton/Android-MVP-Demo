package com.example.joshuaton.mvp.presenter;

/**
 * Created by joshuaton on 16/5/7.
 */
public interface ILoginPresenter {
    void clear();
    void doLogin(String name, String passwd);
    void setProgressBarVisibility(int visibility);
}
