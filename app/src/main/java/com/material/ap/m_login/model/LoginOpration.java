package com.material.ap.m_login.model;

import android.util.Log;

import com.material.ap.m_login.ILogin;
import com.material.ap.m_login.ILoginListener;

/**
 * Created by wangtao on 2017/3/3.
 */

public class LoginOpration implements ILogin {
    @Override
    public void login(final String a, final String b, final ILoginListener loginListener) {

        new Thread() {
            @Override
            public void run() {
                if (a.equals("wangtao") && b.equals("123456")) {
                    loginListener.onLoginSuccess();
                    Log.i("username",a);
                    Log.i("password",b);
                } else {
                    loginListener.onLoginFail("登录失败");
                    Log.i("username",a);
                    Log.i("password",b);
                }

            }
        }.start();

    }
}
