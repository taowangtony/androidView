package com.material.ap.m_login;

/**
 * Created by wangtao on 2017/3/3.
 */

public interface ILoginListener {

    void onLoginSuccess();
    void onLoginFail(String msg);
}
