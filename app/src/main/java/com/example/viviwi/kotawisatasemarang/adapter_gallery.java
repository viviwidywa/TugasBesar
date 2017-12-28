package com.example.viviwi.kotawisatasemarang;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by Vivi Widyawati on 12/5/2017.
 */

public class adapter_gallery extends RecyclerView.Adapter<adapter_gallery.HolderGallery> {
    //int img[];
    Context ctx;
    String[] img;
    adapter_gallery.GalleryListener mListener;

    /*public adapter_gallery (Context ct,int i1[],adapter_gallery.GalleryListener listener){
        ctx = ct;
        img = i1;
        mListener=listener;

    }*/

    public adapter_gallery(Context ctx, String[] img, GalleryListener mListener) {
        this.ctx = ctx;
        this.img = img;
        this.mListener = mListener;
    }

    interface GalleryListener{
        void onClick(int position);
    }


    public adapter_gallery.HolderGallery onCreateViewHolder(ViewGroup parent, int viewType) {
        ctx = parent.getContext();
        View myGalleryView = LayoutInflater.from(ctx).inflate(R.layout.item_galery,parent,false);
        return new adapter_gallery.HolderGallery(myGalleryView);
    }

    public void onBindViewHolder(adapter_gallery.HolderGallery holder, int position) {
        //holder.imageView_gallery.setImageResource(img[position]);
        Glide.with(ctx).load(img[position]).skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE).into(holder.imageView_gallery);
    }
    public int getItemCount() {
        return  img == null ? 0 : img.length;
    }


public class HolderGallery extends RecyclerView.ViewHolder implements View.OnClickListener{
      private ImageView imageView_gallery;

    public HolderGallery(View itemView) {
        super(itemView);
        imageView_gallery = itemView.findViewById(R.id.imageView_gallery);

    }

    @Override
    public void onClick(View v) {
        mListener.onClick(getAdapterPosition());
    }
}
}
