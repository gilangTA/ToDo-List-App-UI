package com.example.todolistui.modul.list;


public class ListPresenter implements ListContract.Presenter{
    private final ListContract.View view;

    public ListPresenter(ListContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {}
}
