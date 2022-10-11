package com.example.medic_complete;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;

public class bloodonateform extends AppCompatActivity {
Button btn,save,reteive,clear;
    EditText name , address,password;
    EditText email,mobileno;

    SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";
    public static final String Address = "addressKey";
    public static final String Phone = "PhoneKey";
    public static final String Pass = "PassKey";

ImageView imv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_bloodonateform);


        btn=findViewById(R.id.button_register);
        imv=findViewById(R.id.back);
        name = (EditText) findViewById(R.id.input_fullName);
        email = (EditText) findViewById(R.id.input_userEmail);
        address=findViewById(R.id.inputAddress);
        mobileno=findViewById(R.id.inputMobile);
        password=findViewById(R.id.input_password);
        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);


        imv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(bloodonateform.this,dashboard.class);
                startActivity(i);
            }
        });


        //shared prefernce
        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));

        }

        if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, ""));

        }
        if (sharedpreferences.contains(Address)) {
            email.setText(sharedpreferences.getString(Address, ""));

        }
        if (sharedpreferences.contains(Phone)) {
            email.setText(sharedpreferences.getString(Phone, ""));

        }
        if (sharedpreferences.contains(Pass)) {
            email.setText(sharedpreferences.getString(Pass, ""));

        }






        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationCompat.Builder builder=new NotificationCompat.Builder(bloodonateform.this,"Enable Notification ");
                builder.setContentTitle("Donar Registration");
                builder.setContentText("Thanks for saving a life");
                builder.setSmallIcon(R.drawable.ic_find_donor);
                builder.setAutoCancel(true);

                builder.setColor(Color.RED);
                builder.setDefaults(NotificationCompat.DEFAULT_ALL);
                NotificationManagerCompat managerCompat=NotificationManagerCompat.from(bloodonateform.this);
                managerCompat.notify(5,builder.build());
                Snackbar.make(findViewById(android.R.id.content),"Registration Successfull",Snackbar.LENGTH_LONG).setAction("close", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).setActionTextColor(Color.RED).show();

            }
        });

















    }
    public void Save(View view) {

        String n = name.getText().toString();
        String e = email.getText().toString();

        String p=mobileno.getText().toString();
        String a=address.getText().toString();
        String pp=password.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Name, n);
        editor.putString(Email, e);

        editor.putString(Phone, p);
        editor.putString(Address, a);
        editor.putString(Pass, pp);
        editor.commit();
    }
    public void Get(View view) {
        name = (EditText) findViewById(R.id.input_fullName);
        email = (EditText) findViewById(R.id.input_userEmail);
        address=findViewById(R.id.inputAddress);
        mobileno=findViewById(R.id.inputMobile);
        password=findViewById(R.id.input_password);
        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, ""));

        }
        if (sharedpreferences.contains(Address)) {
            address.setText(sharedpreferences.getString(Address, ""));

        }
        if (sharedpreferences.contains(Phone)) {
            mobileno.setText(sharedpreferences.getString(Phone, ""));

        }
        if (sharedpreferences.contains(Pass)) {
            password.setText(sharedpreferences.getString(Pass, ""));

        }

    }


    public void clear(View view) {
        name = (EditText) findViewById(R.id.input_fullName);
        email = (EditText) findViewById(R.id.input_userEmail);
        address=findViewById(R.id.inputAddress);
        mobileno=findViewById(R.id.inputMobile);
        password=findViewById(R.id.input_password);
        name.setText("");
        email.setText("");
        address.setText("");
        mobileno.setText("");
        password.setText("");

    }

}