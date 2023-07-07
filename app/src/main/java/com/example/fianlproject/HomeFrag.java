package com.example.fianlproject;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFrag extends Fragment {
    View view;
    FloatingActionButton floatBtn;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    ImageView imgBook,imgviewMale,imgviewFemale,discountImg;

    public HomeFrag() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);



        recyclerView = view.findViewById(R.id.rvlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));


        // Create a list of icon resource IDs
        List<Integer> icons = getIcons();
        List<String> iconsText = getIconText();



        // Initialize the adapter with the icon list
        adapter = new RecyclerViewAdapter(icons,iconsText);
        recyclerView.setAdapter(adapter);


        floatBtn=view.findViewById(R.id.floatBtn);
        imgBook = view.findViewById(R.id.imgBook);
        discountImg=view.findViewById(R.id.discountImg);
        imgviewMale=view.findViewById(R.id.imgviewMale);
        imgviewFemale=view.findViewById(R.id.imgviewFemale);


        imgBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(view.getContext(), Categories.class);
                requireContext().startActivity(i);
               requireActivity().finish();

            }
        });

        imgviewFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(view.getContext(), Categories.class);
                requireContext().startActivity(i);
                requireActivity().finish();
            }
        });
        imgviewMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(view.getContext(), Categories.class);
                requireContext().startActivity(i);
                requireActivity().finish();
            }
        });
        discountImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(view.getContext(), Categories.class);
                requireContext().startActivity(i);
                requireActivity().finish();
            }
        });

        floatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber="090076321";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(intent);

            }
        });


        return view;
    }



    private List<String> getIconText() {
        List<String> iconsText = new ArrayList<>();

        iconsText.add(0,"Eye");
        iconsText.add(1,"Neuro");
        iconsText.add(2,"Skin");
        iconsText.add(3,"Dentist");
        iconsText.add(4,"Heart");
        iconsText.add(5,"Physician");
        iconsText.add(6,"Blood");
        iconsText.add(7,"ENT");
        iconsText.add(8,"Nutrition");
        iconsText.add(9,"Liver");
        iconsText.add(10,"Ortho");
        iconsText.add(11,"Pulmonol");


        // Add more icons as needed
        return iconsText;
    }
    private List<Integer> getIcons() {
        List<Integer> icons = new ArrayList<>();
        icons.add(R.drawable.eye);
        icons.add(R.drawable.neuro);
        icons.add(R.drawable.skin);
        icons.add(R.drawable.dentist);
        icons.add(R.drawable.heart);
        icons.add(R.drawable.physician);
        icons.add(R.drawable.blood);
        icons.add(R.drawable.speech);
        icons.add(R.drawable.nutrition);
        icons.add(R.drawable.liver);
        icons.add(R.drawable.ortho);
        icons.add(R.drawable.pulmonologist);
        // Add more icons as needed
        return icons;
    }

}