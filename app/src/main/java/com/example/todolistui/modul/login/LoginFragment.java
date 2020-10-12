package com.example.todolistui.modul.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.example.todolistui.R;
import com.example.todolistui.base.BaseFragment;
import com.example.todolistui.modul.list.ListActivity;

public class LoginFragment extends BaseFragment<LoginActivity, LoginContract.Presenter> implements LoginContract.View {

    EditText etUsername;
    EditText etPassword;
    Button btnLogin;


    public LoginFragment() {
    }

    @Nullable
    @Override
    public android.view.View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_login, container, false);
        mPresenter = new LoginPresenter(this);
        mPresenter.start();

        etUsername = fragmentView.findViewById(R.id.username_field_login);
        etPassword = fragmentView.findViewById(R.id.password_field_login);
        btnLogin = fragmentView.findViewById(R.id.login_btn);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtLoginClick();
            }
        });

        setTitle("My Login View");

        return fragmentView;
    }

    public void setBtLoginClick(){
        String usernameLogin = etUsername.getText().toString();
        String passwordLogin = etPassword.getText().toString();
        mPresenter.performLogin(usernameLogin,passwordLogin);
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToListActivity() {
            Intent intent = new Intent(activity, ListActivity.class);
            intent.putExtra("username",etUsername.getText().toString());
            intent.putExtra("password",etPassword.getText().toString());
            startActivity(intent);
            activity.finish();
    }
}
