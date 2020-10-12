package com.example.todolistui.modul.login;

import com.example.todolistui.base.BasePresenter;
import com.example.todolistui.base.BaseView;

public interface LoginContract {
    interface View extends BaseView<Presenter> {
        void redirectToListActivity();
    }

    interface Presenter extends BasePresenter {
        void start();

        void performLogin(String email, String password);
    }
}
