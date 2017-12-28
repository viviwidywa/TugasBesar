package com.example.viviwi.kotawisatasemarang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class gallery_wisata extends AppCompatActivity implements adapter_gallery.GalleryListener{
    private RecyclerView r1;
    //private int[] gambar;
    private String[] gambar;
    private adapter_gallery ad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_wisata);
        gambar = getIntent().getStringArrayExtra("gambar");
        GridLayoutManager manager = new GridLayoutManager(this,2, GridLayoutManager.VERTICAL,false);
        r1 = (RecyclerView) findViewById(R.id.grid_galery);
        ad = new adapter_gallery(this,gambar,this);
        r1.setLayoutManager(manager);
        r1.setHasFixedSize(true);
        r1.setAdapter(ad);

    }

    @Override
    public void onClick(int position) {

    }
}
