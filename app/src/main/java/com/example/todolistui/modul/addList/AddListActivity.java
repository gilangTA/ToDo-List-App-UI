package com.example.todolistui.modul.addList;

import android.view.View;
import com.example.todolistui.base.BaseFragmentHolderActivity;

public class AddListActivity extends BaseFragmentHolderActivity {
    AddListFragment addListFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        btBack.setVisibility(View.VISIBLE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.VISIBLE);

        addListFragment = new AddListFragment();
        setCurrentFragment(addListFragment, false);
    }
}
