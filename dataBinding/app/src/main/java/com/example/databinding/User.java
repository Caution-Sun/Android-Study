package com.example.databinding;

import android.view.View;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

public class User {

    ObservableField<String> name = new ObservableField<>();
    ObservableInt age = new ObservableInt();
    ObservableBoolean fav = new ObservableBoolean();
    ObservableField<String> msg = new ObservableField<>();

    public User(String name, int age, boolean fav){
        this.name.set(name);
        this.age.set(age);
        this.fav.set(fav);
    }

    public ObservableField<String> getName(){
        return name;
    }

    public ObservableInt getAge(){
        return age;
    }

    public ObservableBoolean getFav(){
        return fav;
    }

    public void changeName(View view){
        name.set("YES");
    }

    public void increaseAge(View view){
        age.set(age.get() + 1);
    }

    public void toggleFav(View view){
        fav.set(!fav.get());
    }

    public ObservableField<String> getMsg(){
        return msg;
    }

    public void onTextChanged(CharSequence s, int start, int before, int count){
        msg.set(s.toString());
    }
}

