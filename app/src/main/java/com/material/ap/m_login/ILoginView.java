package com.material.ap.m_login;

/**
 * Created by wangtao on 2017/3/3.
 */

public interface ILoginView {

    String getUserName();
    String getPassword();
    void showProgress();
    void hideProgress();

}
