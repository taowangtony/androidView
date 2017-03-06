package com.material.ap.m_login.presenter;

import android.util.Log;

import com.material.ap.m_login.ILoginListener;
import com.material.ap.m_login.ILoginView;
import com.material.ap.m_login.model.LoginOpration;

/**
 * Created by wangtao on 2017/3/3.
 */

public class LoginPresenter {

    private LoginOpration mLoginOpration;// Model of MVP
    private ILoginView mILoginView;  //View of MVP

    public LoginPresenter(ILoginView ILoginView) {
        mLoginOpration = new LoginOpration();
        mILoginView = ILoginView;
    }

    public void login(){
        mLoginOpration.login(mILoginView.getUserName(), mILoginView.getPassword(), new ILoginListener() {
            @Override
            public void onLoginSuccess() {
                Log.d("success","onSuccess");
                mILoginView.hideProgress();
            }

            @Override
            public void onLoginFail(String msg) {
                Log.d("fail","onLoginFail");
                mILoginView.hideProgress();
            }
        });
    }

}
