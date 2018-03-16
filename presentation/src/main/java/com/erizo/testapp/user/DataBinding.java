package com.erizo.testapp.user;

import android.arch.lifecycle.ViewModelProviders;

import com.erizo.testapp.R;
import com.erizo.testapp.base.BaseMvvmActivity;
import com.erizo.testapp.databinding.ActivityUserBinding;

/**
 * Created by Erizo on 14.03.2018.
 */

public class DataBinding extends BaseMvvmActivity<ActivityUserBinding, UserViewModel> {

    @Override
    public int provideLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    public UserViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(UserViewModel.class);
    }
}