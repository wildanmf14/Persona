package com.wildhevire.persona.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wildhevire.persona.R;
import com.wildhevire.persona.recycle.GalleryAdapter;

import java.util.ArrayList;


public class GalleryFragment extends Fragment {
    private ArrayList<Integer> list;
    RecyclerView recyclerView;
    GalleryAdapter galleryAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        list = new ArrayList<Integer>();
        list.add(R.drawable.g1);
        list.add(R.drawable.g2);
        list.add(R.drawable.g3);
        list.add(R.drawable.g4);
        list.add(R.drawable.g5);
        list.add(R.drawable.g6);
        list.add(R.drawable.g7);
        list.add(R.drawable.g8);
        list.add(R.drawable.g9);
        list.add(R.drawable.g0);

        recyclerView = view.findViewById(R.id.recycler_gallery);
        galleryAdapter = new GalleryAdapter(getActivity(), list);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(galleryAdapter);
        return view;
    }
}