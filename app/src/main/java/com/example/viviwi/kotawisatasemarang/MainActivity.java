package com.example.viviwi.kotawisatasemarang;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     }


    public void menuhotel(View view) {
        Intent intent = new Intent(MainActivity.this,main_hotel.class);
        startActivity(intent);
    }

    public void menuwisata(View view) {
        Intent intent = new Intent(MainActivity.this,main_wisata.class);
        startActivity(intent);
    }

    public void menukuliner(View view) {
        Intent intent = new Intent(MainActivity.this,main_kuliner.class);
        startActivity(intent);
    }

    public void keluar(View view) {
        Intent exit = new Intent(Intent.ACTION_MAIN);
        exit.addCategory(Intent.CATEGORY_HOME);
        exit.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(exit);
    }
}
