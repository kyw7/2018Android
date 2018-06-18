package com.example.kywlater.myapplication.entity;

import java.io.Serializable;

/**
 * Created by 16911 on 2018/06/15.
 */

public class animal implements Serializable {
    private int id;
    private String animal_type;//右下角的动物类型
    private String imageId;
    private int age;
    private String detail;//简介

    public animal(int id, String animal_type, String imageId, int age, String detail) {
        this.id = id;
        this.animal_type = animal_type;
        this.imageId = imageId;
        this.age = age;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimal_type() {
        return animal_type;
    }

    public void setAnimal_type(String animal_type) {
        this.animal_type = animal_type;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
