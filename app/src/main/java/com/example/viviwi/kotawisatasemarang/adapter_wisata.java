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
public class  adapter_wisata extends RecyclerView.Adapter<adapter_wisata.HolderWisata> {

    //private String mjudul[];
    //private String mket[];
    private WisataListener mListener;
    //int img[];
    //List<int[]> gambar;
    Context ctx;
    private List<DataWisataKuliner> list;

    /*public adapter_wisata (Context ct,String judul[],String ket[],int i1[],WisataListener listener, List<int[]> gmbr){
        ctx = ct;
        mjudul=judul;
        mket=ket;
        img = i1;
        gambar = gmbr;
        mListener=listener;
    }*/

    public adapter_wisata(WisataListener mListener, Context ctx, List<DataWisataKuliner> list) {
        this.mListener = mListener;
        this.ctx = ctx;
        this.list = list;
    }

    interface WisataListener{
        void onClick(int position);
    }

    @Override
    public HolderWisata onCreateViewHolder(ViewGroup parent, int viewType) {
        ctx = parent.getContext();
        View myWisataView = LayoutInflater.from(ctx).inflate(R.layout.row_wisata,parent,false);
        return new HolderWisata(myWisataView);
    }

    @Override
    public void onBindViewHolder(HolderWisata holder, int position) {
        RecyclerView.LayoutParams  params = (RecyclerView.LayoutParams) holder.mItemView.getLayoutParams();
        if(position == 0){
            params.topMargin = params.bottomMargin;
        }
        else{
            params.topMargin = 0;
        }
        holder.t1.setText(list.get(position).getNama());
        holder.t2.setText(list.get(position).getInfo());
        //holder.t1.setText(mjudul[position]);
        //holder.t2.setText(mket[position]);
        Glide.with(ctx).load(list.get(position).getGambarutama()).into(holder.myImage);
    }

    @Override
    public int getItemCount() {
        //return mjudul.length;
        return list == null ? 0 : list.size();
    }

    /*public String getJudul(int position) {
        return mjudul[position];
    }*/

    public class HolderWisata extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView t1;
        private TextView t2;
        ImageView myImage;
        private View mItemView;

        public HolderWisata(View itemView) {
            super(itemView);
            t1 = (TextView) itemView.findViewById(R.id.text1);
            t2 = (TextView) itemView.findViewById(R.id.text2);
            myImage = (ImageView)itemView.findViewById(R.id.image_wisata);
            mItemView = itemView;
            mItemView.setOnClickListener(this);

        }
        public void setWisata(String judul,String ket){
            t1.setText(judul);
            t2.setText(ket);
        }
        @Override
        public void onClick(View v) {
            mListener.onClick(getAdapterPosition());
        }
    }
}
