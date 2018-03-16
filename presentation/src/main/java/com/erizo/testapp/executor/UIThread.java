package com.erizo.testapp.executor;

import executor.PostExecutionThreads;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by Erizo on 16.03.2018.
 */

public class UIThread implements PostExecutionThreads {

    @Override
    public Scheduler getSheduler() {
        return AndroidSchedulers.mainThread();
    }

}
