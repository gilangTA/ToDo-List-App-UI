package com.example.todolistui.modul.list;

import android.view.View;

import com.example.todolistui.base.BaseFragmentHolderActivity;

public class ListActivity extends BaseFragmentHolderActivity {
    ListFragment listFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
//        ivIcon.setImageResource(R.drawable.....);
        ivIcon.setVisibility(View.VISIBLE);

        listFragment = new ListFragment();
        setCurrentFragment(listFragment, false);

    }
}
