package com.example.miprimerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.miprimerapp.Conveniencia.Validate;
import com.example.miprimerapp.DB.DB;
import com.example.miprimerapp.DB.UserDB;
import com.example.miprimerapp.Entity.Message;
import com.example.miprimerapp.Entity.User;

import org.w3c.dom.Text;

public class Registrar extends AppCompatActivity implements View.OnClickListener {

    private TextView txtUserName;
    private TextView txtEmail;
    private TextView txtPassword;
    private TextView txtPassword2;
    private Button btnRegistrar;
    private Intent panelLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        this.txtUserName = findViewById(R.id.txtUserName);
        this.txtPassword = findViewById(R.id.txtPassword);
        this.txtPassword2 = findViewById(R.id.txtPassword2);
        this.txtEmail = findViewById(R.id.txtEmail);
        this.btnRegistrar = findViewById(R.id.btnRegistrar);

        panelLogin = new Intent(Registrar.this,MainActivity.class);

        this.btnRegistrar.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {

        String userName = this.txtUserName.getText().toString().trim();
        String password = this.txtPassword.getText().toString();
        String password2 = this.txtPassword2.getText().toString();
        String email = this.txtEmail.getText().toString().trim();

        //VALIDAMOS
        /*
        *  -->SI LAS VARIABLES ESTAN VACIAS
        *  -->SI LA CLAVE INGRESADA CUMPLEN CON LOS PAREMTROS ESTABLECIDOS
        *  -->SI LA PERSISTENCIA ES CORRECTA
        *  -->VOLVEMOS AL LOGIN
        */
        if(!userName.isEmpty() && !password.isEmpty() && !email.isEmpty())
            if(Validate.validate(password) && Validate.validatePasswords(password,password2))
                if (new UserDB().save(new User(userName,password,email))) {
                    startActivity(this.panelLogin);
                    MainActivity.NEWUSER = true;
                }
    }
}