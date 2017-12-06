package com.example.fromsi.fs_collegetransporttask.kz.kcollege.fill;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.fromsi.fs_collegetransporttask.kz.kcollege.fill.Fill1;
import com.example.fromsi.fs_collegetransporttask.kz.kcollege.fill.Fill2;

/**
 * Created by fromsi on 02.12.17.
 */

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
    public ScreenSlidePagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Fill1();
            case 1:
                return new Fill2();
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return 2;
    }
    public void ononon(){}
}
