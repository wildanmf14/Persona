package com.wildhevire.persona;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wildhevire.persona.recycle.DailyAdapter;
import com.wildhevire.persona.recycle.FriendAdapter;

import java.util.ArrayList;
import java.util.List;


public class DailyFragment extends Fragment {
    RecyclerView recyclerFriend;
    FriendAdapter friendAdapter;

    RecyclerView recyclerDaily;
    DailyAdapter dailyAdapter;

    List<Integer> imageList;
    List<String> nameList;

    List<DailyData> dailyList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daily, container, false);

        imageList = new ArrayList<Integer>();
        imageList.add(R.drawable.f1);
        imageList.add(R.drawable.f2);
        imageList.add(R.drawable.f3);
        imageList.add(R.drawable.f4);
        imageList.add(R.drawable.f5);
        imageList.add(R.drawable.f6);

        nameList = new ArrayList<String>();
        nameList.add("Angga");
        nameList.add("Suyatna");
        nameList.add("Daffa");
        nameList.add("Ivan");
        nameList.add("Enrico");
        nameList.add("Galih");

        dailyList = new ArrayList<DailyData>();
        dailyList.add(new DailyData(R.drawable.ic_coding, "Ngoding", "Kerjaan - tugas banyak dan numpuk"));
        dailyList.add(new DailyData(R.drawable.ic_coding, "Ngoding 2.0", "Kerjaan - tugas masih banyak dan numpuk"));
//        dailyList.add(new DailyData(R.drawable.ic_coding, "Ngoding 3.0", "Tugas belum selesai"));
//        dailyList.add(new DailyData(R.drawable.ic_coding, "Ngoding 4.0", "Tugas masih belum selesai"));
        dailyList.add(new DailyData(R.drawable.sleep, "Tidur", "Kadang lanjut ngoding kalo masih belum selesai, gk kadang sih sering"));




        recyclerFriend = (RecyclerView) view.findViewById(R.id.recycler_friend);
        friendAdapter = new FriendAdapter(getActivity(), nameList, imageList);

        recyclerDaily = (RecyclerView) view.findViewById(R.id.recycler_daily);
        dailyAdapter = new DailyAdapter(dailyList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerFriend.setLayoutManager(layoutManager);
        recyclerFriend.setAdapter(friendAdapter);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity());
        recyclerDaily.setLayoutManager(layoutManager2);
        recyclerDaily.setAdapter(dailyAdapter);

        return view;
    }
}