package com.example.fianlproject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class viewPagerAdapter extends FragmentPagerAdapter {

    int tabsCount;
    public viewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabsCount=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                return new NavFrag();
            case 1:
                return new HomeFrag();
            case 2:
                return new AppoinFrag();
            case 3:
                return new RecFrag();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {

        return tabsCount;
    }
}
