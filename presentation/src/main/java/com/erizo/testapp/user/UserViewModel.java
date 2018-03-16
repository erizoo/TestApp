package com.erizo.testapp.user;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;

import com.erizo.testapp.base.BaseViewModel;
import com.erizo.testapp.base.GetUserUseCase;

import entity.UserEntity;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Erizo on 14.03.2018.
 */

public class UserViewModel extends BaseViewModel {

    private GetUserUseCase getUserByIdUSeCase = new GetUserUseCase();

    public ObservableField<String> userName = new ObservableField<>("");
    public ObservableField<String> profileUrl = new ObservableField<>("");
    public ObservableInt age = new ObservableInt();
    public ObservableBoolean progressVisible = new ObservableBoolean(false);

    public UserViewModel() {
        progressVisible.set(false);
        //метод вызван из актвити той которая приняла в xml эту viewModel

        getUserByIdUSeCase
                .get("id")
                .subscribe(new Observer<UserEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("aaa", "onSubscribe");

                    }

                    @Override
                    public void onNext(UserEntity userEntity) {
                        Log.e("aaa", "onNext");
                        userName.set(userEntity.getUserName());
                        age.set(userEntity.getAge());
                        profileUrl.set(userEntity.getProfileUrl());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("aaa", "onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("aaa", "onComplete");
                        progressVisible.set(true);
                    }
                });
    }

    @Override
    public void onResume() {
    }


    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
