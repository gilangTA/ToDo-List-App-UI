package com.example.todolistui.modul.editDelete;

import com.example.todolistui.data.model.Task;

public class EditDeletePresenter implements EditDeleteContract.Presenter {
    private final EditDeleteContract.View view;

    public EditDeletePresenter(EditDeleteContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {
    }

    @Override
    public void saveData(final String title, final String description){
        Task newTask = new Task("3", title, description);
        //save new task
        //then go back to task list
        view.redirectToTaskList();
    }

    @Override
    public void loadData(String id) {
        //load data task by id
        //then send data to fragment
        Task task = new Task("3", "title of taskIndex:"+id, "description of taskIndex:"+id);
        view.showData(task);
    }
}
