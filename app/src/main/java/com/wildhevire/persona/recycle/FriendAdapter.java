package com.wildhevire.persona.recycle;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.wildhevire.persona.R;

import java.util.ArrayList;
import java.util.List;



public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.FriendView>{


    List<Integer> imageList = new ArrayList<>();
    List<String> nameList = new ArrayList<>();
    Activity activity;

    public FriendAdapter(Activity activity, List<String> nameList, List<Integer> imageList) {
        this.activity = activity;
        this.imageList = imageList;
        this.nameList = nameList;
    }

    @NonNull
    @Override
    public FriendView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_friend,viewGroup,false);

        return new FriendView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendView holder, int position) {
//        RequestOptions requestOptions = new RequestOptions();
//        requestOptions = requestOptions.transform(new CenterCrop(), new RoundedCorners(16));
//        Glide
//                .with(activity)
//                .load(imageList.get(position))
//                .override(500,500)
//                .apply(requestOptions)
//                .into(holder.imageView);

        Glide.with(activity)
                .load(imageList.get(position))
                .circleCrop()
                .into(holder.imageView);
//
//        holder.imageView.setImageResource((Integer) imageList.get(position));
        holder.textView.setText(nameList.get(position));
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }



    public class FriendView extends RecyclerView.ViewHolder{


        ImageView imageView;
        TextView textView;
        public FriendView(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.pic_friend);
            textView = (TextView)itemView.findViewById(R.id.nama);
        }

        public ImageView getImageView(){
            return imageView;
        }

        public TextView getTextView(){
            return textView;
        }
    }

}