package com.erizo.testapp.hw7;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Erizo on 02.03.2018.
 */

public interface PublicSubjectContract {

    Observable<Integer> getObservable();

}
