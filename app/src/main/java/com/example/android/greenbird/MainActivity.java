package com.example.android.greenbird;


import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //PageViewer Implementation
        ViewPager viewPager = findViewById(R.id.mainImgSlider);
        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);
    }

    public void onLinkClick(View v) {
        String destinationUri = (String) v.getTag();
        Intent openURL = new Intent(Intent.ACTION_VIEW);
        openURL.setData(Uri.parse(destinationUri));
        startActivity(openURL);
        Toast.makeText(this, "A abrir página...", Toast.LENGTH_LONG).show();
    }

    public void onMessengerClick(View v) {
        String messengerPackage = (String) v.getTag();

        Uri uri = Uri.parse(messengerPackage);
        uri = ContentUris.withAppendedId(uri,698588337009413L);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);

        try {
        startActivity(intent);
        Toast.makeText(this, "A abrir conversa...", Toast.LENGTH_LONG).show();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "Por favor instale o facebook Messenger", Toast.LENGTH_LONG).show();
        }

    }
}