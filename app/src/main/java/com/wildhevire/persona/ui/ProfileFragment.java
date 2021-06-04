package com.wildhevire.persona.ui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;
import com.wildhevire.persona.MapsFragment;
import com.wildhevire.persona.R;


public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);

        ImageView imageView = view.findViewById(R.id.profile_image);
        Glide.with(getActivity()).
                load(R.drawable.profile)
                .circleCrop()
                .into(imageView);

        Button btnFB = (Button) view.findViewById(R.id.btn_fb);
        Button btnEmail = (Button) view.findViewById(R.id.btn_email);
        Button btnWA = (Button) view.findViewById(R.id.btn_wa);
        Button btnGH = (Button) view.findViewById(R.id.btn_github);
        Button btnAbout = (Button) view.findViewById(R.id.fab);



        btnFB.setOnClickListener(this::OnFBClicked);
        btnEmail.setOnClickListener(this::OnEmailClicked);
        btnWA.setOnClickListener(this::OnWaClicked);
        btnGH.setOnClickListener(this::OnGHClicked);
        btnAbout.setOnClickListener(this::OnAboutClicked);


        FragmentTransaction mTransactiont = getActivity().getSupportFragmentManager().beginTransaction();

        Fragment fragment = new MapsFragment();
        mTransactiont.replace(R.id.maps_profile, fragment, fragment.getClass().getName());
        mTransactiont.commit();
        String urlWA = "https://api.whatsapp.com/send?phone=6285314809161&text=Hallo!!";
        return  view;
    }


    public void OnWaClicked(View view){
        Intent intentCall = new Intent(Intent.ACTION_CALL);
        intentCall.setData(Uri.parse("tel:085314809191"));
        if (ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.CALL_PHONE}, 1);
        } else {
            startActivity(intentCall);
        }
    }

    public void OnFBClicked(View view){
        OpenURL("https://www.facebook.com/wildhevire/");
    }
    public void OnGHClicked(View view){
        OpenURL("https://github.com/wildhevire/");
    }

    public void OnEmailClicked(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"wildan.10118044@mahasiswa.unikom.ac.id"});
        intent.putExtra(Intent.EXTRA_CC, new String[]{""});
        intent.putExtra(Intent.EXTRA_SUBJECT, "");
        intent.putExtra(Intent.EXTRA_TEXT, "");

        try {
            startActivity(Intent.createChooser(intent, null));
        } catch (android.content.ActivityNotFoundException ex) {
            //do something else
        }
    }

    public void OpenURL(String s){
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    public void OnAboutClicked(View view){
        Snackbar bar = Snackbar.make(view,
                "Persona Apps v.0.1 \nMade by Wildan Muhammad Fikri \n10118044 \nCopyright © 2021 Wildhevire",
                Snackbar.LENGTH_LONG);
        View snackView = bar.getView();
        TextView tv = (TextView) snackView.findViewById(com.google.android.material.R.id.snackbar_text);
        tv.setMaxLines(4);
        bar.setDuration(3000).setAction("Action", null).show();


    }
}