package com.example.todolistui.modul.list;

import com.example.todolistui.base.BasePresenter;
import com.example.todolistui.base.BaseView;

public interface ListContract {
    interface View extends BaseView<ListContract.Presenter> {
    }

    interface Presenter extends BasePresenter {
    }
}
