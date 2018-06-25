package com.robpercival.demoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {



    public void clickFunction(View view) {

        ImageView picture = (ImageView) findViewById(R.id.imageView2);
        ImageView picture2 = (ImageView) findViewById(R.id.imageView3);

        picture.animate().translationYBy(1000).translationXBy(1000).rotationBy(3600).setDuration(8000);
       // picture2.animate().alpha(100);

       // Log.i("Info", "Button Pressed!");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView picture = (ImageView) findViewById(R.id.imageView2);
        picture.setTranslationX(-100);
        picture.setTranslationY(-100);

    }
}
