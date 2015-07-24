package com.example.jpalaci5.addevent;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by jpalaci5 on 7/20/2015.
 */
public class UserLocalStore {

    public static final String SP_EMAIL = "userDetails";
    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context)
    {
        userLocalDatabase = context.getSharedPreferences(SP_EMAIL, 0);
    }

    public void storeUserData(User user)
    {
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putString("email", user.email);
        spEditor.putString("password", user.password);
        spEditor.putInt("birthyear", user.birthyear);
        spEditor.putString("zipcode", user.zipcode);
        spEditor.putInt("gender", user.gender);
        spEditor.commit();

    }

    public User getLoggedInUser(){
        String email= userLocalDatabase.getString("email", "");
        String password= userLocalDatabase.getString("password", "");
        int birthyear= userLocalDatabase.getInt("birthyear", -1);
        String zipcode= userLocalDatabase.getString("zipcode", "");
        int gender= userLocalDatabase.getInt("gender", -1);

        User storedUser = new User(email, password, birthyear, zipcode, gender);
        return storedUser;
    }

    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn", loggedIn);
        spEditor.commit();

    }

    public boolean getUserLoggedIn(){
        if (userLocalDatabase.getBoolean("loggedIn", false)== true){
            return true;
        }
        else { return false;}
    }

    public void clearData(){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
}
