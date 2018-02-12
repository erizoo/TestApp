package com.erizo.testapp.cw1;

/**
 * Created by Erizo on 09.02.2018.
 */

public class Singleton {

    private static final Singleton ourInstance = new Singleton();

    public String text;

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
    }
}
