package com.example.miprimerapp.Entity;

public class User {
    private String userName;
    private String password;
    private Persona persona;


    public User(){}

    public User(String userName, String password, Persona persona) {
        this.userName = userName;
        this.password = password;
        this.persona = persona;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Persona getPersona() {
        return persona;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", persona=" + persona +
                '}';
    }
}
