package com.erizo.testapp.base;

import java.util.concurrent.Executor;

import executor.PostExecutionThreads;
import executor.ThreadExecutor;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Erizo on 16.03.2018.
 */

public abstract class BaseUseCase {

    //поток в котором будем получать результаты в presentation слое
    protected Scheduler postExecutionThread;
    //поток в котором будем выполнять сложные запросы
    protected Scheduler threadExecution;

    public BaseUseCase(PostExecutionThreads postExecutionThread) {
        this.postExecutionThread = postExecutionThread.getSheduler();
        this.threadExecution = Schedulers.io();
    }

    public BaseUseCase(PostExecutionThreads postExecutionThread, ThreadExecutor threadExecution) {
        this.postExecutionThread = postExecutionThread.getSheduler();
        this.threadExecution = Schedulers.from(threadExecution);
    }

}
