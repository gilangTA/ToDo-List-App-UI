package com.example.todolistui.modul.editDelete;

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
import com.example.todolistui.data.model.Task;
import com.example.todolistui.modul.list.ListActivity;

public class EditDeleteFragment extends BaseFragment<EditDeleteActivity, EditDeleteContract.Presenter> implements EditDeleteContract.View{
    EditText etTaskDate;
    EditText etTaskDescription;
    Button btnSave;
    String id;


    public EditDeleteFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_editdeleteupdate_list, container, false);
        mPresenter = new EditDeletePresenter(this);
        mPresenter.start();

        etTaskDate = fragmentView.findViewById(R.id.date_edit_field);
        etTaskDescription = fragmentView.findViewById(R.id.list_edit_field);
        btnSave = fragmentView.findViewById(R.id.save_btn_edit);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtSaveClick();
            }
        });

        setTitle("Add New Task");
        mPresenter.loadData(this.id);

        return fragmentView;
    }

    public void setBtSaveClick(){
        String title = etTaskDate.getText().toString();
        String description = etTaskDescription.getText().toString();
        mPresenter.saveData(title,description);
    }

    @Override
    public void setPresenter(EditDeleteContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToTaskList() {
        Intent intent = new Intent(activity, ListActivity.class);
        startActivity(intent);
        activity.finish();
    }

    @Override
    public void showData(Task task) {
        this.etTaskDate.setText(task.getTitle());
        this.etTaskDescription.setText(task.getDescription());
    }

    @Override
    public void setId(String id) {
        this.id=id;
    }
}
