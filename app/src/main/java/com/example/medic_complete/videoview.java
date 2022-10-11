package com.example.medic_complete;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.MediaController;
import android.widget.VideoView;

public class videoview extends AppCompatActivity {
VideoView v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoview);
        v=findViewById(R.id.videoView);
        WebView browser = (WebView) findViewById(R.id.webview);

        browser.loadUrl("https://www.apollohospitals.com");
        v.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.medidreview));
        // create an object of media controller
        MediaController mediaController = new MediaController(this);
// initiate a video view

// set media controller object for a video view
        v.setMediaController(mediaController);
    }
}