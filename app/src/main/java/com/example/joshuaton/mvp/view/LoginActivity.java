package com.example.joshuaton.mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.joshuaton.mvp.R;
import com.example.joshuaton.mvp.presenter.ILoginPresenter;
import com.example.joshuaton.mvp.presenter.LoginPresenterCompl;

public class LoginActivity extends AppCompatActivity implements ILoginView , View.OnClickListener{
    private EditText mEtUserName;
    private EditText mEtPassword;
    private Button mBtnLogin;
    private Button mBtnClear;
    private ProgressBar mProgressBar;

    ILoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEtUserName = (EditText) findViewById(R.id.activity_main_et_username);
        mEtPassword = (EditText) findViewById(R.id.activity_main_et_password);
        mBtnLogin = (Button) findViewById(R.id.activity_main_btn_login);
        mBtnClear = (Button) findViewById(R.id.activity_main_btn_clear);
        mProgressBar = (ProgressBar) findViewById(R.id.activity_main_pb_loading);

        mBtnLogin.setOnClickListener(this);
        mBtnClear.setOnClickListener(this);

        mLoginPresenter = new LoginPresenterCompl(this);
        mLoginPresenter.setProgressBarVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.activity_main_btn_login:
                mLoginPresenter.setProgressBarVisibility(View.VISIBLE);
                mLoginPresenter.doLogin(mEtUserName.getText().toString(), mEtPassword.getText().toString());
                break;
            case R.id.activity_main_btn_clear:
                mLoginPresenter.clear();
                break;
        }
    }

    @Override
    public void onClearText() {
        mEtUserName.setText("");
        mEtPassword.setText("");
    }

    @Override
    public void onLoginResult(Boolean result, int code) {
        mLoginPresenter.setProgressBarVisibility(View.INVISIBLE);
        if(result){
            Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "fail", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {
        mProgressBar.setVisibility(visibility);
    }


}
