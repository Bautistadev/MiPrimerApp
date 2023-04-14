package com.example.miprimerapp;

import androidx.appcompat.app.AppCompatActivity;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin =  findViewById(R.id.btnLogin);
        txtPassword = findViewById(R.id.txtPassword);
        txtUserName = findViewById(R.id.txtUserName);


        //DAMOS ACCION AL BOTON
        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

      DB DataBase = DB.getDB();

      System.out.println(DataBase.getTable().get(0L));

    }
}