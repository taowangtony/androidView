package com.material.ap.m_login.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.material.ap.m_login.ILoginView;
import com.material.ap.m_login.presenter.LoginPresenter;
import com.material.viewapplication.R;

/**
 * Created by wangtao on 2017/3/3.
 */

public class LoginActivity extends AppCompatActivity implements ILoginView {
    private EditText eName;
    private EditText ePsd;
    private Button bLogin;
    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        initView();
    }

    private void initView() {
        eName = (EditText) findViewById(R.id.editText);
        ePsd = (EditText) findViewById(R.id.editText2);
        bLogin = (Button) findViewById(R.id.button);
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.login();
            }
        });

        mPresenter = new LoginPresenter(this);
    }

    @Override
    public String getUserName() {
        return eName.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return ePsd.getText().toString().trim();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
