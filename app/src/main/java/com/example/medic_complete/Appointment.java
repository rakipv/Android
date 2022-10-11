package com.example.medic_complete;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.snackbar.Snackbar;

public class Appointment extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {
  ConstraintLayout cl;
  ImageView back;
Switch simpleSwitch;
Button submit;

    private TextView textView;
    private ProgressBar progressBar;
    private SeekBar seekBar;

    String[] courses = { "10-15", "16-20",
            "21-26", "26-35",
            "35-50", "60+" };
    ToggleButton tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        String uri = "...";
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
//
//        startActivity(intent);

        cl=(ConstraintLayout) findViewById(R.id.cll);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        Spinner spino = findViewById(R.id.spinner);
        spino.setOnItemSelectedListener(this);
        tb = (ToggleButton) findViewById(R.id.toggleButton);
        tb.setChecked(false);
        tb.setTextOn("Remainder is Set");
        simpleSwitch=findViewById(R.id.simpleSwitch); // initiate Switch
        textView = (TextView) findViewById(R.id.textView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        simpleSwitch.setTextOn("On"); // displayed text of the Switch whenever it is in checked or on state
        simpleSwitch.setTextOff("Off"); // displayed text of the Switch whenever it is in unchecked i.e. off state
        submit=findViewById(R.id.submit);
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Appointment.this,dashboard.class);
                startActivity(i);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder=new NotificationCompat.Builder(Appointment.this,"Appointment Registration  ");
                builder.setContentTitle("Registration Added");
                builder.setContentText("Your Appointment is Sent to Center ,we will reply with confirmation");
         builder.setDefaults(NotificationCompat.DEFAULT_ALL);
                builder.setSmallIcon(R.drawable._01);
                builder.setAutoCancel(true);
                NotificationManagerCompat managerCompat=NotificationManagerCompat.from(Appointment.this);
                managerCompat.notify(2,builder.build());
                Toast.makeText(Appointment.this,"Appointment Sent for Confrmation",Toast.LENGTH_LONG).show();
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressBar.setProgress(progress);
                textView.setText("" + progress + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        tb.setTextOff("Remainder is Turned Off");
        tb.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                Snackbar.make(findViewById(android.R.id.content),"Remander is added to you Calender",Snackbar.LENGTH_LONG).setAction("close", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).setActionTextColor(Color.RED).show();
            }
        });
        simpleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                //open the url when user taps the notification
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.c1ctech.com/"));
                PendingIntent pendingIntent = PendingIntent.getActivity(Appointment.this, 0, intent, 0);



                NotificationCompat.Builder builder=new NotificationCompat.Builder(Appointment.this,"Enable Notification ");
                builder.setContentTitle("Notification Enable");
                builder.setContentText("You will now start to recieve notification from this application");
                builder.setSmallIcon(R.drawable.ic_find_donor);
                builder.setAutoCancel(true);
                builder.setDefaults(NotificationCompat.DEFAULT_ALL);

                NotificationManagerCompat managerCompat=NotificationManagerCompat.from(Appointment.this);
                managerCompat.notify(1,builder.build());
                builder.setContentIntent(pendingIntent)
                        //removes the notification when the user taps it
                        .setAutoCancel(true)
                        .build();


                Snackbar.make(findViewById(android.R.id.content),"You Will Recieve Notification",Snackbar.LENGTH_LONG).setAction("close", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).setActionTextColor(Color.RED).show();
            }
        });


        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                courses);
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        spino.setAdapter(ad);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AlertDialog.Builder builder
                = new AlertDialog
                .Builder(Appointment.this);

        // Set the message show for the Alert time
        builder.setMessage("Do you want to exit ?");

        // Set Alert Title
        builder.setTitle("Alert !");

        // Set Cancelable false
        // for when the user clicks on the outside
        // the Dialog Box then it will remain show
        builder.setCancelable(false);
        builder
                .setPositiveButton(
                        "Yes",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                            {

                                // When the user click yes button
                                // then app will close
                                finish();
                            }
                        });
        builder
                .setNegativeButton(
                        "No",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                            {

                                // If user click no
                                // then dialog box is canceled.
                                dialog.cancel();
                            }
                        });
        AlertDialog alertDialog = builder.create();

        // Show the Alert Dialog box
        alertDialog.show();



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),
                        courses[position],
                        Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}