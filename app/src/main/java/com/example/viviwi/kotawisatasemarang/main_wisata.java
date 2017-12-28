package com.example.viviwi.kotawisatasemarang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class main_wisata extends AppCompatActivity implements adapter_wisata.WisataListener {

    RecyclerView r1;
    //String s1[], s2[];
    //public static final String POSITION = "position";
    //int imageResource[] = {R.drawable.photo1, R.drawable.photo2, R.drawable.photo3, R.drawable.photo4, R.drawable.photo5};
    adapter_wisata ad;
    //List<int[]> gambar = new ArrayList<>();
    private List<DataWisataKuliner> list;

    private FirebaseDatabase database;
    private DatabaseReference references;
    private ValueEventListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_wisata);
        r1 = findViewById(R.id.viewwisata);
        database = FirebaseDatabase.getInstance();
        references = database.getReference("wisata");
        /*s2 = getResources().getStringArray(R.array.deskripsi_wisata);
        gambar.add(new int[]{R.drawable.lw1, R.drawable.lw2, R.drawable.lw3, R.drawable.lw4, R.drawable.lw5});
        gambar.add(new int[]{R.drawable.gb1, R.drawable.gb2, R.drawable.gb3, R.drawable.gb4, R.drawable.gb5});
        gambar.add(new int[]{R.drawable.kl1, R.drawable.kl2, R.drawable.kl3, R.drawable.kl4, R.drawable.kl5});
        gambar.add(new int[]{R.drawable.spk1, R.drawable.spk2, R.drawable.spk3, R.drawable.spk4, R.drawable.spk5});
        gambar.add(new int[]{R.drawable.sl1, R.drawable.sl2, R.drawable.sl3, R.drawable.sl4, R.drawable.sl5});
        ad = new adapter_wisata(this, s1, s2, imageResource, this, gambar);
        r1.setAdapter(ad);*/
        r1.setLayoutManager(new LinearLayoutManager(this));
        tambahListener();
    }


    @Override
    public void onClick(int position) {
        Intent intent = new Intent(this, activity_detail_wisata.class);
        Gson gson = new Gson();
        String data = gson.toJson(list.get(position));
        intent.putExtra(Intent.EXTRA_TEXT, data);
        //ntent.putExtra(Intent.EXTRA_TEXT, list.get(position).getInfo());
        //intent.putExtra(POSITION, position);
        //intent.putExtra("gambar_utama", imageResource[position]);
        //intent.putExtra("gambar", gambar.get(position));
        startActivity(intent);
    }
    public void tambahListener(){
        listener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot != null){
                    if(dataSnapshot.getChildrenCount() > 0){
                        list = new ArrayList<>();
                        for(DataSnapshot child : dataSnapshot.getChildren()){
                            DataWisataKuliner data = child.getValue(DataWisataKuliner.class);
                            list.add(data);
                        }
                        ad = new adapter_wisata(main_wisata.this,main_wisata.this, list);
                        r1.setAdapter(ad);
                    }
                    else{
                        Toast.makeText(main_wisata.this,"kosong",Toast.LENGTH_SHORT).show();
                    }
                    Log.d("MainWisata", "Count : " + dataSnapshot.getChildrenCount());

                }
                else{
                    Log.d("MainWisata", "NULL" );
                    Toast.makeText(main_wisata.this,"kosong",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(main_wisata.this,"error",Toast.LENGTH_SHORT).show();
            }
        };
        references.addListenerForSingleValueEvent(listener);
    }
}