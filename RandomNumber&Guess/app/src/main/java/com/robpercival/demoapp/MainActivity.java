package com.robpercival.demoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber = new Random().nextInt(20)+1;

    public void  Toast(String string){
        Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
    }


public void Clickfunction(View view){

    EditText editText = (EditText)findViewById(R.id.guessText);
    int guessInt =Integer.parseInt( editText.getText().toString());
    if (guessInt > randomNumber)
    {
        Toast("Please Lower");
    }
    else if (guessInt < randomNumber)
    {
       Toast("Please Higher");
    }
    else
    {
       Toast("correct, next number");

    }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String str="Welcome To here";
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();



    }
}
