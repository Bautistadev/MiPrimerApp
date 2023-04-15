package com.example.miprimerapp.DB;

import com.example.miprimerapp.Entity.User;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class UserDB {

    private Map<Long,User> dataBase = DB.getDB().getTable();

    public Long lastKey(Map<Long,User> database ){
        //ULTIMA CLAVE
       return database.keySet().stream().reduce((first,second)->second).get();
    }

    public Boolean save(User user){
        try{
            //PERSISTIMO
            dataBase.put(lastKey(dataBase)+1,user);
            return  true;
        }catch (Exception e){
            return false;
        }

    }

    //ROTORNA SOLO EL LISTADO DE USUARION, SIN LAS CLAVES
    public Collection<User> getOnlyUsers(){
        return dataBase.values();
    }

    public Boolean existUser(String userName, String password){
        //BUSCAMOS EL USUARIO
        for(User usuario: dataBase.values()){
            if(usuario.getUserName().equals(userName) && usuario.getPassword().equals(password))
                return true;
        }
        return false;
    }

    public User getUserDb(String userName,String password){
        for(User usuario: dataBase.values()){
            if(usuario.getUserName().equals(userName) && usuario.getPassword().equals(password))
                return usuario;
        }
        return null;
    }

}
