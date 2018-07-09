package com.example.user.downloadimagefromweb;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    ImageView downloadImage;

    public void downloadImage(View view){


        //https://upload.wikimedia.org/wikipedia/zh/thumb/e/ed/Bart_Simpson.svg/222px-Bart_Simpson.svg.png

        imageDownloader task = new imageDownloader();
        Bitmap bitmap;
        try {
            bitmap = task.execute("https://upload.wikimedia.org/wikipedia/zh/thumb/e/ed/Bart_Simpson.svg/222px-Bart_Simpson.svg.png").get();
            downloadImage.setImageBitmap(bitmap);



        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.i("Interaction","Button Tapped");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         downloadImage = (ImageView)findViewById(R.id.imageView);

    }
    public  class imageDownloader extends AsyncTask<String,Void,Bitmap>{

        @Override
        protected Bitmap doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection connection = (HttpURLConnection)url.openConnection();

                connection.connect();
                InputStream inputStream = connection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                return bitmap;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return  null;
        }

    }
}
