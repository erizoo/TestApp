package com.erizo.testapp.base;

import entity.UserEntity;
import executor.PostExecutionThreads;
import executor.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Erizo on 16.03.2018.
 */

public class GetUserUseCase extends BaseUseCase {

    public GetUserUseCase(PostExecutionThreads postExecutionThread) {
        super(postExecutionThread);
    }

    public Observable<UserEntity> get(String id) {
        //то что в крэейч будет в другом потоке
        //как правило ненужно самому создавать obserable, а будем подписываться(например к realm)
        return Observable.create((ObservableOnSubscribe<UserEntity>) emitter -> {
            Thread.sleep(2000);
            UserEntity entity = new UserEntity("user name",
                    12, "http://tomidjerry.com/images/stories/kot_tom.png");
            //создали источник данных
            emitter.onNext(entity);
            emitter.onComplete();
        })
                .subscribeOn(postExecutionThread)//в каком потокe хотим запустить получения результата
                .observeOn(threadExecution);//в каком потоку хотим запустить результат
    }

}
