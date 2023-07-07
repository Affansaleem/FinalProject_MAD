package com.example.fianlproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class topBar extends Fragment {

    View view;
    ImageView backIcon;

    public topBar() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_top_bar, container, false);

        backIcon = view.findViewById(R.id.backIcon);




        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainerView, new HomeFrag());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        // Return the inflated view
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();

        // Enable the back button press callback
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Pop the back stack to move to the previous fragment
                getParentFragmentManager().popBackStack();
            }
        });
    }


}