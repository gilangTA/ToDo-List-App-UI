package com.example.todolistui.modul.addList;

public class AddListPresenter implements AddListContract.Presenter {
    private final AddListContract.View view;

    public AddListPresenter(AddListContract.View view) {
        this.view = view;
    }

    @Override
    public void start() { }

    public void performLogin(final String email, final String password){
        view.redirectToListActivity();
    }
}
