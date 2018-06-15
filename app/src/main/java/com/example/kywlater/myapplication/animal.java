package com.example.kywlater.myapplication;

/**
 * Created by 16911 on 2018/06/15.
 */

public class animal {
    private String animal_type;
    private int Imageid;
    private int animal_age;
    private String detail;
    private String id;
    public animal(int animal_age,String animal_type,String detail,int Imageid,String id){
        this.animal_age=animal_age;
        this.animal_type=animal_type;
        this.detail=detail;
        this.Imageid=Imageid;
        this.id=id;
    }
    public String getAnimal_type(){
        return animal_type;
    }
    public int getAnimal_age(){
        return animal_age;
    }
    public int getImageid(){
        return Imageid;
    }
    public String getDetail(){
        return detail;
    }
    public String getId(){return id;}
}
