package com.wildhevire.persona.recycle;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.wildhevire.persona.R;
import com.wildhevire.persona.VideoData;

import java.util.ArrayList;
import java.util.List;



public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicView>{


    List<VideoData> videoData = new ArrayList<>();
    YouTubePlayerView videoView;
    Activity activity;
    YouTubePlayer player;

    public MusicAdapter(Activity activity, YouTubePlayerView videoView,List<VideoData> videoData) {
        this.activity = activity;
        this.videoData = videoData;
        this.videoView = videoView;
    }

    @NonNull
    @Override
    public MusicAdapter.MusicView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_music, viewGroup,false);

        videoView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                player = youTubePlayer;
            }
        });

        return new MusicView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicAdapter.MusicView holder, int position) {
        holder.judulView.setText(videoData.get(position).title);
        holder.judulView.setOnClickListener(v -> {
//            videoView.setVideoURI(Uri.parse(videoData.get(position).uri));
//            videoView.start();
            player.cueVideo(videoData.get(position).uri, 0);
        });
    }

    @Override
    public int getItemCount() {
        return videoData.size();
    }


    public class MusicView extends RecyclerView.ViewHolder{
        TextView judulView;
        public MusicView(@NonNull View itemView) {
            super(itemView);
            judulView = (TextView)itemView.findViewById(R.id.judul);
        }

        public TextView getJudulView(){
            return getJudulView();
        }
    }
}