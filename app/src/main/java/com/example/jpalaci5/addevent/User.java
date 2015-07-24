package com.example.jpalaci5.addevent;

/**
 * Created by jpalaci5 on 7/20/2015.
 */
public class User {

    String email;
    String password;
    String zipcode;
    int birthyear, gender;

    public User(String email, String password, int birthyear, String zipcode, int gender)
    {
        this.email = email;
        this.password = password;
        this.birthyear = birthyear;
        this.zipcode = zipcode;
        this.gender = gender;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.birthyear = -1;
        this.zipcode = "";
        this.gender = -1;
    }
}
