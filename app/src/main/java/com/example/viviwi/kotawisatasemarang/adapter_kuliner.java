package com.example.viviwi.kotawisatasemarang;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Vivi Widyawati on 11/22/2017.
 */

public class adapter_kuliner extends RecyclerView.Adapter<adapter_kuliner.HolderKuliner> {

    //private String mjudul[];
    //private String mket[];
    private KulinerListener mListener;
    //int img[];
    Context ctx;
    private List<DataWisataKuliner> list;


   /* public adapter_kuliner(Context ct, String s1[], String s2[], int i1[], KulinerListener listener){
        ctx=ct;
        mjudul=s1;
        mket=s2;
        img=i1;
        mListener= listener;

    }*/
    @Override
    public HolderKuliner onCreateViewHolder(ViewGroup parent, int viewType) {
        ctx = parent.getContext();
        View myKulinerView = LayoutInflater.from(ctx).inflate(R.layout.row_kuliner,parent,false);
        return new HolderKuliner(myKulinerView);
    }

    @Override
    public void onBindViewHolder(HolderKuliner holder, int position) {
        RecyclerView.LayoutParams  params = (RecyclerView.LayoutParams) holder.mItemView.getLayoutParams();
        if(position == 0){
            params.topMargin = params.bottomMargin;
        }
        else{
            params.topMargin = 0;
        }
        holder.t1.setText(list.get(position).getNama());
        holder.t2.setText(list.get(position).getInfo());
       // holder.t1.setText(mjudul[position]);
        //holder.t2.setText(mket[position]);
        Glide.with(ctx).load(list.get(position).getGambarutama()).into(holder.myImage);
    }

    @Override
    public int getItemCount() {
        //return mjudul.length;
        return list == null ? 0: list.size();
    }

    public interface KulinerListener {
        void OnClick(int position);
    }

    /*public String getJudul(int position) {
        return mjudul[position];
    }*/

    public class HolderKuliner extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView t1;
        private TextView t2;
        ImageView myImage;
        private View mItemView;

        public HolderKuliner(View itemView) {
            super(itemView);
            t1 = (TextView) itemView.findViewById(R.id.text1);
            t2 = (TextView) itemView.findViewById(R.id.text2);
            myImage = (ImageView)itemView.findViewById(R.id.image_kuliner);
            mItemView = itemView;
            mItemView.setOnClickListener(this);
        }
        public void setKuliner(String judul,String ket){
            t1.setText(judul);
            t2.setText(ket);
        }

        @Override
        public void onClick(View v) {
            mListener.OnClick(getAdapterPosition());
        }
    }
}
