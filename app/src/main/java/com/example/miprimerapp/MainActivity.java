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
import com.example.miprimerapp.DB.UserDB;
import com.example.miprimerapp.Entity.Message;
import com.example.miprimerapp.Entity.User;

import java.util.EventListener;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static boolean NEWUSER = false;

    private Button btnLogin;

    private Button btnRegistrar;
    private TextView txtUserName;
    private TextView txtPassword;
    private Intent panelRegistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageNewUser();

        //TRAEMOS LOS BOTONES DEL FRONT
        btnLogin =  findViewById(R.id.btnLogin);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        txtPassword = findViewById(R.id.txtPassword);
        txtUserName = findViewById(R.id.txtUserName);

        panelRegistrar = new Intent(MainActivity.this,Registrar.class);

        //DAMOS ACCION AL BOTON
        btnLogin.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.btnRegistrar)
            startActivity(this.panelRegistrar);
        else
            Login();
    }
    public void Login(){
        //COPIAMOS USUARIO Y CONTRASEÑA DEL FRONT
        String userName = this.txtUserName.getText().toString().trim();
        String password = this.txtPassword.getText().toString();

        //SI LA CONTRASEÑA Y USUARIO SON CORRECTOS
        if(new UserDB().existUser(userName,password))
            System.out.println(true);   //NOS MOVEMOS DE ACTIVIDAD
        else
            new Message(MainActivity.this,"ERROR, REVISE SUS CREDENCILALES !!").show(); //MOSTRAMOS MENSAJE DE ERROR
    }

    //MENSAJE QUE SOLO SE MUESTRA LUEGO DE CREAR UN NUEVO USUARIO DE FORMA EXITOSA
    public void messageNewUser(){
        if(NEWUSER) {
            new Message(MainActivity.this, "USUARIO REGISTRADO CON EXITO !!").show();
            NEWUSER = false;
        }
    }
}