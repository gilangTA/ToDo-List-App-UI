package com.example.todolistui.modul.editDelete;

import com.example.todolistui.base.BasePresenter;
import com.example.todolistui.base.BaseView;
import com.example.todolistui.data.model.Task;

public interface EditDeleteContract {
    interface View extends BaseView<Presenter> {
        void redirectToTaskList();
        void showData(Task task);
        void setId(String id);
    }

    interface Presenter extends BasePresenter {
        void saveData(String title, String description);
        void loadData(String id);
    }
}
