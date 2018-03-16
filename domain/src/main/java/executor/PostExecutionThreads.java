package executor;

import io.reactivex.Scheduler;

/**
 * Created by Erizo on 16.03.2018.
 */

//этот интерфейс нужно реализовать в presentation слое
public interface PostExecutionThreads {

    public Scheduler getSheduler();

}
