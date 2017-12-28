package com.example.viviwi.kotawisatasemarang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class main_hotel extends AppCompatActivity implements adapter_hotel.HotelListener{

    RecyclerView r1;
    String s1[],s2[];
    public static final String POSITION = "position";
    int imageResource[]={R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5};
    adapter_hotel ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hotel);

        r1=(RecyclerView)findViewById(R.id.viewhotel);
        s1=getResources().getStringArray(R.array.nama_hotel);
        s2=getResources().getStringArray(R.array.deskripsi_hotel);

        ad=new adapter_hotel(this,s1,s2,imageResource,this);
        r1.setAdapter(ad);
        r1.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void OnClick(int position) {
        Intent intent = new Intent(this,activity_detail_hotel.class);
        intent.putExtra(Intent.EXTRA_TEXT,ad.getJudul(position));
        intent.putExtra(POSITION,position);
        startActivity(intent);
    }
}
