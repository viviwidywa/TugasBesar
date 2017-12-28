package com.example.viviwi.kotawisatasemarang;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Vivi Widyawati on 11/22/2017.
 */

public class adapter_hotel extends RecyclerView.Adapter<adapter_hotel.HolderHotel> {
    private String mjudul[];
    private String mket[];
    private HotelListener mListener;
    int img[];
    Context ctx;

    public adapter_hotel(Context ct, String s1[], String s2[], int i1[], HotelListener listener){
        ctx=ct;
        mjudul=s1;
        mket=s2;
        img=i1;
        mListener=listener;

    }

    @Override
    public HolderHotel onCreateViewHolder(ViewGroup parent, int viewType) {
        ctx = parent.getContext();
        View myHotelView = LayoutInflater.from(ctx).inflate(R.layout.row_hotel,parent,false);
        return new adapter_hotel.HolderHotel(myHotelView);
    }

    @Override
    public void onBindViewHolder(HolderHotel holder, int position) {
        RecyclerView.LayoutParams  params = (RecyclerView.LayoutParams) holder.mItemView.getLayoutParams();
        if(position == 0){
            params.topMargin = params.bottomMargin;
        }
        else{
            params.topMargin = 0;
        }
        holder.t1.setText(mjudul[position]);
        holder.t2.setText(mket[position]);
        holder.myImage.setImageResource(img[position]);
    }

    @Override
    public int getItemCount() {
        return mjudul.length;
    }

    public interface HotelListener {
        void OnClick(int position);
    }

    public String getJudul(int position) {
        return mjudul[position];
    }

    public class HolderHotel extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView t1;
        private TextView t2;
        ImageView myImage;
        private View mItemView;

        public HolderHotel(View itemView) {
            super(itemView);
            t1=(TextView)itemView.findViewById(R.id.text1);
            t2=(TextView)itemView.findViewById(R.id.text2);
            myImage=(ImageView)itemView.findViewById(R.id.image_hotel);
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
