package com.example.miprimerapp.DB;

import com.example.miprimerapp.Entity.Persona;
import com.example.miprimerapp.Entity.User;

import java.util.HashMap;
import java.util.List;
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
                new Persona(
                        "Bautista",
                        "Basilio",
                        "batubasilio@hotmail.com",
                        43463078
                )
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
