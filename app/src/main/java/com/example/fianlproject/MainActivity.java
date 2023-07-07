package com.example.fianlproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem tabHome,tabAppoint,tabRec,tabNav;
    ViewPager viewPager;
    viewPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();

        adapter=new viewPagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());


        viewPager.setAdapter(adapter);
        tabLayout.getTabAt(0).setIcon(R.drawable.menu);
        tabLayout.getTabAt(1).setIcon(R.drawable.home);
        tabLayout.getTabAt(2).setIcon(R.drawable.appoint);
        tabLayout.getTabAt(3).setIcon(R.drawable.record);


        tabLayout.setOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
    private void init()
    {
        tabLayout=findViewById(R.id.tabLayout);
        tabNav=findViewById(R.id.tabNav);
        tabHome=findViewById(R.id.tabHome);
        tabAppoint=findViewById(R.id.tabAppoint);
        tabRec=findViewById(R.id.tabRec);
        viewPager=findViewById(R.id.viewPager);

    }
    @Override
    public void onBackPressed() {
        // Check if there are any fragments in the back stack
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            // Pop the back stack to move to the previous fragment
            getSupportFragmentManager().popBackStack();
        } else {
            // If the back stack is empty, perform the default back button behavior
            super.onBackPressed();
        }
    }

}