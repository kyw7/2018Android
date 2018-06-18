package com.example.kywlater.myapplication.entity;

import android.graphics.Picture;

import java.util.List;

public class Person {
    private int id;
    private String name;
    private String password;
    //private List<animal> adopted;
    //private String head;

    public Person(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Person() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
