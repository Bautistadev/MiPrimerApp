package com.example.miprimerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.miprimerapp.DB.DB;

import java.util.EventListener;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnLogin;
    private TextView txtUserName;
    private TextView txtPassword;
    private Intent panelRegistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TRAEMOS LOS BOTONES DEL FRONT
        btnLogin =  findViewById(R.id.btnLogin);
        txtPassword = findViewById(R.id.txtPassword);
        txtUserName = findViewById(R.id.txtUserName);

        panelRegistrar = new Intent(MainActivity.this,Registrar.class);

        //DAMOS ACCION AL BOTON
        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        //COPIAMOS USUARIO Y CONTRASEÑA DEL FRONT
        String userName = this.txtUserName.getText().toString();
        String password = this.txtPassword.getText().toString();

        //SI LA CONTRASEÑA Y USUARIO SON CORRECTOS
        if(initSession(userName,password))
            //NOS MOVEMOS DE ACTIVIDAD
            startActivity(this.panelRegistrar);
        else {
            //MOSTRAMOS MENSAJE DE ERROR EN CREDENCIALES
            new AlertDialog.Builder(MainActivity.this) //INSTANCIAMOS UN MENSAJE
                    .setMessage("ERROR EN LAS CREDENCIALES")//SETEAMOS MENSAJE
                    .setCancelable(false)//EL MENSAJE NO PUEDE SER CANCELABLE
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() { //CREAMOS EL BOTON "OK"
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel(); //SALIMOS DEL MENSAJE
                        }
                    })
                    .create()//CREAMOS EL MENSAJE
                    .show();//LO MOSTRAMOS
            ;
        }

    }
    public boolean initSession(String userName, String password){
        //INSTANCIAMOS LA BASE DE DATOS
        DB DataBase = DB.getDB();

        //BUSCAMOS EL USUARIO
        for(Long i = 0L; i < DataBase.getTable().size();i++){
            if(DataBase.getTable().get(i).getUserName().equals(userName) && DataBase.getTable().get(i).getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}