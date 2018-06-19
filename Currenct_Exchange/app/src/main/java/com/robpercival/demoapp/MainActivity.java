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

public class MainActivity extends AppCompatActivity {

    public void ClickFunction (View view){
        EditText dollaramount = (EditText) findViewById(R.id.CurrencyEditText);
        Double NTDollar = Double.parseDouble(dollaramount.getText().toString());
        Double USDollar = 29 * NTDollar;
        Toast.makeText(MainActivity.this,"It's"+USDollar.toString(),Toast.LENGTH_SHORT).show();
        Log.i("inform",dollaramount.getText().toString());

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String str="Welcome To here";
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
    }
}
