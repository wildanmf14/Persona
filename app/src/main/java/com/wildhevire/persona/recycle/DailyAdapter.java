package com.wildhevire.persona.recycle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.wildhevire.persona.DailyData;
import com.wildhevire.persona.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.DailyVew> {

    List<DailyData> list;

    public DailyAdapter(List<DailyData> list){
        this.list = list;
    }

    @NonNull
    @Override
    public DailyVew onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_daily,parent,false);
        return new DailyVew(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DailyVew holder, int position) {
        DailyData data = list.get(position);
        Glide.with(holder.itemView.getContext())
                .load(data.image)
                .apply(new RequestOptions().override(1000,1000))
                .into(holder.imgPhoto);
        holder.title.setText(data.judul);
        holder.desc.setText(data.desc);
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    class DailyVew extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView title, desc;

        DailyVew(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_daily);
            title = itemView.findViewById(R.id.judul_daily);
            desc = itemView.findViewById(R.id.desc_daily);
        }
    }
}

