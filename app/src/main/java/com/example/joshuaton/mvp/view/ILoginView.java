package com.example.joshuaton.mvp.view;

/**
 * Created by joshuaton on 16/5/7.
 */
public interface ILoginView {
    public void onClearText();
    public void onLoginResult(Boolean result, int code);
    public void onSetProgressBarVisibility(int visibility);
}
