package com.erizo.testapp.base;

import java.util.concurrent.Executor;

import io.reactivex.Scheduler;

/**
 * Created by Erizo on 16.03.2018.
 */

public abstract class BaseUseCase {

    //поток в котором будем получать результаты в presentation слое
    protected Scheduler postExecutionThread;
    //поток в котором будем выполнять сложные запросы
    protected Executor threadExecution;

    public BaseUseCase(Scheduler postExecutionThread, Executor threadExecution) {
        this.postExecutionThread = postExecutionThread;
        this.threadExecution = threadExecution;
    }

}
