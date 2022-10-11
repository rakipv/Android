package com.example.medic_complete;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Color;

import android.icu.util.Calendar;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;

import android.os.Bundle;

import java.io.File;

public class dashboard extends AppCompatActivity {
    GridLayout mainGrid;
    TextView e,text;
    Button btnbtn,pop;
    DownloadManager manager;
    private MediaPlayer mpp;

ImageView img;
    CardView cus, bloodoonate, hospital, appoitment, music, mailus, mp,vv,myfamily,pharmacy,remainder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        remainder=findViewById(R.id.remainder);
        remainder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(dashboard.this,remaindersplash.class);
                startActivity(i);

            }
        });
        myfamily=findViewById(R.id.myfamily);
        myfamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(dashboard.this,family.class);
                startActivity(i);
            }
        });
        img=findViewById(R.id.imgho);
        text=findViewById(R.id.textH);

pop=findViewById(R.id.pop);
pharmacy=findViewById(R.id.pharmacy);
pharmacy.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
Intent i = new Intent(dashboard.this,Contactlist.class);
startActivity(i);
    }
});
/////////////////////////////////pop up menu/////////////////////////////////
        /////// on button click ///////////////


pop.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        PopupMenu popup = new PopupMenu(dashboard.this, btnbtn);
        popup.getMenuInflater().inflate(R.menu.map_options, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.all:
                        Uri gmmIntentUri = Uri.parse("geo:0,0?q=hopitals");
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        startActivity(mapIntent);
                        //Toast.makeText(dashboard.this,"i am all",Toast.LENGTH_SHORT).show();

                        return true;

                    case R.id.apolo:
                        Uri gmmIntenttUri = Uri.parse("geo:0,0?q=Apollo hopitals");
                        Intent mappIntent = new Intent(Intent.ACTION_VIEW, gmmIntenttUri);
                        mappIntent.setPackage("com.google.android.apps.maps");
                        startActivity(mappIntent);
                        //Toast.makeText(dashboard.this,"i am apollo",Toast.LENGTH_SHORT).show();

                        return true;
                    case R.id.navigate:
                        Uri ggmmIntenttUri = Uri.parse("https://www.google.com/maps/dir/12.9306312,77.6034967/Apollo+Hospital+Rd,+Bengaluru,+Karnataka+560076/@12.9137099,77.5815315,14z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x3bae153d2cdaac07:0xaa623f62780204dd!2m2!1d77.5980808!2d12.8967034");
                        Intent mmappIntent = new Intent(Intent.ACTION_VIEW, ggmmIntenttUri);
                        mmappIntent.setPackage("com.google.android.apps.maps");
                        startActivity(mmappIntent);
                        return true;




                }
//                Toast.makeText(dashboard.this,"You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
              return true;
            }
        });
        popup.show();//showing popup menu
    }
});

//s1=findViewById(R.id.switch1);
//s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//    @Override
//    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//        if(isChecked){
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//        }
//        else{
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//        }
//    }
//});


        mainGrid = (GridLayout) findViewById(R.id.mainGrid);
        mpp = MediaPlayer.create(dashboard.this, R.raw.smooth);
        mpp.setLooping(true);
        mpp.start();
        btnbtn=findViewById(R.id.btnbtn);

        //Set Event
        vv=findViewById(R.id.video);
        e = findViewById(R.id.e);
        cus = (CardView) findViewById(R.id.cus);
        bloodoonate = findViewById(R.id.bloodoonate);
        hospital = findViewById(R.id.hospital);
        appoitment = findViewById(R.id.fixappointment);
        music = findViewById(R.id.music);
        mailus = findViewById(R.id.mailus);
        mp = findViewById(R.id.mp);
   registerForContextMenu(btnbtn);

        vv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(dashboard.this,videoview.class);
                startActivity(i);
            }
        });

        cus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri u = Uri.parse("tel:" + e.getText().toString());

                // Create the intent and set the data for the
                // intent as the phone number.
                Intent i = new Intent(Intent.ACTION_DIAL, u);

                try {
                    // Launch the Phone app's dialer with a phone
                    // number to dial a call.
                    startActivity(i);
                } catch (SecurityException s) {
                    // show() method display the toast with
                    // exception message.

                }
            }
        });




        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=hopitals");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        bloodoonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i = new Intent(dashboard.this,blood.class);
               startActivity(i);
            }
        });

 appoitment.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         Intent i =new Intent(dashboard.this,FIndoctor.class);
         startActivity(i);
     }
 });
        mailus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "rakeshpvooficial@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "CUSTOMER QUERY");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });

        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.INTENT_ACTION_MUSIC_PLAYER);
                startActivity(intent);
            }
        });
    }
    @Override

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.logout_profile, menu);

        return true;

    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.Profile:

                Intent ii = new Intent(dashboard.this,ProfileActivity.class);
                startActivity(ii);

         // Toast.makeText(dashboard.this,"i am all",Toast.LENGTH_SHORT).show();

                return true;

            case R.id.Setting:

             Toast.makeText(dashboard.this,"i am apollo",Toast.LENGTH_SHORT).show();

                return true;

            case R.id.logout:
                Intent i = new Intent(dashboard.this,LoginActivity.class);
                startActivity(i);

                //Toast.makeText(dashboard.this,"i am apollo",Toast.LENGTH_SHORT).show();

                return true;

            default:

                return super.onOptionsItemSelected(item);

        }

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected( MenuItem item) {
        switch (item.getItemId()){
            case R.id.context_call:
              //  Toast.makeText(dashboard.this,"i am editing",Toast.LENGTH_SHORT).show();
                Uri u = Uri.parse("tel:" + e.getText().toString());

                // Create the intent and set the data for the
                // intent as the phone number.
                Intent i = new Intent(Intent.ACTION_DIAL, u);

                try {
                    // Launch the Phone app's dialer with a phone
                    // number to dial a call.
                    startActivity(i);
                } catch (SecurityException s) {
                    // show() method display the toast with
                    // exception message.

                }
                return true;

            case R.id.context_map:
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Blood Banks");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
                return  true;
            case  R.id.context_share:

                ApplicationInfo api=getApplicationContext().getApplicationInfo();
                String s=api.sourceDir;
                Intent iq= new Intent(Intent.ACTION_SEND);
                iq.setType("application/vnd.android.package-archive");
                iq.putExtra(Intent.EXTRA_STREAM,Uri.fromFile(new File(s)));
                startActivity(Intent.createChooser(iq,"shareVia"));

                return  true;
            case R.id.context_PREVIOUS:
                manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse("https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf");
                DownloadManager.Request request = new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);

                long reference = manager.enqueue(request);
            default:
                return super.onContextItemSelected(item);



        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mpp.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mpp.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mpp.stop();
        mpp.release();
    }
}




