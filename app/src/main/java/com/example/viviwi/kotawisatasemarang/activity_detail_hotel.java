package com.example.viviwi.kotawisatasemarang;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class activity_detail_hotel extends AppCompatActivity {
    private ArrayList<Integer> Hotel_ImageID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hotel);
        ActionBar toolbar = getSupportActionBar();
        toolbar.setDisplayHomeAsUpEnabled(true);
        addKuliner_ImageID();
        bindData();
    }

    private void bindData() {
        int position;
        String nama;
        String keter[] = getResources().getStringArray(R.array.keterangan_hotel);
        Intent intent = getIntent();
        nama = intent.getStringExtra(Intent.EXTRA_TEXT);
        position = intent.getIntExtra(main_hotel.POSITION, 0);
        TextView tv_nama = (TextView) findViewById(R.id.nm_hotel);
        TextView tv_keter = (TextView) findViewById(R.id.ket);
        ImageView image = (ImageView) findViewById(R.id.imageView_hotel);
        tv_nama.setText(nama);
        tv_keter.setText(keter[position]);
        image.setImageResource(Hotel_ImageID.get(position));
    }

    private void addKuliner_ImageID() {
        Hotel_ImageID = new ArrayList<>();
        Hotel_ImageID.add(R.drawable.h1);
        Hotel_ImageID.add(R.drawable.h2);
        Hotel_ImageID.add(R.drawable.h3);
        Hotel_ImageID.add(R.drawable.h4);
        Hotel_ImageID.add(R.drawable.h5);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void calling(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + "0123456"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void website(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.facebook.com"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
