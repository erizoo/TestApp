package com.erizo.testapp.base;

import android.arch.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Erizo on 12.03.2018.
 */

public class BaseViewModel extends ViewModel {
    //нужно создавать здесь что бы не засорять UserViewModel
    //забрасываем в него
    //все подписки и можно отписать сразу отовсех
    //compositeDisposable.add(забрасываем диспособлы)
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    public void onResume() {

    }

    public void onPause() {

    }

    public void onStart() {

    }

    public void onStop() {

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
}