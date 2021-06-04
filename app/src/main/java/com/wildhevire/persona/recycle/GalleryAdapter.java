package com.wildhevire.persona.recycle;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.wildhevire.persona.R;

import java.util.ArrayList;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryView>{

    private ArrayList<Integer> list;
    private Activity activity;
    public GalleryAdapter(Activity activity, ArrayList<Integer> list){
        this.list=list;
        this.activity = activity;
    }
    @NonNull
    @Override
    public GalleryView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gallery,parent,false);
        return new GalleryView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryView holder, int position) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.transforms(new RoundedCorners(16));
        Glide.with(activity)
                .load(list.get(position))
                .apply(requestOptions)
                .into(holder.imgPhoto);



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class GalleryView extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        public GalleryView(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_gallery);
        }
    }
}
