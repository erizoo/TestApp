package com.erizo.testapp.hw6;

import java.util.List;

/**
 * Created by Erizo on 27.02.2018.
 */

public class JsonTest {

    private String name;
    private int gender;
    private String date;
    private List<People> people;

    public JsonTest() {
    }

    public JsonTest(String name, int gender, String date, List<People> people) {
        this.name = name;
        this.gender = gender;
        this.date = date;
        this.people = people;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<People> getPeople() {
        return people;
    }

    public void setPeople(List<People> people) {
        this.people = people;
    }
}
