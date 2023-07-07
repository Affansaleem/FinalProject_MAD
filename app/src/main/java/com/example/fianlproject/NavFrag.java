package com.example.fianlproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class NavFrag extends Fragment {

TextView tvAbout,tvContact,tvFeed,tvDetail;
Button btnLogout;

FirebaseAuth auth;

FirebaseUser user;
    public NavFrag() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_nav, container, false);

        auth=FirebaseAuth.getInstance();
        user= auth.getCurrentUser();
        tvAbout=view.findViewById(R.id.tvAbout);
        tvContact=view.findViewById(R.id.tvContact);
        tvFeed=view.findViewById(R.id.tvFeed);
        tvDetail=view.findViewById(R.id.tvDetail);
        btnLogout=view.findViewById(R.id.btnLogout);

        if (user==null)
        {
            Intent i=new Intent(getContext(), Login.class);
            startActivity(i);
            getActivity().finish();

        }
        else {


        }

        tvAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getActivity(),aboutUs.class);
                startActivity(i);


            }
        });

        tvContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x=new Intent(getActivity(),contactUs.class);
                startActivity(x);

            }
        });
        tvFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent j=new Intent(getActivity(),feed.class);
                startActivity(j);

            }
        });

        // Firebase method
        tvDetail.setText(user.getEmail());

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();
                Intent i=new Intent(getContext(), Login.class);
                startActivity(i);
                getActivity().finish();

            }
        });


        // Inflate the layout for this fragment
        return view;
    }
}