package com.example.viviwi.kotawisatasemarang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Map;

public class activity_detail_wisata extends AppCompatActivity {
    private ArrayList<Integer>Wisata_ImageID;
    private int[] gambar;
    private DataWisataKuliner data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);
        ActionBar toolbar=getSupportActionBar();
        toolbar.setDisplayHomeAsUpEnabled(true);
        bindData();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void bindData() {
        //int position;
        //int gambar_utama;
        //String nama;
        //String keter [] = getResources().getStringArray(R.array.keterangan_wisata);
        Intent intent = getIntent();
        Gson gson = new Gson();
        data = gson.fromJson(intent.getStringExtra(Intent.EXTRA_TEXT), new TypeToken<DataWisataKuliner>(){}.getType());
        //nama = intent.getStringExtra(Intent.EXTRA_TEXT);
        //position = intent.getIntExtra(main_wisata.POSITION, 0);
        //gambar_utama = intent.getIntExtra("gambar_utama",0);
        //gambar = intent.getIntArrayExtra("gambar");
        TextView tv_nama=(TextView)findViewById(R.id.nm_wisata);
        TextView tv_keter = (TextView) findViewById(R.id.ket);
        ImageView image = (ImageView) findViewById(R.id.imageView_wisata);
        tv_nama.setText(data.getNama());
        tv_keter.setText(data.getInfo());
        Glide.with(this).load(data.getGambarutama()).into(image);
        //image.setImageResource(gambar_utama);
    }

    public void gallery_wisata(View view) {
        Intent intent = new Intent(this,gallery_wisata.class);
        Map<String,String> mapGambar = data.getGambar();
        String listGambar [] = null;
        int i = 0;
        if(mapGambar!= null){
            listGambar = new String[mapGambar.size()];
            for(String key : mapGambar.keySet()){
                listGambar[i] = mapGambar.get(key);
                i++;
            }
        }
        intent.putExtra("gambar",listGambar);
        startActivity(intent);
    }
    public void lokasi(View  view){
        Intent intent = new Intent(this,MapsActivity.class);
        intent.putExtra("lokasi",data.getKoordinat());
        startActivity(intent);
    }
}
