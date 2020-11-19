package com.example.todolistui.modul.addList;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolistui.R;
import com.example.todolistui.base.BaseFragment;
import com.example.todolistui.data.model.Task;
import com.example.todolistui.modul.list.ListActivity;
import com.example.todolistui.utils.RecyclerViewAdapter;

public class AddListFragment extends BaseFragment<AddListActivity, AddListContract.Presenter> implements AddListContract.View {

    RecyclerView mRecyclerView;
    EditText etDate;
    EditText etList;
    Button btnAdd;

    public AddListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_add_list, container, false);
        mPresenter = new AddListPresenter(this);
        mPresenter.start();

        etDate = fragmentView.findViewById(R.id.date_add_field);
        etList = fragmentView.findViewById(R.id.list_add_field);
        btnAdd = fragmentView.findViewById(R.id.btn_add_list);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtAddClick();
            }
        });

        setTitle("Add List");
        return fragmentView;
    }

    public void setBtAddClick(){
        String dateAdd = etDate.getText().toString();
        String listAdd = etList.getText().toString();
        mPresenter.saveData(dateAdd,listAdd);
    }

    @Override
    public void setPresenter(AddListContract.Presenter presenter) { mPresenter = presenter;}

    @Override
    public void redirectToListActivity() {

        activity.finish();
    }
}

