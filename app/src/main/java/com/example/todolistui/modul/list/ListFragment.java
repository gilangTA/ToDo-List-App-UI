package com.example.todolistui.modul.list;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolistui.R;
import com.example.todolistui.base.BaseFragment;
import com.example.todolistui.data.model.Task;
import com.example.todolistui.modul.addList.AddListActivity;
import com.example.todolistui.modul.editDelete.EditDeleteActivity;
import com.example.todolistui.utils.RecyclerViewAdapter;

import java.util.ArrayList;

public class ListFragment extends  BaseFragment<ListActivity, ListContract.Presenter> implements ListContract.View {
    Button add_btn_move;
    RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

        public  ListFragment(){
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            super.onCreateView(inflater, container, savedInstanceState);
            fragmentView = inflater.inflate(R.layout.fragment_list_activity, container, false);
            mPresenter = new ListPresenter(this);
            mPresenter.start();

            mRecyclerView = fragmentView.findViewById(R.id.recyclerViewList);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(activity);
            mRecyclerView.setLayoutManager(mLayoutManager);
            final ArrayList<Task> data = mPresenter.getDataSet();
            mAdapter = new RecyclerViewAdapter(data);
            mRecyclerView.setAdapter(mAdapter);
            setTitle("Todo List");

            add_btn_move = fragmentView.findViewById(R.id.addButton);
            add_btn_move.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    gotoNewTask();
                }
            });

            ((RecyclerViewAdapter) mAdapter).setOnItemClickListener(new RecyclerViewAdapter.MyClickListener() {
                @Override
                public void onItemClick(int position, View v) {
                    String id = data.get(position).getId();
                    Log.d("BELAJAR ACTIVITY",">>>>>"+ position);
                    editTask(id);
                }
            });

            return fragmentView;
        }

        @Override
        public void setPresenter(ListContract.Presenter presenter) {
            mPresenter = presenter;
        }

        @Override
        public void gotoNewTask() {
            Intent intent = new Intent(activity, AddListActivity.class);
            startActivity(intent);
        }

        public void editTask(String id) {
            Intent intent = new Intent(activity, EditDeleteActivity.class);
            intent.putExtra("TaskId", id);
            startActivity(intent);
        }
}
