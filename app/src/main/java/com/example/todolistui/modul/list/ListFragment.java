package com.example.todolistui.modul.list;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.example.todolistui.R;
import com.example.todolistui.base.BaseFragment;
import com.example.todolistui.modul.addList.AddListActivity;

import java.util.ArrayList;


public class ListFragment extends  BaseFragment<ListActivity, ListContract.Presenter> implements ListContract.View {
    Button add_btn_move;
    private ArrayList<String> list = new ArrayList<>();

        public  ListFragment(){
        }


        @Nullable
        @Override
        public android.view.View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            super.onCreateView(inflater, container, savedInstanceState);
            fragmentView = inflater.inflate(R.layout.fragment_list_activity, container, false);
            mPresenter = new ListPresenter(this);
            mPresenter.start();

            add_btn_move = fragmentView.findViewById(R.id.addButton);
            add_btn_move.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    redirectToAddList();
                }
            });

            ListView lvItem = fragmentView.findViewById(R.id.listAct);

            for(int i=0; i<10; i++){
                list.add("Kegiatan " + i);
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(activity, android.R.layout.simple_list_item_1, list);
            lvItem.setAdapter(adapter);

            setTitle("List Ativity");

            return fragmentView;
        }

        @Override
        public void setPresenter(ListContract.Presenter presenter) {

        }

    public void redirectToAddList(){
        Intent intent = new Intent(activity, AddListActivity.class);
        startActivity(intent);
        activity.finish();
        }
    }
