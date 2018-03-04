package com.erizo.testapp.hw6;

/**
 * Created by Erizo on 27.02.2018.
 */

public class People {

    private String name;
    private String surname;
    private int  age;
    private boolean isDegree;

    public People() {
    }

    public People(String name, String surname, int age, boolean isDegree) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.isDegree = isDegree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isDegree() {
        return isDegree;
    }

    public void setDegree(boolean degree) {
        isDegree = degree;
    }
}
