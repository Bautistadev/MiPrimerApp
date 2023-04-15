package com.example.miprimerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

import com.example.miprimerapp.service.LoginService;

public class MenuPrincipal extends AppCompatActivity {

    private TextView txtNombre;
    private TextView txtEmail;
    private Intent panelLogin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        this.txtNombre = findViewById(R.id.txtNombre);
        this.txtEmail = findViewById(R.id.txtEmail);

        panelLogin = new Intent(MenuPrincipal.this,MainActivity.class);

        Session();

    }
    void Session(){
        if(LoginService.isInit()){
            this.txtNombre.setText(LoginService.getUserLogin().getUserName());
            this.txtEmail.setText(LoginService.getUserLogin().getEmail());
        }

    }
    @Override
    public void onBackPressed() {

    }


}