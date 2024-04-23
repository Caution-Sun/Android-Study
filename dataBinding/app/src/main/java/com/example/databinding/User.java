package com.example.databinding;
public class User {

    String name;
    int age;
    boolean fav;

    public User(String name, int age, boolean fav){
        this.name = name;
        this.age = age;
        this.fav = fav;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public boolean getFav(){
        return fav;
    }
}

