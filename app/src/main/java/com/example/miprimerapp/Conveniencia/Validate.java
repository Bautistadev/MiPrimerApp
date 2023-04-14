package com.example.miprimerapp.Conveniencia;

//CLASE CREADA SOLO PARA SITUACIONES DE VALIDACION

public class Validate{

    //VALIDAMOS ENTRE AMBAS CONTRASEÑAS
    public static boolean validatePasswords(String pass1, String pass2){
        return pass1.equals(pass2);
    }
    //VALIDAMOS CONTRASEÑA
    public static boolean validate(String pass){
        return (pass.length() > 6);
    }
}
