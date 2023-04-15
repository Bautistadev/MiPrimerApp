package com.example.miprimerapp.service;

import com.example.miprimerapp.Entity.User;

public class LoginService {
    private static User USER = null;

    public static User getUserLogin(){
        return USER;
    }
    public static void initSession(User user){
        USER = user;
    }
    public static boolean isInit(){
        return (USER != null);
    }
    public static void closeSession(){
        USER = null;
    }
}
