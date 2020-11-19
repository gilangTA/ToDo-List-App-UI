package com.example.todolistui.modul.list;

import com.example.todolistui.base.BasePresenter;
import com.example.todolistui.base.BaseView;
import com.example.todolistui.data.model.Task;

import java.util.ArrayList;

public interface ListContract {
    interface View extends BaseView<ListContract.Presenter> {
        void gotoNewTask();
    }

    interface Presenter extends BasePresenter {
        ArrayList<Task> getDataSet();
    }
}
