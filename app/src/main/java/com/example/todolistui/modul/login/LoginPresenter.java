package com.example.todolistui.modul.login;


public class LoginPresenter implements LoginContract.Presenter{
    private final LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {}

    @Override
    public void performLogin(final String email, final String password){
        //proses com.example.todolistui.modul.com.example.todolistui.modul.login
        //if com.example.todolistui.modul.com.example.todolistui.modul.login success call redirect to profile
        view.redirectToListActivity();
    }

}
