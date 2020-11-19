package com.example.todolistui.modul.editDelete;

import android.view.View;
import com.example.todolistui.base.BaseFragmentHolderActivity;

public class EditDeleteActivity extends BaseFragmentHolderActivity {
    EditDeleteFragment editDeleteFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);

        editDeleteFragment = new EditDeleteFragment();
        String id = getIntent().getExtras().getString("TaskId");

        editDeleteFragment.setId(id);
        setCurrentFragment(editDeleteFragment, false);
    }
}
