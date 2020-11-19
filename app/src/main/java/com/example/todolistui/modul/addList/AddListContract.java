package com.example.todolistui.modul.addList;

import com.example.todolistui.base.BasePresenter;
import com.example.todolistui.base.BaseView;

public interface AddListContract {
    interface View extends BaseView<Presenter> {
        void redirectToListActivity();
    }

    interface Presenter extends BasePresenter {
        void saveData(String dateAdd, String listAdd);
    }
}
