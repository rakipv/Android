package com.example.medic_complete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity21 extends AppCompatActivity {
    TextView msg;
    Button btnLogOut;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(MainActivity21.this,dashboard.class);
                startActivity(i);
            }
        },3000);

        mAuth = FirebaseAuth.getInstance();
        msg=findViewById(R.id.message);
        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");
        msg.setText(str);


    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null){
            startActivity(new Intent(MainActivity21.this, LoginActivity.class));
        }
    }
}