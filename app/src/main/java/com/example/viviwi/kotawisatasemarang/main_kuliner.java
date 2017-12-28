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

public class main_kuliner extends AppCompatActivity implements adapter_wisata.WisataListener {
    RecyclerView r1;
    //String s1[],s2[];
    //public static final String POSITION = "position";
    //int imageResource[]={R.drawable.k1,R.drawable.k2,R.drawable.k3,R.drawable.k4,R.drawable.k5};
    adapter_wisata ad;
    private List<DataWisataKuliner> list;

    private FirebaseDatabase database;
    private DatabaseReference references;
    private ValueEventListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_kuliner);
        database = FirebaseDatabase.getInstance();
        references = database.getReference("kuliner");
        r1=(RecyclerView)findViewById(R.id.viewkuliner);

        r1.setLayoutManager(new LinearLayoutManager(this));
        tambahListener();
    }

    private void tambahListener() {
        listener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    if (dataSnapshot.getChildrenCount() > 0) {
                        list = new ArrayList<>(); // masuk array list
                        for (DataSnapshot child : dataSnapshot.getChildren()) {
                            DataWisataKuliner data = child.getValue(DataWisataKuliner.class);
                            list.add(data);
                        }
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
                                        ad = new adapter_wisata(main_kuliner.this,main_kuliner.this, list);
                                        r1.setAdapter(ad);
                                    }
                                    else{
                                        Toast.makeText(main_kuliner.this,"kosong",Toast.LENGTH_SHORT).show();
                                    }
                                    Log.d("MainKuliner", "Count : " + dataSnapshot.getChildrenCount());

                                }
                                else{
                                    Log.d("MainKuliner", "NULL" );
                                    Toast.makeText(main_kuliner.this,"kosong",Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {
                                Toast.makeText(main_kuliner.this,"error",Toast.LENGTH_SHORT).show();
                            }
                        };
                        references.addListenerForSingleValueEvent(listener);
                    }r1.setAdapter(ad);
                } else {
                    Toast.makeText(main_kuliner.this, "kosong", Toast.LENGTH_SHORT).show();
                }
                Log.d("MainKuliner", "Count : " + dataSnapshot.getChildrenCount());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(main_kuliner.this, "error", Toast.LENGTH_SHORT).show();
            }
        };
        references.addListenerForSingleValueEvent(listener);
    }




    @Override
    public void onClick(int position) {
        Intent intent = new Intent(this,activity_detail_kuliner.class);
        Gson gson = new Gson();
        String data = gson.toJson(list.get(position));
        intent.putExtra(Intent.EXTRA_TEXT, data);

        //intent.putExtra(Intent.EXTRA_TEXT,ad.getJudul(position));
        //intent.putExtra(POSITION,position);
        startActivity(intent);
    }
}
