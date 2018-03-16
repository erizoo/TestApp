package com.erizo.testapp.base;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.erizo.testapp.BR;

/**
 * Created by Erizo on 12.03.2018.
 */

//Binding extends ViewDataBinding, ViewModel extends BaseViewModel это параметризированные типы(дженерики)
// т.е. можем установить любые типы

public abstract class BaseMvvmActivity<Binding extends ViewDataBinding,
        ViewModel extends BaseViewModel> extends AppCompatActivity {
    //один раз пишем абстарактную реализацию активити и потом это будем вставлять каждый раз когда нужно реализовать активити
    //задаёт стиль програмирования(что бы проект строился в одном стиле)
    //связывание будет заниматься эта активити
    protected Binding binding;
    protected ViewModel viewModel;

    public abstract int provideLayoutId();
    public abstract ViewModel provideViewModel();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = provideViewModel();
        binding = DataBindingUtil.setContentView(this, provideLayoutId());
        binding.setVariable(BR.viewModel , viewModel);

    }

    @Override
    protected void onResume() {
        super.onResume();
        //т.е. мы вызваем когда в активити onResume, мы вызваем метод во viewModel(зеркалим метод актвивити)
        viewModel.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewModel.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        viewModel.onStop();
    }
}