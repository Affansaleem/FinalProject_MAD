package com.example.fianlproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Categories extends AppCompatActivity {

    List<String> leftIconsText;
    List<Integer> leftIcons;
    List<Integer> rightIcons;
    List<String> rightIconsText;
    private SearchView searchView;
    private RecyclerView rvCategories;
    private categoriesAdapter adapterCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        searchView=findViewById(R.id.searchView);




        rvCategories=findViewById(R.id.rvCategories);
        rvCategories.setLayoutManager(new LinearLayoutManager(this));

        leftIcons=getLeftIcons();
        leftIconsText=getLeftText();
        rightIcons=getRightIcons();
        rightIconsText=getRightText();

        adapterCat=new categoriesAdapter(leftIcons,leftIconsText,rightIcons,rightIconsText);
        rvCategories.setAdapter(adapterCat);



    }



    private List<String> getRightText() {
        List<String> iconsText = new ArrayList<>();
        iconsText.add(0,"Dentist");
        iconsText.add(1,"Heart");
        iconsText.add(2,"Physician");
        iconsText.add(3,"Blood");
        iconsText.add(4,"ENT");
        iconsText.add(5,"Nutrition");
        return iconsText;
    }

    private List<Integer> getRightIcons() {
        List<Integer> icons = new ArrayList<>();
        icons.add(R.drawable.dentist);
        icons.add(R.drawable.heart);
        icons.add(R.drawable.physician);
        icons.add(R.drawable.blood);
        icons.add(R.drawable.speech);
        icons.add(R.drawable.nutrition);

        return icons;
    }

    private List<String> getLeftText() {
        List<String> iconsText = new ArrayList<>();

        iconsText.add(0,"Eye");
        iconsText.add(1,"Neuro");
        iconsText.add(2,"Skin");
        iconsText.add(3,"Liver");
        iconsText.add(4,"Ortho");
        iconsText.add(5,"Pulmonologist");
        return iconsText;
    }

    private List<Integer> getLeftIcons() {
        List<Integer> icons = new ArrayList<>();
        icons.add(R.drawable.eye);
        icons.add(R.drawable.neuro);
        icons.add(R.drawable.skin);
        icons.add(R.drawable.liver);
        icons.add(R.drawable.ortho);
        icons.add(R.drawable.pulmonologist);
        return icons;

    }
}