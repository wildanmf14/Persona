package com.wildhevire.persona.ui;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;


import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.wildhevire.persona.R;
import com.wildhevire.persona.VideoData;
import com.wildhevire.persona.recycle.MusicAdapter;

import java.util.ArrayList;
import java.util.List;

public class MusicFragment extends Fragment {

    RecyclerView recycler;
//    VideoView videoView;
    YouTubePlayerView videoView;
    MusicAdapter adapter;

    List<VideoData> videoList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music, container, false);

//        videoView = view.findViewById(R.id.videoView);
//        MediaController mediaController = new MediaController(getContext());
//        mediaController.setAnchorView(videoView);
//        mediaController.setMediaPlayer(videoView);
//        videoView.setMediaController(mediaController);

        videoView = view.findViewById(R.id.youtube_player_view);
        videoList = new ArrayList<VideoData>();
//        videoList.add(new VideoData("Ano Yume wo Nazotte - Yoasobi", "android.resource://"+getContext().getPackageName()+"/"+R.raw.ano_yume_wo_nazotte));
//        videoList.add(new VideoData("Inochi no Namae (Cover) - Zea Cornelia", "android.resource://"+getContext().getPackageName()+"/"+R.raw.inochi_no_namae));
//        videoList.add(new VideoData("センチメンタルな愛慕心", "android.resource://"+getContext().getPackageName()+"/"+R.raw.sentimental_love));
//        videoList.add(new VideoData("Virtual to Live - Nijisanji", "android.resource://"+getContext().getPackageName()+"/"+R.raw.virtual_to_live));
//        videoList.add(new VideoData("Winning the Soul - Tokai Teio", "android.resource://"+getContext().getPackageName()+"/"+R.raw.winning_the_soul));

//        videoView.setVideoURI(Uri.parse(videoList.get(0).uri));

        videoList.add(new VideoData("Ano Yume wo Nazotte - Yoasobi","sAuEeM_6zpk"));
        videoList.add(new VideoData("Inochi no Namae (Cover) - Zea Cornelia","sY27n2MxWGY"));
        videoList.add(new VideoData("Virtual to Live - Nijisanji","_G6kcpRxaio"));
        videoList.add(new VideoData("Winning the Soul - Tokai Teio","wHmQi6c_fMw-A"));
        videoList.add(new VideoData("夜に駆ける - Yoasobi","by4SYYWlhEs"));
        videoList.add(new VideoData("センチメンタルな愛慕心 - - なつめ千秋","SVqTTO1KQS0"));

        recycler = (RecyclerView) view.findViewById(R.id.recycler_titles);
        adapter = new MusicAdapter(getActivity(), videoView, videoList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);

        return view;
    }
}