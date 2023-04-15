package com.example.miprimerapp.Entity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class Message extends AlertDialog.Builder implements  DialogInterface.OnClickListener{
    public Message(Context context,String Message) {
        super(context);
        this.setMessage(Message);
        this.setCancelable(false);
        this.setPositiveButton("OK",this);
        this.create();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }


}
