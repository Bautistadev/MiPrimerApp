package com.example.miprimerapp.DB;

import com.example.miprimerapp.Entity.User;

import java.util.HashMap;
import java.util.Map;

public class DB {
    private static  DB singleton = null;
    //CREAMOS LA LISTA QUE SIMULA LA BASE DE DATOS
    private Map<Long, User> listUser = new HashMap<>();

    //CONSTRUCTOR
    private DB(){
        //DAMOS DE ALTA AL USUARIO ADMINISTRADOR
        this.listUser.put(0L,new User(
                "admin",
                "admin",
                "batubasilio@hotmail.com"
        ));
    }

    public static DB getDB(){
        if(singleton == null){
            singleton = new DB();
        }
        return singleton;
    }

    public Map<Long, User> getTable(){
        return this.listUser;
    }
}
